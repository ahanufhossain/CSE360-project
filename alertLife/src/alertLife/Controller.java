package alertLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Controller extends JFrame implements ActionListener
{
	LoginScreenPanel login;
	DoctorProfilePanel docPage;
	EditProfilePanel editProfile;
	NewEntryPanel newEntry;
	PatientProfilePanel patientPage;
	RegistrationPanel registerPage;
	JFrame frame;

	
	public void init()
	{
		login = new LoginScreenPanel();
		docPage = new DoctorProfilePanel();
		editProfile = new EditProfilePanel();
		newEntry = new NewEntryPanel();
		patientPage = new PatientProfilePanel();
		registerPage = new  RegistrationPanel();
				
		login.btnLogin.addActionListener(this);
		
		frame = new JFrame();
		frame.setSize(450, 450);
		frame.getContentPane().add(login);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//currently when login button is pressed it navigates to docPage
		//we will change this later to check login information and user type
		if(e.getSource() == login.btnLogin)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(docPage);
			frame.setVisible(true);
		}
		
	}
	
}


