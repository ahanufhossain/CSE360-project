/***************************************************************************************************************
//Team #3
//Team Members: 	Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens
//
//Description: 		This class implements the Diagnosis object which is a detailed description of a new entry 
//					made by the patient.
/***************************************************************************************************************/

package alertLife;

import java.util.Date;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Diagnosis implements Serializable {

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

	/***************************************************************************************************************
	//Function:		Diagnosis()
	//
	//Description:	Empty constructor for a Diagnosis object
	/***************************************************************************************************************/
	public Diagnosis() {
		symptom1 = 0;
		symptom2 = 0;
		symptom3 = 0;
		symptom4 = 0;
		symptom5 = 0;
		comment = "";
	}

	/***************************************************************************************************************
	//Function:		Diagnosis(int symp1, int symp2, int symp3, int symp4, int symp5, String com, String dName)
	//
	//Description:	Constructor for a Diagnosis object
	/***************************************************************************************************************/
	public Diagnosis(int symp1, int symp2, int symp3, int symp4, int symp5, String com, String dName) {
		symptom1 = symp1;
		symptom2 = symp2;
		symptom3 = symp3;
		symptom4 = symp4;
		symptom5 = symp5;
		comment = com;
		diagnosisName = dName;
		dateTime = dateFormat.format(date);
	}

	/***************************************************************************************************************
	//Function:		getSymptom(int num)
	//
	//Description:	returns a specific symptom (1-5)
	/***************************************************************************************************************/
	public int getSymptom(int num) {
		switch (num) {
		case 1:
			return symptom1;
		case 2:
			return symptom2;
		case 3:
			return symptom3;
		case 4:
			return symptom4;
		case 5:
			return symptom5;
		default:
			return -1; // signifies bug
		}
	}

	/***************************************************************************************************************
	//Function:		getComment()
	//
	//Description:	returns the comments
	/***************************************************************************************************************/
	public String getComment() {
		return comment;
	}

	/***************************************************************************************************************
	//Function:		getDiagnosisName()
	//
	//Description:	returns the diagnosis name
	/***************************************************************************************************************/
	public String getDiagnosisName() {
		return diagnosisName;
	}

	/***************************************************************************************************************
	//Function:		getDiagnosisDateTime()
	//
	//Description:	returns the diagnosis datetime as a String
	/***************************************************************************************************************/
	public String getDiagnosisDateTime() {
		return dateTime;
	}

	/***************************************************************************************************************
	//Function:		setSymptom(int s, int value)
	//
	//Description:	sets a specific symptom (1-5)
	/***************************************************************************************************************/
	public void setSymptom(int s, int value) {
		switch (s) {
		case 1:
			symptom1 = value;
		case 2:
			symptom2 = value;
		case 3:
			symptom3 = value;
		case 4:
			symptom4 = value;
		case 5:
			symptom5 = value;
		}
	}

	/***************************************************************************************************************
	//Function:		toString()
	//
	//Description:	returns the diagnosis as a String; used for testing
	/***************************************************************************************************************/
	public String toString() {
		return "Diagnosis:\t" + diagnosisName + "\n" + "Pain:\t" + symptom1
				+ "\n" + "Nausea:\t" + symptom2 + "\n" + "Sleepiness:\t"
				+ symptom3 + "\n" + "Fatigue:\t" + symptom4 + "\n"
				+ "Dizziness:\t" + symptom5 + "\n" + dateTime;
	}

	/***************************************************************************************************************
	//Function:		toShortString()
	//
	//Description:	returns the diagnosis name and time reported as a String
	/***************************************************************************************************************/
	public String toShortString() {
		return dateTime + ": " + diagnosisName;
	}
}
