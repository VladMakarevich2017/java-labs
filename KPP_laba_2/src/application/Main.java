package application;

import controller.MainController;
import model.MainModel;
import paper.OfficePaper;
import paper.Paper;
import paper.PhotoPaper;
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
		OfficePaper officePaper = new OfficePaper();
		PhotoPaper photoPaper = new PhotoPaper();
		Printer printer = new Printer();
		Person person = new Person(printer, officePaper, photoPaper);
		MainModel model = new MainModel(person, printer);
		MainFrame frame = new MainFrame(model);
		MainController controller = new MainController(frame, model);
		frame.run();
	}

}
