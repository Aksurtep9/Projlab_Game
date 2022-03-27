package src;
import java.util.ArrayList;
import java.util.List;
/**
 * EffectCollection
 * Stores classes that implement the Effect interface, that are affecting the Virologist in the current round.
 * @author csizm
 *
 */
public class EffectCollection {
	
	/** Stores all of the Effects applied to the Virologist*/
	private List<Effect> effects;
	
	
	public EffectCollection() {
		System.out.println("EffectCollection");
		effects = new ArrayList<Effect>();
	}
	
	/**
	 * Adds a new Effect to the collection.
	 * @param craftedAgent the Effect
	 */
	public void Add(Effect e) {
		System.out.println("Add");
		effects.add(e);
//		e.Affect(viroPlayer1);
	}
	
	/**
	 * Removes the Effect given as parameter from the collection.
	 * @param e the Effect we need to remove
	 */
	public void Remove(Effect e) {
		System.out.println("Remove");
		for(int i=0; i< effects.size(); i++) {
			if(effects.get(i)==e) {
				effects.remove(i);
				return;
			}
		}
	}
	
	/**
	 * Checks whether the Effect given as parameter is in the collection or not.
	 * @param effectName - the name of the Effect we compare to the Effect names in the collection
	 * @return true, if the Effect is found
	 */
	public boolean Contains(String effectName) {
		System.out.println("Contains");
		for(int i = 0; i < effects.size(); i++) {
			if(effects.get(i).toString().contains(effectName)) return true; //If the toString of the Effect contains the effectname return true
		}
		return false;
	}
	
	/**
	 * Affects the Virologist (owner of the collection)with all of the Effects stored.
	 * @param v Virologist, it is given as parameter to the Affect methods
	 */
	void AffectWithAll(Virologist v) {
		System.out.println("AffectWithAll");
	}
	
	/**
	 * Decreases all of the Agent's EffectTime by one (by calling DecreaseEffectTime() methods).
	 * @param v Virologist, who has the EffectCollection, given as parameter to DecreaseEffectTime()
	 */
	void DecreaseAgentTimeEColl(Virologist v) {
		System.out.println("DecreaseAgentTimeEColl");
		for(int i=0;i< effects.size();i++) {
			this.effects.get(i).DecreaseEffectTime(v);			
			
		}
	}
	
	
}
