package application;
import javax.swing.text.BadLocationException;

import GUI.LoginFrame;
import GUI.MenuFrame;
import GUI.RegistrationFrame;

public class Main {

	public static void main(String[] args) throws BadLocationException {
		MenuFrame menu = new MenuFrame();
		menu.run();
		LoginFrame login = new LoginFrame();
		login.run();
		RegistrationFrame reg = new RegistrationFrame();
		reg.run();
	}
}
