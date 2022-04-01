package src;

import java.util.Random;
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
	
	public Cloak() {
		this.useTime = 1;
	}
	
	/**
	 * 
	 * @param v The virologist, who is being affected by an effect.
	 */
	public void Affect(Virologist v) {
		System.out.println("Affect");
		double random = ThreadLocalRandom.current().nextDouble(0,100);
		if(random>82.3){
			
		}
	}
	
	/**
	 * Calculates the chance of protecting the Virologist against Touching and BearDance.
	 * @return Whether the Virologist can be interacted with.
	 */
	public boolean Chance() {
		Random rand = new Random();
		double chance = rand.nextDouble() * 100;
		return chance >= 82.3;
	}
	
	/**
	 * 
	 * @return Returns "Cloak".
	 */
	public String GetEffectName() {
		System.out.println("GetEffectName");
		return "Cloak";
	}
	
	/**
	 * 
	 * @return Returns the properties of this Cloak.
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

	@Override
	public int DecreaseUseTime() {
		//üres
		return 1;
	}
}
