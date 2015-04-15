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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Arrays;

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
	ArrayList<User> listOfUsers;
	User currentUser;
	int indexOfCurrentUser; //needed to update the arraylist when users info is changed

	
	public void init()
	{
		//initialize arrayList and currentUser
		currentUser = new User();
		listOfUsers = new ArrayList<User>();
		load();
		
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
		registerPage.btnBack.addActionListener(this);
		docPage.btnEditProfile.addActionListener(this);
		docPage.btnAddPatient.addActionListener(this);
		docPage.btnSeePatientDetails.addActionListener(this);
		patientPage.btnEditProfile.addActionListener(this);
		patientPage.btnNewEntry.addActionListener(this);
		editProfile.saveButton.addActionListener(this);
		editProfile.cancelButton.addActionListener(this);
		newEntryPage.entryButton.addActionListener(this);
		
		frame = new JFrame();
		frame.setSize(450,500);
		frame.getContentPane().add(login);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
	}
	
	//the purpose of this method will be to update the information
	//across the entire application so it is consistent
	public void updateAll()
	{
		//updates arraylist so information for current user is accurate
		listOfUsers.set(indexOfCurrentUser, currentUser);
	}
	
	//writes the arrayList of users to a file
	public void save()
	{
		try{
			FileOutputStream fileOut = new FileOutputStream("allUsers");
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
			
			//serializes each user individually
			for(int i=0; i<listOfUsers.size();i++)
			{
				outputStream.writeObject(listOfUsers.get(i));
			}
			
            outputStream.close();
            fileOut.close();
        }
		catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
		catch (IOException ex) {
            ex.printStackTrace();
		}
	}
	
	//loads the arrayList of users from a file
	public void load()
	{
		try{
			FileInputStream fileIn = new FileInputStream("allUsers");
			ObjectInputStream inputStream = new ObjectInputStream(fileIn);
			
			//loads objects until an exception is thrown
			try {
		        while (true) {
		            listOfUsers.add((User) inputStream.readObject());
		        }
		    } catch (OptionalDataException ex) {
		        if (!ex.eof) throw ex;
		    } 
			inputStream.close();
			fileIn.close();
        }
		catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
		catch (IOException ex) {
            ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//used for login purposes checks if user exists and if so sets current user
	//to user who is logged in otherwise sets it to null
	public boolean userExists()
	{
		boolean flag = false;
		
		//iterates through arrayList
		for(int i=0;i<listOfUsers.size();i++)
		{
			//checks if username is equal to the username field
			if(listOfUsers.get(i).getUsername().equals(login.fieldUsername.getText()))
			{
				//checks if password of that user is correct
				if(Arrays.equals(listOfUsers.get(i).getPassword().toCharArray(), login.passwordField.getPassword()))
				{
					flag = true;
					currentUser = listOfUsers.get(i); //sets current user
					indexOfCurrentUser = i; //sets index for current user
					break;
				}
				else
				{
					//display incorrect password
				}
			}
			else
			{
				//display username does not exist
			}
		}
		return flag;
	}
	
	//this method is the action listener for all of the buttons in the application
	//this method controls the entire application as nothing can happen within the
	//application until the user clicks on a button
	public void actionPerformed(ActionEvent e) {
		//currently when login button is pressed it navigates to docPage
		//we will change this later to check login information and user type
		if(e.getSource() == login.btnLogin)
		{
			if(userExists())
			{
				if(currentUser.userType.equals("Doctor"))
				{
					frame.getContentPane().removeAll();
					frame.getContentPane().add(docPage);
					frame.setVisible(true);
					frame.repaint();
				}
				else
				{
					frame.getContentPane().removeAll();
					frame.getContentPane().add(patientPage);
					frame.setVisible(true);
					frame.repaint();
				}
			}
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
			//gets all values from fields for registration
			String username = registerPage.textField.getText();
			char[] tempPass = registerPage.passwordField.getPassword();
			String password = new String(tempPass);
			String name = registerPage.firstNameField.getText() + " " + registerPage.lastNameField.getText();
			String dob = (String)registerPage.comboBoxMonth.getSelectedItem() + "/" +
			(String)registerPage.comboBoxDay.getSelectedItem() + "/" + registerPage.txtYear.getText();
			
			//checks none of the fields are blank
			if(username.equals("") || password.equals("") || name.equals("") || dob.equals(""))
			{
				//set label to say please fill in all information
			}
			else
			{
				//if doctor radio button selected creates new doctor
				if(registerPage.radioButtonDoctor.isSelected())
				{	
					Doctor doc = new Doctor(username, password, dob, name);
					doc.userType = "Doctor";
					listOfUsers.add(doc);
				}
				//otherwise a new patient is created
				else
				{
					Patient patient = new Patient(username, password, dob, name);
					patient.userType = "Patient";
					listOfUsers.add(patient);
				}
				save();
			}
			
			frame.getContentPane().removeAll();
			frame.getContentPane().add(login);
			frame.setVisible(true);
			frame.repaint();
		}
		// goes back to login page
		if(e.getSource() == registerPage.btnBack)
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
		//navigates from edit profile back to doc page
		//or patient page depending on user type
		//TODO update user information
		if(e.getSource() == editProfile.saveButton)
		{
			if(currentUser.userType.equals("Doctor"))
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().add(docPage);
				frame.setVisible(true);
				frame.repaint();
			}
			else
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().add(patientPage);
				frame.setVisible(true);
				frame.repaint();
			}
		}
		//navigates from edit profile back to doc page
		//or patient page depending on user type
		if(e.getSource() == editProfile.cancelButton)
		{
			if(currentUser.userType.equals("Doctor"))
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().add(docPage);
				frame.setVisible(true);
				frame.repaint();
			}
			else
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().add(patientPage);
				frame.setVisible(true);
				frame.repaint();
			}
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


