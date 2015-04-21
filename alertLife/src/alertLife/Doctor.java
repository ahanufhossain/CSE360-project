/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the Doctor class object.

/***********************************************/

package alertLife;

import java.io.Serializable;
import java.util.ArrayList;

public class Doctor extends User implements Serializable {

	private ArrayList<Patient> patients = new ArrayList<Patient>();
		
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
				highestPriority = 0;
				indexOfHighest = 0;
				count = 0;
				while (count < patients.size())
				{
					if(patients.get(count).getPriority() > highestPriority)
					{
						highestPriority = patients.get(count).getPriority();
						indexOfHighest = count;
					}
					count++;
				}
				tempPatient = patients.get(indexOfHighest); //obtain highest priority patient after search
				temp.add(tempPatient); //add highest priority patient to new arraylist
				removePatient(tempPatient); //remove from current list
				
			}//close inner while
			patients = temp; //list is sorted
		}//close outer while
	}//close sortPatients
	
	public void addPatient(Patient newPatient)
	{
		if(patients.add(newPatient) && AlertLife.debugModeOn == 1);
		System.out.println("Patient has been added to the current list.");
	}
	
	public void removePatient(Patient remEntry)
	{
		if(patients.remove(remEntry) && AlertLife.debugModeOn == 1);
		System.out.println("Patient has been removed from the current list.");
	}
	
	public ArrayList<Patient> getPatientList()
	{
		sortPatients();
		return patients;
	}
	
	public Patient getPatient(String pName)
	{
		Patient temp = new Patient();
		for(int i = 0; i < patients.size(); i++ )
		{
			
			if(patients.get(i).getName() == pName)
			{
				
				temp = patients.get(i);
				i = 9001;
			}
		}
		if(temp.getName() != pName) //if not found
			System.out.println("Patient not found");
		return temp;
	}
}
