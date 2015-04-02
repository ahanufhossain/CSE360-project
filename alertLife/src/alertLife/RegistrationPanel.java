package alertLife;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class RegistrationPanel extends JPanel {

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
		lblFirstName.setBounds(104, 83, 80, 22);
		add(lblFirstName);

	}

}
