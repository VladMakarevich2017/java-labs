package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
	private JPanel inputPanel;
	private JLabel loginLabel;
	private JLabel passwordLabel;
	private JButton entryButton;
	private JButton guestEntryButton;
	private JButton registerButton;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
					frame.setTitle("Авторизация");
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		tuningContentPane();		
		inputPanel = new JPanel();
		tuningInputPanel();				
		loginLabel = new JLabel("Логин:");
		tuningLoginLabel();		
		loginField = new JTextField();
		tuningLoginField();		
		passwordLabel = new JLabel("Пароль:");
		tuningPasswordLabel();				
		passwordField = new JPasswordField();
		tuningPasswordField();				
		entryButton = new JButton("Войти");
		tuningEntryButton();
		guestEntryButton = new JButton("Войти как гость");
		tuningGuestEntryButton();
		
	}
	
	private void tuningContentPane() {
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void tuningInputPanel() {
		inputPanel.setBackground(new Color(135, 206, 250));
		inputPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		inputPanel.setBounds(192, 107, 397, 280);
		contentPane.add(inputPanel);
		inputPanel.setLayout(null);
	}
	
	private void tuningLoginLabel() {
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginLabel.setBounds(105, 46, 186, 30);
		inputPanel.add(loginLabel);
	}
	
	private void tuningLoginField() {
		loginField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginField.setBounds(105, 75, 186, 30);
		loginField.setDocument(new JTextFieldLimit(20));
		inputPanel.add(loginField);
		loginField.setColumns(10);
	}
	
	private void tuningPasswordLabel() {
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordLabel.setBounds(105, 110, 186, 30);
		inputPanel.add(passwordLabel);
	}
	
	private void tuningPasswordField() {
		passwordField.setBounds(105, 140, 186, 30);
		passwordField.setDocument(new JTextFieldLimit(30));
		inputPanel.add(passwordField);
	}
	
	private void tuningEntryButton() {
		entryButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		entryButton.setBounds(105, 197, 186, 37);
		inputPanel.add(entryButton);
	}
	
	private void tuningGuestEntryButton() {
		guestEntryButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		guestEntryButton.setBounds(592, 13, 178, 37);
		contentPane.add(guestEntryButton);
		
		registerButton = new JButton("Регистрация");
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registerButton.setBounds(12, 13, 178, 37);
		contentPane.add(registerButton);
	}
}
