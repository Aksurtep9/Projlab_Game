package src;


/**
* Chorea
* Inherited from Agent
* Stores the required amount of nucleotid and aminoacid to craft the agent in addition the time till this agent affect someone and it expires
* This class represents the 'Chorea' agent and it's attributes. Chorea is a type of vaccine the Virologist can use to make the target move uncontrollable to fields for sort period of turns.
**/

public class Chorea extends Agent
{

	public Chorea() {
		System.out.println("Chorea");
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
		System.out.println("Affect");
		v.RandomField();
	}
	
	/**
	* Gives back the name of the agent
	* @return name - the name of the agent(here it's "Chorea")
	**/
	public String GetEffectName()
	{
		System.out.println("GetEffectName");
		return "Chorea";
	}
	
	/**
	* Gives back all the attributes in string
	* @return a string stating the parameters of the class
	**/
	@Override
	public String toString()
	{
		System.out.println("toString");
		return  GetEffectName() + " amino cost:" + costAmino +", nucleo cost:" + costNucle + ", expire time:" + expireTime + ", effect time:" + effectTime;
	}
}
