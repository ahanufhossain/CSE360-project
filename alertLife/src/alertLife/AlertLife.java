/***************************************************************************************************************
//Team #3
//Team Members: 	Emily 	Berk
//					Parker 	Derks
//					Ahanuf 	Hossains
//					Adam 	Lew
//					Josh	Owens
//
//Description: 		This class implements the main, which runs the main functions to open the gui.
/***************************************************************************************************************/

package alertLife;

public class AlertLife {
	
	static final int debugModeOn = 0; 
	
	/***************************************************************************************************************
	//Function:		main(String[] args)
	//
	//Description:	main function for Alert Life
	/***************************************************************************************************************/
	public static void main(String[] args)
	{
		Controller control = new Controller();
		control.init();
	}
}
