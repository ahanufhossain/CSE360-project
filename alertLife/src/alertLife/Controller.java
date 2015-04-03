package alertLife;

import javax.swing.JFrame;


public class Controller extends JFrame
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
		
		frame = new JFrame();
		frame.setSize(450, 450);
		frame.getContentPane().add(login);
		frame.setVisible(true);
		
	}
	
}
