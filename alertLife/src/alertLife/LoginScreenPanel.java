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
import javax.swing.SwingConstants;

public class LoginScreenPanel extends JPanel {
	JTextField fieldUsername;
	JPasswordField passwordField;
	JButton btnLogin;
	JButton btnRegister;

	/**
	 * Create the panel.
	 */
	public LoginScreenPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblLogin.setBounds(0, 85, 450, 26);
		add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPassword.setBounds(0, 190, 220, 30);
		add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblUsername.setBounds(0, 150, 220, 30);
		add(lblUsername);
		
		fieldUsername = new JTextField();
		fieldUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		fieldUsername.setToolTipText("10 Characters or less, no special characters.");
		fieldUsername.setBounds(225, 150, 110, 30);
		add(fieldUsername);
		fieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		passwordField.setBounds(225, 190, 110, 30);
		add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnLogin.setBounds(75, 399, 300, 40);
		add(btnLogin);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegister.setBounds(75, 449, 300, 40);
		add(btnRegister);

	}
}
