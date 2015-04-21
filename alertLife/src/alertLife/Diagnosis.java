/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the Diagnosis object which is a detailed description of a new entry made by the patient.

/***********************************************/
package alertLife;

import java.util.Date;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Diagnosis implements Serializable{
	
	private int symptom1;
	private int symptom2;
	private int symptom3;
	private int symptom4;
	private int symptom5;
	private String comment;
	private String diagnosisName = "";
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Date date = new Date();
	private String dateTime;
	
	public Diagnosis()
	{
		symptom1 = 0;
		symptom2 = 0;
		symptom3 = 0;
		symptom4 = 0;
		symptom5 = 0;
		comment = "";
	}
	
	public Diagnosis(int symp1, int symp2, int symp3, int symp4, int symp5, String com, String dName)
	{
		symptom1 = symp1;
		symptom2 = symp2;
		symptom3 = symp3;
		symptom4 = symp4;
		symptom5 = symp5;
		comment = com;
		diagnosisName = dName;
		dateTime = dateFormat.format(date);
	}
	
	public int getSymptom(int num)
	{
		switch (num){
		case 1 : return symptom1;
		case 2 : return symptom2;
		case 3 : return symptom3;
		case 4 : return symptom4;
		case 5 : return symptom5;
		default: return -1; //signifies bug
		}
	}
	
	public String getComment()
	{
		return comment;
	}
	
	public String getDiagnosisName()
	{
		return diagnosisName;
	}
	
	public String getDiagnosisDateTime()
	{
		return dateTime;
	}
	
	public void setSymptom(int s, int value)
	{
		switch (s)
		{
			case 1 : symptom1 = value;
			case 2 : symptom2 = value;
			case 3 : symptom3 = value;
			case 4 : symptom4 = value;
			case 5 : symptom5 = value;
		}
	}
	
	public String toString()
	{
		return "Diagnosis:\t" + diagnosisName + "\n" +
				"Pain:\t" + symptom1 + "\n" + 
				"Nausea:\t" + symptom2 + "\n" + 
				"Sleepiness:\t" + symptom3 + "\n" + 
				"Fatigue:\t" + symptom4 + "\n" + 
				"Dizziness:\t" + symptom5 + "\n" + 
				dateTime;
	}
	
	public String toShortString()
	{
		return dateTime + ": " + diagnosisName;
	}
}
