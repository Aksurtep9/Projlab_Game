package src;


/**
* MaterialCollecton
* amino - An AminoAcid with amount
* nucle - An Nucleotid with amount
* It represent a collection of the Materials that a player can find on the map.
**/
public class MaterialCollection {
	
	/**The AminoAcid in the collection*/
	private AminoAcid amino;
	
	/**The Nucleotid in the collection*/
	private Nucleotid nucle;
	
	public MaterialCollection() {
		amino = new AminoAcid();
		nucle = new Nucleotid();
	}
	
	/**
	 * The amount of Nucleotid or Aminoacid a player currently carrying.
	 */
	private int amount;
	
	public MaterialCollection() {
		amino = new AminoAcid();
		nucle = new Nucleotid();
	}
	
	/**
	* Getter to the AminoAcid
	* @return amino
	**/
	public AminoAcid GetAmino(){
		return amino;
	}
	
	/**
	* Getter to the Nucleotid
	* @return nucle
	**/
	public Nucleotid GetNucle() {
		return nucle;
	}
}
