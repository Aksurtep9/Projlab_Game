package src;
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
		effects = new ArrayList<Effect>();
	}
	
	/**
	 * Adds a new Effect to the collection.
	 * @param craftedAgent the Effect
	 */
	public void Add(Effect e) {
		e.Affect(viroPlayer1);
	}
	
	/**
	 * Removes the Effect given as parameter from the collection.
	 * @param e the Effect we need to remove
	 */
	public void Remove(Effect e) {
		
	}
	
	/**
	 * Checks whether the Effect given as parameter is in the collection or not.
	 * @param e the Effect we compare to the Effects of the collection
	 * @return true, if the Effect is found
	 */
	public boolean Contains(Effect e) {
		
	}
	
	/**
	 * Affects the Virologist (owner of the collection)with all of the Effects stored.
	 * @param v Virologist, it is given as parameter to the Affect methods
	 */
	void AffectWithAll(Virologist v) {
		
	}
	
	/**
	 * Decreases all of the Agent's EffectTime by one (by calling DecreaseEffectTime() methods).
	 * @param v Virologist, who has the EffectCollection, given as parameter to DecreaseEffectTime()
	 */
	void DecreaseAgentTimeEColl(Virologist v) {
		
	}
	
	
}
