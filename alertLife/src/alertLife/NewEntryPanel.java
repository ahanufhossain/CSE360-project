/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the NewEntry panel which allows the patient to submit a new diagnosis.

/***********************************************/

package alertLife;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Choice;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewEntryPanel extends JPanel {

	JSlider pSlider;
	JSlider nSlider;
	JSlider sSlider;
	JSlider fSlider;
	JSlider dSlider;
	JTextPane enterComments;
	JButton entryButton;
	String[] diagnosisNames = new String[] {"Urothelial Carcinoma", "Ductal Carcinoma", "Colorectal Polyps", "Leukemia", "Melanoma", "Ulcerative Colitis"};
	
	public NewEntryPanel() 
	{
		setLayout(null);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagnosis.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDiagnosis.setBounds(0, 11, 450, 36);
		add(lblDiagnosis);
		
		pSlider = new JSlider();
		pSlider.setBounds(120, 100, 210, 30);
		pSlider.setSnapToTicks(true);
		pSlider.setMajorTickSpacing(1);
		pSlider.setMaximum(5);
		pSlider.setValue(0);
		add(pSlider);
		
		nSlider = new JSlider();
		nSlider.setBounds(120, 140, 210, 30);
		nSlider.setSnapToTicks(true);
		nSlider.setMajorTickSpacing(1);
		nSlider.setMaximum(5);
		nSlider.setValue(0);
		add(nSlider);
		
		sSlider = new JSlider();
		sSlider.setBounds(120, 180, 210, 30);
		sSlider.setSnapToTicks(true);
		sSlider.setMajorTickSpacing(1);
		sSlider.setMaximum(5);
		sSlider.setValue(0);
		add(sSlider);
		
		fSlider = new JSlider();
		fSlider.setBounds(120, 220, 210, 30);
		fSlider.setSnapToTicks(true);
		fSlider.setMajorTickSpacing(1);
		fSlider.setMaximum(5);
		fSlider.setValue(0);
		add(fSlider);
		
		dSlider = new JSlider();
		dSlider.setBounds(120, 260, 210, 50);
		dSlider.setSnapToTicks(true);
		dSlider.setMajorTickSpacing(1);
		dSlider.setMaximum(5);
		dSlider.setPaintLabels(true);
		dSlider.setValue(0);
		dSlider.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		add(dSlider);
		
		JLabel lblPain = new JLabel("Pain:");
		lblPain.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPain.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPain.setBounds(0, 100, 110, 30);
		add(lblPain);
		
		JLabel lblNausea = new JLabel("Nausea:");
		lblNausea.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNausea.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNausea.setBounds(0, 140, 110, 30);
		add(lblNausea);
		
		JLabel lblDizziness = new JLabel("Dizziness:");
		lblDizziness.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDizziness.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDizziness.setBounds(0, 260, 110, 30);
		add(lblDizziness);
		
		JLabel lblSleepiness = new JLabel("Sleepiness:");
		lblSleepiness.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSleepiness.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSleepiness.setBounds(0, 180, 110, 30);
		add(lblSleepiness);
		
		JLabel lblFatigue = new JLabel("Fatigue:");
		lblFatigue.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFatigue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblFatigue.setBounds(0, 220, 110, 30);
		add(lblFatigue);
		
		enterComments = new JTextPane();
		enterComments.setText("Enter Additional Information...");
		enterComments.setBounds(75, 345, 300, 91);
		enterComments.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		add(enterComments);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setHorizontalAlignment(SwingConstants.CENTER);
		lblComments.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblComments.setBounds(0, 311, 450, 34);
		add(lblComments);
		
		entryButton = new JButton("Complete Entry");
		entryButton.setBounds(75, 447, 300, 40);
		entryButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		add(entryButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(diagnosisNames));
		comboBox.setBounds(75, 60, 300, 30);
		add(comboBox);		
	}
}