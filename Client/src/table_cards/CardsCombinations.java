package table_cards;

import java.util.Vector;

public class CardsCombinations {
	public final static int NUMBER_STRAIGHT_CARDS = 5;
	public final static int ONE_PAIR_RANGE = 14;
	public final static int TWO_PAIR_RANGE = 28;
	public final static int THREE_OF_KIND_RANGE = 42;
	public final static int STRAIGHT_RANGE = 56;
	public final static int FLUSH_RANGE = 70;
	public final static int FULL_HOUSE_RANGE = 84;
	public final static int FOUR_OF_KIND = 98;
	public final static int STRAIGHT_FLUSH_RANGE = 112;
	public final static int MAX_COMBINATION_RANGE = 126;
	
	public static int seachCombination(Vector<Card> cards) {
		int combinationRange = 0;
		
		combinationRange = straightFlush(cards);
		if(straightFlush(cards) != 0) {
			return combinationRange + STRAIGHT_FLUSH_RANGE;
		}
		
		combinationRange = fourOfKind(cards);
		if(fourOfKind(cards) != 0) {
			return combinationRange + FOUR_OF_KIND;
		}
		
		combinationRange = fullHouse(cards);
		if(fullHouse(cards) != 0) {
			return combinationRange + FULL_HOUSE_RANGE;
		}
		
		combinationRange = flush(cards);
		if(flush(cards) != 0) {
			return combinationRange + FLUSH_RANGE;
		}
		
		combinationRange = straight(cards);
		if(straight(cards) != 0) {
			return combinationRange + STRAIGHT_RANGE;
		}
		
		combinationRange = threeOfKind(cards);
		if(threeOfKind(cards) != 0) {
			return combinationRange + THREE_OF_KIND_RANGE;
		}
		
		combinationRange = twoPairs(cards);
		if(twoPairs(cards) != 0) {
			return combinationRange + TWO_PAIR_RANGE;
		}
		
		combinationRange = onePair(cards);
		if(onePair(cards) != 0) {
			return combinationRange + ONE_PAIR_RANGE;
		}
		
		combinationRange = highHand(cards);
		if(highHand(cards) != 0) {
			return combinationRange;
		}
		
		return combinationRange;
	}
	
	public static int highHand(Vector<Card> cards) {
		int tempRange = 0;
		for(int i = 0; i < cards.size(); i++) {
			if(cards.elementAt(i).getRange().getRange() > tempRange) {
				tempRange = cards.elementAt(i).getRange().getRange();
			}
		}
		return tempRange;
	}
	
	public static int onePair(Vector<Card> cards) {
		int tempRange = 0;
		
		for(int i = 0; i < cards.size(); i++) {
			for(int j = i + 1; j < cards.size(); j++) {
				if(cards.elementAt(i).getRange().getRange() == cards.elementAt(j).getRange().getRange() && 
						cards.elementAt(i).getRange().getRange() > tempRange) {
					tempRange = cards.elementAt(i).getRange().getRange();
				}
			}
		}
		
		return tempRange;
	}
	
	public static int twoPairs(Vector<Card> cards) {
		int firstTempPairRange = onePair(cards);
		if(firstTempPairRange == 0) {
			return 0;
		}
		int secondTempPairRange = 0;
		for(int i = 0; i < cards.size(); i++) {
			for(int j = i + 1; j < cards.size(); j++) {
				if(cards.elementAt(i).getRange().getRange() == cards.elementAt(j).getRange().getRange() && 
						cards.elementAt(i).getRange().getRange() > secondTempPairRange &&
						cards.elementAt(i).getRange().getRange() != firstTempPairRange) {
					secondTempPairRange = cards.elementAt(i).getRange().getRange();
				}
			}
		}
		
		if(firstTempPairRange != 0 && secondTempPairRange != 0) {
			return secondTempPairRange > firstTempPairRange ? secondTempPairRange : firstTempPairRange;
		} else {
			return 0;
		}
	}
	
