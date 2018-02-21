package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegistrationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField LoginField;
	private JPasswordField passwordField;
	private JLabel passwordLable;
	private JLabel loginLabel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationFrame frame = new RegistrationFrame();
					frame.setVisible(true);
					frame.setTitle("Регистрация");
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
	public RegistrationFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 395, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(153, 153, 255));
		panel.setBounds(0, 0, 388, 280);
		contentPane.add(panel);
		
		loginLabel = new JLabel("Логин:");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginLabel.setBounds(105, 46, 186, 30);
		panel.add(loginLabel);
		
		LoginField = new JTextField();
		LoginField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LoginField.setDocument(new JTextFieldLimit(20));
		LoginField.setColumns(10);
		LoginField.setBounds(105, 75, 186, 30);
		panel.add(LoginField);
		
		passwordLable = new JLabel("Пароль:");
		passwordLable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordLable.setBounds(105, 110, 186, 30);
		panel.add(passwordLable);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 140, 186, 30);
		passwordField.setDocument(new JTextFieldLimit(30));
		panel.add(passwordField);
		
		JButton button = new JButton("Регистрация");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(105, 197, 186, 37);
		panel.add(button);
	}

}
