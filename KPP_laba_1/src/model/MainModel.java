package model;

public class MainModel {
	
	public int calculateResultSpeed(int mass1, int mass2, int speed1, int speed2) {
		int resultSpeed = (mass1 * speed1 + mass2 * speed2) / (mass1 + mass2);
		return Math.abs(resultSpeed);
	}
	
	public boolean isValidation(String[] arr) throws NumberFormatException {
		try {
			for(int i = 0; i < arr.length; i++) {
				if(Integer.parseInt(arr[i]) == 0 && (i == 0 || i == 1)) {
					return false;
				}			
			}
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
