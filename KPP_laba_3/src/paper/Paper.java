package paper;

import java.io.IOException;

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
	protected String content;
	
	/**
	 * default  constructor
	 */
	
	public Paper() {
		length = 0.;
		width = 0.;
		content = "";
	}
	
	public void writeDownContent() throws IOException {
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
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

}
