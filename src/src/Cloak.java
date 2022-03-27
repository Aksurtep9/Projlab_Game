package src;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Vili
 * Cloak
 * Inherited from Equipment
 * It implements the equipment "Cloak". This equipment has an effect of protecting the virologist against other agents with a certain amount of chance.
 *
 */
public class Cloak extends Equipment {
	
	
	/**
	 * 
	 * @param v The virologist, who is being affected by an effect.
	 */
	public void Affect(Virologist v) {
		double random = ThreadLocalRandom.current().nextDouble(0,100);
		if(random>82.3){
			
		}
	}
	
	/**
	 * 
	 * @return Returns "Cloak".
	 */
	public String GetEffectName() {
		return "Cloak";
	}
	
	/**
	 * 
	 * @return Returns the properties of this Cloak.
	 */
	@Override
	public String toString() {
		return GetEffectName();
	}

	@Override
	public void DecreaseEffectTime(Virologist v) {
		// TODO Auto-generated method stub
		
	}
}
