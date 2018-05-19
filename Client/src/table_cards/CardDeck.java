package table_cards;

import java.util.Random;
import java.util.Vector;

public class CardDeck {
	private Vector<Card> cardDeck;
	private final int NUMBER_OF_SUITS = 4;
	private final int NUMBER_OF_RANGES = 13;
	final Random random = new Random();
	
	public CardDeck() {
		cardDeck = new Vector<Card>();
		setCardDeck();
	}

	public Vector<Card> getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(Vector<Card> cardDeck) {
		this.cardDeck = cardDeck;
	}
	
	public void setCardDeck() {
		for(int i = 1; i <= NUMBER_OF_SUITS; i++) {
			for(int j = 2; j <= NUMBER_OF_RANGES + 1; j++) {
				Card tempCard = new Card(i, j);
				cardDeck.add(tempCard);
			}
		}
		shuffleCardDeck();
	}

	public Card getRandomCard() {
		int cardNumber = random.nextInt(cardDeck.size());
		Card tempElem = new Card(cardDeck.elementAt(cardNumber));
		cardDeck.removeElementAt(cardNumber);
		return tempElem;
	}
	
	public void shuffleCardDeck() {
		for(int i = 0; i < cardDeck.size(); i++) {
			int randomNumber = random.nextInt(cardDeck.size());
			Card tempCard = new Card(cardDeck.elementAt(i));
			cardDeck.setElementAt(cardDeck.elementAt(randomNumber), i);
			cardDeck.setElementAt(tempCard, randomNumber);
		}
	}
}
