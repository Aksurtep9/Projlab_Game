package src;


/**
* AminoAcid
* Inherited from Material
* amount - from Material
* Represents AminoAcid with an amount
**/
public class AminoAcid extends Material{
	
	/**
	 * default constructor
	 */
	public AminoAcid() {
		amount=20;
	}
	
	/**
	* Default ToString method for console printout.
	* @return String with the amount
	**/
	public String ToString() {
		return ("Amount of AminoAcid: " + amount);
	}
}
