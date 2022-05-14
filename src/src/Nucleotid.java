package src;

/**
* Nucleotid
* Inherited from Material
* amount - from Material
* Represents Nucleotid with an amount
**/
public class Nucleotid extends Material{
	
	/**
	 * default constructor
	 */
	public Nucleotid() {
		amount = 20;
	}
	
	/**
	 * constructor with parameter
	 * @param amount: how many nucleotid we are going to have
	 */
	public Nucleotid(int amount) {
		this.amount=amount;
	}
	
	/**
	* Default ToString method for console printout.
	* @return String with the amount
	**/
	public String ToString() {
		return ("Amount of Nucleotid: " + amount);
	}
}