package alertLife;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

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
		dobLabel = new JLabel("DOB: ");
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		
		nameField = new JTextField();
		dobField = new JTextField();
		usernameField = new JTextField();
		passwordField = new JTextField();
		
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		
		// set font for each component
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		dobLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		saveButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		
		//bounds		
		titleLabel.setBounds(203, 25, 100, 20);
		nameLabel.setBounds(200, 75, 45, 20);
		nameField.setBounds(253, 70, 110, 30);
		dobLabel.setBounds(207, 105, 38, 20);
		dobField.setBounds(253, 100, 110, 30);
		usernameLabel.setBounds(172, 135, 73, 20);
		usernameField.setBounds(253, 130, 110, 30);
		passwordLabel.setBounds(177, 165, 68, 20);
		passwordField.setBounds(253, 160, 110, 30);
		saveButton.setBounds(133, 375, 110, 20);
		cancelButton.setBounds(263, 375, 110, 20);
		
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
	
}
