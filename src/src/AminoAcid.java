package src;


/**
* AminoAcid
* Inherited from Material
* amount - from Material
* Represents AminoAcid with an amount
**/
public class AminoAcid extends Material{
	
	
	/**
	* Default ToString method for console printout.
	* @return String with the amount
	**/
	@Override
	public String toString() {
		return ("Amount of AminoAcid: " + amount);
	}
}
