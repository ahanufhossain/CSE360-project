/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the DoctorProfilePage panel, which allows the doctor to select a patient, add a patient, or change their information.

/***********************************************/

package alertLife;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorProfilePanel extends JPanel {

	String[] docPatNames = new String[] {"Paitent1", "Patient2", "Patient3", "Patient4", "Patient5", "Patient6", "Patient7", "Patient8"};
	String doctorName = "Example Doctor Name";
	JButton btnSeePatientDetails;
	JButton btnAddPatient;
	JButton btnEditProfile;
	
	public DoctorProfilePanel() {
		setLayout(null);
		
		JScrollPane doscPatScrollPane = new JScrollPane();
		doscPatScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		doscPatScrollPane.setBounds(75, 77, 300, 230);
		JList docsPatList = new JList(docPatNames);
		docsPatList.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		docsPatList.setModel(new AbstractListModel() {
			public int getSize() {
				return docPatNames.length;
			}
			public Object getElementAt(int index) {
				return docPatNames[index];
			}
		});
		doscPatScrollPane.setViewportView(docsPatList);
		add(doscPatScrollPane);
		
		JLabel lblDoctorNamesProfile = new JLabel(doctorName + "'s Profile Page", SwingConstants.CENTER);
		lblDoctorNamesProfile.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDoctorNamesProfile.setBounds(0, 27, 450, 39);
		add(lblDoctorNamesProfile);
		
		btnSeePatientDetails = new JButton("See Patient Details");
		btnSeePatientDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnSeePatientDetails.setBounds(75, 318, 300, 40);
		add(btnSeePatientDetails);
		
		btnAddPatient = new JButton("Add Patient");
		btnAddPatient.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddPatient.setBounds(75, 368, 300, 40);
		add(btnAddPatient);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnEditProfile.setBounds(75, 418, 300, 40);
		add(btnEditProfile);
	}
}
