package src;

/**
 * <b>Effect class</b><br>
 * This class is implemented in Agent and Equipment classes so that can behave like an effect.<br>
 * Interacts with the virologist.
 * @author - Martin
 */
public interface Effect {
	
	/**
	 * Affects the given virologist.
	 * @param v - the affected virologist
	 */
	@Override
	public void Affect(Virologist v);
	
	/**
	 * Gives back the effect's name.
	 * @return the effect's name.
	 */
	@Override
	public String GetEffectName();
	
	/**
	 * Reduces the effect's effect time - which considered to be agent.
	 * @param v - the virologist whom agents' effect time gets reduced
	 */
	@Override
	public void DecreaseEffectTime(Virologist v);
}
