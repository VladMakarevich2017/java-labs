package paper;

/**
 * Class describing paper. 
 * Stores information about 
 * the length and width of paper
 * @author VladMakarevich
 *
 */

public class Paper {
	
	protected double length;
	protected double width;
	
	/**
	 * default  constructor
	 */
	
	public Paper() {
		length = 0.;
		width = 0.;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}

}
