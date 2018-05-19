package player_info;

import java.util.Random;
import java.util.Vector;

import game.Game;
import table_cards.Card;
import table_cards.CardsCombinations;

public class Bot extends Player {
	public static Random rand = new Random();
	
	public Bot() {
		super();
	}
	
	public Bot(int tablePosition, int stakeSize) {
		super(tablePosition, stakeSize);
	}
	
	public static int sendingRequest(int requestCode, int betDifference, int currentBank, Card[] playerCards, Vector<Card> tableCards, 
			int stakeSize, int roundNumber) throws InterruptedException {
		Thread.sleep(rand.nextInt(2000) + 1500);
		Vector<Card> cards = new Vector<Card>(tableCards);
		cards.add(playerCards[0]);
		cards.add(playerCards[1]);
		double combinationRange = CardsCombinations.seachCombination(cards);
		switch(requestCode) {
		case 1: return addBetRequest(betDifference, combinationRange, currentBank, stakeSize, roundNumber);
		case 2: return raiseRequest(combinationRange, currentBank, stakeSize, roundNumber);
		default: return 0;
		}
	}
	
	private static int addBetRequest(int betDifference, double range, int currentBank, int stakeSize, int roundNumber) {
		double progressChance =  range / (double)CardsCombinations.MAX_COMBINATION_RANGE * randomRange(0.9, 1.1);
		if(roundNumber == 0) {
			progressChance *= rand.nextInt(3) + 2;
		}
		if(progressChance >= ((double)betDifference / (double)currentBank)) {
			if(betDifference > stakeSize) return stakeSize;
			else {
				int rate = betDifference + (int)((double)currentBank * progressChance * (double)(Game.NUMBER_OF_ROUNDS - roundNumber) * randomRange(1.0, 1.2));
				if(rate <= stakeSize) return rate;
				else return stakeSize;
			}
		} else {
			return -1;
		}
	}
	
	private static int raiseRequest(double range, int currentBank, int stakeSize, int roundNumber) {
		double progressChance =  range / (double)CardsCombinations.MAX_COMBINATION_RANGE * randomRange(0.9, 1.1);
		if(roundNumber == 0) {
			progressChance *= rand.nextInt(3) + 2;
		}
		if(progressChance >= (double)(CardsCombinations.ONE_PAIR_RANGE / (double)CardsCombinations.MAX_COMBINATION_RANGE)) {
			int rate = (int)((double)currentBank * progressChance * (double)(Game.NUMBER_OF_ROUNDS - roundNumber + 1) * randomRange(0.65, 1.4)) ;
			if(rate > stakeSize) return stakeSize;
				else return rate;
		} else {
			return 0;
		}
	}
	
	public static double randomRange(double a, double b) {
		return Math.random() * (b - a) + a;
	}

}
