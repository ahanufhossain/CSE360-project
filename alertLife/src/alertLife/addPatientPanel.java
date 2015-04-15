/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the addPatient panel, which allows a doctor to add a patient to their patient array list.

/***********************************************/
package alertLife;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;


public class addPatientPanel extends JPanel {
	
	public JButton btnAddPatient;
	public JList patientList;
	
	String[] allPatNames = new String[] {"Paitent1", "Patient2", "Patient3", "Patient4", "Patient5", "Patient6", "Patient7", "Patient8", "Patient2", "Patient3", "Patient4", "Patient5", "Patient6", "Patient7", "Patient8", "Patient2", "Patient3", "Patient4", "Patient5", "Patient6", "Patient7", "Patient8"};
	public addPatientPanel() {
		setBorder(null);
		setLayout(null);
		
		JLabel lblPatients = new JLabel("Patients");
		lblPatients.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblPatients.setBounds(192, 11, 69, 39);
		add(lblPatients);
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnAddPatient.setBounds(75, 420, 300, 40);
		add(btnAddPatient);
		
		JScrollPane allPatScrollPane = new JScrollPane();
		allPatScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		allPatScrollPane.setBounds(75, 90, 300, 300);
		JList allPatList = new JList(allPatNames);
		allPatList.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		allPatList.setModel(new AbstractListModel() {
			public int getSize() {
				return allPatNames.length;
			}
			public Object getElementAt(int index) {
				return allPatNames[index];
			}
		});
		allPatScrollPane.setViewportView(allPatList);
		add(allPatScrollPane);

	}
}
