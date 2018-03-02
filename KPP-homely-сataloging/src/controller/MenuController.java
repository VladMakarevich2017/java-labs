package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.JList;

import org.w3c.dom.events.MouseEvent;

import View.LoginFrame;
import View.MenuFrame;

public class MenuController {
	
	private MenuFrame frame;
	
	public MenuController(MenuFrame frame) {
		this.frame = frame;
		frame.addMenuItemForOpenninListener(new MenuItemForOpenninListener());
	}
	
	class MenuItemForOpenninListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.createFileChooser();
		}
	}
	
	class MenuItemForSavingListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {		
		}
	}
	
	class ExitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			frame.dispose();
			LoginFrame login = new LoginFrame();
			login.run();
		}
	}
	
	class AddButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.createFileChooser();
		}
	}
	
	class TextSearchFieldListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {		
		}
	}
	
//	class DocumentsListListener extends MouseAdapter {
//		public void mouseClicked(MouseEvent event) {
//	        JList<String> documentsList = (JList<String>)event.getSource();
//	        if (event.getClickCount() == 2) {
//	            //int index = documentsList.locationToIndex(event.getPoint());
//	        } 
//	    }
//		
//	}

}
