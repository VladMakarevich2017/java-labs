package model;

import application.Person;
import printer.Printer;

/**
 * The class that is responsible for the logic of the program
 * @author VladMakarevich
 *
 */

public class MainModel {
	
	private Person person;
	private Printer printer;
	
	/**
	 * initialization constructor
	 * @param person
	 * @param printer
	 */
	
	public MainModel(Person person, Printer printer) {
		this.person = person;
		this.printer = printer;
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
	
	
}
