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
		frame.addSortArrayListener(new ActionListeneraddSortArrayButton());
	}
	
	/**
	 * The processing class of the result sort button pressing
	 */
	public class ActionListeneraddSortArrayButton implements ActionListener {
	     public void actionPerformed(ActionEvent e) {
	    	 model.getSort().setNumberOfThreads(Integer.parseInt(frame.threadsNumberText.getText()));
	    	 model.getSort().setArrSize(Integer.parseInt(frame.arraySizeText.getText()));
	    	 model.startSort();
	    	 frame.singleSortTimeText.setText(String.valueOf(model.getSort().getSingleSortTime()));
	    	 frame.multiSortTimeText.setText(String.valueOf(model.getSort().getMultiSortTime()));
	     }
	}
	

}
