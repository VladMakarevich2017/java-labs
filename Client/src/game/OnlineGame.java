package game;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import player_info.Player;
import poker_room.Room;
import server.PokerClientHandler;
import table_cards.Card;
import table_cards.CardDeck;
import table_cards.CardsCombinations;

public class OnlineGame extends Game {
	private static Vector<PokerClientHandler> clients = new Vector<PokerClientHandler>();
	private static ExecutorService executeIt = Executors.newFixedThreadPool(10);
    private int port;
	
	public OnlineGame(int numberOfPlayers, int valueSmallBlind, int valueBigBlind) {
		players = new Vector<Player>();
		currentRoom = new Room(numberOfPlayers, valueSmallBlind, valueBigBlind);
	}
	
	public OnlineGame(int numberOfPlayers, int valueSmallBlind, int valueBigBlind, int port, int stakeSize) {
		players = new Vector<Player>();
		currentRoom = new Room(numberOfPlayers, valueSmallBlind, valueBigBlind);
		this.port = port;
		this.stakeSize = stakeSize;
	}
	
	@Override
	public void run() {
		try (ServerSocket server = new ServerSocket(port);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int positions = 0;
                for(int i = 0; i < getCurrentTable().getNumberOfPlayers(); i++) {
                	if (br.ready()) {
                        String serverCommand = br.readLine();
                        if (serverCommand.equalsIgnoreCase("quit")) {
                            server.close();
                            break;
                        }
                    }
                	Socket client = server.accept();
                    PokerClientHandler tempElem = new PokerClientHandler(client);
                    clients.add(tempElem);
                    Player player = new Player(0, stakeSize);
                    players.add(player);
                    players.lastElement().setTablePosition(positions++);
                    executeIt.execute(tempElem);
                }
                addressDistribution();
                game();
                executeIt.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }		
	}
	
	public void addressDistribution() throws UnknownHostException {
		readPortsPlayers();
		sendingWebCamAdressesToClients(adressesIntoRequest());
	}
	
	public void readPortsPlayers() throws UnknownHostException {
		for(int i = 0; i < clients.size(); i++) {
			String port = clients.elementAt(i).readUTF();
			String adress = clients.elementAt(i).getClientDialog().getRemoteSocketAddress().toString();
			if(adress.split(":")[0].equals("/127.0.0.1")) {
				adress = InetAddress.getLocalHost().toString();
			}
			clients.elementAt(i).setWebCamConnectionAdress(adress.split(":")[0] + ":" + port);			
		}
	}
	
	public String adressesIntoRequest() {
		String message = "";
		for(int i = 0; i < clients.size(); i++) {
			message += clients.elementAt(i).getWebCamConnectionAdress();
		}
		return message;
	}
	
	public void sendingWebCamAdressesToClients(String request) {
		final String code = "code:WEBCAM,";
		for(int i = 0; i < clients.size(); i++) {
			clients.elementAt(i).writeUTF(code + request);
		}
	}

	
	public void game() {
		while (checkActivePlayers()) {
			CardDeck cardDeck = new CardDeck();
			getCurrentTable().getTableCards().removeAllElements();
			session(cardDeck);
			Vector<Card> tempCards = new Vector<Card>(getCurrentTable().getTableCards());
			findWinners(tempCards);
			getCurrentTable().setCurrentBank();
			getCurrentTable().setCurrentRase(0);
			deleteInactivePlayers();
			zeroRates();
			getCurrentTable().setDealerPosition();
		}
	}
	
