package src;
import java.util.List;
import java.util.Random;

/**
 * <b>Shelter class</b><br>
 * <i>Inherits from Field.</i><br><br>
 * Stores equipments like gloves, cloak or sack.<br>
 * @author Martin
 */
public class Shelter extends Field {
	
	/**Stores the shelter's equipments.*/
	private List<Equipment> equipments;
	
	
	/**
	 * Constructor for the Laboratory
	 */
	public Shelter() {
		super();
		
		if(Game.isRandom()) {
			Random rand = new Random();
			int equipRandom = rand.nextInt(3);
			switch(equipRandom) {
				case 0: equipments.add(new Axe()); break;
				case 1: equipments.add(new Cloak()); break;
				case 2: equipments.add(new Gloves()); break;
				case 3: equipments.add(new Sack()); break;
			}
		}else {
			equipments.add(new Gloves());
		}
	}
	
	/**
	 * Allocates and creates special equipments for the shelter's store.
	 */
	public void CreateEquipment() {
		System.out.println("CreateEquipment");
		
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
		System.out.println("toString");
		return "Shelter";
	}
}
