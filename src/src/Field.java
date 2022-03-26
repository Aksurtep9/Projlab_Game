package src;
import java.util.List;

/**
 * <b>Field class</b><br>
 * Stores the things - virologists, agents, materials, equipments - which can be found here.<br>
 * Stores its neighbours.<br><br>
 * Its job is to store everyTHING that can be found or put here.<br>
 * Implements a special method - called Accept(Virologist v) - which acts different in other subclasses.
 * @author - Martin
 */
public class Field {
	
	/**A counter for the fields. Use this to differ one field from another field.*/
	private static int uniqueID = 0;
	
	/**The ID which being given to toString method.*/
	protected int ID;
	
	/**
	 * Constructor for the Field class.<br>
	 * Creates a unique ID for the instance.
	 */
	public Field() {
		this.ID = uniqueID;
		++uniqueID;
	}

	/**Stores the field neighbours.*/
	protected List<Field> neighbours;
	
	/**Stores the things - virologist, agenst, materials, equipments - that can be found on the field.*/
	protected List<Thing> things;
	
	/**
	 * Stores the given thing.
	 * @param t - the given thing that will be placed on the field
	 */
	public void Accept(Thing t) {
		this.things.add(t);
	}
	
	/**
	 * Stores the given virologist. <br> Acts different in other subclasses.
	 * @param v - the given virologist who wants to move to the field
	 */
	public void Accept(Virologist v) {
		this.things.add(v);
	}
	
	/**
	 * Gives back the things.
	 * @return the things that can be found on the field
	 */
	public List<Thing> GetThings(){
		
	}
	
	/**
	 * Gives back a selected neighbour that has been picked out.
	 * @return the chosen neigbhour
	 */
	public Field GetNeighbour() {
		
	}
	
	/**
	 * Gives all the neighbour back that has been picked out.
	 * @return the chosen neigbhour
	 */
	public List<Field> GetNeighbours() {
		return this.neighbours;
	}
	
	/**
	 * Removes the given thing from its store.
	 * @param t - the removable thing
	 */
	public void Remove(Thing t) {
		this.things.remove(t);
	}
	
	/**
	 * Gives the field's type back
	 * @return the type of the field
	 */
	@Override
	public String toString() {
		return "Field" + this.ID;
	}
}
