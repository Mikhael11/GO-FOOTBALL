package frontend;
import java.util.List;
import java.util.Scanner;

import go_football.entity.AvaliableHour;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Playground;
import go_football.managers.OwnerManager;

/** 
* OwnerMain class is the main of the owner used to manage the options of the playground owner in the program. 
*/
public class OwnerMain {
	Scanner scanner;
	/** 
	 * playground's owner manager.
	 */
	private OwnerManager manager;
	
	
	/** 
	* OwnerMain Constructor.
	* @param PlayGroundOwner owner
	* @param List<Playground> playgrounds
	*/
	public OwnerMain(PlayGroundOwner owner, List<Playground> playgrounds) {
		scanner =new java.util.Scanner(System.in);
		manager = new OwnerManager(owner, playgrounds);
	}

	/** 
	* this method used to make the actions of the show menu of the playground owner.
	*/
	public void ownerMain() {
		boolean logout = false;
		while(true) {
			if (logout)
				break;
			showMenu();
			int choice = Integer.parseInt(scanner.next());
			switch(choice) {
				case 1:
					addNewPlayground();
					break;
				case 2:
					removePlayground();
					break;
				case 3:
					deposite();
					break;
				case 4:
					withdraw();
					break;
				case 5:
					addAvaliableTime();
					break;
				case 6:
					showComplains();
					break;
				case 7:
					logout=true;
					break;
			}
		}
	}
	/** 
	* this method shows the menu of the playground owner .
	*/
	private void showMenu() {
		System.out.println("1- Add new playground ");
		System.out.println("2- Remove playground");
		System.out.println("3- Deposit ");
		System.out.println("4- Withdraw ");
		System.out.println("5- Add avaliable time ");
		System.out.println("6- Show complains ");
		System.out.println("7- Logout ");
		
	}
	
	/** 
	* this method withdraws an amount from the playground owner.
	*/
	public void withdraw() {
		System.out.println("Enter how much you wanna withraw: ");
		int amount = Integer.parseInt(scanner.next());
		manager.withdraw(amount);
	}

	/** 
	* this method deposits an amount for the playground owner.
	*/
	public void deposite() {
		System.out.println("Enter how much you wanna deposite:");
		int amount = Integer.parseInt(scanner.next());
		manager.deposite(amount);
	}
	
	/** 
	* this method removes a new playground from the playgrounds of the owner.
	*/
	public void removePlayground() {
		System.out.println("Enter the Playground ID: ");
		int id = Integer.parseInt(scanner.next());
		manager.removePlayground(id);	
	}
	
	/** 
	* this method adds the available hours for a specific playground.
	*/
	public void addAvaliableTime() {
		AvaliableHour avaliableHour = new AvaliableHour();
		System.out.println("Enter the Playground ID: ");
		int id = Integer.parseInt(scanner.next());
		System.out.println("Enter the day: ");
		String day = scanner.next();
		scanner.nextLine();
		avaliableHour.setDay(day);
		System.out.println("please enter the Start hour: ");
		int starthour = Integer.parseInt(scanner.next());
		avaliableHour.setStartHour(starthour);
		System.out.println("please enter the End hour: ");
		int endhour = Integer.parseInt(scanner.next());
		avaliableHour.setEndHour(endhour);
		manager.addAvaliableTime(id, avaliableHour);
	}
	
	/** 
	* this method adds a new playground to the playgrounds of the owner.
	*/
	public void addNewPlayground() {
		System.out.println("Enter the playground name: ");
		String name = scanner.next();
		scanner.nextLine();
		System.out.println("Enter the location: ");
		String location = scanner.nextLine();
		System.out.println("Enter the size: ");
		double size = Double.parseDouble(scanner.nextLine());
		System.out.println("Enter the price per hour: ");
		double price = Double.parseDouble(scanner.nextLine());
		manager.addNewPlayground(location, size, name, price);		
	}
	
	/** 
	* this method shows all the complains on the playgrounds of the playground owner.
	*/
	public void showComplains() {
		manager.showAllComplains();
	}

}
