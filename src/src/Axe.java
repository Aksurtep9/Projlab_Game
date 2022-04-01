package src;


/**
 * 
 * Axe
 * Inherited from Equipment.
 * It implements the equipment "Axe". Use this equipment to kill a virologist who had been affected by BearDance agent.
 *
 */
public class Axe extends Equipment{
	
	/**
	 * Constructor for axe.
	 */
	public Axe() {
		super();
	}

	/**
	 * Decrease the equipment's effect time
	 */
	@Override
	public void DecreaseEffectTime(Virologist v) {
				
	}
	
	/**
	 * The Axe kills the Virologist in the parameters
	 * @param v - Virologist that is going to be killed
	 * 
	 */
	public void Affect(Virologist v) {
		v.setDead();
	}
	
	
	

}
