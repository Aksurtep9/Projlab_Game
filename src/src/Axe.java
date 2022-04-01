package src;

public class Axe extends Equipment{
	
	public Axe() {
		super();
	}

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
