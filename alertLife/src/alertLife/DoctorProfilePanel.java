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

	/**
	 * Create the fgfdgpanel.
	 */
	public DoctorProfilePanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(75, 105, 300, 100);
		JList list = new JList();
		list.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Paitent1", "Patient2", "Patient3", "Patient4", "Patient5", "Patient6", "Patient7", "Patient8"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		add(scrollPane);
		
		JLabel lblDoctorNamesProfile = new JLabel("Doctor Name's Profile Page", SwingConstants.CENTER);
		lblDoctorNamesProfile.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblDoctorNamesProfile.setBounds(0, 32, 450, 39);
		add(lblDoctorNamesProfile);
		
		JButton btnSeePatientDetails = new JButton("See Patient Details");
		btnSeePatientDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnSeePatientDetails.setBounds(75, 248, 300, 40);
		add(btnSeePatientDetails);
		
		JButton btnNewButton = new JButton("Add Patient");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(75, 326, 300, 40);
		add(btnNewButton);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnEditProfile.setBounds(75, 402, 300, 40);
		add(btnEditProfile);
	}
}
