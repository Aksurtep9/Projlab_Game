package src;

/**
 * 
 * @author Vili
 * Gloves
 * Inherited from Equipment.
 * It implements the equipment "Gloves". By wearing this equipment the virologist1 is able to anoint the other virologist2 with the agent virologist2 anointed to virologist1.
 */
public class Gloves extends Equipment {
	
	public Gloves() {
		super();
		System.out.println("Gloves constructor");
	}
	
	/**
	 * 
	 * @param v The virologist, who is being affected by an effect.
	 */
	public void Affect(Virologist v) {
		System.out.println("Affect");
		
	}
	
	/**
	 * 
	 * @return Returns "Gloves".
	 */
	public String GetEfectName() {
		System.out.println("GetEffectName");
		return "Gloves";
	}
	
	/**
	 * 
	 * @return Returns the properties of these Gloves.
	 */
	@Override
	public String toString() {
		System.out.println("toString");
		return GetEffectName();
	}

	@Override
	public void DecreaseEffectTime(Virologist v) {
		System.out.println("DecreaseEffectTime");
		// TODO Auto-generated method stub
		
	}

}
