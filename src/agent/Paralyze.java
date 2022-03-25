package agent;
 

/**
* Paralyze
* Agent
* Every parameter required for an agent
* This class represents the 'Paralyze' agent and it's attributes
**/

public class Paralyze 
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
	* This method has an effect on the Virologist it is applied, making him unable to move for a short period of turns
	* @param v - v is the Virologist, the agent is affecting
	**/
	public void Affect(Virologist v)
	{
		
	}
	
	/**
	* Gives back the name of the agent
	* @return name - The name of the agent(here it's "Paralyze")
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
