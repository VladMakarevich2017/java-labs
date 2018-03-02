package controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import model.MainModel;
import view.MainFrame;

public class MainController {
	
	private MainFrame frame;
	private MainModel model;
	
	public MainController(MainFrame frame, MainModel model) {
		this.frame = frame;
		this.model = model;
		//frame.addCalculateListener(new CalculateButtonSelectionAdapter());
	}
	
	class CalculateButtonSelectionAdapter implements SelectionListener{

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {		
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			
		}

    }

}
