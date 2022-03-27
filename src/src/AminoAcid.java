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
		System.out.println("AminoAcid");
		amount=20;
	}
	
	/**
	* Default ToString method for console printout.
	* @return String with the amount
	**/
	public String ToString() {
		System.out.println("ToString");
		return ("Amount of AminoAcid: " + amount);
	}
}
