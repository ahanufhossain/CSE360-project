package alertLife;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class NewEntryPanel extends JPanel {

	JSlider pSlider;
	JSlider nSlider;
	JSlider sSlider;
	JSlider fSlider;
	JSlider dSlider;
	JTextPane enterComments;
	JButton entryButton;
	JLabel painLabel;
	JLabel nauseaLabel;
	JLabel sleepyLabel;
	JLabel fatigueLabel;
	JLabel dizzyLabel;
	
	public NewEntryPanel() 
	{
		setLayout(null);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblDiagnosis.setBounds(184, 17, 82, 20);
		add(lblDiagnosis);
		
		pSlider = new JSlider(0,5);
		pSlider.setBounds(132, 62, 190, 29);
		add(pSlider);
		
		nSlider = new JSlider(0,5);
		nSlider.setBounds(132, 103, 190, 29);
		add(nSlider);
		
		sSlider = new JSlider(0,5);
		sSlider.setBounds(132, 144, 190, 29);
		add(sSlider);
		
		fSlider = new JSlider(0,5);
		fSlider.setBounds(132, 185, 190, 29);
		add(fSlider);
		
		dSlider = new JSlider(0,5);
		dSlider.setBounds(132, 226, 190, 29);
		add(dSlider);
		
		JLabel lblPain = new JLabel("Pain");
		lblPain.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPain.setBounds(91, 62, 29, 29);
		add(lblPain);
		
		JLabel lblNausea = new JLabel("Nausea");
		lblNausea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNausea.setBounds(68, 103, 52, 29);
		add(lblNausea);
		
		JLabel lblDizziness = new JLabel("Dizziness");
		lblDizziness.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDizziness.setBounds(50, 226, 70, 29);
		add(lblDizziness);
		
		JLabel lblSleepiness = new JLabel("Sleepiness");
		lblSleepiness.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSleepiness.setBounds(46, 144, 74, 16);
		add(lblSleepiness);
		
		JLabel lblFatigue = new JLabel("Fatigue");
		lblFatigue.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblFatigue.setBounds(68, 185, 52, 29);
		add(lblFatigue);
		
		enterComments = new JTextPane();
		enterComments.setText("Enter Additional Information...");
		enterComments.setBounds(91, 285, 276, 101);
		add(enterComments);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setBounds(91, 267, 82, 16);
		add(lblComments);
		
		entryButton = new JButton("Complete Entry");
		entryButton.setBounds(155, 398, 140, 34);
		add(entryButton);
		
		painLabel = new JLabel("0");
		painLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		painLabel.setBounds(334, 62, 61, 29);
		add(painLabel);
		
		nauseaLabel = new JLabel("1");
		nauseaLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		nauseaLabel.setBounds(334, 103, 61, 29);
		add(nauseaLabel);
		
		sleepyLabel = new JLabel("2");
		sleepyLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		sleepyLabel.setBounds(334, 144, 61, 29);
		add(sleepyLabel);
		
		fatigueLabel = new JLabel("3");
		fatigueLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		fatigueLabel.setBounds(334, 185, 61, 29);
		add(fatigueLabel);
		
		dizzyLabel = new JLabel("4");
		dizzyLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		dizzyLabel.setBounds(334, 226, 61, 29);
		add(dizzyLabel);

	}
/*	
	public Diagnosis getEntry()
	{
		int pValue = pSlider.getValue();
		int nValue = nSlider.getValue();
		int sValue = sSlider.getValue();
		int fValue = fSlider.getValue();
		int dValue = dSlider.getValue();
		String comments = enterComments.getText();
		
		Diagnosis diag = new Diagnosis(whatever parameters are);
		return diag;
	}*/
}