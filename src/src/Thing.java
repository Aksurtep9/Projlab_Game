package src;

/**
* Thing
* Stores the field the thing is on
* Representing every thing(Player, Equipment, Agent and Material) in the game
**/
public abstract class Thing 
{
	/**The Field which the Thing is on*/
	protected Field field;
	
	/**
	 * Puts the thing on the given field.
	 * @param pField - the field which the thing should be on.
	 */
	public void SetField(Field pField) { field = pField; }
	
	/**
	 * Gives the thing's current field back.
	 * @return the field which the thing is on
	 */
	public Field GetField() { return field; }
	
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
