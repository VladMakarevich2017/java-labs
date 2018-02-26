package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textSearchField;
	private JMenuBar mainMenuBar;
	private JMenu filesManagementMenu;
	private JMenuItem menuItemForAdding;
	private JMenuItem menuItemForOpenning;
	private JMenuItem menuItemForSaving;
	private JMenu filterMenu;
	private JMenuItem filterSettingMenuItem;
	private JCheckBox filterSwitchMenuItem;
	private JMenuBar informationManagementMenu;
	private JMenu menuAddingInformation;
	private JMenuItem documentsMenuItem;
	private JMenuItem booksMenuItem;
	private JMenuItem soundsMenuItem;
	private JMenuItem videoMenuItem;
	private JTabbedPane tabbedPane;
	private DefaultListModel<String> documentsListModel;
	private JList<String> documentsList;
	private DefaultListModel<String> booksListModel;
	private JList<String> booksList;
	private DefaultListModel<String> soudsListModel;
	private JList<String> soudsList;
	private DefaultListModel<String> videoListModel;
	private JList<String> videoList;
	private JScrollPane scrollPane;
	private JTextArea informationArea;
	private JLabel searchLabel;
	private JButton exitButton;
	private JLabel loginLabel;
	private Component rigidArea_3;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
					setTitle("Cataloguer (Russian)");
					setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws BadLocationException 
	 */
	public MenuFrame() throws BadLocationException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainMenuBar = new JMenuBar();
		mainMenuBar.setBounds(5, 5, 996, 26);
		
		filesManagementMenu = new JMenu("Файл");
		filesManagementMenu.setPreferredSize(new Dimension(70, 24));
		mainMenuBar.add(filesManagementMenu);
		
		menuItemForAdding = new JMenuItem("Добавить");
		menuItemForAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		filesManagementMenu.add(menuItemForAdding);
		
		menuItemForOpenning = new JMenuItem("Открыть");
		menuItemForOpenning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		filesManagementMenu.add(menuItemForOpenning);
		
		menuItemForSaving = new JMenuItem("Сохранить");
		menuItemForSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		filesManagementMenu.add(menuItemForSaving);
		
		filterMenu = new JMenu("Фильтры");
		filterMenu.setPreferredSize(new Dimension(70, 24));
		mainMenuBar.add(filterMenu);
		
		filterSettingMenuItem = new JMenuItem("Настроить фильтр");
		filterSettingMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		filterMenu.add(filterSettingMenuItem);
		
		filterSwitchMenuItem = new JCheckBox("Включить фильтр");
		filterSwitchMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		filterMenu.add(filterSwitchMenuItem);
		contentPane.add(mainMenuBar);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(804, 20));
		mainMenuBar.add(rigidArea_2);
		
		loginLabel = new JLabel("");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mainMenuBar.add(loginLabel);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(-26, 20));
		mainMenuBar.add(rigidArea_3);
		
		exitButton = new JButton("Выход");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				LoginFrame login = new LoginFrame();
				login.run();
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mainMenuBar.add(exitButton);
		
		informationManagementMenu = new JMenuBar();
		informationManagementMenu.setBounds(5, 33, 991, 48);
		contentPane.add(informationManagementMenu);
		
		menuAddingInformation = new JMenu("Добавить");
		tuningMenuAddingInformation();
		informationManagementMenu.add(menuAddingInformation);
		
		documentsMenuItem = new JMenuItem("Документы");
		documentsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuAddingInformation.add(documentsMenuItem);
		
		booksMenuItem = new JMenuItem("Книги");
		booksMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuAddingInformation.add(booksMenuItem);
		
		soundsMenuItem = new JMenuItem("Аудио");
		soundsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuAddingInformation.add(soundsMenuItem);
		
		videoMenuItem = new JMenuItem("Видео");
		videoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuAddingInformation.add(videoMenuItem);
		
		Component rigidArea = Box.createRigidArea(new Dimension(483, 20));
		informationManagementMenu.add(rigidArea);
		
		searchLabel = new JLabel("Поиск:");
		searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		informationManagementMenu.add(searchLabel);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(6, 20));
		informationManagementMenu.add(rigidArea_1);
		
		textSearchField = new JTextField();
		textSearchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textSearchField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		informationManagementMenu.add(textSearchField);
		textSearchField.setBorder(UIManager.getBorder("MenuBar.border"));
		textSearchField.setMaximumSize(new Dimension(250, 50));
		textSearchField.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 94, 368, 614);
		contentPane.add(tabbedPane);
		
		documentsListModel = new DefaultListModel<String>(); 
		documentsList = new JList<String>(documentsListModel);
		tuningDocumentsList();
		
		booksListModel = new DefaultListModel<String>(); 
		booksList = new JList<String>(booksListModel);
		tuningBooksList();
		
		soudsListModel = new DefaultListModel<String>(); 
		soudsList = new JList<String>(soudsListModel);
		tuningSoundsList();
		
		videoListModel = new DefaultListModel<String>(); 
		videoList = new JList<String>(videoListModel);
		tuningVideoList();
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(385, 116, 611, 592);
		contentPane.add(scrollPane);
		
		informationArea = new JTextArea();
		informationArea.setEditable(false);
		informationArea.setLineWrap(true);
		informationArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		informationArea.setText("Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!Test!");
		informationArea.setCaretPosition(informationArea.getLineStartOffset(informationArea.getLineCount() - 1));
		scrollPane.setViewportView(informationArea);
		
	}
	
	private void tuningMenuAddingInformation() {
		menuAddingInformation.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		menuAddingInformation.setBorderPainted(true);
		menuAddingInformation.setBackground(Color.DARK_GRAY);
		menuAddingInformation.setHorizontalTextPosition(SwingConstants.CENTER);
		menuAddingInformation.setHorizontalAlignment(SwingConstants.CENTER);
		menuAddingInformation.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuAddingInformation.setPreferredSize(new Dimension(200, 24));
	}
	
	private void tuningDocumentsList() {
		documentsListModel.addElement("Test Document Element №1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		documentsListModel.addElement("Test Document Element №2");
		documentsList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.addTab("Документы", null, documentsList, null);
		documentsList.setModel(documentsListModel);
		documentsList.addMouseListener(new MouseAdapter() {
		    @SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent event) {
		        JList<String> documentsList = (JList<String>)event.getSource();
		        if (event.getClickCount() == 2) {
		            //int index = documentsList.locationToIndex(event.getPoint());
		        } 
		    }
		});
	}
	
	private void tuningBooksList() {
		booksListModel.addElement("Test Book Element №1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		booksListModel.addElement("Test Book Element №2");
		booksList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.addTab("Книги", null, booksList, null);
		booksList.setModel(booksListModel);
		booksList.addMouseListener(new MouseAdapter() {
		    @SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent event) {
		        JList<String> booksList = (JList<String>)event.getSource();
		        if (event.getClickCount() == 2) {
		            //int index = booksList.locationToIndex(event.getPoint());
		        } 
		    }
		});
	}
	
	private void tuningSoundsList() {
		soudsListModel.addElement("Test Sound Element №1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		soudsListModel.addElement("Test Sound Element №2");	
		soudsList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.addTab("Аудио", null, soudsList, null);
		soudsList.setModel(soudsListModel);
		soudsList.addMouseListener(new MouseAdapter() {
		    @SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent event) {
		        JList<String> soudsList = (JList<String>)event.getSource();
		        if (event.getClickCount() == 2) {
		            //int index = soudsList.locationToIndex(event.getPoint());
		        } 
		    }
		});	
	}
	
	private void tuningVideoList() {	
		videoListModel.addElement("Test Film Element №1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		videoListModel.addElement("Test Film Element №2");
		videoList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.addTab("Видео", null, videoList, null);
		videoList.setModel(videoListModel);
		videoList.addMouseListener(new MouseAdapter() {
		    @SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent event) {
		        JList<String> videoList = (JList<String>)event.getSource();
		        if (event.getClickCount() == 2) {
		            //int index = videoList.locationToIndex(event.getPoint());
		        } 
		    }
		});
	}
}
