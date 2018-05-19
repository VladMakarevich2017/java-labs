package client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bytedeco.javacpp.opencv_core.IplImage;

import application.Card;
import controller.Controller;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import player_info.Player;
import webcam.ImageManipulation;
import webcam.WebCamManipulation;

public class TestRunnableClientTester implements Runnable {
    static Socket socket;
    private static DataOutputStream out;
    private static DataInputStream in;
    private int currentBank;
    private int currentStake;
    private static int playerPosition;
	private static int tempBet;
    private Card firstHandCard;
    private Card secondHandCard;
    private Vector<Card> cards;
    private static Vector<Player> players;
   	private Controller controller;
    private boolean connectionFlag;
    private static int gamePort;
    private static String gameIp;
    private static boolean webCamFlag = true;
    
    public static void writeUTF(String message) {
		try {
			out.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    public String readUTF() {
		try {
			return in.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static int getTempBet() {
    	return tempBet;
    }
    
    public static boolean compareBet() {
    	if(players.elementAt(playerPosition).getBet() == tempBet) {
    		return true;
    	} else {
    		return false;
    	}
    }

    public TestRunnableClientTester(Controller tempController) {
        try {
        	controller = tempController;
        	connectionFlag = true;
        	try {
                socket = new Socket(gameIp, gamePort);
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
        	} catch(ConnectException e) {
        		connectionFlag = false;
        	}
            setCurrentBank(0);
            setFirstHandCard(new Card());
            setSecondHandCard(new Card());
            cards = new Vector<Card>();
            players = new Vector<Player>();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void run() {
    	if(!connectionFlag) {
    		controller.getInfo().setText("Ошибка подключения.");
    		return;
    	}
        try 
        {
        	ExecutorService executeIt = Executors.newFixedThreadPool(10);
        	WebCamServer webCamServer = new WebCamServer();
        	WebCamManipulation webCam = new WebCamManipulation();
        	executeIt.execute(webCamServer);
        	executeIt.execute(webCam);
        	executeIt.shutdown();
        	controller.getInfo().clear();
        	controller.getInfo().setText("Вы успешно подключились к комнате. Ожидайте подключения всех игроков...");
        	String message;
        	writeUTF(String.valueOf(WebCamServer.getPort()));
        	while(!socket.isClosed()) {
        		message = readUTF();
        		sendingRequest(message);
        	}
            out.writeUTF("quit");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.exit(1);
        }
    }
    
    private void sendingRequest(String message) throws IOException {
    	String[] array1 = message.split("code:");
    	String[] array = array1[1].split(",");
    	switch(array[0]) {
    	case "you":
    	case "YOU": yourRequest(array1[1]);
    		break;
    	case "info":
    	case "INFO": infoRequest(array1[1]);
    		break;
    	case "ADD_BET":
    	case "add_bet": betRequest(array1[1]);
    		break;
    	case "RAISE":
    	case "raise": raiseRequest(array1[1]);
    		break;
    	case "WEBCAM":
    	case "webcam": webCamRequest(array1[1]);
    		break;
    	case "NULL":
    	case "null": nullRequest();
    		break;
    	default: 
    		break;
    	}
    }
    
    private void webCamRequest(String request) throws UnknownHostException {
    	String[] topics = request.split("/");
    	ExecutorService executeIt = Executors.newFixedThreadPool(10);
    	for(int i = 1; i < topics.length; i++) {
    		String[] partsOfAdress = topics[i].split(":");
    		int tempPort = Integer.parseInt(partsOfAdress[1]);
    		if(tempPort == WebCamServer.getPort() || partsOfAdress[0] == InetAddress.getLocalHost().toString()) continue;
    		WebCamClient client = new WebCamClient(partsOfAdress[0], tempPort);
    		executeIt.execute(client);
    	}
    	executeIt.shutdown();
    }
    
    private void yourRequest(String request) {   
    	String[] topics = request.split(",");
    	String cards = topics[1];
    	String position = topics[2];
		playerPosition = Integer.parseInt(position.split("position:")[1]);	
		selectFunction(playerPosition, 0, 1, 0, true);
    	if(cards.indexOf(";") == -1) {
    		return;
    	}
    	cards = cards.split("cards:\\{")[1];
    	cards = cards.split("\\}")[0];
    	String[] cardsArray = cards.split(";");
    	firstHandCard.setRange(cardsArray[0].split("-")[0]);
    	firstHandCard.setSuit(cardsArray[0].split("-")[1]);
		secondHandCard.setRange(cardsArray[1].split("-")[0]);
		secondHandCard.setSuit(cardsArray[1].split("-")[1]);
		controller.playerFirstCard.setOpacity(1);
		controller.playerSecondCard.setOpacity(1);
		controller.tableCard1.setImage(null);
		controller.tableCard2.setImage(null);
		controller.tableCard3.setImage(null);
		controller.tableCard4.setImage(null);
		controller.tableCard5.setImage(null);
		controller.getInfo().setText("Началась раздача. Ожидайте вашего хода");
    }
    
    private void selectFunction(int position, int stakeSize, double opacity, int bet, boolean flag) {
    	switch(position + 1) {
		case 1: controller.setPlayer1(stakeSize, opacity, bet);
			if(flag) {
				controller.player1.setText("You");
				controller.player1.setFill(Color.RED);
			}
			break;
		case 2: controller.setPlayer2(stakeSize, opacity, bet);
			if(flag) {
				controller.player2.setText("You");
				controller.player2.setFill(Color.RED);
			}
			break;
		case 3: controller.setPlayer3(stakeSize, opacity, bet);
			if(flag) {
				controller.player3.setText("You");
				controller.player3.setFill(Color.RED);
			}
			break;
		case 4: controller.setPlayer4(stakeSize, opacity, bet);
			if(flag) {
				controller.player4.setText("You");
				controller.player4.setFill(Color.RED);
			}
			break;
		case 5: controller.setPlayer5(stakeSize, opacity, bet);
			if(flag) {
				controller.player5.setText("You");
				controller.player5.setFill(Color.RED);
			}
			break;
		case 6: controller.setPlayer6(stakeSize, opacity, bet);
			if(flag) {
				controller.player6.setText("You");
				controller.player6.setFill(Color.RED);
			}
			break;
		case 7: controller.setPlayer7(stakeSize, opacity, bet);
			if(flag) {
				controller.player7.setText("You");
				controller.player7.setFill(Color.RED);
			}
			break;
		case 8: controller.setPlayer8(stakeSize, opacity, bet);
			if(flag) {
				controller.player8.setText("You");
				controller.player8.setFill(Color.RED);
			}
			break;
		case 9: controller.setPlayer9(stakeSize, opacity, bet);
			if(flag) {
				controller.player9.setText("You");
				controller.player9.setFill(Color.RED);
			}
			break;
		default: break;
    	}
    }
    
    private void selectCard(int cardNumber, String cardName) {
    	Image tempImage = new Image("/cards/" + cardName + "_thumb" + ".jpg");
    	switch(cardNumber + 1) {
    	case 1: controller.tableCard1.setImage(tempImage);
    		break;
    	case 2: controller.tableCard2.setImage(tempImage);
    		break;
    	case 3: controller.tableCard3.setImage(tempImage);
    		break;
    	case 4: controller.tableCard4.setImage(tempImage);
    		break;
    	case 5: controller.tableCard5.setImage(tempImage);
    		break;
    	default : break;
    	}
    }
    
    private void infoRequest(String request) {
    	players.removeAllElements();
    	String[] topics = request.split(",");
    	setCurrentBank(Integer.parseInt((topics[1].split("bank:"))[1]));
    	parseCards(topics[2]);
    	parsePlayersInfo(topics[3]);
    	
    	controller.getbank().setText(String.valueOf(currentBank));
    	if(cards.size() != 0) {
    		for(int i = 0; i < cards.size(); i++) {
    			selectCard(i, cards.elementAt(i).getRange() + "-" + cards.elementAt(i).getSuit());
    		}
    	}
    	for(int i = 0; i < players.size(); i++) {
    		if(i == playerPosition) {
    			if(players.elementAt(i).getFoldFlag()) {
    				selectFunction(i, players.elementAt(i).stake.getStakeSize(), 0.35, players.elementAt(i).getCurrentBet(), true);
    			} else {
			    	controller.playerFirstCard.setOpacity(1);
					controller.playerSecondCard.setOpacity(1);
        			selectFunction(i, players.elementAt(i).stake.getStakeSize(), 1, players.elementAt(i).getCurrentBet(), true);
    			}
    		}
    		if(players.elementAt(i).getFoldFlag()) {
        		selectFunction(i, players.elementAt(i).stake.getStakeSize(), 0.35, players.elementAt(i).getCurrentBet(), false);
    		} else {
        		selectFunction(i, players.elementAt(i).stake.getStakeSize(), 1, players.elementAt(i).getCurrentBet(), false);
    		}
    	}
    	
    	Image tempImage1 = new Image("/cards/" + firstHandCard.getRange() + "-" + firstHandCard.getSuit() + "_thumb" + ".jpg");
		controller.playerFirstCard.setImage(tempImage1);
		Image tempImage2 = new Image("/cards/" + secondHandCard.getRange() + "-" + secondHandCard.getSuit() + "_thumb" + ".jpg");
		controller.playerSecondCard.setImage(tempImage2);
		
    	cards.removeAllElements();
    }
    
    private void parseCards(String cards) {
    	if(cards.indexOf(";") == -1) {
    		return;
    	}
    	cards = cards.split("cards:\\{")[1];
    	cards = cards.split("\\}")[0];
    	String[] cardsArray = cards.split(";");
    	for(int i = 0; i < cardsArray.length; i++) {
    		Card tempCard = new Card();
    		tempCard.setRange(cardsArray[i].split("-")[0]);
    		tempCard.setSuit(cardsArray[i].split("-")[1]);
    		this.cards.addElement(tempCard);
    	}
    }
    
    private void parsePlayersInfo(String players) {
    	players = players.split("players:\\[")[1];
    	players = players.split("\\]")[0];
    	String[] tempArray = players.split("\\{");
    	for(int i = 1; i < tempArray.length; i++) {
    		tempArray[i] = tempArray[i].split("\\}")[0];
    		parsePlayer(tempArray[i]);
    	}
    }
    
    private void parsePlayer(String info) {
    	String[] topics = info.split(";");
    	Player tempPlayer = new Player();
    	tempPlayer.setPosition(Integer.parseInt((topics[0].split("&:"))[1]));
    	tempPlayer.stake.setStakeSize(Integer.parseInt((topics[1].split("stake_size:"))[1]));
    	tempPlayer.setBet(Integer.parseInt((topics[2].split("bet:"))[1]));
    	tempPlayer.setFoldFlag(Boolean.parseBoolean((topics[3].split("fold:"))[1]));
    	players.add(tempPlayer);
    }
    
    private void betRequest(String request) throws IOException {
    	controller.playerFirstCard.setOpacity(1);
		controller.playerSecondCard.setOpacity(1);
    	int bet = Integer.parseInt(request.split("bet:")[1]);
    	controller.getRate().setText(String.valueOf(bet));
    	controller.getInfo().clear();
    	controller.getInfo().setText("Подтвердите ставку в размере " + bet + " или повысьте.");
    	tempBet = bet;
    }
    
    private void raiseRequest(String request) throws IOException {
    	controller.playerFirstCard.setOpacity(1);
		controller.playerSecondCard.setOpacity(1);
    	controller.getInfo().clear();
    	controller.getInfo().setText("Введите ставку.");
    }
    
    private void nullRequest() throws IOException {
    	controller.getInfo().clear();
    	controller.getInfo().setText("Игра завершилась по техническим причинам");
    	out.writeUTF("quite");
    	out.flush();
    	in.close();
    	out.close();
    	socket.close();
    	controller.exit();
    }

	public Card getFirstHandCard() {
		return firstHandCard;
	}

	public void setFirstHandCard(Card firstHandCard) {
		this.firstHandCard = firstHandCard;
	}

	public Card getSecondHandCard() {
		return secondHandCard;
	}

	public void setSecondHandCard(Card secondHandCard) {
		this.secondHandCard = secondHandCard;
	}

	public int getCurrentStake() {
		return currentStake;
	}

	public void setCurrentStake(int currentStake) {
		this.currentStake = currentStake;
	}

	public int getCurrentBank() {
		return currentBank;
	}

	public void setCurrentBank(int currentBank) {
		this.currentBank = currentBank;
	}

	public boolean isConnectionFlag() {
		return connectionFlag;
	}

	public void setConnectionFlag(boolean connectionFlag) {
		this.connectionFlag = connectionFlag;
	}

	public static int getGamePort() {
		return gamePort;
	}

	public static void setGamePort(int gamePort) {
		TestRunnableClientTester.gamePort = gamePort;
	}
	
    public static DataOutputStream getOutStream() {
    	return out;
    }
    
    public static DataInputStream getInStream() {
    	return in;
    }
    
    public static Vector<Player> getPlayers() {
		return players;
	}

	public static void setPlayers(Vector<Player> players) {
		TestRunnableClientTester.players = players;
	}
	
   public static int getPlayerPosition() {
		return playerPosition;
	}

	public static void setPlayerPosition(int playerPosition) {
		TestRunnableClientTester.playerPosition = playerPosition;
	}

	public static String getGameIp() {
		return gameIp;
	}

	public static void setGameIp(String gameIp) {
		TestRunnableClientTester.gameIp = gameIp;
	}

	public static boolean isWebCamFlag() {
		return webCamFlag;
	}

	public static void setWebCamFlag(boolean webCamFlag) {
		TestRunnableClientTester.webCamFlag = webCamFlag;
	}
}