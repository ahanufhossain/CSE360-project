package alertLife;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class PatientProfilePanel extends JPanel {

	JButton btnEditProfile;
	JButton btnNewEntry;
	/**
	 * Create the panel.
	 */
	public PatientProfilePanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblProfilePage = new JLabel("Profile Page");
		lblProfilePage.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblProfilePage.setBounds(171, 22, 107, 37);
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
		lblUsername.setBounds(246, 63, 151, 14);
		add(lblUsername);
		
		JLabel lblDoctor = new JLabel("Doctor: ");
		lblDoctor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDoctor.setBounds(246, 89, 151, 14);
		add(lblDoctor);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnEditProfile.setBounds(168, 130, 113, 23);
		add(btnEditProfile);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblHistory.setBounds(67, 171, 62, 26);
		add(lblHistory);
		
		JList listHistory = new JList();
		listHistory.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		listHistory.setBounds(10, 208, 160, 244);
		add(listHistory);
		
		JScrollBar scrollBarHistory = new JScrollBar();
		scrollBarHistory.setBounds(169, 208, 17, 244);
		add(scrollBarHistory);
		
		JLabel lblSelectedEntry = new JLabel("Selected Entry");
		lblSelectedEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblSelectedEntry.setBounds(288, 171, 126, 26);
		add(lblSelectedEntry);
		
		JScrollBar scrollBarSelectEntry = new JScrollBar();
		scrollBarSelectEntry.setBounds(423, 208, 17, 244);
		add(scrollBarSelectEntry);
		
		JList list = new JList();
		list.setBounds(264, 208, 160, 244);
		add(list);
		
		btnNewEntry = new JButton("New Entry");
		btnNewEntry.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNewEntry.setBounds(170, 463, 110, 23);
		add(btnNewEntry);

	}
}