	public void session(CardDeck cardDeck) {
		try {
			int currentPosition = searchSmallBlindPosition();
			deleteBlaindOfPlayers();
			getCurrentTable().setCurrentBank();
			addCardsToPlayers(cardDeck);
			for(int i = 0; i < clients.size(); i++) {
				clients.elementAt(i).sendingYourInformation(players.elementAt(i));
			}
			int countOfInactivePlayers = 0;
			for (int countOfRounds = 0; countOfRounds < NUMBER_OF_ROUNDS; countOfRounds++) {
				if(countActivePlayers() == 1) break;
				//for(int i = 0; i < players.size(); i++) players.elementAt(i).setBet(0);
				for(int countOfPlayers = countOfInactivePlayers; countOfPlayers < getCurrentTable().getNumberOfPlayers(); countOfPlayers++) {
					int tempBet = 0;
					sendingInformation();
					if(!checkActivePlayers() && checkPlayersRaises()) {
						break;
					} else if(players.elementAt(currentPosition).getFoldFlag()) {
						currentPosition = searchNextPosition(currentPosition);
						countOfPlayers--;
						continue;
					} else if(players.elementAt(currentPosition).getStake().getStakeSize() <= 0) {
						currentPosition = searchNextPosition(currentPosition);
						countOfPlayers--;
						continue;
					} else if(players.elementAt(currentPosition).getCurrentBet() < getCurrentTable().getCurrentRase()) {
						int tempRaise = getCurrentTable().getCurrentRase() - players.elementAt(currentPosition).getCurrentBet();
						tempBet = Integer.parseInt(clients.elementAt(currentPosition).sendingRequest(BET_REQUEST_CODE, tempRaise));
						if(tempBet == FOLD_REQUES_CODE) {
							players.elementAt(currentPosition).setFoldFlag(true);
							tempBet = 0;
							countOfInactivePlayers++;
						} else {
							if(tempBet < tempRaise && players.elementAt(currentPosition).getStake().getStakeSize() != tempBet) {
								countOfPlayers--;
								continue;
							} else if (tempBet > tempRaise) {		
								getCurrentTable().setCurrentRase(getCurrentTable().getCurrentRase() + tempBet - tempRaise);			
							} 
						}	
					} else if(players.elementAt(currentPosition).getStake().getStakeSize() != 0){
						tempBet = Integer.parseInt(clients.elementAt(currentPosition).sendingRequest(RAISE_REQUEST_CODE, 0));
						if(tempBet == FOLD_REQUES_CODE) {
							players.elementAt(currentPosition).setFoldFlag(true);
							tempBet = 0;
							countOfInactivePlayers++;
						} else {
							getCurrentTable().setCurrentRase(getCurrentTable().getCurrentRase() + tempBet);	
						}
					}
					getCurrentTable().setCurrentBank(getCurrentTable().getCurrentBank() + tempBet);
					players.elementAt(currentPosition).setCurrentBet(players.elementAt(currentPosition).getCurrentBet() + tempBet);
					players.elementAt(currentPosition).getStake().setStakeSize(players.elementAt(currentPosition).getStake().getStakeSize() - tempBet);
					currentPosition = searchNextPosition(currentPosition);
					if(!checkPlayersRaises() && getCurrentTable().getNumberOfPlayers() - countOfPlayers == 1) countOfPlayers--;
				}
				getNextCardsOnTable(countOfRounds + 1, cardDeck);
				currentPosition = searchSmallBlindPosition();
			}
		} catch(Exception e) {
			System.exit(0);
		}
		
	}
	
	private void sendingInformation() {
		for(int i = 0; i < clients.size(); i++) {
			clients.elementAt(i).sendingInformation(players, i, getCurrentTable().getCurrentBank(), getCurrentTable().getTableCards());
		}
	}
	
	protected void deleteInactivePlayers() {
		for(int i = 0; i < players.size(); i++) {
			if (players.elementAt(i).getStake().getStakeSize() <= 0) {
				if(getCurrentTable().getDealerPosition() == i) {
					if(i == 0) {
						getCurrentTable().setDealerPosition(players.size());
					} else {
						getCurrentTable().setDealerPosition(i - 1);
					}
				}
				players.removeElementAt(i);
				clients.removeElementAt(i);
				i--;
			}
		}
	}
	
	public static Vector<PokerClientHandler> getClients() {
		return clients;
	}

	public static void setClients(Vector<PokerClientHandler> clients) {
		OnlineGame.clients = clients;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