	public static int threeOfKind(Vector<Card> cards) {
		int tempRange = 0;
		for(int i = 0; i < cards.size(); i++) {
			for(int j = i + 1; j < cards.size(); j++) {
				for(int z = j + 1; z < cards.size(); z++) {
					if(cards.elementAt(i).getRange().getRange() == cards.elementAt(j).getRange().getRange() && 
							cards.elementAt(i).getRange().getRange() == cards.elementAt(z).getRange().getRange() &&
							cards.elementAt(i).getRange().getRange() > tempRange) {
						tempRange = cards.elementAt(i).getRange().getRange();
					}
				}
			}
		}
		return tempRange;
	}

	public static int straight(Vector<Card> cards) {
		int array[] = new int[cards.size()];
		for(int i = 0; i < cards.size(); i++) {
			array[i] = cards.elementAt(i).getRange().getRange();
		}
		sortArray(array);
		int maxRange = 0;
		for(int i = 0; i < array.length - NUMBER_STRAIGHT_CARDS + 1; i++) {
			if(array[i + NUMBER_STRAIGHT_CARDS - 1] - array[i] == NUMBER_STRAIGHT_CARDS - 1) {
				int flag = 1;
				for(int j = i; j < NUMBER_STRAIGHT_CARDS + i - 1; j++) {
					if(array[j + 1] - array[j] != 1) {
						flag = 0;
					}
				}
				if(flag != 0) {
					maxRange = array[i + NUMBER_STRAIGHT_CARDS - 1];
				}		
			}
		}
		return maxRange;
	}
	
	public static int flush(Vector<Card> cards) {
		int cardsCount = 0;
		final int COUNT_FLUSH_CARDS = 5;
		int maxRange = 0;
		for(int i = 0; i < cards.size(); i++){
			cardsCount = 0;
			maxRange = 0;
			for(int j = i + 1; j < cards.size(); j++) {
				if(cards.elementAt(i).getSuit().getId() == cards.elementAt(j).getSuit().getId()) {
					cardsCount++;
					if(maxRange > cards.elementAt(i).getRange().getRange()) {
						maxRange = cards.elementAt(i).getRange().getRange();
					}
					if(maxRange > cards.elementAt(j).getSuit().getId()) {
						maxRange = cards.elementAt(j).getSuit().getId();
					}
				}
			}
			if(cardsCount == COUNT_FLUSH_CARDS) {
				return maxRange;
			}
		}
		return 0;
	}
	
	public static int fullHouse(Vector<Card> cards) {
		int rangeThreeOfKind = threeOfKind(cards);
		if(rangeThreeOfKind == 0) {
			return 0;
		}
		int tempRange = 0;
		for(int i = 0; i < cards.size(); i++) {
			for(int j = i + 1; j < cards.size(); j++) {
				if(cards.elementAt(i).getRange().getRange() == cards.elementAt(j).getRange().getRange() && 
						cards.elementAt(i).getRange().getRange() > tempRange &&
						cards.elementAt(i).getRange().getRange() != rangeThreeOfKind) {
					tempRange = cards.elementAt(i).getRange().getRange();
				}
			}
		}
		if(tempRange != 0) {
			return rangeThreeOfKind;
		} else {
			return 0;
		}
	}
	
	public static int fourOfKind(Vector<Card> cards) {
		int tempRange = 0;
		for(int i = 0; i < cards.size(); i++) {
			for(int j = i + 1; j < cards.size(); j++) {
				for(int z = j + 1; z < cards.size(); z++) {
					for(int k = z + 1; k < cards.size(); k++) {
						if(cards.elementAt(i).getRange().getRange() == cards.elementAt(j).getRange().getRange() && 
								cards.elementAt(i).getRange().getRange() == cards.elementAt(z).getRange().getRange() &&
								cards.elementAt(i).getRange().getRange() == cards.elementAt(k).getRange().getRange() &&
								cards.elementAt(i).getRange().getRange() > tempRange) {
							tempRange = cards.elementAt(i).getRange().getRange();
						}
					}
				}
			}
		}
		return tempRange;
	}

	public static int straightFlush(Vector<Card> cards) {
	    return 0;
	}
	
	public static void sortArray(int[] numbers) {
		int min, temp;
	    for (int index = 0; index < numbers.length-1; index++){
	        min = index;
	        for (int scan = index+1; scan < numbers.length; scan++){
	            if (numbers[scan] < numbers[min])
	                min = scan;
	        }
	        temp = numbers[min];
	        numbers[min] = numbers[index];
	        numbers[index] = temp;
	    }
	}
	
}
