import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	private static Scanner in = new Scanner(System.in);
	public static Vector<Integer> array = new Vector<Integer>();
	public static int arraySize;
	private static Random random = new Random(System.currentTimeMillis());
	
	public static void main(String[] args) {
		System.out.print("Enter the size of the array: ");
		arraySize = in.nextInt();
		showMenu();
		int selectedOption = in.nextInt();
		functionSelection(selectedOption);
		System.out.println(searchPrimeNumbers());
	}
	
	public static void showMenu() {
		System.out.println("1)Fill the array yourself");
		System.out.println("2)Fill the array randomly");
		System.out.println("3)Fill the array sequentially");
	}
	
	public static void functionSelection(int selectedOption) {
		switch(selectedOption) {
		case 1: fillingArrayManually();
			break;
		case 2: fillingArrayRandomly();
			break;
		case 3: fillingArraySequentially();
			break;
		}
	}
	
	public static void fillingArrayManually() {
		array.removeAllElements();
		for(int i = 0; i < arraySize; i++) {
			System.out.print("Element ¹" + i + " = ");
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
	
//	public void menu() {
//		while(true) {
//			//System.out.println("\n\n\n\n\n\n\n\n\n\n\n"); 
//			showMenu();
//			int selectedFunction = selectFunction();
//			switch(selectedFunction) {
//			case 1: 
//				break;
//			case 2: 
//				break;
//			case 3: searchNumbersOfPrimeNumerics(Vector<Integer>);
//				break;
//			case 4:
//				break;
//			}
//		}
//	}
//	
//	private int selectFunction() {
//		while(true) {
//			int selectedFunction;
//			selectedFunction = in.nextInt();
//			if(selectedFunction > NUMBER_OF_FUNCTIONS && selectedFunction < 1 && checkingSelectionErrors(selectedFunction)) {
//				continue;
//			} else {
//				return selectedFunction;
//			}
//		}	
//	}
//	
//	private boolean checkingSelectionErrors(int selectedFunction) {
//		
//	}
//	
//	private Vector<Integer> searchNumbersOfPrimeNumerics(Vector<Integer> array) {
//		
//	}
//	
//	private void showMenu() {
//		System.out.printf("Array size: " + arraySize + "; ");
//		if(arrayValidation(array)) {
//			System.out.print("!!Array is empty!!");
//		} else {
//			System.out.print("The array is ready for use.");
//		}
//		System.out.print("1)Set new array size");
//		System.out.print("2)Set array elements values");
//		System.out.print("3)Find prime numbers");
//		System.out.print("4)Exit");
//	}
//	
//	private boolean arrayValidation(Vector<Integer> array) {
//		return true;
//	}
//	
//	public Main() {
//		arraySize = new Integer(0);
//		array = new Vector<Integer>();
//	}
//	
//	public Main(int arraySize) {
//		this.arraySize = new Integer(arraySize);
//		array = new Vector<Integer>();
//	}
//	
//	public Main(Vector<Integer> array) {
//		this.array = new Vector<Integer>(array);
//		arraySize = new Integer(array.size());
//	}
//
//	public int getArraySize() {
//		return arraySize;
//	}
//
//	public void setArraySize(int arraySize) {
//		this.arraySize = arraySize;
//	}
//
//	public Vector<Integer> getArray() {
//		return array;
//	}
//
//	public void setArray(Vector<Integer> array) {
//		this.array = array;
//	}

}