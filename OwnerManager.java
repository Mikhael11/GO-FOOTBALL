package go_football.managers;

import java.util.List;

import go_football.entity.AvaliableHour;
import go_football.entity.PlayGroundOwner;
import go_football.entity.Playground;

/** 
* OwnerManager class to manage the actions of the playground owner in the program. 
*/
public class OwnerManager {
	/** 
	 * playground's owner.
	 */
	PlayGroundOwner owner;
	
	/** 
	 * playground owner's playgrounds.
	 */
	List<Playground> playgrounds;
	
	/** 
	* OwnerManager Constructor.
	* @param PlayGroundOwner owner
	* @param List<Playground> playgrounds
	*/
	public OwnerManager(PlayGroundOwner owner, List<Playground> playgrounds) {
		this.owner = owner;
		this.playgrounds = playgrounds;
	}
	
	/** 
	* this method adds a new playground to the playgrounds of the owner.
	* @param String location
	* @param double size
	* @param String name
	* @param double pricePerHour
	*/
	public void addNewPlayground(String location, double size, String name, double pricePerHour) {
		Playground playground = new Playground(location, size, name, pricePerHour, owner);
		playgrounds.add(playground);
		owner.addNewPlayground(playground);
	}
	
	/** 
	* this method removes a new playground from the playgrounds of the owner.
	* @param int playgroundId
	*/
	public void removePlayground(int playgroundId) {
		Playground playground =  owner.removePlayground(playgroundId);
		if (playground != null)
			playgrounds.remove(playground);
	}
	
	/** 
	* this method adds the available hours for a specific playground.
	* @param int playgroundId
	* @param AvaliableHour avaliableHour
	*/
	public void addAvaliableTime(int playgroundId, AvaliableHour avaliableHour) {
		Playground  playground = owner.getPlayground(playgroundId);
		playground.addNewAvaliableHour(avaliableHour);
	}
	
	/** 
	* this method withdraws an amount from the playground owner.
	* @param int amount
	*/
	public boolean withdraw(int amount) {
		return owner.withdraw(amount);
	}
	
	/** 
	* this method deposits an amount for the playground owner.
	* @param int amount
	*/
	public void deposite(int amount) {
		owner.deposite(amount);
	}
	
	/** 
	* this method shows all the playgrounds of the playground owner.
	*/
	public void showPlaygrounds() {
		owner.showPlaygrounds();
	}
	
	/** 
	* this method shows all the complains on the playgrounds of the playground owner.
	*/
	public void showAllComplains() {
		List<Playground> playgrounds = owner.getPlaygrounds();
		for (Playground playground : playgrounds) {
			
			System.out.println("Playground id - " + playground.getId());
			System.out.println(">>>> Complains: ");
			System.out.println(playground.getComplains());
		}
	}
	
}
