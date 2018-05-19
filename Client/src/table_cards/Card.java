package table_cards;

import java.util.Random;

enum CardSuit {
	SPADES(1), CLUBS(2), HEARTS(3), DIAMONDS(4);
	
	private int id;
	
	CardSuit(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

enum CardRange {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), 
	JACK(11), QUEEN(12), KING(13), ACE(14);
	
	private int range;
	
	CardRange(int range) {
		this.setRange(range);
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
}

public class Card {
	private CardSuit suit;
	private CardRange range;
	final Random random = new Random();
	
	public Card() {
		setSuit(chooseSuit(random.nextInt(4)));
		setRange(chooseRange(random.nextInt(14)));
	}
	
	public Card(Card card) {
		setSuit(card.getSuit());
		setRange(card.getRange());
	}
	
	public Card(int id, int range) {
		this.setSuit(chooseSuit(id));
		this.setRange(chooseRange(range));
	}
	
	public void setCard(int id, int range) {
		this.setSuit(chooseSuit(id));
		this.setRange(chooseRange(range));
	}
	
	public CardSuit chooseSuit(int id) {
		switch(id) {
			case 1: return CardSuit.SPADES;
			case 2: return CardSuit.CLUBS;
			case 3: return CardSuit.HEARTS;
			case 4: return CardSuit.DIAMONDS;
			default: return CardSuit.SPADES;
		}
	}
	
	public CardRange chooseRange(int range) {
		switch(range) {
			case 2: return CardRange.TWO;
			case 3: return CardRange.THREE;
			case 4: return CardRange.FOUR;
			case 5: return CardRange.FIVE;
			case 6: return CardRange.SIX;
			case 7: return CardRange.SEVEN;
			case 8: return CardRange.EIGHT;
			case 9: return CardRange.NINE;
			case 10: return CardRange.TEN;
			case 11: return CardRange.JACK;
			case 12: return CardRange.QUEEN;
			case 13: return CardRange.KING;
			case 14: return CardRange.ACE;
			default: return CardRange.TWO;
		}
	}
	
	public CardSuit getSuit() {
		return suit;
	}

	public void setSuit(CardSuit suit) {
		this.suit = suit;
	}

	public CardRange getRange() {
		return range;
	}

	public void setRange(CardRange range) {
		this.range = range;
	}
}
