package src;

/**
* Thing
* Stores the field the thing is on
* Representing every thing(Player, Equipment, Agent and Material) in the game
**/
public abstract class Thing 
{
	/**The Field which the Thing is on*/
	Field field;
	
	/**
	* Gives back all the attributes in string
	* @return a string stating the parameters of the class
	**/
	@Override
	public String toString()
	{
		return "";
	}
}
