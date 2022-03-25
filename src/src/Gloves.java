package src;

/**
 * 
 * @author Vili
 * Gloves
 * Inherited from Equipment.
 * It implements the equipment "Gloves". By wearing this equipment the virologist1 is able to anoint the other virologist2 with the agent virologist2 anointed to virologist1.
 */
public class Gloves extends Equipment {
	
	
	/**
	 * 
	 * @param v The virologist, who is being affected by an effect.
	 */
	public void Affect(Virologist v) {
		
	}
	
	/**
	 * 
	 * @return Returns "Gloves".
	 */
	public String GetEfectName() {
		return "Gloves";
	}
	
	/**
	 * 
	 * @return Returns the properties of these Gloves.
	 */
	@override
	public String ToString() {
		
	}
}
