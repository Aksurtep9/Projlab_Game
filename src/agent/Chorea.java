package agent;
 

/**
* Chorea
* Agent
* Every parameter required for an agent
* This class represents the 'Chorea' agent and i's attributes
**/

public class Chorea 
{
	
	/**Stating how long the agent can be used*/
	private int expireTime;
	
	/**Stating how long the agent has an effect on the target*/
	private int effectTime;
	
	/**Stating how much aminoacid the agent requires to be crafted*/
	private int costAmino;
	
	/**Stating how much nukleoid the agent requires to be crafted*/
	private int costNucle;

	
	/**
	* This method has an effect on the Virologist it is applied, making him move to random fields for a sort period of turns
	* @param v - v is the Virologist, the agent is affecting
	**/
	public void Affect(Virologist v)
	{
		
	}
	
	/**
	* Gives back the name of the agent
	* @return name - the name of the agent(here it's "Chorea")
	**/
	public String GetEffectName()
	{
		
	}
	
	/**
	* Gives back all the attributes in string
	* @return a string stating the parameters of the class
	**/
	public String ToString()
	{
		
	}
}
