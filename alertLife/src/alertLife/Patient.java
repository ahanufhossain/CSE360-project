/***************************************************************************************************************
//Team #3
//Team Members: 	Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens
//
//Description: 		This class implements the Patient object, which has inherited values from the User class and
//					new unique values such as a diagnosis.
/***************************************************************************************************************/

package alertLife;

import java.io.Serializable;
import java.util.ArrayList;

public class Patient extends User implements Serializable {

	public ArrayList<Diagnosis> diagnoses;

	/***************************************************************************************************************
	//Function:		Patient()
	//
	//Description:	Empty constructor for a Patient object
	/***************************************************************************************************************/
	public Patient() {
		username = null;
		password = null;
		dateOfBirth = null;
		name = null;
		userType = "Patient";
		diagnoses = new ArrayList<Diagnosis>();
	}

	/***************************************************************************************************************
	//Function:		Patient(String uName, String pw, String initDOB, String initName)
	//
	//Description:	Constructor for a Patient object
	/***************************************************************************************************************/
	public Patient(String uName, String pw, String initDOB, String initName) {
		username = uName;
		password = pw;
		dateOfBirth = initDOB;
		name = initName;
		userType = "Patient";
		diagnoses = new ArrayList<Diagnosis>();
	}

	/***************************************************************************************************************
	//Function:		addDiagnosis(Diagnosis newEntry)
	//
	//Description:	adds a diagnosis to the patient's diagnosis list
	/***************************************************************************************************************/
	public void addDiagnosis(Diagnosis newEntry) {
		if (diagnoses.add(newEntry) && AlertLife.debugModeOn == 1)
			;
		System.out.println("Diagnosis has been added to the current list.");
	}

	/***************************************************************************************************************
	//Function:		removeDiagnosis(Diagnosis remEntry)
	//
	//Description:	remones a diagnosis from the patient's diagnosis list
	/***************************************************************************************************************/
	public void removeDiagnosis(Diagnosis remEntry) {
		if (diagnoses.remove(remEntry) && AlertLife.debugModeOn == 1)
			;
		System.out.println("Diagnosis has been removed from the current list.");
	}

	/***************************************************************************************************************
	//Function:		getDiagnoses()
	//
	//Description:	returns the patient's array list of diagnosis
	/***************************************************************************************************************/
	public ArrayList<Diagnosis> getDiagnoses() {
		return diagnoses;
	}

	/***************************************************************************************************************
	//Function:		getDiagnosisReport(Diagnosis reported)
	//
	//Description:	returns the diagnosis as a String; calculates the severity
	//
	//				Symptom1: x/Symptom2: x/Symptom 3: x
	//				Symptom4: x/SYmptom5: x
	//				Comment: Line of text
	//				Line of text
	//				...
	//				last line of text
	/***************************************************************************************************************/
	public String getDiagnosisReport(Diagnosis reported) {
		if (AlertLife.debugModeOn == 1) {
			if (reported.getSymptom(1) > 5 || reported.getSymptom(1) < 0)
				return "Failed to obtain Symptom 1";
			else if (reported.getSymptom(2) > 5 || reported.getSymptom(2) < 0)
				return "Failed to obtain Symptom 2";
			else if (reported.getSymptom(3) > 5 || reported.getSymptom(3) < 0)
				return "Failed to obtain Symptom 3";
			else if (reported.getSymptom(4) > 5 || reported.getSymptom(4) < 0)
				return "Failed to obtain Symptom 4";
			else if (reported.getSymptom(1) > 5 || reported.getSymptom(5) < 0)
				return "Failed to obtain Symptom 5";
		}// end debug mode

		String report;
		report = "Severity: ";
		report += determineSeverity() + "\n";
		report += "Pain: "; 
		report += reported.getSymptom(1) + "\nNausea: " + reported.getSymptom(2) + "\nSleepiness: " + reported.getSymptom(3) + "\n";
		report += "Fatgue: " + reported.getSymptom(4) + "\nDizziness: " + reported.getSymptom(5) + "\n";
		report += "Comment: " + reported.getComment() + "\n";

		return report;
	}

	/***************************************************************************************************************
	//Function:		getPriority()
	//
	//Description:	Returns a patient's priority based on the sum of symptoms
	/***************************************************************************************************************/
	public int getPriority() {
		if (diagnoses.size() == 0) // if no new entries exist
			return 0;
		Diagnosis temp = diagnoses.get(diagnoses.size() - 1);// get last indexed diagnosis
		return temp.getSymptom(1) + temp.getSymptom(2) + temp.getSymptom(3)	+ temp.getSymptom(4) + temp.getSymptom(5);
	}

	/***************************************************************************************************************
	//Function:		determineSeverity()
	//
	//Description:	returns a string that gives the level of problematicness of the patient's most recent entry.
	//				Assuming that our maximum priority level is 25, then 60% of 25 is 15 (problematic) and 80% of 25
	//				is 20 (significantly problematic)
	/***************************************************************************************************************/
	public String determineSeverity() {
		if (diagnoses.size() == 0) // if no new entries exist
			return "Patient has no entries.";
		else if (getPriority() >= 20)
			return "SIGNIFICANTLY PROBLEMATIC";
		else if (getPriority() > 15)
			return "Problematic";
		else
			return "Below the problematic threshold";
	}
}
