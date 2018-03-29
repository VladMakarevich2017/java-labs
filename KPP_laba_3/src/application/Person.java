package application;

import paper.Paper;
import printer.Printer;

/**
 * A class that describes a person stores links 
 * to a printer and various types of paper
 * @author VladMakarevich
 *
 */

public class Person {
	
	private Paper officePaper;
	private Paper photoPaper;
	private Printer printer;
	
	/**
	 * default  constructor
	 */
	
	public Person() {
		officePaper = new Paper();
		printer = new Printer();
	}
	
	/**
	 * initialization constructor
	 * @param printer - printer
	 * @param paper1 - first type of paper
	 * @param paper2 - second type of paper
	 */
	
	public Person(Printer printer, Paper paper1, Paper paper2) {
		this.printer = printer;
		this.officePaper = paper1;
		this.photoPaper = paper2;
	}
	
	/**
	 * method fills the printer with paper
	 */
	
	public void refillOfficePaper() {
		printer.setOfficePaper(officePaper);
	}
	
	public void refillPhotoPaper() {
		printer.setPhotoPaper(photoPaper);
	}
	
	
	/**
	 * method prints text and images on paper
	 */
	
	public void printText() {
		printer.printText();
	}
	
	public void printImage() {
		printer.printImage();
	}

}
