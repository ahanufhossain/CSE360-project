package alertLife;

import java.io.ObjectInputStream.GetField;

public class TestUser {
	
	public static void main(String[] args)
	{
		
		//Test user constructors, setter, and getter methods.
		User fake = new User();
		User real = new User("jschmoe", "notpassword", "August, 29, 1994", "Joe Schmoe");
		System.out.println("Fake's name: " + fake.getName() + "\t Fake's username: " + fake.getUsername() +
							"\t Fake's password: " + fake.getPassword() + "\t Fake's DOB: " + fake.getDOB());
		fake.setDOB("This Year");
		fake.setName("Ray Jay");
		fake.setPassword("defnotpassword");
		fake.setUsername("rJay");
		System.out.println("Fake's name: " + fake.getName() + "\t Fake's username: " + fake.getUsername() +
				"\t Fake's password: " + fake.getPassword() + "\t Fake's DOB: " + fake.getDOB());
		
		System.out.println("Reals's name: " + real.getName() + "\t Real's username: " + real.getUsername() +
				"\t Real's password: " + real.getPassword() + "\t Fake's DOB: " + real.getDOB());
		
		//Test Patient, Doctor, and Diagnosis
		Patient seeker = new Patient("cheapscape", "d834jd(@!", "Today", "Bob Saggot");
		Doctor wiseguy = new Doctor("supmario", "sd3$)(", "Tomorrow", "Mario Luigi");
		
		Diagnosis repo3 = new Diagnosis();
		repo3.setSymptom(1, 1);
		repo3.setSymptom(2, 2);
		repo3.setSymptom(3, 3);
		repo3.setSymptom(4, 4);
		repo3.setSymptom(5, 5);
		repo3.setComment("AINT NO BODY GOT TIME FOR THAT, I GOT BRONCHIDAS");
		repo3.setDoctor("Dr. Mario");
		System.out.println("Symptom 1:" + repo3.getSymptom(1) + "\t Symptom 2: " + repo3.getSymptom(2)
				+ "\t Symptom 3: " + repo3.getSymptom(3)+ "\t Symptom 3: " + repo3.getSymptom(3)
				+ "\t Symptom 4: " + repo3.getSymptom(4) + "\t Symptom 5: " + repo3.getSymptom(5)
				+ "\nComment: " + repo3.getComment() + "\t Doctor: " + repo3.getDoctor());
		Diagnosis repo = new Diagnosis();
		Diagnosis repo2 = new Diagnosis(5, 2, 1, 1, 1, "I wanna be the very best, like no one ever was", "Prof Oak");
		Patient ashkecha = new Patient("akecha", "pikachu", "10 for Life", "Ash Kecham");
		Patient tyrone = new Patient("TRone", "dsf3dsf", "Everyday", "Tyrone");
	
		ashkecha.addDiagnosis(repo3);
		ashkecha.addDiagnosis(repo2);
		
		seeker.addDiagnosis(repo3);
		seeker.addDiagnosis(repo);
		
		tyrone.addDiagnosis(repo2);
		tyrone.addDiagnosis(repo);
		tyrone.addDiagnosis(repo3);
		
		System.out.println("Ash Kecham's Reports:");
		for(int i = 0; i < ashkecha.getDiagnoses().size(); i++)
		{
			System.out.print(ashkecha.getDiagnosisReport(ashkecha.getDiagnoses().get(i)));
		}
		
		System.out.println("\nGeneric Patient's Reports:");
		for(int i = 0; i < seeker.getDiagnoses().size(); i++)
		{
			System.out.print(seeker.getDiagnosisReport(seeker.getDiagnoses().get(i)));
		}
		
		System.out.println("\nTyrone's Reports:");
		for(int i = 0; i < tyrone.getDiagnoses().size(); i++)
		{
			System.out.print(tyrone.getDiagnosisReport(tyrone.getDiagnoses().get(i)));
		}
		
		System.out.println("\nPriority List: " +
							"\nAsh Kecham: " + ashkecha.getPriority() +
							"\nTyrone: " + tyrone.getPriority() +
							"\nGeneric Patient: " + seeker.getPriority());
		
		wiseguy.addPatient(ashkecha);
		wiseguy.addPatient(seeker);
		wiseguy.addPatient(tyrone);
		
		
		System.out.println("Current Order: "); 
		for(int i = 0; i < wiseguy.getPatientList().size(); i++ )
		{
			System.out.println(wiseguy.getPatientList().get(i).getName());
		}
		
		wiseguy.sortPatients();
		System.out.println("\nSorted: "); 
		for(int i = 0; i < wiseguy.getPatientList().size(); i++ )
		{
			System.out.println(wiseguy.getPatientList().get(i).getName());
		}
		
		System.out.println("Wiseguy patient list size:" + wiseguy.getPatientList().size());
		System.out.println(wiseguy.getPatient("Ash Kecham").getName() + ": Success");
		
		System.out.println("\n[Doctor] " + wiseguy.getName() + "Has patient:" + wiseguy.getPatient("Ash Kecham").getName() + "\twith username: " + wiseguy.getPatient("Ash Kecham").getUsername());
		System.out.println("and Has patient:" + wiseguy.getPatient("Tyrone").getName() + "\twith username: " + wiseguy.getPatient("Tyrone").getUsername());
		System.out.println("and Has patient:" + wiseguy.getPatient("Bob Saggot").getName() + "\twith username: " + wiseguy.getPatient("Bob Saggot").getUsername());
	}
}
