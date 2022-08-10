package go_football.entity;

import java.util.ArrayList;
import java.util.List;

/** 
* PlayGroundOwner class to manage a playground owner in the program. 
*/
public class PlayGroundOwner extends User{

	/** 
	 * playground owner's ewallet.
	 */
	private double ewallet;
	/** 
	 * playground owner's playgrounds.
	 */
	private List<Playground> playgrounds;
	
	/** 
	* PlayGroundOwner Constructor.
	* @param String name
	* @param String password
	* @param String email
	* @param String phone
	* @param String location
	*/
	public PlayGroundOwner(String name, String password, String email, String phone, String location) {
		super(name, password, email, phone, location);
		ewallet = 0;
		playgrounds = new ArrayList<>();
	}
	
	/** 
	* this method makes withdraw from the ewallet of the playground owner.
	* @param double amount
	*/
	public boolean withdraw(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		if (ewallet - amount < 0) return false;
		ewallet -= amount;
		return true;
	}	
	
	/** 
	* this method makes deposit for the ewallet of the playground owner.
	* @param double amount
	*/
	public void deposite(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		ewallet += amount;
	}
	
	/** 
	* this method returns the playground owner ewallet.
	* @return double
	*/
	public double getEwallet() {
		return ewallet;
	}

	/** 
	* this method returns the playgrounds of the playground owner.
	* @return double
	*/
	public List<Playground> getPlaygrounds() {
		return playgrounds;
	}
	
	/** 
	* this method adds a new playground to the playgrounds of the playground owner.
	* @param Playground playground
	*/
	public void addNewPlayground(Playground playground) {
		playgrounds.add(playground);
	}
	
	/** 
	* this method gets a specific playground from the playgrounds of the playground owner.
	* @param int id
	*/
	public Playground getPlayground(int id) {
		for (Playground playground : playgrounds) {
			if (playground.getId() == id) {
				return playground;
			}
		}
		return null;
	}
	
	/** 
	* this method removes a specific playground from the playgrounds of the playground owner.
	* @param int id
	*/
	public Playground removePlayground(int id) {
		Playground playground = getPlayground(id);
		if (playground == null) {
			return null;
		}
		playgrounds.remove(playground);
		return playground;
	}

	/** 
	* this method shows all the playgrounds of the playground owner.
	*/
	public void showPlaygrounds() {
		System.out.println(playgrounds);
	}
	
}
