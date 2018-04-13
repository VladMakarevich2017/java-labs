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
	
	public JButton sortArrayButton;
	public JLabel threadsNumberLabel;
	public JTextField threadsNumberText;
	public JLabel arraySizeLabel;
	public JTextField arraySizeText;
	public JLabel sortTimeLabel;
	public JLabel singleSortTimeLabel;
	public JTextField singleSortTimeText;
	public JLabel multiSortTimeLabel;
	public JTextField multiSortTimeText;

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
					setTitle("KPP_laba4_20v");
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
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBackground(new Color(50, 73, 87));
		setContentPane(contentPane);
		
		sortArrayButton = new JButton("Сортировать");
		threadsNumberLabel = new JLabel("Количество потоков");
		threadsNumberText = new JTextField("");;
		arraySizeLabel = new JLabel("Размер массива");
		arraySizeText = new JTextField("");;
		sortTimeLabel = new JLabel("Время сортировки");
		singleSortTimeLabel = new JLabel("Однопоточная");
		singleSortTimeText = new JTextField("");;
		multiSortTimeLabel = new JLabel("       Многопоточная");
		multiSortTimeText = new JTextField("");;
		
		threadsNumberLabel.setForeground(Color.WHITE);
		//threadsNumberLabel.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(threadsNumberLabel, new GridBagConstraints(0, 0 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(threadsNumberText, new GridBagConstraints(1, 0 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		arraySizeLabel.setForeground(Color.WHITE);
		//arraySizeLabel.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(arraySizeLabel, new GridBagConstraints(0, 1 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(arraySizeText, new GridBagConstraints(1, 1 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(sortArrayButton, new GridBagConstraints(0, 2 , 2, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(30, 5, 5, 5), 0, 0));
		
		sortTimeLabel.setForeground(Color.WHITE);
		sortTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(sortTimeLabel, new GridBagConstraints(0, 3 , 2, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		singleSortTimeLabel.setForeground(Color.WHITE);
		//singleSortTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(singleSortTimeLabel, new GridBagConstraints(0, 4 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		multiSortTimeLabel.setForeground(Color.WHITE);
		//multiSortTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(multiSortTimeLabel, new GridBagConstraints(1, 4 , 0, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(singleSortTimeText, new GridBagConstraints(0, 5 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
		
		getContentPane().add(multiSortTimeText, new GridBagConstraints(1, 5 , 1, 1, 0.0, 0.9,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 5, 5, 5), 0, 0));
	}
	
	public void addSortArrayListener(ActionListener e) {
		sortArrayButton.addActionListener(e);
	}
	

}
