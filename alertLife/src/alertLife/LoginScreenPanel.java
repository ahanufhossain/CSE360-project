package alertLife;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreenPanel extends JPanel {
	private JTextField fieldUsername;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginScreenPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblLogin.setBounds(203, 85, 43, 26);
		add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPassword.setBounds(137, 195, 61, 17);
		add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblUsername.setBounds(137, 148, 73, 19);
		add(lblUsername);
		
		fieldUsername = new JTextField();
		fieldUsername.setToolTipText("10 Characters or less, no special characters.");
		fieldUsername.setBounds(229, 149, 73, 18);
		add(fieldUsername);
		fieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 196, 73, 17);
		add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnLogin.setBounds(165, 239, 119, 26);
		add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegister.setBounds(165, 343, 119, 26);
		add(btnRegister);

	}
}
