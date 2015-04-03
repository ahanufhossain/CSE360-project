package alertLife;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JList;

public class alertLife_gui_PatientProfilePage {

	private JFrame frame;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alertLife_gui_PatientProfilePage window = new alertLife_gui_PatientProfilePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public alertLife_gui_PatientProfilePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 508, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProfilePage = new JLabel("Profile Page");
		lblProfilePage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProfilePage.setBackground(Color.LIGHT_GRAY);
		lblProfilePage.setBounds(193, 11, 106, 35);
		frame.getContentPane().add(lblProfilePage);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(132, 45, 135, 24);
		frame.getContentPane().add(lblName);
		
		JLabel lblDob = new JLabel("DOB: ");
		lblDob.setBounds(132, 82, 118, 19);
		frame.getContentPane().add(lblDob);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(286, 45, 152, 24);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblDoctor = new JLabel("Doctor: ");
		lblDoctor.setBounds(286, 84, 95, 14);
		frame.getContentPane().add(lblDoctor);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBounds(184, 120, 124, 47);
		frame.getContentPane().add(btnEditProfile);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHistory.setBounds(82, 172, 43, 24);
		frame.getContentPane().add(lblHistory);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(157, 205, 17, 168);
		frame.getContentPane().add(scrollBar);
		
		JList list = new JList();
		list.setBounds(34, 205, 124, 168);
		frame.getContentPane().add(list);
		
		JButton btnNewEntry = new JButton("New Entry");
		btnNewEntry.setBounds(198, 371, 95, 24);
		frame.getContentPane().add(btnNewEntry);
		
		JList list_1 = new JList();
		list_1.setBounds(317, 205, 135, 168);
		frame.getContentPane().add(list_1);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(452, 205, 17, 168);
		frame.getContentPane().add(scrollBar_1);
	}
}
