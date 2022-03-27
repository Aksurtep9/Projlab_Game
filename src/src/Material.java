package src;

/**
* Material
* Inharited from Thing
* amount - Amount of the material
* Base class to the AminoAcid and Nucleotid
**/
public abstract class Material extends Thing {
	
	/**Shows the amount of the Material*/
	protected int amount;
	
	public Material() {
		System.out.println("Material constructor");
		amount = 20;
	}
	
	/**
	* Getter to the amount
	* @return amount
	**/
	public int GetAmount() {
		System.out.println("GetAmount");
		return amount;
	}
	
	/**
	* Increases the amount with the int in the parameter
	* @param a - adds this amount to the amount
	**/
	public void AddAmount(int a) {
		System.out.println("AddAmount");
		amount += a;
	}
	
	/**
	* Decreases the amount with the int in the parameter
	* @param a - removes this amount to the amount
	**/
	public void RemoveAmount(int a) {
		System.out.println("RemoveAmount");
		amount -= a;
	}
	
	/**
	* Default ToString method for console printout.
	* @return String with the amount
	**/
	public String ToString() {
		System.out.println("ToString");
		return ("Amount of material: " + amount);
	}
}
