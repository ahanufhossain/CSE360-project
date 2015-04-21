/***************************************************************************************************************
//Team #3
//Team Members: 	Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens
//
//Description: 		This class implements the User object, which will be inherited by both Patient and Doctor 
//					objects.
/***************************************************************************************************************/

package alertLife;

import java.io.Serializable;

public class User implements Serializable {
	protected String username;
	protected String password;
	protected String dateOfBirth;
	protected String name;
	public String userType = "Patient";

	/***************************************************************************************************************
	//Function:		User()
	//
	//Description:	Empty constructor for a User object
	/***************************************************************************************************************/
	public User() {
		username = null;
		password = null;
		dateOfBirth = null;
		name = null;
	}

	/***************************************************************************************************************
	//Function:		User(String uName, String pw, String initDOB, String initName)
	//
	//Description:	Constructor for a User object
	/***************************************************************************************************************/
	public User(String uName, String pw, String initDOB, String initName) {
		username = uName;
		password = pw;
		dateOfBirth = initDOB;
		name = initName;
	}

	/***************************************************************************************************************
	//Function:		getUsername()
	//
	//Description:	returns the username string of the current User object
	/***************************************************************************************************************/
	public String getUsername() {
		return username;
	}

	/***************************************************************************************************************
	//Function:		setUsername(String iUsername)
	//
	//Description:	sets the username string of the current User object
	/***************************************************************************************************************/
	public void setUsername(String iUsername) {
		username = iUsername;
	}

	/***************************************************************************************************************
	//Function:		getPassword()
	//
	//Description:	returns the password string of the current User object
	/***************************************************************************************************************/
	public String getPassword() {
		return password;
	}

	/***************************************************************************************************************
	//Function:		setPassword(String iPassword)
	//
	//Description:	sets the password string of the current User object
	/***************************************************************************************************************/
	public void setPassword(String iPassword) {
		password = iPassword;
	}

	/***************************************************************************************************************
	//Function:		getDOB()
	//
	//Description:	gets the DOB string of the current User object
	/***************************************************************************************************************/
	public String getDOB() {
		return dateOfBirth;
	}

	/***************************************************************************************************************
	//Function:		setDOB(String iDOB)
	//
	//Description:	sets the DOB string of the current User object
	/***************************************************************************************************************/
	public void setDOB(String iDOB) {
		dateOfBirth = iDOB;
	}

	/***************************************************************************************************************
	//Function:		getName()
	//
	//Description:	gets the name string of the current User object
	/***************************************************************************************************************/
	public String getName() {
		return name;
	}

	/***************************************************************************************************************
	//Function:		setName(String iName)
	//
	//Description:	sets the name string of the current User object
	/***************************************************************************************************************/
	public void setName(String iName) {
		name = iName;
	}
}
