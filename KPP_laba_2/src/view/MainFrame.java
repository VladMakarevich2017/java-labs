package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MainModel;

/**
 * The class that displays the main window 
 * and all the basic actions take place on this window
 * @author VladMakarevich
 *
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	public JButton refillPaperButton;
	public JButton printButton;
	public JLabel officePaperLabel;
	public JLabel photoPaperLabel;
	public JLabel lengthOfficePaperLabel;
	public JLabel widthOfficePaperLabel;
	public JLabel lengthPhotoPaperLabel;
	public JLabel widthPhotoPaperLabel;
	public JTextField lengthOfficePaperText;
	public JTextField widthOfficePaperText;
	public JTextField lengthPhotoPaperText;
	public JTextField widthPhotoPaperText;

	private JPanel contentPane;
	private MainModel model;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
					setTitle("KPP_laba2_20v");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame(MainModel model) {
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBackground(new Color(50, 73, 87));
		setContentPane(contentPane);
		
		refillPaperButton = new JButton("Заправить принтер");
		printButton = new JButton("Печать");
		officePaperLabel = new JLabel("Офисная бумага");
		photoPaperLabel = new JLabel("   Фотобумага");
		lengthOfficePaperLabel = new JLabel("Длина");
		widthOfficePaperLabel = new JLabel("Ширина");
		lengthPhotoPaperLabel = new JLabel("Длина");
		widthPhotoPaperLabel = new JLabel("Ширина");
		lengthOfficePaperText = new JTextField("100");
		widthOfficePaperText = new JTextField("200");
		lengthPhotoPaperText = new JTextField("150");
		widthPhotoPaperText = new JTextField("330");
		
		getContentPane().add(refillPaperButton, new GridBagConstraints(0, 0 , 2, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(15, 0, 5, 5), 0, 0));
		
		getContentPane().add(printButton, new GridBagConstraints(1, 1 , 3, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(30, 30, 5, 5), 0, 0));
		
		officePaperLabel.setForeground(Color.WHITE);
		officePaperLabel.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(officePaperLabel, new GridBagConstraints(0, 2 , 2, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		photoPaperLabel.setForeground(Color.WHITE);
		photoPaperLabel.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(photoPaperLabel, new GridBagConstraints(4, 2 , 3, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		lengthOfficePaperLabel.setForeground(Color.WHITE);
		getContentPane().add(lengthOfficePaperLabel, new GridBagConstraints(0, 3 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		widthOfficePaperLabel.setForeground(Color.WHITE);
		getContentPane().add(widthOfficePaperLabel, new GridBagConstraints(0, 4 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		lengthPhotoPaperLabel.setForeground(Color.WHITE);
		getContentPane().add(lengthPhotoPaperLabel, new GridBagConstraints(2, 3 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		widthPhotoPaperLabel.setForeground(Color.WHITE);
		getContentPane().add(widthPhotoPaperLabel, new GridBagConstraints(2, 4 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(lengthOfficePaperText, new GridBagConstraints(1, 3 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(widthOfficePaperText, new GridBagConstraints(1, 4 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(lengthPhotoPaperText, new GridBagConstraints(3, 3 , 4, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(widthPhotoPaperText, new GridBagConstraints(3, 4 , 4, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		//pack();
	}
	
	public void addPrintListener(ActionListener e) {
		printButton.addActionListener(e);
	}
	
	public void addRefillPaperListener(ActionListener e) {
		refillPaperButton.addActionListener(e);
	}

}
