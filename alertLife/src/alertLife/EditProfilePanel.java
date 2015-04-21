/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the EditProfile panel, which lets a user modify their name, date of birth, username, and password.

/***********************************************/

package alertLife;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditProfilePanel extends JPanel {
	
	public JLabel titleLabel;
	public JLabel nameLabel;
	public JLabel dobLabel;
	public JLabel usernameLabel;
	public JLabel passwordLabel;
	
	public JTextField nameField;
	public JTextField dobField;
	public JTextField usernameField;
	public JTextField passwordField;
	
	public JButton saveButton;
	public JButton cancelButton;
	
	/**
	 * Create the panel.
	 */
	public EditProfilePanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		titleLabel = new JLabel("Edit Profile");
		nameLabel = new JLabel("Name: ");
		nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dobLabel = new JLabel("DOB: ");
		dobLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		usernameLabel = new JLabel("Username: ");
		usernameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		dobField = new JTextField();
		dobField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		usernameField = new JTextField();
		usernameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		passwordField = new JTextField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		saveButton = new JButton("Save");
		cancelButton = new JButton("Back");
		
		// set font for each component
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		dobLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		saveButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		
		//bounds				
		titleLabel.setBounds(0, 55, 450, 20);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(0, 100, 215, 30);
		nameField.setBounds(225, 100, 110, 30);
		dobLabel.setBounds(0, 141, 220, 30);
		dobField.setBounds(225, 141, 110, 30);
		usernameLabel.setBounds(0, 223, 220, 30);
		usernameField.setBounds(225, 182, 110, 30);
		passwordLabel.setBounds(0, 182, 220, 30);
		passwordField.setBounds(225, 223, 110, 30);
		saveButton.setBounds(75, 350, 300, 40);
		cancelButton.setBounds(75, 400, 300, 40);
		
		
		// add all
		add(titleLabel);
		add(nameLabel);
		add(nameField);
		add(dobLabel);
		add(dobField);
		add(usernameLabel);
		add(usernameField);
		add(passwordLabel);
		add(passwordField);
		add(saveButton);
		add(cancelButton);
	}
	
	public EditProfilePanel(User currentUser) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		titleLabel = new JLabel("Edit Profile");
		nameLabel = new JLabel("Name: ");
		nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dobLabel = new JLabel("DOB: ");
		dobLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		usernameLabel = new JLabel("Username: ");
		usernameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		nameField = new JTextField(currentUser.getName());
		nameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		dobField = new JTextField(currentUser.getDOB());
		dobField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		usernameField = new JTextField(currentUser.getUsername());
		usernameField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		passwordField = new JTextField(currentUser.getPassword());
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		saveButton = new JButton("Save");
		cancelButton = new JButton("Back");
		
		// set font for each component
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		dobLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		saveButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		//bounds				
		titleLabel.setBounds(0, 55, 450, 20);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(0, 100, 215, 30);
		nameField.setBounds(225, 100, 110, 30);
		dobLabel.setBounds(0, 141, 220, 30);
		dobField.setBounds(225, 141, 110, 30);
		usernameLabel.setBounds(0, 223, 220, 30);
		usernameField.setBounds(225, 223, 110, 30);
		passwordLabel.setBounds(0, 182, 220, 30);
		passwordField.setBounds(225, 182, 110, 30);
		saveButton.setBounds(75, 350, 300, 40);
		cancelButton.setBounds(75, 400, 300, 40);
		
		
		// add all
		add(titleLabel);
		add(nameLabel);
		add(nameField);
		add(dobLabel);
		add(dobField);
		add(usernameLabel);
		add(usernameField);
		add(passwordLabel);
		add(passwordField);
		add(saveButton);
		add(cancelButton);
	}
	
	// update user
	public void UpdateUser(User currentUser)
	{
		currentUser.setUsername(usernameField.getText());
		currentUser.setPassword(passwordField.getText());
		currentUser.setDOB(dobField.getText());
		currentUser.setName(nameField.getText());
	}
}
