package application;

import paper.Paper;

public class Person {
	
	private Paper paper;
	private Printer printer;
	
	public Person() {
		paper = new Paper();
		printer = new Printer();
	}
	
	public Person(Paper paper) {
		this.paper = paper;
	}
	
	public void printText() {
		
	}
	
	public void printImage() {
		
	}

}
