package controller;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import model.MainModel;
import view.MainFrame;

/**
 * The class manages events that occur on the main window
 * In the class, we pass the view and model references
 * @author VladMakarevich
 *
 */

public class MainController {
	
	private MainFrame frame;
	private MainModel model;
	
	
	/**
	 * In the constructor, we pass the view and model references 
	 * and and add event processing to the frame
	 */
	public MainController(MainFrame frame, MainModel model) {
		this.frame = frame;
		this.model = model;
		//frame.addCalculateListener(new CalculateButtonSelectionAdapter());
	}
	
	/**
	 * The processing class of the result button pressing
	 */
	class CalculateButtonSelectionAdapter extends SelectionAdapter{

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			String[] strArray = {frame.massText1.getText(), frame.massText2.getText(), frame.speedText1.getText(), frame.speedText2.getText()};
			if(model.isValidation(strArray)) {
				int mass1 = Integer.parseInt(frame.massText1.getText());
				int mass2 = Integer.parseInt(frame.massText2.getText());
				int speed1 = Integer.parseInt(frame.speedText1.getText());
				int speed2 = Integer.parseInt(frame.speedText2.getText());
				int result = model.calculateResultSpeed(mass1, mass2, speed1, speed2);
				frame.resultLabel.setText(Integer.toString(result));
			} else {
				frame.resultLabel.setText("");
			}
			frame.resetTextFields();
		}

    }

}
