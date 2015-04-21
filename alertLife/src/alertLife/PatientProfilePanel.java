/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the PatientProfile panel, which displays the patient informaton and allows the patient to edit their informaton
// 				or to submit a new diagnosis entry.

/***********************************************/

package alertLife;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Choice;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class PatientProfilePanel extends JPanel {
	//private static final long serialVersionUID = 1L;
	JButton btnEditProfile;
	JButton btnNewEntry;
	private String[] patHistory = new String[] {"History1", "History2", "History3", "History4", "History5", "History6", "History7", "History8", "History9", "History10", "History11", "History12"};
	JButton btnBack;
	JTextPane diagnosisDisplayPane;
	JList patHistoryList;
	private Patient currentPatient;
	
	public PatientProfilePanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblProfilePage = new JLabel("Profile Page");
		lblProfilePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilePage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblProfilePage.setBounds(0, 22, 450, 37);
		add(lblProfilePage);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblName.setBounds(79, 63, 107, 15);
		add(lblName);
		
		JLabel lblDob = new JLabel("DOB: ");
		lblDob.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDob.setBounds(79, 89, 107, 14);
		add(lblDob);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblUsername.setBounds(250, 63, 151, 14);
		add(lblUsername);
		
		JLabel lblDoctor = new JLabel("Doctor: ");
		lblDoctor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDoctor.setBounds(250, 89, 151, 14);
		add(lblDoctor);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnEditProfile.setBounds(75, 120, 300, 40);
		add(btnEditProfile);
		
		JLabel lblHistory = new JLabel("History:");
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblHistory.setBounds(20, 170, 180, 26);
		add(lblHistory);
		
		JLabel lblSelectedEntry = new JLabel("Selected Entry:");
		lblSelectedEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSelectedEntry.setBounds(250, 170, 180, 26);
		add(lblSelectedEntry);
		
		btnNewEntry = new JButton("New Entry");
		btnNewEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNewEntry.setBounds(20, 421, 200, 40);
		add(btnNewEntry);
		
		JScrollPane patHistoryScrollPane = new JScrollPane();
		patHistoryScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		patHistoryScrollPane.setBounds(20, 200, 200, 210);
		patHistoryList = new JList(patHistory);
		patHistoryList.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		patHistoryList.setModel(new AbstractListModel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public int getSize()
			{
				return patHistory.length;
			}
			public Object getElementAt(int index)
			{
				return patHistory[index];
			}
			
		});
		patHistoryScrollPane.setViewportView(patHistoryList);
		add(patHistoryScrollPane);
		
		diagnosisDisplayPane = new JTextPane();
		diagnosisDisplayPane.setEditable(false);
		diagnosisDisplayPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		diagnosisDisplayPane.setBounds(230, 200, 200, 210);
		add(diagnosisDisplayPane);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnBack.setBounds(230, 421, 200, 40);
		add(btnBack);
	}
	
	public PatientProfilePanel(User currentUser, Patient currentPatient, ArrayList<User> userlist, String diagnosis) {
		this.currentPatient = currentPatient;
		this.patHistory = getPatHistoryList();
		
		// get patient's doctor
		String doctorName = getDoctorName(userlist);
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblProfilePage = new JLabel("Profile Page");
		lblProfilePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilePage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblProfilePage.setBounds(0, 22, 450, 37);
		add(lblProfilePage);
		
		JLabel lblName = new JLabel("Name: " + currentPatient.getName());
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblName.setBounds(79, 63, 120, 20);
		add(lblName);
		
		JLabel lblDob = new JLabel("DOB: " + currentPatient.getDOB());
		lblDob.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDob.setBounds(79, 89, 120, 20);
		add(lblDob);
		
		JLabel lblUsername = new JLabel("Username: " + currentPatient.getUsername());
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblUsername.setBounds(250, 63, 151, 20);
		add(lblUsername);
		
		JLabel lblDoctor = new JLabel("Doctor: " + doctorName);
		lblDoctor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDoctor.setBounds(250, 89, 151, 20);
		add(lblDoctor);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnEditProfile.setBounds(75, 120, 300, 40);
		add(btnEditProfile);
		
		JLabel lblHistory = new JLabel("History:");
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblHistory.setBounds(20, 170, 180, 26);
		add(lblHistory);
		
		JLabel lblSelectedEntry = new JLabel("Selected Entry:");
		lblSelectedEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSelectedEntry.setBounds(250, 170, 180, 26);
		add(lblSelectedEntry);
		
		JScrollPane patHistoryScrollPane = new JScrollPane();
		patHistoryScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		patHistoryScrollPane.setBounds(20, 200, 200, 210);
		patHistoryList = new JList(patHistory);
		patHistoryList.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		patHistoryList.setModel(new AbstractListModel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public int getSize()
			{
				return patHistory.length;
			}
			public Object getElementAt(int index)
			{
				return patHistory[index];
			}
			
		});
		patHistoryScrollPane.setViewportView(patHistoryList);
		add(patHistoryScrollPane);
		
		diagnosisDisplayPane = new JTextPane();
		diagnosisDisplayPane.setText(diagnosis);
		diagnosisDisplayPane.setEditable(false);
		diagnosisDisplayPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		diagnosisDisplayPane.setBounds(230, 200, 200, 210);
		add(diagnosisDisplayPane);
		
		btnNewEntry = new JButton("New Entry");
		btnNewEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		if (currentUser instanceof Doctor)
		{
			btnNewEntry.setBounds(20, 421, 200, 40);
			
			btnBack = new JButton("Back");
			btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			btnBack.setBounds(230, 421, 200, 40);
			add(btnBack);
		}
		else
		{
			btnNewEntry.setBounds(125, 421, 200, 40);
		}
		add(btnNewEntry);
	}
	
	// return name of current patient's doctor
	private String getDoctorName(ArrayList<User> userlist)
	{
		String res = "";
		String patientUsername = currentPatient.getUsername();
		for (User user : userlist)
		{
			if (user instanceof Doctor)
			{
				Doctor doctor = (Doctor) user;
				ArrayList<Patient> patientList = doctor.getPatientList();
				for (Patient patient : patientList)
				{
					if (patient.getUsername().equals(patientUsername))
						res = doctor.getName();
				}
			}
		}
		return res;
	}
	
	// returns true if it has one or more diagnoses
	// returns false otherwise
	public boolean hasDiagnosis()
	{
		return (currentPatient.getDiagnoses().size() > 0);
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
	
	public String getDiagnosis()
	{
		int index = patHistoryList.getSelectedIndex();
		ArrayList<Diagnosis> listOfDiagnoses = currentPatient.getDiagnoses();
		
		return listOfDiagnoses.get(index).toString();
	}
}
