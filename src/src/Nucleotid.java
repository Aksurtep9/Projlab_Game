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
	* Default ToString method for console printout.
	* @return String with the amount
	**/
	public String ToString() {
		System.out.println("ToString");
		return ("Amount of Nucleotid: " + amount);
	}
}