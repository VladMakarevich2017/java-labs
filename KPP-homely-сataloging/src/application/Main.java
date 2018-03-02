package application;

import javax.swing.text.BadLocationException;

import View.LoginFrame;
import View.MenuFrame;
import View.RegistrationFrame;
import domain.Book;
import domain.Catalog;

public class Main {

	public static void main(String[] args) throws BadLocationException {
		MenuFrame menu = new MenuFrame();
		menu.run();
		//LoginFrame login = new LoginFrame();
		//login.run();
		//RegistrationFrame reg = new RegistrationFrame();
		//reg.run();
	}
}
