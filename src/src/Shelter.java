package src;
import java.util.List;

/**
 * <b>Shelter class</b><br>
 * <i>Inherites from Field.</i><br><br>
 * Stores equipments like gloves, cloak or sack.<br>
 * @author Martin
 */
public class Shelter extends Field {

	/**
	 * Constructor for the Laboratory
	 */
	public Shelter() {
		super();
	}
	
	/**Stores the shelter's equipments.*/
	private List<Equipment> equipments;
	
	/**
	 * Allocates and creates special equipments for the shelter's store.
	 */
	public void CreateEquipment() {
		
	}
	
	/**
	 * Stores the given virologist. <br>
	 * Asks the virologist to check the shelter's equipments.
	 * @param v - the given virologist who might pick up an equipment
	 */
	/*
	 * public void Accept(Virologist v) {
	 * 
	 * }
	 */
	
	/**
	 * Gives the field's type back
	 * @return the type of the field
	 */
	@Override
	public String toString() {
		return "Shelter" + ID;
	}
}
