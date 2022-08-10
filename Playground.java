package go_football.entity;

import java.util.ArrayList;
import java.util.List;

/** 
* Playground class to control the data of the playground. 
*/
public class Playground {
	/** 
	 * playground's count of id.
	 */
	private static int idCounter;
	
	/** 
	 * playground's id.
	 */
	private int id;
	
	/** 
	 * playground's location.
	 */
	private String location;
	
	/** 
	 * playground's size.
	 */
	private double size;
	
	/** 
	 * playground's name.
	 */
	private String name;
	
	/** 
	 * playground's price per hour.
	 */
	private double pricePerHour;
	
	/** 
	 * playground's owner.
	 */
	private PlayGroundOwner owner;
	
	/** 
	 * playground's available hours.
	 */
	private List<AvaliableHour> avaliableHours;
	
	/** 
	 * playground's complains.
	 */
	private List<Complain> complains;
	
	/** 
	* PlayGround Constructor.
	* @param String location
	* @param double size
	* @param String name
	* @param double pricePerHour
	* @param PlayGroundOwner owner
	*/
	public Playground(String location, double size, String name, double pricePerHour, PlayGroundOwner owner) {
		this.id = idCounter;
		idCounter += 1;
		this.location = location;
		this.size = size;
		this.name = name;
		this.pricePerHour = pricePerHour;
		this.owner = owner;
		avaliableHours = new ArrayList<>();
		complains = new ArrayList<>();
	}

	/** 
	* this method returns the id of the playground.
	* @return int
	*/
	public int getId() {
		return id;
	}

	/** 
	* this method sets the id of the playground.
	* @param int id 
	*/
	public void setId(int id) {
		this.id = id;
	}

	/** 
	* this method returns the location of the playground.
	* @return String
	*/
	public String getLocation() {
		return location;
	}

	/** 
	* this method sets the location of the playground.
	* @param String location 
	*/
	public void setLocation(String location) {
		this.location = location;
	}

	/** 
	* this method returns the size of the playground.
	* @return double
	*/
	public double getSize() {
		return size;
	}

	/** 
	* this method sets the size of the playground.
	* @param double size
	*/
	public void setSize(double size) {
		this.size = size;
	}

	/** 
	* this method returns the name of the playground.
	* @return String
	*/
	public String getName() {
		return name;
	}

	/** 
	* this method sets the name of the playground.
	* @param String name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/** 
	* this method returns the price per hour of the playground.
	* @return double
	*/
	public double getPricePerHour() {
		return pricePerHour;
	}

	/** 
	* this method sets the name of the playground.
	* @param double pricePerHour
	*/
	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	/** 
	* this method returns the available hours of the playground.
	* @return List<AvaliableHour>
	*/
	public List<AvaliableHour> getAvaliableHours() {
		return avaliableHours;
	}
	
	/** 
	* this method adds new available hour to the available hours of the playground .
	*/
	public void addNewAvaliableHour(AvaliableHour avaliableHour) {
		avaliableHours.add(avaliableHour);
	}
	
	/** 
	* this method removes available hour from the available hours of the playground .
	*/
	public boolean removeAvaliableHour(AvaliableHour avaliableHour) {
		return avaliableHours.remove(avaliableHour);
	}

	/** 
	* this method returns the owner of the playground.
	* @return PlayGroundOwner
	*/
	public PlayGroundOwner getOwner() {
		return owner;
	}

	/** 
	* this method sets the owner of the playground.
	* @param PlayGroundOwner owner
	*/
	public void setOwner(PlayGroundOwner owner) {
		this.owner = owner;
	}

	 /** 
	* override toString method for Playground Class
	* @return String
	*/
	@Override
	public String toString() {
		return "Playground [id=" + id + ", location=" + location + ", size=" + size + ", name=" + name
				+ ", pricePerHour=" + pricePerHour + ", avaliableHours=" + avaliableHours + "]";
	}

	/** 
	* this method returns the complains of the playground.
	* @return List<Complain>
	*/
	public List<Complain> getComplains() {
		return complains;
	}

	/** 
	* this method adds new complain to the complains of the playground .
	* @param Player player
	* @param String complainMessage
	*/
	public void complain(Player player, String complainMessage) {
		Complain newComplain = new Complain(this, player, complainMessage);
		complains.add(newComplain);
	}
	
	
}
