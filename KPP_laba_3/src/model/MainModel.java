package model;

import application.Person;
import printer.Printer;
import printer.Xerox;

/**
 * The class that is responsible for the logic of the program
 * @author VladMakarevich
 *
 */

public class MainModel {
	
	private Person person;
	private Printer printer;
	private Xerox xerox;
	
	/**
	 * initialization constructor
	 * @param person
	 * @param printer
	 */
	
	public MainModel(Person person, Printer printer, Xerox xerox) {
		this.person = person;
		this.printer = printer;
		this.xerox = xerox;
	}
	
	/**
	 * default  constructor
	 */
	
	public MainModel() {
		person = new Person();
		printer = new Printer();
	}
	
	public Person getPerson() {
		return person;
	}
	
	public Printer getPrinter() {
		return printer;
	}

	public Xerox getXerox() {
		return xerox;
	}

	public void setXerox(Xerox xerox) {
		this.xerox = xerox;
	}
	
	
}