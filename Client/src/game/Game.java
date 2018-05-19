package game;

import java.util.Vector;

import player_info.Player;
import poker_room.Room;
import poker_room.Table;
import table_cards.Card;
import table_cards.CardDeck;
import table_cards.CardsCombinations;

public abstract class Game implements Runnable {
	protected Vector<Player> players;
	protected Player player;
	protected Room currentRoom;
	protected int stakeSize;
	public final int BET_REQUEST_CODE = 1;
    public final int RAISE_REQUEST_CODE = 2;
    public final int FOLD_REQUES_CODE = -1;
    public final static int NUMBER_OF_ROUNDS = 4;
    
    protected abstract void deleteInactivePlayers();
    public abstract void session(CardDeck cardDeck);
    
    protected Game() {
    	players = new Vector<Player>();
		currentRoom = new Room();
    }
    
    protected void findWinners(Vector<Card> cards) {
		int tempRange = 0;
		int maxRange = 0;
		int countPlayersWithMaxRange = 1;
		for(int i = 0; i < players.size(); i++) {
			if(players.elementAt(i).getFoldFlag()) {
				continue;
			}
			cards.add(players.elementAt(i).getPlayerCards()[0]);
			cards.add(players.elementAt(i).getPlayerCards()[1]);
			tempRange = CardsCombinations.seachCombination(cards);
			players.elementAt(i).setCombinationRange(tempRange);
			if(tempRange > maxRange) {
				maxRange = tempRange;
				countPlayersWithMaxRange = 1;
			} else if(tempRange == maxRange) {
				countPlayersWithMaxRange++;
			}
			cards.removeElementAt(cards.size() - 1);
			cards.removeElementAt(cards.size() - 1);
		}
		dividingWinEqually(maxRange, countPlayersWithMaxRange);
	}
	
    protected void dividingWinEqually(int maxRange, int countPlayersWithMaxRange) {
		for(int i = 0; i < players.size(); i++) {
			if(players.elementAt(i).getCombinationRange() == maxRange) {
				players.elementAt(i).stake.setStakeSize(players.elementAt(i).stake.getStakeSize() + getCurrentTable().getCurrentBank() / countPlayersWithMaxRange);
			}
		}
	}
	
    protected void addCardsToPlayers(CardDeck cardDeck) {
		for(int i = 0;i < players.size(); i++) {
			players.elementAt(i).getPlayerCards()[0] = cardDeck.getRandomCard();
			players.elementAt(i).getPlayerCards()[1] = cardDeck.getRandomCard();
		}
	}
	
    protected void getNextCardsOnTable(int roundNumber, CardDeck cardDeck) {
		switch(roundNumber) {
			case 1: getCurrentTable().getTableCards().add(cardDeck.getRandomCard());
					getCurrentTable().getTableCards().add(cardDeck.getRandomCard());
					getCurrentTable().getTableCards().add(cardDeck.getRandomCard());
					return;
			case 2: getCurrentTable().getTableCards().add(cardDeck.getRandomCard());
					return;
			case 3: getCurrentTable().getTableCards().add(cardDeck.getRandomCard());
					return;
			default: return;
		}
	}
	
    protected void zeroRates() {
		for(int i = 0; i < players.size(); i++) {
			players.elementAt(i).setCurrentBet(0);
			players.elementAt(i).setBet(0);
			players.elementAt(i).setFoldFlag(false);
		}
	}
	
    protected int searchNextPosition(int currentPosition) {
		if (currentPosition + 2 <= getCurrentTable().getNumberOfPlayers()) {
			currentPosition = currentPosition + 1;
		}
		else {
			currentPosition = 0;
		}
		if(players.elementAt(currentPosition).getFoldFlag()) {
			searchNextPosition(currentPosition);
		}
		return currentPosition;
	}
	
	public boolean checkPlayersRaises() {
		for(int i = 0; i < players.size(); i++) {
			if (players.elementAt(i).getCurrentBet() > getCurrentTable().getCurrentRase() && !players.elementAt(i).getFoldFlag()) {
				return false;
			} else if (players.elementAt(i).getCurrentBet() < getCurrentTable().getCurrentRase() && 
					players.elementAt(i).stake.getStakeSize() > 0 && !players.elementAt(i).getFoldFlag()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkActivePlayers() {
		int countActivePlayers = countActivePlayers();
		if (countActivePlayers < currentRoom.MIN_PLAYERS || countActivePlayers > currentRoom.MAX_PLAYERS) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int countActivePlayers() {
		int countActivePlayers = 0;
		for(int i = 0; i < players.size(); i++) {
			if (players.elementAt(i).stake.getStakeSize() > 0 && !players.elementAt(i).getFoldFlag()) {
				countActivePlayers++;
			}
		}
		return countActivePlayers;
	}
	
	protected void deleteBlaindOfPlayers() {
		int smallBlindPosition = searchSmallBlindPosition();
		int bigBlindPosition = searchBigBlindPosition();
		int tempStakeSize = players.elementAt(smallBlindPosition).stake.getStakeSize();
		if(tempStakeSize < getCurrentTable().getValueSmallBlind()) {
			players.elementAt(smallBlindPosition).stake.setStakeSize(0);
			getCurrentTable().setCurrentBank(getCurrentTable().getCurrentBank() - (getCurrentTable().getValueSmallBlind() - tempStakeSize));
		} else {
			players.elementAt(smallBlindPosition).stake.setStakeSize(tempStakeSize - getCurrentTable().getValueSmallBlind());
		}
		tempStakeSize = players.elementAt(bigBlindPosition).stake.getStakeSize();
		if(tempStakeSize < getCurrentTable().getValueBigBlind()) {
			players.elementAt(bigBlindPosition).stake.setStakeSize(0);
			getCurrentTable().setCurrentBank(getCurrentTable().getCurrentBank() - (getCurrentTable().getValueBigBlind() - tempStakeSize));
		} else {
			players.elementAt(bigBlindPosition).stake.setStakeSize(tempStakeSize - getCurrentTable().getValueBigBlind());
		}
	}
	
	protected int searchSmallBlindPosition() {
		int smallBlindPosition = 0;
		if (getCurrentTable().getDealerPosition() + 2 <= getCurrentTable().getNumberOfPlayers()) {
			smallBlindPosition = getCurrentTable().getDealerPosition() + 1;
		}
		else {
			smallBlindPosition = 0;
		}
		return  smallBlindPosition;
	}
	
	protected int searchBigBlindPosition() {
		int bigBlindPosition = 0;
		int differencePositions = getCurrentTable().getNumberOfPlayers() - getCurrentTable().getDealerPosition();
		if (differencePositions == 1) {
			bigBlindPosition = 1;
		}
		else if (differencePositions == 2){
			bigBlindPosition = 0;
		}
		else {
			bigBlindPosition = getCurrentTable().getDealerPosition() + 2;
		}
		return  bigBlindPosition;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public Table getCurrentTable() {
		return currentRoom.getCurrentTable();
	}
	
	public int getStakeSize() {
		return stakeSize;
	}

	public void setStakeSize(int stakeSize) {
		this.stakeSize = stakeSize;
	}
}
