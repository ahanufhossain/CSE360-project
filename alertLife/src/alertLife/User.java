/***********************************************/
//Team #3
//Team Members: 	(First 	Last)
//					Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens

//Description: 	This class implements the User object, which will be inherited by both Patient and Doctor objects.

/***********************************************/
package alertLife;

import java.io.Serializable;

public class User implements Serializable {
protected String username;
protected String password;
protected String dateOfBirth;
protected String name;
public  String userType = "Patient";

/***********************Constructors******************************************/
//Methods: User(), and User(String uName, String pw, String initDOB, String initName) 
//Description: Constructors for the User object.
/*****************************************************************************/

public User()
{
	username = null; 
	password = null;
	dateOfBirth = null;
	name = null;
}
public User(String uName, String pw, String initDOB, String initName)
{
	username = uName;
	password = pw;
	dateOfBirth = initDOB;
	name = initName;
}


/***********************Username Getter and Setters***************************/
//Methods: getUsername(), setUsername()
//Description: Returns or modifies the username string of the current User object.
/*****************************************************************************/
public String getUsername()
{
	return username;
}
public void setUsername(String iUsername)
{
	username = iUsername;
}

/***********************Password Getter and Setters***************************/
//Methods: getPasswod(), setPassword()
//Description: Returns or modifies the password string of the current User object.
/*****************************************************************************/
public String getPassword()
{
	return password;
}
public void setPassword(String iPassword)
{
	password = iPassword;
}

/***********************Date of Birth Getter and Setters***************************/
//Methods: getDOB(), setDOB()
//Description: Returns or modifies the dateOfBirth string of the current User object.
/*****************************************************************************/
public String getDOB()
{
	return dateOfBirth;
}
public void setDOB(String iDOB)
{
	dateOfBirth = iDOB;
}

/***********************name Getter and Setters***************************/
//Methods: getName(), setName()
//Description: Returns or modifies the name string of the current User object.
/*****************************************************************************/
public String getName()
{
	return name;
}
public void setName(String iName)
{
	name = iName;
}


}//close class
