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

public class User {
private String username;
private String password;
private String dateOfBirth;
private String name;

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

}
