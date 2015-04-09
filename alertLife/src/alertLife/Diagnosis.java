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

public class Diagnosis {
	
	private int symptom1;
	private int symptom2;
	private int symptom3;
	private int symptom4;
	private int symptom5;
	private String comment;
	private String doctor;
	
	public Diagnosis()
	{
		symptom1 = 0;
		symptom2 = 0;
		symptom3 = 0;
		symptom4 = 0;
		symptom5 = 0;
		comment = "";
		doctor = "";
	}
	
	public Diagnosis(int symp1, int symp2, int symp3, int symp4, int symp5, String com, String doc)
	{
		symptom1 = symp1;
		symptom2 = symp2;
		symptom3 = symp3;
		symptom4 = symp4;
		symptom5 = symp5;
		comment = com;
		doctor = doc;
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
	
	public String getDoctor()
	{
		return doctor;
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
	
	public void setComment(String c)
	{
		comment = c;
	}
	
	public void setDoctor(String d)
	{
		doctor = d;
	}
}
