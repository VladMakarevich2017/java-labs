package application;

import controller.MainController;
import model.MainModel;
import view.MainFrame;

public class Main {

	public static void main(String[] args) {
		MainModel model = new MainModel();
		MainFrame frame = new MainFrame(model);
		MainController controller = new MainController(frame, model);
		frame.run();
	}

}
