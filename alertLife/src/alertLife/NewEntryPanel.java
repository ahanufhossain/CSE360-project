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

public class NewEntryPanel extends JPanel {

	JSlider pSlider;
	JSlider nSlider;
	JSlider sSlider;
	JSlider fSlider;
	JSlider dSlider;
	JTextPane enterComments;
	JButton entryButton;
	
	public NewEntryPanel() 
	{
		setLayout(null);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagnosis.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDiagnosis.setBounds(0, 11, 450, 36);
		add(lblDiagnosis);
		
		pSlider = new JSlider();
		pSlider.setBounds(132, 62, 190, 29);
		pSlider.setSnapToTicks(true);
		pSlider.setMajorTickSpacing(1);
		pSlider.setMaximum(5);
		add(pSlider);
		
		nSlider = new JSlider();
		nSlider.setBounds(132, 103, 190, 29);
		nSlider.setSnapToTicks(true);
		nSlider.setMajorTickSpacing(1);
		nSlider.setMaximum(5);
		add(nSlider);
		
		sSlider = new JSlider();
		sSlider.setBounds(132, 144, 190, 29);
		sSlider.setSnapToTicks(true);
		sSlider.setMajorTickSpacing(1);
		sSlider.setMaximum(5);
		add(sSlider);
		
		fSlider = new JSlider();
		fSlider.setBounds(132, 185, 190, 29);
		fSlider.setSnapToTicks(true);
		fSlider.setMajorTickSpacing(1);
		fSlider.setMaximum(5);
		add(fSlider);
		
		dSlider = new JSlider();
		dSlider.setBounds(132, 226, 190, 44);
		dSlider.setSnapToTicks(true);
		dSlider.setMajorTickSpacing(1);
		dSlider.setMaximum(5);
		dSlider.setPaintLabels(true);
		dSlider.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		add(dSlider);
		
		JLabel lblPain = new JLabel("Pain");
		lblPain.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPain.setBounds(91, 62, 29, 29);
		add(lblPain);
		
		JLabel lblNausea = new JLabel("Nausea");
		lblNausea.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNausea.setBounds(68, 103, 52, 29);
		add(lblNausea);
		
		JLabel lblDizziness = new JLabel("Dizziness");
		lblDizziness.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDizziness.setBounds(50, 226, 70, 29);
		add(lblDizziness);
		
		JLabel lblSleepiness = new JLabel("Sleepiness");
		lblSleepiness.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblSleepiness.setBounds(46, 144, 74, 16);
		add(lblSleepiness);
		
		JLabel lblFatigue = new JLabel("Fatigue");
		lblFatigue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblFatigue.setBounds(68, 185, 52, 29);
		add(lblFatigue);
		
		enterComments = new JTextPane();
		enterComments.setText("Enter Additional Information...");
		enterComments.setBounds(50, 325, 350, 100);
		add(enterComments);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblComments.setBounds(50, 284, 82, 34);
		add(lblComments);
		
		entryButton = new JButton("Complete Entry");
		entryButton.setBounds(155, 450, 140, 34);
		add(entryButton);
	}
	
//	public Diagnosis getEntry()
//	{
//		int pValue = pSlider.getValue();
//		int nValue = nSlider.getValue();
//		int sValue = sSlider.getValue();
//		int fValue = fSlider.getValue();
//		int dValue = dSlider.getValue();
//		String comments = enterComments.getText();
//		
//		Diagnosis diag = new Diagnosis(whatever parameters are);
//		return diag;
//	}
}