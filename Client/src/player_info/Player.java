package player_info;

import table_cards.Card;

public class Player {
	protected int tablePosition;
	private ChipStake stake;
	protected int currentBet;
	protected int combinationRange;
	protected boolean foldFlag;
	protected Card[] playerCards;
	protected int position;
	protected int bet = 0;
	private String imageDataString;
	
	public Player() {
		setPlayerCards(new Card[2]);
		tablePosition = 0;
		setStake(new ChipStake());
		currentBet = 0;
		combinationRange = 0;
		foldFlag = false;
	}
	
	public Player(int tablePosition, int stakeSize) {
		setPlayerCards(new Card[2]);
		this.tablePosition = tablePosition;
		setStake(new ChipStake(stakeSize));
		currentBet = 0;
		combinationRange = 0;
		foldFlag = false;
	}

	public int getTablePosition() {
		return tablePosition;
	}

	public void setTablePosition(int tablePosition) {
		this.tablePosition = tablePosition;
	}

	public int getCurrentBet() {
		return currentBet;
	}

	public void setCurrentBet(int currentBet) {
		this.currentBet = currentBet;
	}

	public Card[] getPlayerCards() {
		return playerCards;
	}

	public void setPlayerCards(Card[] playerCards) {
		this.playerCards = playerCards;
	}
	

	public int getCombinationRange() {
		return combinationRange;
	}
	

	public void setCombinationRange(int combinationRange) {
		this.combinationRange = combinationRange;
	}

	public boolean getFoldFlag() {
		return foldFlag;
	}

	public void setFoldFlag(boolean foldFlag) {
		this.foldFlag = foldFlag;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getBet() {
		return bet;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}

	public String getImageDataString() {
		return imageDataString;
	}

	public void setImageDataString(String imageDataString) {
		this.imageDataString = imageDataString;
	}

	public ChipStake getStake() {
		return stake;
	}

	public void setStake(ChipStake stake) {
		this.stake = stake;
	}
}
