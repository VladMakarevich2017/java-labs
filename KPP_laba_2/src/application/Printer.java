package application;

import java.util.Random;

import paper.Paper;

/**
 * class describes the printer and 
 * stores links to paper
 * @author VladMakarevich
 *
 */

public class Printer {
	
	private Paper officePaper;
	private Paper photoPaper;
	Random rnd;
	
	/**
	 * default  constructor
	 */
	
	public Printer() {
		rnd = new Random(System.currentTimeMillis()); 
	}
	
	/**
	 * method sets references to paper
	 * @param paper1 - first type of paper
	 * @param paper2 - - second type of paper
	 */
	
	public void setPaper(Paper paper1, Paper paper2) {
		this.officePaper = paper1;
		this.setPhotoPaper(paper2);
	}
	
	/**
	 * The method prints text 
	 * and changes the paper size
	 */
	
	public void printText() {
		officePaper.setLength(70 + rnd.nextInt(30));
		officePaper.setWidth(10 + rnd.nextInt(50));
	}
	
	/**
	 * The method prints image 
	 * and changes the paper size
	 */
	
	public void printImage() {
		photoPaper.setLength(70 + rnd.nextInt(30));
		photoPaper.setWidth(10 + rnd.nextInt(50));
	}

	public Paper getPhotoPaper() {
		return photoPaper;
	}

	public void setPhotoPaper(Paper photoPaper) {
		this.photoPaper = photoPaper;
	}

	public Paper getOfficePaper() {
		return officePaper;
	}

	public void setOfficePaper(Paper officePaper) {
		this.officePaper = officePaper;
	}
	
	
	
	

}
