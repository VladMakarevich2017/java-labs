package poker_room;

import java.util.Random;
import java.util.Vector;

import table_cards.Card;

public class Table {
	private int numberOfPlayers;
	private int valueSmallBlind;
	private int valueBigBlind;
	private int dealerPosition;
	private int currentBank;
	private int currentRase;
	private Vector<Card> tableCards;
	final Random random = new Random();
	
	Table() {
		numberOfPlayers = 0;
		valueSmallBlind = 0;
		valueBigBlind = 0;
		dealerPosition = 0;
		currentBank = 0;
		currentRase = 0;
		tableCards = new Vector<Card>();
	}

	Table(int numberOfPlayers, int valueSmallBlind, int valueBigBlind) {
		this.numberOfPlayers = numberOfPlayers;
		this.valueSmallBlind = valueSmallBlind;
		this.valueBigBlind = valueBigBlind;
		this.dealerPosition = random.nextInt(numberOfPlayers);
		tableCards = new Vector<Card>();
		currentRase = 0;
		currentBank = 0;
	}
	
	public void setTableCards(Vector<Card> tableCards) {
		this.tableCards = tableCards;
	}
	
	public Vector<Card> getTableCards() {
		return tableCards;
	}
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getValueSmallBlind() {
		return valueSmallBlind;
	}

	public void setValueSmallBlind(int valueSmallBlind) {
		this.valueSmallBlind = valueSmallBlind;
	}

	public int getValueBigBlind() {
		return valueBigBlind;
	}

	public void setValueBigBlind(int valueBigBlind) {
		this.valueBigBlind = valueBigBlind;
	}

	public int getDealerPosition() {
		return dealerPosition;
	}

	public void setDealerPosition(int dealerPosition) {
		this.dealerPosition = dealerPosition;
	}
	
	public void setDealerPosition() {
		if (numberOfPlayers - dealerPosition == 1) {
			dealerPosition = 0;
		}
		else {
			dealerPosition++;
		}
	}

	public int getCurrentBank() {
		return currentBank;
	}

	public void setCurrentBank(int currentBank) {
		this.currentBank = currentBank;
	}

	public void setCurrentBank() {
		currentBank = valueSmallBlind + valueBigBlind;
	}
	
	public int getCurrentRase() {
		return currentRase;
	}

	public void setCurrentRase(int currentRase) {
		this.currentRase = currentRase;
	}
	
}
