package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.MainModel;

/**
 * The class manages events that occur on the main window
 * In the class, we pass the view and model references
 * @author VladMakarevich
 *
 */

public class MainController {
	
	private Main frame;
	private MainModel model;
	
	
	/**
	 * In the constructor, we pass the view and model references 
	 * and and add event processing to the frame
	 */
	public MainController(Main frame, MainModel model) {
		this.frame = frame;
		this.model = model;
		//frame.addPrintListener(new ActionListenerPrintButton());
		//frame.addRefillPaperListener(new ActionListenerRefillPaperButton());
	}
	
	/**
	 * The processing class of the result print button pressing
	 */
	public class ActionListenerPrintButton implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent arg0) {
			model.getPerson().printText();
   		 	model.getPerson().printImage();
   		 	frame.lengthOfficePaperText.setText(String.valueOf(model.getPrinter().getOfficePaper().getLength()));
   		 	frame.widthOfficePaperText.setText(String.valueOf(model.getPrinter().getOfficePaper().getWidth()));
   		 	frame.lengthPhotoPaperText.setText(String.valueOf(model.getPrinter().getPhotoPaper().getLength()));
   		 	frame.widthPhotoPaperText.setText(String.valueOf(model.getPrinter().getPhotoPaper().getWidth()));
   		 	model.getPrinter().setOfficePaper(null);
   		 	model.getPrinter().setPhotoPaper(null);
		}
	}
	
	/**
	 * The processing class of the result refill paper button pressing
	 */
	
	public class ActionListenerRefillPaperButton implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {	
			model.getPerson().refillOfficePaper();
	        model.getPerson().refillPhotoPaper();
		}
	}

}
