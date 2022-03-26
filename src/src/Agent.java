package src;
/**
 * Agent
 * Thing- base class
 * Implements Effect interface.
 * This class represents the basic attributes of Agents (such as Chorea, Protect, etc.).
 * @author csizm
 *
 */
public abstract class Agent 
{
	/**The number of remaining rounds, before the agent expires.	 */
	protected int expireTime;
	
	/**The number of remaining rounds, before the effect of the agent is deleted */
	protected int effectTime;
	
	/**how much aminoacid is required to craft the agent*/
	protected int costAmino;
	
	/**how much nucleotid is required to craft the agent*/
	protected int costNucle;
	
	/**
	 * An abstract method which the child classes redefine to apply an effect on a virologist.
	 * @param v Virologist the agent is affecting
	 */
	public abstract void Affect(Virologist v);
	
	/**
	 * Returns the name of the Agent.
	 * @return name of the Agent (e.g. Chorea)
	 */
	public abstract String GetEffectName();
	
	/**
	 * Lists all the attributes of the agent in a string.
	 */
	@Override
	public String toString() {
		
	}
	
	/**
	 * Decreases the attribute expireTime by one. This function is called in each round. If the remaining time is 0, it removes the Agent from AgentCollection.
	 * @param v Virologist that has the crafted agent
	 */
	public void DecreaseExpireTime(Virologist v) {
		
	}
	
	/**
	 * Decreases the attribute effectTime by one. This function is called in each round. If the remaining time is 0, it removes the Agent from EffectCollection.
	 * @param v Virologist that the effect of the agent has been applied to
	 */
	public void DecreaseEffectTime(Virologist v) {
		expireTime--;
		if(expireTime == 0) {
			
			v.RemoveAgentFromAgentColl(this);
		}
		
	}
	
	/**
	 * Returns how much aminoacid is needed to craft the agent.
	 * @return the amount of aminoacid required
	 */
	public int GetCostAmino() {
		
	}
	
	/**
	 * Returns how much nucleotid is needed to craft the agent.
	 * @return the amount of nucleotid required
	 */
	public int GetCostNucle() {
		
	}
	
	/**
	 * Returns how many rounds need to pass before the agent expires.
	 * @return the number of rounds
	 */
	public int GetExpireTime() {
		
	}
	
	/**
	 * Deletes the agent.
	 */
	public void Delete() {
		
	}
}
