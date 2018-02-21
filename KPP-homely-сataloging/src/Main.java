import javax.swing.text.BadLocationException;

import GUI.AdminLoginFrame;
import GUI.LoginFrame;
import GUI.MenuFrame;

public class Main {

	public static void main(String[] args) throws BadLocationException {
		// TODO Auto-generated method stub
		MenuFrame menu = new MenuFrame();
		menu.run();
		LoginFrame login = new LoginFrame();
	}

}
