/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the graphical user interface. The user starts by first logging into their account.
//				After account validation, the user can update their info, view notifications (doctor), and submit a new diagnosis entry (patient).

/***********************************************/

package alertLife;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class alertLife_gui {

	private JFrame loginScreen;
//	private JFrame register;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alertLife_gui window = new alertLife_gui();
					window.loginScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public alertLife_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginScreen = new JFrame();
		loginScreen.setResizable(false);
		loginScreen.getContentPane().setBackground(Color.LIGHT_GRAY);
		loginScreen.setBounds(100, 100, 505, 505);
		loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginScreen.getContentPane().setLayout(null);
		
		JButton btnLogIn = new JButton("Sign On");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogIn.setBounds(201, 240, 89, 23);
		loginScreen.getContentPane().add(btnLogIn);
		
		textField = new JTextField();
		textField.setBounds(251, 145, 86, 20);
		loginScreen.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(251, 186, 86, 20);
		loginScreen.getContentPane().add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(201, 308, 89, 23);
		loginScreen.getContentPane().add(btnRegister);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblLogin.setBounds(223, 96, 46, 14);
		loginScreen.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblUsername.setBounds(173, 146, 68, 17);
		loginScreen.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblPassword.setBounds(173, 187, 68, 17);
		loginScreen.getContentPane().add(lblPassword);
	}
}
