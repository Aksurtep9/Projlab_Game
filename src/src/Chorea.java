package src;


/**
* Chorea
* Inherited from Agent
* Stores the required amount of nucleotid and aminoacid to craft the agent in addition the time till this agent affect someone and it expires
* This class represents the 'Chorea' agent and it's attributes. Chorea is a type of vaccine the Virologist can use to make the target move uncontrollable to fields for sort period of turns.
**/

public class Chorea extends Agent
{
	
	/**Stating how long the agent can be used*/
	private int expireTime;
	
	/**Stating how long the agent has an effect on the target*/
	private int effectTime;
	
	/**Stating how much aminoacid the agent requires to be crafted*/
	private int costAmino;
	
	/**Stating how much nukleoid the agent requires to be crafted*/
	private int costNucle;

	public Chorea() {
		this.expireTime = 4;
		this.effectTime = 4;
		this.costAmino = 3;
		this.costNucle = 2;
	}
	
	/**
	* This method has an effect on the Virologist it is applied to, making him move to random fields for a sort period of turns
	* @param v - v is the Virologist, the agent is affecting
	**/
	public void Affect(Virologist v)
	{
		v.RandomField();
	}
	
	/**
	* Gives back the name of the agent
	* @return name - the name of the agent(here it's "Chorea")
	**/
	public String GetEffectName()
	{
		return "Chorea";
	}
	
	/**
	* Gives back all the attributes in string
	* @return a string stating the parameters of the class
	**/
	@Override
	public String toString()
	{
		return  GetEffectName() + " amino cost:" + costAmino +", nucleo cost:" + costNucle + ", expire time:" + expireTime + ", effect time:" + effectTime;
	}
}
