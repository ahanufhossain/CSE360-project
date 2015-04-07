/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the Patient object, which has inherited values from the User class and new unique values such as a diagnosis.

/***********************************************/

package alertLife;

import java.util.ArrayList;

public class Patient extends User {

	
	private ArrayList<Diagnosis> diagnoses;
	
	/***********************Constructors******************************************/
	//Methods: Patient(), and Patient(String uName, String pw, String initDOB, String initName) 
	//Description: Constructors for the Patient object.
	/*****************************************************************************/
	public Patient()
	{
		username = null; 
		password = null;
		dateOfBirth = null;
		name = null;
		userType = "Patient";
	}
	public Patient(String uName, String pw, String initDOB, String initName)
	{
		username = uName;
		password = pw;
		dateOfBirth = initDOB;
		name = initName;
		userType = "Patient";
	}
	
	
	
	
	/***********************Constructors******************************************/
	//Methods: Patient(), and Patient(String uName, String pw, String initDOB, String initName) 
	//Description: Constructors for the Patient object.
	/*****************************************************************************/
	public void addDiagnosis(Diagnosis newEntry)
	{
		if(diagnoses.add(newEntry) && AlertLife.debugModeOn == 1);
		System.out.println("Diagnosis has been added to the current list.");
	}
	
	public void removeDiagnosis(Diagnosis remEntry)
	{
		if(diagnoses.remove(remEntry) && AlertLife.debugModeOn == 1);
		System.out.println("Diagnosis has been removed from the current list.");
	}
	
	/*************************getDiagnosis()***********************************/
	//Description: returns a string in the format: 
	//Symptom1: x/Symptom2: x/Symptom 3: x
	//Symptom4: x/SYmptom5: x
	//Comment: Line of text
	//Line of text
	//...
	//last line of text
	/*************************************************************************/
	
	public String getDiagnosisReport(Diagnosis reported)
	{	
		if(AlertLife.debugModeOn == 1) 
		{
			if(reported.getSymptom(1) > 5 || reported.getSymptom(1) < 0)
				return "Failed to obtain Symptom 1";
			else if(reported.getSymptom(2) > 5 || reported.getSymptom(2) < 0)
				return "Failed to obtain Symptom 2";
			else if(reported.getSymptom(3) > 5 || reported.getSymptom(3) < 0)
				return "Failed to obtain Symptom 3";
			else if(reported.getSymptom(4) > 5 || reported.getSymptom(4) < 0)
				return "Failed to obtain Symptom 4";
			else if(reported.getSymptom(1) > 5 || reported.getSymptom(5) < 0)
				return "Failed to obtain Symptom 5";
		}//end debug mode
				
		String report;
		report = "Pain: "; 
		report += reported.getSymptom(1) + "/Nausea: " + reported.getSymptom(2) + "/Sleepiness: " + reported.getSymptom(3) + "/\n";
		report += "Fatgue: " + reported.getSymptom(4) + "/Dizziness: " + reported.getSymptom(5) + "\n";
		report += "Comment: " + reported.getComment() + "\n";
		
		return report;
	}
	
	
	/************************getPriority()**************************/
	//Description: Returns a patient's priority based on the sum of symptoms.
	public int getPriority()
	{
		if(diagnoses.size() == 0) //if no new entries exist
			return 0;
		Diagnosis temp = diagnoses.get(diagnoses.size() - 1);//get last indexed diagnosis
		return temp.getSymptom(1) + temp.getSymptom(2) + temp.getSymptom(3) + temp.getSymptom(4) + temp.getSymptom(5);
	}

}