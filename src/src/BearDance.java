package src;


/**
 * BearDance
 * Thing- base class
 * Implements Effect interface.
 * This class represents the bear dance virus.
 * @author erdei
 */
public class BearDance extends Agent {
	
	/**unique id*/
	private static final long serialVersionUID = -7301741576013918512L;

	/**
	 * Constructor of BearDance.
	 */
	public BearDance() {
		
	}
	
	/**
	 * Responsible of the bear dance to have an effect on the virologist.
	 * @param virologist - the virologist who is a bear
	 */
	@Override
	public void Affect(Virologist v) {
		v.RandomField();
		
	}
	
	/**
	 * Return the Effects name.
	 * @return string "BearDance
	 */
	@Override
	public String GetEffectName() {
		return "BearDance";
	}
	
	/**
	 * Decreases the attribute effectTime by one. This function is called in each round. If the remaining time is 0, it removes the Agent from EffectCollection.
	 * @param v Virologist that the effect of the agent has been applied to
	 */
	public void DecreaseEffectTime(Virologist v) {
		effectTime--;
		if(effectTime == 0) {
			v.RemoveAgentFromAgentColl(this);
		}
		
	}

}
