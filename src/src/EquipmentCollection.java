package src;
import java.util.ArrayList;
/**
 * EquipmentCollection
 * Stores the different Equipments a Virologist picks up in a heterogenous collection.
 * @author csizm
 *
 */
public class EquipmentCollection {
	/**the Equipments that the Virologist has */
	private ArrayList<Equipment> equipments;
	
	public EquipmentCollection() {
		equipments = new ArrayList<Equipment>();
	}
	
	/**
	 * Adds a new Equipment to the collection.
	 * @param e the Equipment added
	 */
	public void Add(Equipment e) {
		System.out.println("Add");
		equipments.add(e);
	}
	
	/**
	 * Returns how many items are in the collection.
	 * @return number of equipments
	 */
	public int GetSize() {
		System.out.println("GetSize");
		return equipments.size();
	}
	
	/**
	 * Returns the list of all the equipment.
	 * @return list
	 */
	public void ListAll() {
		System.out.println("ListAll");
		for(int i=0;i< equipments.size();i++) {
			System.out.println(equipments.get(i).ToString());
		}
	}
	
	/**
	 * Removes the equipment given as parameter from the collection.
	 * @param e the name of the item we want to remove
	 */
	public void Remove(String e) {
		System.out.println("Remove");
		for(int i=0; i< equipments.size(); i++) {
			if(equipments.get(i).equals(e)) {
				equipments.remove(i);
				return;
			}
		}
		
	}
	
	/**
	 * Checks whether the given Equipment is part of the Collection.
	 * @param e the Equipment we are checking
	 * @return true, if the equipment was found in the collection
	 */
	public boolean Contains(String s) {
		System.out.println("Contains");
		for(int i=0; i< equipments.size(); i++) {
			if(equipments.get(i).GetEffectName().equals(s))
				return true;
		}
		
		return false;
	}
	
	public ArrayList<Equipment> GetEquipments(){
		System.out.println("GetEquipments");
		return equipments;
	}
}
