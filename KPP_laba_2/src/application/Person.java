package application;

import paper.Paper;

public class Person {
	
	private Paper officePaper;
	private Paper photoPaper;
	private Printer printer;
	
	public Person() {
		officePaper = new Paper();
		printer = new Printer();
	}
	
	public Person(Printer printer, Paper paper1, Paper paper2) {
		this.printer = printer;
		this.officePaper = paper1;
		this.photoPaper = paper2;
	}
	
	public void refillPaper() {
		printer.setPaper(officePaper, photoPaper);
	}
	
	public void printThis() {
		printer.printText();
		printer.printImage();
	}

}
