package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		frame.addPrintListener(new ActionListenerPrintButton());
		frame.addRefillPaperListener(new ActionListenerRefillPaperButton());
	}
	
	/**
	 * The processing class of the result button pressing
	 */
	public class ActionListenerPrintButton implements ActionListener {
	     public void actionPerformed(ActionEvent e) {
	    	 if(model.getPrinter().getOfficePaper() != null && model.getPrinter().getPhotoPaper() != null) {
	    		 model.getPerson().printThis();
		    	 frame.lengthOfficePaperText.setText(String.valueOf(model.getPrinter().getOfficePaper().getLength()));
		    	 frame.widthOfficePaperText.setText(String.valueOf(model.getPrinter().getOfficePaper().getWidth()));
		    	 frame.lengthPhotoPaperText.setText(String.valueOf(model.getPrinter().getPhotoPaper().getLength()));
		    	 frame.widthPhotoPaperText.setText(String.valueOf(model.getPrinter().getPhotoPaper().getWidth()));
	    	 }	 
	     }
	}
	
	public class ActionListenerRefillPaperButton implements ActionListener {
	     public void actionPerformed(ActionEvent e) {
	          model.getPerson().refillPaper();
	     }
	}

}
