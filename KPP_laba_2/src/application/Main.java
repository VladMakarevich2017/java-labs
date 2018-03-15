package application;

import controller.MainController;
import model.MainModel;
import view.MainFrame;

/**
 * The program calculates the final speed 
 * after an inelastic collision of two bodies 
 * with given masses and velocities
 * @author VladMakarevich
 *
 */

public class Main {

	/**
	 * Start the program
	 */
	public static void main(String[] args) {
		MainModel model = new MainModel();
		MainFrame frame = new MainFrame(model);
		MainController controller = new MainController(frame, model);
		frame.run();
	}

}
