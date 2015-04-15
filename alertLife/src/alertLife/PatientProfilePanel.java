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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JScrollPane;

public class PatientProfilePanel extends JPanel {

	JButton btnEditProfile;
	JButton btnNewEntry;

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
		lblHistory.setBounds(20, 170, 187, 26);
		add(lblHistory);
		
		JLabel lblSelectedEntry = new JLabel("Selected Entry:");
		lblSelectedEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSelectedEntry.setBounds(250, 170, 168, 26);
		add(lblSelectedEntry);
		
		btnNewEntry = new JButton("New Entry");
		btnNewEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNewEntry.setBounds(75, 440, 300, 40);
		add(btnNewEntry);
	
		

	}
}
