package alertLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		//initialize all JPanels
		login = new LoginScreenPanel();
		docPage = new DoctorProfilePanel();
		editProfile = new EditProfilePanel();
		newEntry = new NewEntryPanel();
		patientPage = new PatientProfilePanel();
		registerPage = new  RegistrationPanel();
		
		//add action listener to all necessary buttons
		login.btnLogin.addActionListener(this);
		login.btnRegister.addActionListener(this);
		registerPage.btnRegister.addActionListener(this);
		docPage.btnEditProfile.addActionListener(this);
		editProfile.saveButton.addActionListener(this);
		editProfile.cancelButton.addActionListener(this);
		
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
			repaint();
		}
		//brings user to the registration page
		if(e.getSource() == login.btnRegister)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(registerPage);
			frame.setVisible(true);
			repaint();
		}
		//brings user back to login in page after registering
		//needs to create new user this will be implemented later
		if(e.getSource() == registerPage.btnRegister)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(login);
			frame.setVisible(true);
			repaint();
		}
		//navigates from doctor page to edit profile page
		if(e.getSource() == docPage.btnEditProfile)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(editProfile);
			frame.setVisible(true);
			repaint();
		}
		//navigates from edit profile back to doc page for now
		//later needs to check if current user is doc or patient
		//and then go back to either doc or patient page
		//also needs to update information for the current user
		if(e.getSource() == editProfile.saveButton)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(docPage);
			frame.setVisible(true);
			repaint();
		}
		//navigates from edit profile back to doc page for now
		//needs to check if current user is doc or patient
		//and then go back to either doc or patient page
		if(e.getSource() == editProfile.cancelButton)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(docPage);
			frame.setVisible(true);
			revalidate();
		}
		
	}
	
}


