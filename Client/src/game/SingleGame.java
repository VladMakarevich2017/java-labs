package game;

import java.util.Vector;

import controller.Controller;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import player_info.Bot;
import player_info.Player;
import poker_room.Room;
import table_cards.Card;
import table_cards.CardDeck;
import table_cards.CardsCombinations;

public class SingleGame extends Game{
	public static Controller controller;
	
	public SingleGame(int numberOfPlayers, int valueSmallBlind, int valueBigBlind, int stakeSize) {
		this.stakeSize = stakeSize;
		players = new Vector<Player>();
		currentRoom = new Room(numberOfPlayers + 1, valueSmallBlind, valueBigBlind);
	}
	
	@Override
	public void run() {
		setPlayers();
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
	
	public void setPlayers() {
		Player player = new Player(0, stakeSize);
		players.add(player);
		players.lastElement().setTablePosition(0);
		for(int i = 0; i < getCurrentRoom().getCurrentTable().getNumberOfPlayers() - 1; i++) {
			Bot tempBot = new Bot(i + 1, stakeSize);
			players.add(tempBot);
			players.lastElement().setTablePosition(i + 1);
		}
	}
	
	public void session(CardDeck cardDeck) {
		try {
			int currentPosition = searchSmallBlindPosition();
			deleteBlaindOfPlayers();
			getCurrentTable().setCurrentBank();
			addCardsToPlayers(cardDeck);
			sendingYourInformation();
			int tempCoef = 0;
			for (int countOfRounds = 0; countOfRounds < NUMBER_OF_ROUNDS; countOfRounds++) {
				if(countActivePlayers() == 1) break;
				for(int countOfPlayers = 0 + tempCoef; countOfPlayers < getCurrentTable().getNumberOfPlayers(); countOfPlayers++) {
					int tempBet = 0;
					sendingInformation();
					if(!checkActivePlayers() && checkPlayersRaises()) {
						break;
					} else if(players.elementAt(currentPosition).getFoldFlag()) {
						currentPosition = searchNextPosition(currentPosition);
						countOfPlayers--;
						continue;
					} else if(players.elementAt(currentPosition).stake.getStakeSize() <= 0) {
						currentPosition = searchNextPosition(currentPosition);
						countOfPlayers--;
						continue;
					} else if(players.elementAt(currentPosition).getCurrentBet() < getCurrentTable().getCurrentRase()) {
						int tempRaise = getCurrentTable().getCurrentRase() - players.elementAt(currentPosition).getCurrentBet();
						if(currentPosition == 0) {
					    	controller.getRate().setText(String.valueOf(tempRaise));
					    	controller.getInfo().clear();
					    	controller.getInfo().setText("Подтвердите ставку в размере " + tempRaise + " или повысьте.");
					    	while(!controller.isProgressFlag()) Thread.sleep(1);
					    	controller.setProgressFlag(false);
					    	tempBet = controller.getTempRate();
						} else {
							tempBet = Bot.sendingRequest(BET_REQUEST_CODE, tempRaise, getCurrentTable().getCurrentBank(), players.elementAt(currentPosition).getPlayerCards(), 
									getCurrentTable().getTableCards(), players.elementAt(currentPosition).stake.getStakeSize(), countOfRounds);
						}
						
						if(tempBet == FOLD_REQUES_CODE) {
							players.elementAt(currentPosition).setFoldFlag(true);
							tempBet = 0;
							tempCoef++;
							//countOfPlayers++;
						} else {
							if(tempBet < tempRaise && players.elementAt(currentPosition).stake.getStakeSize() != tempBet) {
								countOfPlayers--;
								continue;
							} else if (tempBet > tempRaise) {		
								getCurrentTable().setCurrentRase(getCurrentTable().getCurrentRase() + tempBet - tempRaise);			
							} 
						}	
					} else if(players.elementAt(currentPosition).stake.getStakeSize() != 0){
						if(currentPosition == 0) {
							controller.playerFirstCard.setOpacity(1);
							controller.playerSecondCard.setOpacity(1);
					    	controller.getInfo().clear();
					    	controller.getInfo().setText("Введите ставку.");
					    	while(!controller.isProgressFlag()) Thread.sleep(1);
					    	controller.setProgressFlag(false);
					    	tempBet = controller.getTempRate();
						} else {
							tempBet = Bot.sendingRequest(RAISE_REQUEST_CODE, 0, getCurrentTable().getCurrentBank(), players.elementAt(currentPosition).getPlayerCards(), 
									getCurrentTable().getTableCards(), players.elementAt(currentPosition).stake.getStakeSize(), countOfRounds);
						}
						
						if(tempBet == FOLD_REQUES_CODE) {
							players.elementAt(currentPosition).setFoldFlag(true);
							tempBet = 0;
							//countOfPlayers++;
							tempCoef++;
						} else {
							getCurrentTable().setCurrentRase(getCurrentTable().getCurrentRase() + tempBet);	
						}
					}
					getCurrentTable().setCurrentBank(getCurrentTable().getCurrentBank() + tempBet);
					players.elementAt(currentPosition).setCurrentBet(players.elementAt(currentPosition).getCurrentBet() + tempBet);
					players.elementAt(currentPosition).stake.setStakeSize(players.elementAt(currentPosition).stake.getStakeSize() - tempBet);
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
	
	private void sendingYourInformation() {
		selectFunction(0, players.elementAt(0).stake.getStakeSize(), 1, 0, true);
		controller.playerFirstCard.setOpacity(1);
		controller.playerSecondCard.setOpacity(1);
		controller.tableCard1.setImage(null);
		controller.tableCard2.setImage(null);
		controller.tableCard3.setImage(null);
		controller.tableCard4.setImage(null);
		controller.tableCard5.setImage(null);
		controller.getInfo().setText("Началась раздача. Ожидайте вашего хода");
	}
	
	private void sendingInformation() {		
    	controller.getbank().setText(String.valueOf(getCurrentTable().getCurrentBank()));
    	for(int i = 0; i < getCurrentTable().getTableCards().size(); i++) {
    		selectCard(i, getCurrentTable().getTableCards().elementAt(i).getRange() + "-" + getCurrentTable().getTableCards().elementAt(i).getSuit());
        }
    	for(int i = 0; i < players.size(); i++) {
    		if(i == 0) {
    			if(players.elementAt(i).getFoldFlag()) {
    				selectFunction(i, players.elementAt(i).stake.getStakeSize(), 0.35, players.elementAt(i).getCurrentBet(), true);
    			} else {
			    	controller.playerFirstCard.setOpacity(1);
					controller.playerSecondCard.setOpacity(1);
        			selectFunction(i, players.elementAt(i).stake.getStakeSize(), 1, players.elementAt(i).getCurrentBet(), true);
    			}
    			continue;
    		}
    		if(players.elementAt(i).getFoldFlag()) {
        		selectFunction(i, players.elementAt(i).stake.getStakeSize(), 0.35, players.elementAt(i).getCurrentBet(), false);
    		} else {
        		selectFunction(i, players.elementAt(i).stake.getStakeSize(), 1, players.elementAt(i).getCurrentBet(), false);
    		}
    	}
    	Image tempImage1 = new Image("/cards/" + players.elementAt(0).getPlayerCards()[0].getRange() + "-" + players.elementAt(0).getPlayerCards()[0].getSuit() + "_thumb" + ".jpg");
		controller.playerFirstCard.setImage(tempImage1);
		Image tempImage2 = new Image("/cards/" + players.elementAt(0).getPlayerCards()[1].getRange() + "-" + players.elementAt(0).getPlayerCards()[1].getSuit() + "_thumb" + ".jpg");
		controller.playerSecondCard.setImage(tempImage2);
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
	
	protected void deleteInactivePlayers() {
		for(int i = 0; i < players.size(); i++) {
			if (players.elementAt(i).stake.getStakeSize() <= 0) {
				if(getCurrentTable().getDealerPosition() == i) {
					if(i == 0) {
						getCurrentTable().setDealerPosition(players.size());
					} else {
						getCurrentTable().setDealerPosition(i - 1);
					}
				}
				players.removeElementAt(i);
				i--;
			}
		}
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
}
