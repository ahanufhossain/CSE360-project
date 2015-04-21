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
import javax.swing.JList;
import javax.swing.JPanel;


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
	//TODO can't access diagnosis without it being a patient instead of a current user
	//TODO set current patient and doctor somewhere
	Patient currentPatient;
	Doctor currentDoctor;
	int indexOfCurrentUser; //needed to update the arraylist when users info is changed

	public void addDocPageListeners()
	{
		docPage.btnEditProfile.addActionListener(this);
		docPage.btnAddPatient.addActionListener(this);
		docPage.btnSeePatientDetails.addActionListener(this);
	}
	
	public void addActionListeners(JPanel panel)
	{
		// addPatientPanel
		if (panel instanceof addPatientPanel)
		{
			addPatientPage.btnBack.addActionListener(this);
		}
		// DoctorProfilePanel
		else if (panel instanceof DoctorProfilePanel)
		{
			docPage.btnEditProfile.addActionListener(this);
			docPage.btnAddPatient.addActionListener(this);
			docPage.btnSeePatientDetails.addActionListener(this);
		}
		// EditProfilePanel
		else if (panel instanceof EditProfilePanel)
		{
			editProfile.saveButton.addActionListener(this);
			editProfile.cancelButton.addActionListener(this);
		}
		// LoginScreenPanel
		else if (panel instanceof LoginScreenPanel)
		{
			login.btnLogin.addActionListener(this);
			login.btnRegister.addActionListener(this);
		}
		// NewEntryPanel
		else if (panel instanceof NewEntryPanel)
		{
			newEntryPage.btnBack.addActionListener(this);
			newEntryPage.btnSaveEntry.addActionListener(this);
		}
		// PatientProfilePanel
		else if (panel instanceof PatientProfilePanel)
		{
			patientPage.btnEditProfile.addActionListener(this);
			patientPage.btnNewEntry.addActionListener(this);
		}
		// RegistrationPanel
		else if (panel instanceof RegistrationPanel)
		{
			registerPage.btnRegister.addActionListener(this);
			registerPage.btnBack.addActionListener(this);
		}
	}
	
	public void init()
	{
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
		newEntryPage.btnBack.addActionListener(this);
		newEntryPage.btnSaveEntry.addActionListener(this);
		addPatientPage.btnBack.addActionListener(this);
		
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
					if(currentUser.userType.equals("Patient"))
					{
						currentPatient = (Patient) listOfUsers.get(i);
					}
					else //currentUser.userType.equals("Doctor")
					{
						currentDoctor = (Doctor)listOfUsers.get(i);
					}
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
					goToDoctorProfilePanel();
				}
				else
				{
					goToPatientProfilePanel();
				}
			}
		}
		//brings user to the registration page
		if(e.getSource() == login.btnRegister)
		{
			goToRegister();
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
			
			goToLogin();
		}
		// goes back to login page
		if(e.getSource() == registerPage.btnBack)
		{
			goToLogin();
		}
		//navigates from doctor page to edit profile page
		if(e.getSource() == docPage.btnEditProfile)
		{
			goToEditProfile();
		}
		//navigates from doctor page to add patient page
		if(e.getSource() == docPage.btnAddPatient)
		{
			goToAddPatientPanel();
		}
		//there is no panel for this button at this time
		if(e.getSource() == docPage.btnSeePatientDetails)
		{
			//TODO
			//goToPatientProfilePanel();
		}
		//navigates from add patient page to doc page
		if (e.getSource() == addPatientPage.btnBack)
		{
			goToDoctorProfilePanel();
		}
		//navigates from edit profile back to doc page
		//or patient page depending on user type
		if(e.getSource() == editProfile.saveButton)
		{
			if(currentUser.userType.equals("Doctor"))
			{
				goToDoctorProfilePanel();
			}
			else
			{
				goToPatientProfilePanel();
			}
		}
		//navigates from edit profile back to doc page
		//or patient page depending on user type
		if(e.getSource() == editProfile.cancelButton)
		{
			if(currentUser.userType.equals("Doctor"))
			{
				goToDoctorProfilePanel();
			}
			else
			{
				goToPatientProfilePanel();
			}
		}
		//navigates from patient page to edit profile page
		if(e.getSource() == patientPage.btnEditProfile)
		{
			goToEditProfile();
		}
		//navigates from patient page to new entry page
		if(e.getSource() == patientPage.btnNewEntry)
		{
			goNewEntry();
		}
		//navigates from new entry back to patient page
		if(e.getSource() == newEntryPage.btnBack)
		{
			goToPatientProfilePanel();
		}
		
		//save the diagnosis entry
		//needs to also get info from the entry and
		//add it to the patients history
		//navigates back to the patient page
		if(e.getSource() == newEntryPage.btnSaveEntry)
		{
			//TODO
			//Diagnosis(int symp1, int symp2, int symp3, int symp4, int symp5, String com, String dName)
			currentPatient.addDiagnosis(new Diagnosis(newEntryPage.pSlider.getValue(),
														newEntryPage.nSlider.getValue(), 
														newEntryPage.sSlider.getValue(), 
														newEntryPage.fSlider.getValue(), 
														newEntryPage.dSlider.getValue(),
														newEntryPage.enterComments.getText(),
														newEntryPage.diagnosesComboBox.getSelectedItem().toString())
														);
			
			goToPatientProfilePanel();
		}
		
	}
	
	//updates all of the variables on the patient page
	//goes to patient profile
	public void goToPatientProfilePanel()
	{
		frame.getContentPane().removeAll();
		patientPage.patHistory = getPatHistoryList();
		patientPage.repaint();		
		//TODO
		
		frame.getContentPane().add(patientPage);
		frame.setVisible(true);
		frame.repaint();
	}
	
	//goes to doctor profile
	public void goToDoctorProfilePanel()
	{
		frame.getContentPane().removeAll();
		docPage = new DoctorProfilePanel(currentDoctor);
		addActionListeners(docPage);
		docPage.repaint();
		//TODO
		frame.getContentPane().add(docPage);
		frame.setVisible(true);
		frame.repaint();
	}
	
	//updates all of the variables on the add patient page
	//goes to add patient page
	public void goToAddPatientPanel()
	{
		frame.getContentPane().removeAll();

		addPatientPage.allPatNames = getAllPatNamesList();
		//addPatientPage.allPatNames = new String[] {"Fix this.", "And this"};
		addPatientPage.repaint();
		//TODO
		
		frame.getContentPane().add(addPatientPage);
		frame.setVisible(true);
		frame.repaint();
	}
	
	//goes to add login page
	public void goToLogin()
	{
		frame.getContentPane().removeAll();
		frame.getContentPane().add(login);
		login.repaint();
		frame.setVisible(true);
		frame.repaint();
	}
	
	//goes to add register page
	public void goToRegister()
	{
		frame.getContentPane().removeAll();
		frame.getContentPane().add(registerPage);
		frame.setVisible(true);
		frame.repaint();
	}

	//goes to add edit profile page
	public void goToEditProfile()
	{
		frame.getContentPane().removeAll();
		frame.getContentPane().add(editProfile);
		frame.setVisible(true);
		frame.repaint();
	}
	
	//goes to add new diagnosis entry page
	public void goNewEntry()
	{
		frame.getContentPane().removeAll();
		frame.getContentPane().add(newEntryPage);
		frame.setVisible(true);
		frame.repaint();
	}


	
	//returns the patient history as a string array
	public String[] getPatHistoryList()
	{
		if (currentPatient.getDiagnoses().size() == 0)
		{
			return new String[] {"No diagnosis reported yet"};
		}
		else
		{
			ArrayList<String> patHistoryArrayList = new ArrayList<String>();
			for (int i = 0; i < currentPatient.getDiagnoses().size(); i++)
			{
				patHistoryArrayList.add(currentPatient.getDiagnoses().get(i).toShortString());
			}
			
			return patHistoryArrayList.toArray(new String[patHistoryArrayList.size()]);
		}
	}
	
	//returns the doctor's patients as a string array
	public String[] getDocPatNamesList()
	{
		if (currentDoctor.getPatientList().size() == 0)
		{
			return new String[] {"No patients added yet"};
		}
		else
		{
			ArrayList<String> docPatArrayList = new ArrayList<String>();
			
			for (int i = 0; i < currentDoctor.getPatientList().size(); i++)
			{
				docPatArrayList.add(currentDoctor.getPatientList().get(i).getName());
			}
			
			return docPatArrayList.toArray(new String[docPatArrayList.size()]);
		}
	}	
	
	//returns the all of the patients as a string array
	public String[] getAllPatNamesList()
	{
		if (listOfUsers.size() == 0)
		{
			return new String[] {"No patients yet"};
		}
		else
		{		
			ArrayList<String> allPatNamesArrayList = new ArrayList<String>();
			for (int i = 0; i < listOfUsers.size(); i++)
			{
				//only display users that are patients
				if (listOfUsers.get(i).userType.equals("Patient"))
					allPatNamesArrayList.add(listOfUsers.get(i).getName());
			}
			
			return allPatNamesArrayList.toArray(new String[allPatNamesArrayList.size()]);
		}
	}	
}


