/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the DiagnosisEntry object.

/***********************************************/
package alertLife;

public class DiagnosisEntry
{
	private int symptom1;
	private int symptom2;
	private int symptom3;
	private int symptom4;
	private int symptom5;
	private String comments;
	private String doctor;
	
	/***********************Constructors******************************************/
	//Methods: DiagnosisEntry(), DiagnosisEntry(int s1, int s2, int s3, int s4, int s5, String com, String doc)
	//Description: Constructors for the DiagnosisEntry object.
	/*****************************************************************************/
	public DiagnosisEntry()
	{
		symptom1 = 0;
		symptom2 = 0;
		symptom3 = 0;
		symptom4 = 0;
		symptom5 = 0;
		comments = "?";
		doctor = "?";
	}
	
	public DiagnosisEntry(int s1, int s2, int s3, int s4, int s5, String com, String doc)
	{
		symptom1 = s1;
		symptom2 = s2;
		symptom3 = s3;
		symptom4 = s4;
		symptom5 = s5;
		comments = com;
		doctor = doc;
	}

	/********************************Getter and Setters***************************/
	//Methods: 	public int getSymptom1(), public void setSymptom1(int s), 
	//          public int getSymptom2(), public void setSymptom2(int s), 
	//			public int getSymptom3(), public void setSymptom3(int s), 
	//			public int getSymptom4(), public void setSymptom4(int s), 
	//			public int getSymptom5(), public void setSymptom5(int s), 
	//			public String getComments(), public void setComments(String c), 
	//			public String getDoctor(), public void setDoctor(String d)
	//Description: Returns or modifies the comment, symptoms, and doctor
	/*****************************************************************************/
	
	public int getSymptom1()
	{
		return symptom1;
	}
	
	public void setSymptom1(int s)
	{
		symptom1 = s;
	}
	
	public int getSymptom2()
	{
		return symptom2;
	}
	
	public void setSymptom2(int s)
	{
		symptom2 = s;
	}
	
	public int getSymptom3()
	{
		return symptom3;
	}
	
	public void setSymptom3(int s)
	{
		symptom3 = s;
	}
	
	public int getSymptom4()
	{
		return symptom4;
	}
	
	public void setSymptom4(int s)
	{
		symptom4 = s;
	}
	
	public int getSymptom5()
	{
		return symptom5;
	}
	
	public void setSymptom5(int s)
	{
		symptom5 = s;
	}
	
	public String getComments()
	{
		return comments;
	}
	
	public void setComments(String c)
	{
		comments = c;
	}
	
	public String getDoctor()
	{
		return doctor;
	}
	
	public void setDoctor(String d)
	{
		doctor = d;
	}
}