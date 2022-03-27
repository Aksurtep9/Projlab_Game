package src;
/**
 * Equipment
 * Thing - base class
 * Implements Effect interface.
 * The abstract base class from which the the different equipments inherit(e.g. Gloves).
 * It can be picked up or thrown out of a Virologist's EquipmentCollection. When it's in someone's EquipmentCollection, it applies its Effect.
 * @author csizm
 *
 */
public abstract class Equipment extends Thing implements Effect {
	/**
	 * The Equipment applies its effect on the virologist given as parameter. The subclasses override this method to apply their unique effects.
	 * @param v the Virologist who has the equipment
	 */
	public void Affect(Virologist v) {
		System.out.println("Affect");
	}
	
	/**
	 * Returns the name of the Effect the Equipment has. 
	 * @return a string containing the name of the Effect
	 */
	public String GetEffectName() {
		System.out.println("GetEffectName");
		return "";
	}
	
	/**
	 * Writes the Attributes of the Equipment in a string.
	 * @return string
	 */
	public String ToString() {
		System.out.println("ToString");
		return "";
	}
}
