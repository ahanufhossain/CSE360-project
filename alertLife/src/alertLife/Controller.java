/***************************************************************************************************************
//Team #3
//Team Members: 	Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens
//
//Description: 		This class implements the Controller object, which links all of the classes together, and 
//					provides an interface between the gui and all of the classes.
///***************************************************************************************************************/

package alertLife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class Controller extends JFrame implements ActionListener, MouseListener {
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
	Patient currentPatient;
	Doctor currentDoctor;
	Patient currentDoctorsPatient;
	int indexOfCurrentUser; // needed to update the arraylist when users info is changed

	/***************************************************************************************************************
	//Function:		getUser(String username)
	//
	//Description:	gets user by username from listOfUsers
	/***************************************************************************************************************/
	private User getUser(String username) {
		User result = new User();
		for (User user : listOfUsers) {
			if (user.getUsername().equals(username))
				result = user;
		}
		return result;
	}

	/***************************************************************************************************************
	//Function:		addActionListeners(JPanel panel)
	//
	//Description:	add action listeners to the panels
	/***************************************************************************************************************/
	public void addActionListeners(JPanel panel) {
		// addPatientPanel
		if (panel instanceof addPatientPanel) {
			addPatientPage.btnBack.addActionListener(this);
			addPatientPage.btnAddPatient.addActionListener(this);
		}
		// DoctorProfilePanel
		else if (panel instanceof DoctorProfilePanel) {
			docPage.btnEditProfile.addActionListener(this);
			docPage.btnAddPatient.addActionListener(this);
			docPage.btnSeePatientDetails.addActionListener(this);
		}
		// EditProfilePanel
		else if (panel instanceof EditProfilePanel) {
			editProfile.saveButton.addActionListener(this);
			editProfile.cancelButton.addActionListener(this);
		}
		// LoginScreenPanel
		else if (panel instanceof LoginScreenPanel) {
			login.btnLogin.addActionListener(this);
			login.btnRegister.addActionListener(this);
		}
		// NewEntryPanel
		else if (panel instanceof NewEntryPanel) {
			newEntryPage.btnBack.addActionListener(this);
			newEntryPage.btnSaveEntry.addActionListener(this);
		}
		// PatientProfilePanel
		else if (panel instanceof PatientProfilePanel) {
			patientPage.btnNewEntry.addActionListener(this);
			if (currentUser instanceof Doctor)
				patientPage.btnBack.addActionListener(this);
			else
				patientPage.btnEditProfile.addActionListener(this);
			patientPage.patHistoryList.addMouseListener(this);
		}
		// RegistrationPanel
		else if (panel instanceof RegistrationPanel) {
			registerPage.btnRegister.addActionListener(this);
			registerPage.btnBack.addActionListener(this);
		}
	}

	/***************************************************************************************************************
	//Function:		init()
	//
	//Description:	loads the user; instantiates all of the panels
	/***************************************************************************************************************/
	public void init() {
		currentUser = new User();
		listOfUsers = new ArrayList<User>();
		load();

		// initialize all JPanels
		login = new LoginScreenPanel();
		docPage = new DoctorProfilePanel();
		editProfile = new EditProfilePanel();
		newEntryPage = new NewEntryPanel();
		patientPage = new PatientProfilePanel();
		registerPage = new RegistrationPanel();
		addPatientPage = new addPatientPanel();

		// add action listener to all necessary buttons
		addActionListeners(login);
		addActionListeners(registerPage);
		addActionListeners(docPage);
		addActionListeners(patientPage);
		addActionListeners(editProfile);
		addActionListeners(newEntryPage);
		addActionListeners(addPatientPage);

		frame = new JFrame();
		frame.setSize(450, 500);
		frame.getContentPane().add(login);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	/***************************************************************************************************************
	//Function:		
	//
	//Description:	updates the information across the entire application so it is consistent; updates arraylist so 
	/***************************************************************************************************************/
	public void updateAll() {
		listOfUsers.set(indexOfCurrentUser, currentUser);
	}

	/***************************************************************************************************************
	//Function:		save()
	//
	//Description:	writes the arrayList of users to a file
	/***************************************************************************************************************/
	public void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream("allUsers");
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);

			// serializes each user individually
			for (int i = 0; i < listOfUsers.size(); i++) {
				if (listOfUsers.get(i).userType.equals("Patient")) {
					Patient tempPat = (Patient) listOfUsers.get(i);
					String filename = tempPat.username + "Diag";
					FileOutputStream diagOut = new FileOutputStream(filename);
					ObjectOutputStream diagStream = new ObjectOutputStream(
							diagOut);

					// serializes each diagnosis individually
					for (int j = 0; j < tempPat.diagnoses.size(); j++) {
						diagStream.writeObject(tempPat.diagnoses.get(j));
					}
					diagStream.close();
					diagOut.close();
				}

				outputStream.writeObject(listOfUsers.get(i));
			}

			outputStream.close();
			fileOut.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/***************************************************************************************************************
	//Function:		load()
	//
	//Description:	loads the arrayList of users from a file
	/***************************************************************************************************************/
	public void load() {
		try {
			FileInputStream fileIn = new FileInputStream("allUsers");
			ObjectInputStream inputStream = new ObjectInputStream(fileIn);

			// loads objects until an exception is thrown
			try {
				while (true) {
					listOfUsers.add((User) inputStream.readObject());
				}
			} catch (OptionalDataException ex) {
				if (!ex.eof)
					throw ex;
			}
			inputStream.close();
			fileIn.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/***************************************************************************************************************
	//Function:		userExists()
	//
	//Description:	used for login purposes checks if user exists and if so sets current user to user who is logged 
	//				in otherwise sets it to null
	/***************************************************************************************************************/
	public boolean userExists() {
		boolean flag = false;

		// iterates through arrayList
		for (int i = 0; i < listOfUsers.size(); i++) {
			// checks if username is equal to the username field
			if (listOfUsers.get(i).getUsername()
					.equals(login.fieldUsername.getText())) {
				// checks if password of that user is correct
				if (Arrays.equals(listOfUsers.get(i).getPassword()
						.toCharArray(), login.passwordField.getPassword())) {
					flag = true;
					currentUser = listOfUsers.get(i); // sets current user
					if (currentUser.userType.equals("Patient")) {
						currentPatient = (Patient) listOfUsers.get(i);
					} else // currentUser.userType.equals("Doctor")
					{
						currentDoctor = (Doctor) listOfUsers.get(i);
					}
					indexOfCurrentUser = i; // sets index for current user
					break;
				} else {
					// display incorrect password
				}
			} else {
				// display username does not exist
			}
		}
		return flag;
	}
	
	/***************************************************************************************************************
	//Function:		hasUser(String username)
	//
	//Description:	checks if there is a user with the chosen username 
	/***************************************************************************************************************/
	public boolean hasUser(String username)
	{
		boolean res = false;
		if (username.length() > 0)
			if (listOfUsers.size() > 0)
				for (User user : listOfUsers)
				{
					if (user.getUsername().equals(username))
					{
						res = true;
						break;
					}
				}
		return res;
	}

	/***************************************************************************************************************
	//Function:		
	//
	//Description:	this method is the action listener for all of the buttons in the application this method controls
	//				the entire application as nothing can happen within the application until the user clicks on a
	//				button
	/***************************************************************************************************************/
	public void actionPerformed(ActionEvent e) {
		// currently when login button is pressed it navigates to docPage
		// we will change this later to check login information and user type
		if (e.getSource() == login.btnLogin) {
			if (userExists()) {
				if (currentUser.userType.equals("Doctor")) {
					goToDoctorProfilePanel();
				} else {
					goToPatientProfilePanel("");
				}
			}
		}
		// brings user to the registration page
		if (e.getSource() == login.btnRegister) {
			goToRegister();
		}
		// brings user back to login in page after registering
		// needs to create new user this will be implemented later
		if (e.getSource() == registerPage.btnRegister) {
			// gets all values from fields for registration
			String username = registerPage.textField.getText();
			char[] tempPass = registerPage.passwordField.getPassword();
			String password = new String(tempPass);
			String name = registerPage.firstNameField.getText() + " "
					+ registerPage.lastNameField.getText();
			String dob = (String) registerPage.comboBoxMonth.getSelectedItem()
					+ "/" + (String) registerPage.comboBoxDay.getSelectedItem()
					+ "/" + registerPage.txtYear.getText();

			// checks none of the fields are blank
			if (username.equals("") || password.equals("") || name.equals("")
					|| dob.equals("") || hasUser(username)) {
				// set label to say please fill in all information
			} else {
				// if doctor radio button selected creates new doctor
				if (registerPage.radioButtonDoctor.isSelected()) {
					Doctor doc = new Doctor(username, password, dob, name);
					doc.userType = "Doctor";
					listOfUsers.add(doc);
				}
				// otherwise a new patient is created
				else {
					Patient patient = new Patient(username, password, dob, name);
					patient.userType = "Patient";
					listOfUsers.add(patient);
				}
				save();
				goToLogin();
			}
		}
		// goes back to login page
		if (e.getSource() == registerPage.btnBack) {
			goToLogin();
		}
		// navigates from doctor page to edit profile page
		if (e.getSource() == docPage.btnEditProfile) {
			goToEditProfile();
		}
		// navigates from doctor page to add patient page
		if (e.getSource() == docPage.btnAddPatient) {
			goToAddPatientPanel();
		}
		// there is no panel for this button at this time
		if (e.getSource() == docPage.btnSeePatientDetails) {
			String patientUsername = docPage.getPatientUsername();
			currentDoctorsPatient = (Patient) getUser(patientUsername);
			goToPatientProfilePanel("");
		}
		// navigates from add patient page to doc page
		if (e.getSource() == addPatientPage.btnBack) {
			goToDoctorProfilePanel();
		}
		// navigates back to doc page from add patient page
		// and adds patient to doctor's list of patients
		if (e.getSource() == addPatientPage.btnAddPatient) {
			// add patient to current doctor's data set
			String patientUsername = addPatientPage.getPatientUsername();
			currentDoctor.addPatient((Patient) getUser(patientUsername));
			updateAll();
			save();

			// go to doctor profile panel
			goToDoctorProfilePanel();
		}
		// navigates from edit profile back to doc page
		// or patient page depending on user type
		if (e.getSource() == editProfile.saveButton) {
			editProfile.UpdateUser(currentUser);
			updateAll();
			save();

			if (currentUser.userType.equals("Doctor")) {
				goToDoctorProfilePanel();
			} else {
				goToPatientProfilePanel("");
			}
		}
		// navigates from edit profile back to doc page
		// or patient page depending on user type
		if (e.getSource() == editProfile.cancelButton) {
			if (currentUser.userType.equals("Doctor")) {
				goToDoctorProfilePanel();
			} else {
				goToPatientProfilePanel("");
			}
		}
		// navigates from patient page to edit profile page
		if (e.getSource() == patientPage.btnEditProfile) {
			goToEditProfile();
		}
		// navigates from patient page to new entry page
		if (e.getSource() == patientPage.btnNewEntry) {
			goNewEntry();
		}
		// navigates from patient page to doctor profile panel
		if (e.getSource() == patientPage.btnBack) {
			goToDoctorProfilePanel();
		}
		// navigates from new entry back to patient page
		if (e.getSource() == newEntryPage.btnBack) {
			goToPatientProfilePanel("");
		}

		// save the diagnosis entry
		// needs to also get info from the entry and
		// add it to the patients history
		// navigates back to the patient page
		if (e.getSource() == newEntryPage.btnSaveEntry) {
			// TODO
			// Diagnosis(int symp1, int symp2, int symp3, int symp4, int symp5,
			// String com, String dName)
			String comments = "";

			if (!newEntryPage.enterComments.getText().equals(
					"Enter Additional Information..."))
				comments = newEntryPage.enterComments.getText();

			if (currentUser instanceof Patient)
			{
				currentPatient.addDiagnosis(new Diagnosis(newEntryPage.pSlider
					.getValue(), newEntryPage.nSlider.getValue(),
					newEntryPage.sSlider.getValue(), newEntryPage.fSlider
					.getValue(), newEntryPage.dSlider.getValue(),
					comments, newEntryPage.diagnosesComboBox.getSelectedItem()
					.toString()));
			}
			else 
			{
				currentDoctorsPatient.addDiagnosis(new Diagnosis(newEntryPage.pSlider
						.getValue(), newEntryPage.nSlider.getValue(),
						newEntryPage.sSlider.getValue(), newEntryPage.fSlider
						.getValue(), newEntryPage.dSlider.getValue(),
						comments, newEntryPage.diagnosesComboBox.getSelectedItem()
						.toString()));
			}

			updateAll();
			save();

			goToPatientProfilePanel("");
		}
	}

	/***************************************************************************************************************
	//Function:		goToPatientProfilePanel(String diagnosis)
	//
	//Description:	goes to patient profile
	/***************************************************************************************************************/
	public void goToPatientProfilePanel(String diagnosis) {
		frame.getContentPane().removeAll();

		if (currentUser instanceof Patient) {
			patientPage = new PatientProfilePanel(currentUser,
					(Patient) currentUser, listOfUsers, diagnosis);
		} else {
			patientPage = new PatientProfilePanel(currentUser,
					currentDoctorsPatient, listOfUsers, diagnosis);
		}
		addActionListeners(patientPage);
		patientPage.repaint();
		frame.getContentPane().add(patientPage);
		frame.setVisible(true);
		frame.repaint();
	}

	/***************************************************************************************************************
	//Function:		goToDoctorProfilePanel()
	//
	//Description:	goes to doctor profile
	/***************************************************************************************************************/
	public void goToDoctorProfilePanel() {
		frame.getContentPane().removeAll();
		docPage = new DoctorProfilePanel(currentDoctor);
		addActionListeners(docPage);
		docPage.repaint();
		// TODO
		frame.getContentPane().add(docPage);
		frame.setVisible(true);
		frame.repaint();
	}

	/***************************************************************************************************************
	//Function:		goToAddPatientPanel()
	//
	//Description:	goes to add patient page
	/***************************************************************************************************************/
	public void goToAddPatientPanel() {
		frame.getContentPane().removeAll();

		addPatientPage = new addPatientPanel(listOfUsers);
		addActionListeners(addPatientPage);
		addPatientPage.repaint();
		frame.getContentPane().add(addPatientPage);
		frame.setVisible(true);
		frame.repaint();
	}

	/***************************************************************************************************************
	//Function:		goToLogin()
	//
	//Description:	goes to login page
	/***************************************************************************************************************/
	public void goToLogin() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(login);
		login.repaint();
		frame.setVisible(true);
		frame.repaint();
	}

	/***************************************************************************************************************
	//Function:		goToRegister()
	//
	//Description:	goes to register page
	/***************************************************************************************************************/
	public void goToRegister() {
		registerPage = new RegistrationPanel();
		addActionListeners(registerPage);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(registerPage);
		frame.setVisible(true);
		frame.repaint();
	}

	/***************************************************************************************************************
	//Function:		goToEditProfile()
	//
	//Description:	goes to edit profile page
	/***************************************************************************************************************/
	public void goToEditProfile() {
		editProfile = new EditProfilePanel(currentUser);
		addActionListeners(editProfile);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(editProfile);
		frame.setVisible(true);
		frame.repaint();
	}

	/***************************************************************************************************************
	//Function:		goNewEntry()
	//
	//Description:	goes to new diagnosis entry page
	/***************************************************************************************************************/
	public void goNewEntry() {
		frame.getContentPane().removeAll();
		newEntryPage = new NewEntryPanel();
		addActionListeners(newEntryPage);
		frame.getContentPane().add(newEntryPage);
		frame.setVisible(true);
		frame.repaint();
	}

	/***************************************************************************************************************
	//Function:		mouseClicked(MouseEvent e)
	//
	//Description:	handles diagnosis display pane
	/***************************************************************************************************************/
	public void mouseClicked(MouseEvent e) {
		String diagnosis = "";
		if (e.getSource() == patientPage.patHistoryList
				&& patientPage.hasDiagnosis()) {
			diagnosis = patientPage.getDiagnosis();
			goToPatientProfilePanel(diagnosis);
		}
	}

	// These are never being used, but warnings get thrown
	// if they aren't implemented. So they're "implemented"
	// but they're doing nothing.
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
