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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class alertLife_gui_registermod {

	private JFrame frmRegister;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField dobField;
	private JTextField userNameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alertLife_gui_registermod window = new alertLife_gui_registermod();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public alertLife_gui_registermod() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmRegister.setResizable(false);
		frmRegister.setBounds(100, 100, 505, 505);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblNewLabel.setBounds(202, 53, 113, 35);
		frmRegister.getContentPane().add(lblNewLabel);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(260, 131, 86, 20);
		frmRegister.getContentPane().add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(260, 163, 86, 20);
		frmRegister.getContentPane().add(lastNameField);
		lastNameField.setColumns(10);
		
		dobField = new JTextField();
		dobField.setBounds(260, 194, 86, 20);
		frmRegister.getContentPane().add(dobField);
		dobField.setColumns(10);
		
		userNameField = new JTextField();
		userNameField.setBounds(260, 225, 86, 20);
		frmRegister.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(260, 256, 86, 20);
		frmRegister.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(175, 131, 75, 20);
		frmRegister.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(175, 163, 75, 20);
		frmRegister.getContentPane().add(lblLastName);
		
		JLabel lblDob = new JLabel("Date of Birth (MM/DD/YYYY)");
		lblDob.setBounds(92, 193, 158, 20);
		frmRegister.getContentPane().add(lblDob);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(175, 224, 75, 20);
		frmRegister.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(175, 259, 75, 14);
		frmRegister.getContentPane().add(lblPassword);
		
		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setBackground(Color.LIGHT_GRAY);
		rdbtnDoctor.setBounds(221, 301, 109, 23);
		frmRegister.getContentPane().add(rdbtnDoctor);
		
		JRadioButton rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setBackground(Color.LIGHT_GRAY);
		rdbtnPatient.setBounds(221, 324, 109, 23);
		frmRegister.getContentPane().add(rdbtnPatient);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.setBounds(212, 354, 89, 23);
		frmRegister.getContentPane().add(btnNewButton);
	}
}
