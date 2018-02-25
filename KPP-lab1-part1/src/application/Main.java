package application;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	private static Scanner in = new Scanner(System.in);
	public static Vector<Integer> array = new Vector<Integer>();
	public static int arraySize;
	private static Random random = new Random(System.currentTimeMillis());
	private final static int NUMBER_OF_METHODS_OF_FILLING = 3;
	
	public static void main(String[] args) {
		System.out.print("Enter the size of the array: ");
		arraySize = in.nextInt();
		int selectedOption;
		showMenu();
		do {
			selectedOption = in.nextInt();	
		} while(!functionSelection(selectedOption));
		System.out.println(searchPrimeNumbers());
	}
	
	public static void showMenu() {
		System.out.println("1)Fill the array yourself");
		System.out.println("2)Fill the array randomly");
		System.out.println("3)Fill the array sequentially");
	}
	
	public static boolean functionSelection(int selectedOption) {
		if(selectedOption > NUMBER_OF_METHODS_OF_FILLING || selectedOption < 1) {
			return false;
		}
		switch(selectedOption) {
		case 1: fillingArrayManually();
			break;
		case 2: fillingArrayRandomly();
			break;
		case 3: fillingArraySequentially();
			break;
		}
		return true;
	}
	
	public static void fillingArrayManually() {
		array.removeAllElements();
		for(int i = 0; i < arraySize; i++) {
			System.out.print("Element " + i + " = ");
			Integer tempInt = new Integer(in.nextInt());
			array.addElement(tempInt); 
		}
	}
	
	public static void fillingArrayRandomly() {
		array.removeAllElements();
		for(int i = 0; i < arraySize; i++) {
			Integer tempInt = new Integer(random.nextInt(arraySize));
			array.addElement(tempInt);
		}
	}
	
	public static void fillingArraySequentially() {
		array.removeAllElements();
		for(int i = 0; i < arraySize; i++) {
			array.addElement(new Integer(i));
		}
	}
	
	public static String searchPrimeNumbers() {
		String result = new String("");
		for (int i = 0; i< array.size(); i++){
			if (primeNumber(array.elementAt(i)) == true){
				result += i;
            	result += " ";
	        }
	    }
		return result;
	}
	
	public static boolean primeNumber(int number) {
		if(number == 2) return true;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
            if ((double)i > Math.sqrt((double)number)) {
                return true;
            }
        }
        return false;
    }
}