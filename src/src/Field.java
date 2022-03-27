package src;
import java.util.ArrayList;

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
	
	/**The ID which is given to toString method.*/
	protected int ID;

	/**Stores the field neighbours.*/
	protected ArrayList<Field> neighbours;
	
	/**Stores the things - virologist, agenst, materials, equipments - that can be found on the field.*/
	protected ArrayList<Thing> things;
	
	/**
	 * Constructor for the Field class.<br>
	 * Creates a unique ID for the instance.
	 */
	public Field() {
		System.out.println("Field constructor");
		this.ID = uniqueID;
		++uniqueID;
		neighbours = new ArrayList<Field>();
		things = new ArrayList<Thing>();
	}
	
	/**
	 * Stores the given thing.
	 * @param t - the given thing that will be placed on the field
	 */
	public void Accept(Thing t) {
		System.out.println("Accept");
		this.things.add(t);
	}
	
	/**
	 * Stores the given virologist. <br> Acts different in other subclasses.
	 * @param v - the given virologist who wants to move to the field
	 */
	public void Accept(Virologist v) {
		System.out.println("Accept");
		this.things.add(v);
	}
	
	/**
	 * Gives back the things.
	 * @return the things that can be found on the field
	 */
	public ArrayList<Thing> GetThings(){
		System.out.println("GetThings");
		return things;
	}
	
	/**
	 * Gives back a selected neighbour that has been picked out.
	 * @return the chosen neigbhour
	 */
	public Field GetNeighbour() {
		System.out.println("GetNeighbour");
		return neighbours.get(0);
	}
	
	/**
	 * Gives all the neighbour back that has been picked out.
	 * @return the chosen neigbhour
	 */
	public ArrayList<Field> GetNeighbours() {
		System.out.println("GetNeighbours");
		return this.neighbours;
	}
	
	/**
	 * Removes the given thing from its store.
	 * @param t - the removable thing
	 */
	public void Remove(Thing t) {
		System.out.println("Remove");
		this.things.remove(t);
	}
	
	/**
	 * Adds a new Field to the list of the Field's neighbours.
	 * @param f the neighbour we want to add
	 */
	public void AddNeighbours(Field f) {
		System.out.println("AddNeighbours");
		neighbours.add(f);
	}
	/**
	 * Gives the field's type back
	 * @return the type of the field
	 */
	@Override
	public String toString() {
		System.out.println("toString");
		return "Field" + this.ID;
	}
}
