package alertLife;

import java.util.ArrayList;

public class Doctor extends User {

	private ArrayList<Patient> patients;
		
	/***********************Constructors******************************************/
	//Methods: Patient(), and Patient(String uName, String pw, String initDOB, String initName) 
	//Description: Constructors for the Doctor object.
	/*****************************************************************************/
	public Doctor()
	{
		username = null; 
		password = null;
		dateOfBirth = null;
		name = null;
		userType = "Doctor";
	}
	public Doctor(String uName, String pw, String initDOB, String initName)
	{
		username = uName;
		password = pw;
		dateOfBirth = initDOB;
		name = initName;
		userType = "Doctor";
	}
	
	/**********************sortPatients*********************************/
	//Description: Sorts patients based on highest to lowest priority
	/******************************************************************/
	
	public void sortPatients()
	{
		int exitCount = patients.size();
		if(exitCount == 0 || exitCount == 1)
			return; //if empty or only 1 element do nothing
		else
		{
			ArrayList<Patient> temp = new ArrayList(); 
			int highestPriority = 0;
			int indexOfHighest = 0;
			int count = 0;
			Patient tempPatient; 
			while(temp.size() != exitCount)
			{
				while (count < exitCount)
				{
					if(patients.get(count).getPriority() > highestPriority)
					{
						highestPriority = patients.get(count).getPriority();
						indexOfHighest = count;
					}
					count++;
				}
				tempPatient = patients.get(indexOfHighest); //obtain lowest priority patient after search
				temp.add(tempPatient); //add lowest priority patient to new arraylist
				
			}//close inner while
			patients = temp; //list is sorted
		}//close outer while
	}//close sortPatients
	
	public void addPatient(Patient newPatient)
	{
		if(patients.add(newPatient) && AlertLife.debugModeOn == 1);
		System.out.println("Patient has been added to the current list.");
	}
	
	public void removeDiagnosis(Diagnosis remEntry)
	{
		if(patients.remove(remEntry) && AlertLife.debugModeOn == 1);
		System.out.println("Patient has been removed from the current list.");
	}
	
	public Patient getPatient(String pName)
	{
		Patient temp = new Patient();
		int count = 0;
		while(temp.getName() != pName && count < patients.size())
		{
			if(patients.get(count).getName() == pName)
			{
				temp = patients.get(count); 
				count = 9001;//break out of loop
			}
			count++;
		}
		if(patients.get(patients.size()).getName() != pName && count != 9001) //if not found
			System.out.println("Patient not found");
		return temp;
	}
}
