package player_info;

public class Card {
	private String range;
	private String suit;
	
	public Card() {
		range = "";
		suit = "";
	}
	
	public String getRange() {
		return range;
	}
	
	public void setRange(String range) {
		this.range = range;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
}
