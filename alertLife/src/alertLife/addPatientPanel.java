package alertLife;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;


public class addPatientPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public addPatientPanel() {
		setBorder(null);
		setLayout(null);
		
		JLabel lblPatients = new JLabel("Patients");
		lblPatients.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblPatients.setBounds(192, 11, 69, 39);
		add(lblPatients);
		
		JButton btnNewButton = new JButton("Log Off");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnNewButton.setBounds(351, 0, 89, 23);
		add(btnNewButton);
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnAddPatient.setBounds(161, 423, 137, 23);
		add(btnAddPatient);
		
		JList patientList = new JList();
		patientList.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		patientList.setModel(new AbstractListModel() {
			String[] values = new String[] {"patient1", "patient2", "patient3", "jimmy mcGee"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		patientList.setVisibleRowCount(10);
		patientList.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0))));
		patientList.setBounds(76, 92, 291, 273);
		add(patientList);
		patientList.setBackground(Color.WHITE);
		
	

	}
}
