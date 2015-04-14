/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the Registration Panel, which is used to allow a first time user to input their initial informaton.

/***********************************************/

package alertLife;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class RegistrationPanel extends JPanel {
	JTextField firstNameField;
	JTextField lastNameField;
	JTextField txtYear;
	JTextField textField;
	JPasswordField passwordField;
	JButton btnRegister;
	JRadioButton radioButtonDoctor;
	JRadioButton rdbtnPatient;
	JComboBox comboBoxMonth;
	JComboBox comboBoxDay;

	/**
	 * Create the panel.
	 */
	public RegistrationPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistration.setBounds(170, 39, 110, 22);
		add(lblRegistration);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblFirstName.setBounds(48, 83, 80, 22);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblLastName.setBounds(48, 120, 80, 14);
		add(lblLastName);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(262, 85, 102, 22);
		add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(262, 118, 102, 22);
		add(lastNameField);
		lastNameField.setColumns(10);
		
		comboBoxMonth = new JComboBox();
		comboBoxMonth.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec"}));
		comboBoxMonth.setMaximumRowCount(12);
		comboBoxMonth.setBounds(212, 165, 68, 27);
		add(comboBoxMonth);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDateOfBirth.setBounds(48, 171, 95, 14);
		add(lblDateOfBirth);
		
		comboBoxDay = new JComboBox();
		comboBoxDay.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBoxDay.setMaximumRowCount(32);
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setBounds(290, 165, 56, 26);
		add(comboBoxDay);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtYear.setText("Year");
		txtYear.setBounds(362, 167, 49, 22);
		add(txtYear);
		txtYear.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblUsername.setBounds(48, 227, 80, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPassword.setBounds(48, 265, 68, 14);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(262, 225, 102, 22);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(262, 263, 102, 22);
		add(passwordField);
		
		radioButtonDoctor = new JRadioButton("Doctor");
		radioButtonDoctor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		radioButtonDoctor.setBackground(Color.LIGHT_GRAY);
		radioButtonDoctor.setBounds(284, 312, 80, 22);
		add(radioButtonDoctor);
		radioButtonDoctor.setSelected(true);
		
		rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setBackground(Color.LIGHT_GRAY);
		rdbtnPatient.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rdbtnPatient.setBounds(284, 336, 85, 27);
		add(rdbtnPatient);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnRegister.setBounds(180, 385, 89, 23);
		add(btnRegister);
		
		groupButton();

	}
	
	private void groupButton()
	{
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButtonDoctor);
		bg.add(rdbtnPatient);
	}
	
}
