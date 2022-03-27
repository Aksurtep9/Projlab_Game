package src;
import java.util.List;
/**
 * AgentCollection
 * Stores Agents which the Virologist crafted, or the genetic Codes (also represented by Agent class) he has learnt.
 * @author csizm
 *
 */
public class AgentCollection {
/** heterogenous collection of the different child classes of Agent*/
	private List<Agent> agents;
	
	/**
	 * Adds the Agent given as argument to the collection.
	 * @param a the Agent we are adding to the collection
	 */
	public void Add(Agent a) {
		agents.add(a);
	}
	
	/**
	 * Returns all of the Agents, so the player can choose which one he wants to use.
	 */
	public List<Agent> ListAll() {
		return agents;
	}
	
	/**
	 * Returns how many Agents are in the collection
	 * @return the number of Agents
	 */
	public int GetSize() {
		return agents.size();
	}
	
	/**
	 * Decreases the expireTime of each of the Agents.
	 * @param v the Virologist, who is the owner of the collection
	 */
	public void DecreaseAgentTimeAColl(Virologist v) {
		
	}
	
	/**
	 * Removes the Agent given as parameter from the collection.
	 * @param a the agent which needs to be removed
	 */
	public void Remove(Agent a) {
		for(int i=0; i< agents.size(); i++) {
			if(agents.get(i)==a) {
				agents.remove(i);
				return;
			}
		}
	}
	
	/**
	 * removes every agent from the collection
	 */
	public void ClearAll() {
		agents.clear();
	}
	
	/**
	 * Checks whether a genetic code is part of the collection or not. If it is, the function returns true.
	 * @param s the name of the Agent we want to check
	 * @return true, if the agent given as parameter is found in the collection
	 */
	public boolean Contains(String s) {
		
		for(int i=0; i< agents.size(); i++) {
			if(agents.get(i).GetEffectName().equals(s))
				return true;
		}
		return false;
	}
}

