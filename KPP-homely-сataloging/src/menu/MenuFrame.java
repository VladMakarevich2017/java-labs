package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
					frame.setVisible(true);
					frame.setTitle("Cataloguer (Russian)");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 5, 996, 26);
		
		JMenu mnNewMenu = new JMenu("Файл");
		mnNewMenu.setPreferredSize(new Dimension(70, 24));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Добавить");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Открыть");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Сохранить");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu menu = new JMenu("Фильтры");
		menu.setPreferredSize(new Dimension(70, 24));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Настроить фильтр");
		menu.add(mntmNewMenuItem_3);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Включить фильтр");
		menu.add(chckbxNewCheckBox);
		
		Component rigidArea = Box.createRigidArea(new Dimension(553, 20));
		menuBar.add(rigidArea);
		
		JTextPane txtpnAsd = new JTextPane();
		txtpnAsd.setEditable(false);
		txtpnAsd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnAsd.setBackground(SystemColor.menu);
		txtpnAsd.setBorder(UIManager.getBorder("MenuBar.border"));
		txtpnAsd.setMaximumSize(new Dimension(50, 50));
		txtpnAsd.setPreferredSize(new Dimension(0, 22));
		txtpnAsd.setText("Поиск:");
		menuBar.add(txtpnAsd);
		
		textField = new JTextField();
		textField.setBorder(UIManager.getBorder("MenuBar.border"));
		textField.setMaximumSize(new Dimension(250, 50));
		menuBar.add(textField);
		textField.setColumns(10);
		contentPane.add(menuBar);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(5, 33, 991, 48);
		contentPane.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("Добавить");
		mnNewMenu_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mnNewMenu_1.setBorderPainted(true);
		mnNewMenu_1.setBackground(Color.DARK_GRAY);
		mnNewMenu_1.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu_1.setPreferredSize(new Dimension(200, 24));
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Документы");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Книги");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Аудио");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Видео");
		mnNewMenu_1.add(mntmNewMenuItem_7);
	}
}
