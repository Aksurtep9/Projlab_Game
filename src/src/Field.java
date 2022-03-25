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

	/**Stores the field neighbours.*/
	private List<Field> neighbours;
	
	/**Stores the things - virologist, agenst, materials, equipments - that can be found on the field.*/
	private List<Thing> things;
	
	/**
	 * Stores the given thing.
	 * @param t - the given thing that will be placed on the field
	 */
	public void Accept(Thing t) {
		
	}
	
	/**
	 * Stores the given virologist. <br> Acts different in other subclasses.
	 * @param v - the given virologist who wants to move to the field
	 */
	@Override
	public void Accept(Virologist v) {
		
	}
	
	/**
	 * Gives back the things.
	 * @return the things that can be found on the field
	 */
	public List<Thing> GetThings(){
		
	}
	
	/**
	 * Gives back a selected neighbour that has been pick out.
	 * @return the chosen neigbhour
	 */
	public Field GetNeighbour() {
		
	}
	
	/**
	 * Removes the given thing from its store.
	 * @param t - the removable thing
	 */
	public void Remove(Thing t) {
		
	}
}
