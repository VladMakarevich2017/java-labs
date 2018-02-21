package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(192, 107, 397, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u041B\u043E\u0433\u0438\u043D:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(105, 46, 186, 30);
		panel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(105, 75, 186, 30);
		textField.setDocument(new JTextFieldLimit(20));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u041F\u0430\u0440\u043E\u043B\u044C:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(105, 110, 186, 30);
		panel.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 140, 186, 30);
		passwordField.setDocument(new JTextFieldLimit(30));
		panel.add(passwordField);
		
		JButton button = new JButton("\u0412\u043E\u0439\u0442\u0438");
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(105, 197, 186, 37);
		panel.add(button);
		
		JButton btnNewButton = new JButton("Войти как гость");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(592, 13, 178, 37);
		contentPane.add(btnNewButton);
	}
}
