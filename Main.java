package frontend;

import java.util.ArrayList;
import java.util.List;

import go_football.entity.Adminstrator;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Player;
import go_football.entity.Playground;
import go_football.entity.User;

/**
 * This is the Main Class  
 * This class will maintain the program and the user deal with it  
 */
public class Main {
	
	/***
	* Main's players
	*/
	private static List<Player> players = new ArrayList<>();
	/***
	* Main's playground owners
	*/
	private static List<PlayGroundOwner> owners = new ArrayList<>();
	/***
	* Main's playgrounds
	*/
	private static List<Playground> playgrounds = new  ArrayList<>();
	/***
	* Main's administrators
	*/
	private static List<Adminstrator> admins = new  ArrayList<>();
	/***
	* Main's registration
	*/
	private static RegistrationMain registrationMain = new RegistrationMain(players, owners, admins);
	
	/** 
     * This is the main method
     * This method will maintain a bank and allow the user to deal with it  
     * @param args
     */
	public static void main(String[] args) {
		while (true) {
			User user = registrationMain.registrationMain();
			if (user == null)
				continue;
			if (user instanceof Player) {
				PlayerMain playerMain = new PlayerMain((Player) user, players, playgrounds);
				playerMain.playerMain();
			}
			else if (user instanceof PlayGroundOwner) {
				OwnerMain ownerMain = new OwnerMain((PlayGroundOwner)user, playgrounds);
				ownerMain.ownerMain();
			} else if (user instanceof Adminstrator) {
				AdminstratorMain adminstratorMain = new AdminstratorMain((Adminstrator)user, playgrounds, players, owners);
				adminstratorMain.adminstratorMain();
			}
		}
	}	
	
	

}
