package model;

/**
 * The class that is responsible for the logic of the program
 * @author VladMakarevich
 *
 */

public class MainModel {
	
	/**
	 * This method calculates the velocity after 
	 * an inelastic collision of two bodies
	 * @param mass1 - mass of the first body
	 * @param mass2 - mass of the second body
	 * @param speed1 - speed of the first body
	 * @param speed2 - speed of the second body
	 * @return final speed
	 */
	
	public int calculateResultSpeed(int mass1, int mass2, int speed1, int speed2) {
		int resultSpeed = (mass1 * speed1 + mass2 * speed2) / (mass1 + mass2);
		return Math.abs(resultSpeed);
	}
	
	/**
	 * The method for checking the input of numbers in fields
	 * @param arr - array of strings
	 * @return boolean result
	 * @throws NumberFormatException
	 */
	
	public boolean isValidation(String[] arr) throws NumberFormatException {
		try {
			for(int i = 0; i < arr.length; i++) {
				if(Integer.parseInt(arr[i]) <= 0 && (i == 0 || i == 1)) {
					return false;
				}			
			}
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
