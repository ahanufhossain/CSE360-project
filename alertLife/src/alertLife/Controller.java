/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the Controller object, which links all of the classes together, and provides an interface between the gui
// 				and all of the classes.

/***********************************************/

package alertLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Controller extends JFrame implements ActionListener
{
	LoginScreenPanel login;
	DoctorProfilePanel docPage;
	EditProfilePanel editProfile;
	NewEntryPanel newEntryPage;
	PatientProfilePanel patientPage;
	RegistrationPanel registerPage;
	addPatientPanel addPatientPage;
	JFrame frame;
	//we will need an arrayList that has all of the users and
	//a current User object so the current user can be modified

	
	public void init()
	{
		//initialize all JPanels
		login = new LoginScreenPanel();
		docPage = new DoctorProfilePanel();
		editProfile = new EditProfilePanel();
		newEntryPage = new NewEntryPanel();
		patientPage = new PatientProfilePanel();
		registerPage = new  RegistrationPanel();
		addPatientPage = new addPatientPanel();
		
		//add action listener to all necessary buttons
		login.btnLogin.addActionListener(this);
		login.btnRegister.addActionListener(this);
		registerPage.btnRegister.addActionListener(this);
		docPage.btnEditProfile.addActionListener(this);
		docPage.btnAddPatient.addActionListener(this);
		docPage.btnSeePatientDetails.addActionListener(this);
		patientPage.btnEditProfile.addActionListener(this);
		patientPage.btnNewEntry.addActionListener(this);
		editProfile.saveButton.addActionListener(this);
		editProfile.cancelButton.addActionListener(this);
		newEntryPage.entryButton.addActionListener(this);
		
		frame = new JFrame();
		frame.setSize(450, 450);
		frame.getContentPane().add(login);
		frame.setVisible(true);
		
	}
	
	//the purpose of this method will be to update the information
	//across the entire application so it is consistent
	public void updateAll()
	{
		
	}
	
	//this method is the action listener for all of the buttons in the application
	//this method controls the entire application as nothing can happen within the
	//application until the user clicks on a button
	public void actionPerformed(ActionEvent e) {
		//currently when login button is pressed it navigates to docPage
		//we will change this later to check login information and user type
		if(e.getSource() == login.btnLogin)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(docPage);
			frame.setVisible(true);
			frame.repaint();
		}
		//brings user to the registration page
		if(e.getSource() == login.btnRegister)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(registerPage);
			frame.setVisible(true);
			frame.repaint();
		}
		//brings user back to login in page after registering
		//needs to create new user this will be implemented later
		if(e.getSource() == registerPage.btnRegister)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(login);
			frame.setVisible(true);
			frame.repaint();
		}
		//navigates from doctor page to edit profile page
		if(e.getSource() == docPage.btnEditProfile)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(editProfile);
			frame.setVisible(true);
			frame.repaint();
		}
		//navigates from doctor page to add patient page
		if(e.getSource() == docPage.btnAddPatient)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(addPatientPage);
			frame.setVisible(true);
			frame.repaint();
		}
		//there is no panel for this button at this time
		if(e.getSource() == docPage.btnSeePatientDetails)
		{
			
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
			frame.repaint();
		}
		//navigates from edit profile back to doc page for now
		//needs to check if current user is doc or patient
		//and then go back to either doc or patient page
		if(e.getSource() == editProfile.cancelButton)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(docPage);
			frame.setVisible(true);
			frame.repaint();
		}
		//navigates from patient page to edit profile page
		if(e.getSource() == patientPage.btnEditProfile)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(editProfile);
			frame.setVisible(true);
			frame.repaint();
		}
		//navigates from patient page to new entry page
		if(e.getSource() == patientPage.btnNewEntry)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(newEntryPage);
			frame.setVisible(true);
			frame.repaint();
		}
		//navigates from new entry back to patient page
		//needs to also get info from the entry and
		//add it to the patients history
		if(e.getSource() == newEntryPage.entryButton)
		{
			frame.getContentPane().removeAll();
			frame.getContentPane().add(patientPage);
			frame.setVisible(true);
			frame.repaint();
		}
		
	}
	
}


