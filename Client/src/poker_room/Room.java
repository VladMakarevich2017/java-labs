package poker_room;

import poker_room.Table;

public class Room {
	public final static int MAX_PLAYERS = 9;
	public final static int MIN_PLAYERS = 2;
	public final static int DEFAULT_STAKE_SIZE = 1200;
	public final static int DEFAULT_PLAYERS_NUMBER = 3;
	private Table currentTable;
	
	public Room() {
		currentTable = new Table();
	}
	
	public Room(int numberOfPlayers, int valueSmallBlind, int valueBigBlind) {
		currentTable = new Table(numberOfPlayers, valueSmallBlind, valueBigBlind);
	}
	
	public Table getCurrentTable() {
		return currentTable;
	}
	
}
