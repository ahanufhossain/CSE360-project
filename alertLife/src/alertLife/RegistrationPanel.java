/***************************************************************************************************************
//Team #3
//Team Members: 	Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens
//
//Description: 		This class implements the Registration Panel, which is used to allow a first time user to 
//					input their initial information.
/***************************************************************************************************************/

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
import javax.swing.SwingConstants;

public class RegistrationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextField firstNameField;
	JTextField lastNameField;
	JTextField txtYear;
	JTextField textField;
	JPasswordField passwordField;
	JButton btnRegister;
	JRadioButton radioButtonDoctor;
	JRadioButton rdbtnPatient;
	JComboBox<?> comboBoxMonth;
	JComboBox<?> comboBoxDay;
	JButton btnBack;

	/***************************************************************************************************************
	//Function:		RegistrationPanel()
	//
	//Description:	Constructor for the Registration Panel
	/***************************************************************************************************************/
	public RegistrationPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblRegistration.setBounds(0, 27, 450, 34);
		add(lblRegistration);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblFirstName.setBounds(0, 72, 220, 30);
		add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblLastName.setBounds(0, 112, 220, 30);
		add(lblLastName);

		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Comic Sans MS", Font.BOLD
				| Font.ITALIC, 14));
		firstNameField.setBounds(225, 72, 110, 30);
		add(firstNameField);
		firstNameField.setColumns(10);

		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lastNameField.setBounds(225, 112, 110, 30);
		add(lastNameField);
		lastNameField.setColumns(10);

		comboBoxMonth = new JComboBox();
		comboBoxMonth.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] { "Month",
				"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug",
				"Sept", "Oct", "Nov", "Dec" }));
		comboBoxMonth.setMaximumRowCount(12);
		comboBoxMonth.setBounds(225, 153, 68, 30);
		add(comboBoxMonth);

		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateOfBirth.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDateOfBirth.setBounds(0, 154, 220, 29);
		add(lblDateOfBirth);

		comboBoxDay = new JComboBox();
		comboBoxDay.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBoxDay.setMaximumRowCount(32);
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] { "Day",
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBoxDay.setBounds(303, 153, 56, 30);
		add(comboBoxDay);

		txtYear = new JTextField();
		txtYear.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtYear.setText("Year");
		txtYear.setBounds(370, 153, 49, 30);
		add(txtYear);
		txtYear.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblUsername.setBounds(0, 194, 220, 30);
		add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPassword.setBounds(0, 234, 220, 29);
		add(lblPassword);

		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		textField.setBounds(225, 196, 102, 30);
		add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		passwordField.setBounds(225, 235, 102, 30);
		add(passwordField);

		radioButtonDoctor = new JRadioButton("Doctor");
		radioButtonDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		radioButtonDoctor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		radioButtonDoctor.setBackground(Color.LIGHT_GRAY);
		radioButtonDoctor.setBounds(0, 271, 450, 30);
		add(radioButtonDoctor);
		radioButtonDoctor.setSelected(true);

		rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnPatient.setBackground(Color.LIGHT_GRAY);
		rdbtnPatient.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rdbtnPatient.setBounds(0, 301, 450, 29);
		add(rdbtnPatient);

		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnRegister.setBounds(75, 387, 300, 40);
		add(btnRegister);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnBack.setBounds(75, 337, 300, 40);
		add(btnBack);

		groupButton();

	}

	/***************************************************************************************************************
	//Function:		groupButton()
	//
	//Description:	Groups the radioButtonDoctor and the rdbtnPatient
	/***************************************************************************************************************/
	private void groupButton() {
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButtonDoctor);
		bg.add(rdbtnPatient);
	}

}
