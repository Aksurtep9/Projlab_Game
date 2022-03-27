package src;
import java.util.List;
/**
 * EquipmentCollection
 * Stores the different Equipments a Virologist picks up in a heterogenous collection.
 * @author csizm
 *
 */
public class EquipmentCollection {
	/**the Equipments that the Virologist has */
	private List<Equipment> equipments;
	
	/**
	 * Adds a new Equipment to the collection.
	 * @param e the Equipment added
	 */
	public void Add(Equipment e) {
		equipments.add(e);
	}
	
	/**
	 * Returns how many items are in the collection.
	 * @return number of equipments
	 */
	public int GetSize() {
		return equipments.size();
	}
	
	/**
	 * Returns the list of all the equipment.
	 * @return list
	 */
	public void ListAll() {
		for(int i=0;i< equipments.size();i++) {
			System.out.println(equipments.get(i).ToString());
		}
	}
	
	/**
	 * Removes the equipment given as parameter from the collection.
	 * @param e the item we want to remove
	 */
	public void Remove(String e) {
		
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
		
		for(int i=0; i< equipments.size(); i++) {
			if(equipments.get(i).GetEffectName().equals(s))
				return true;
		}
		
		return false;
	}
	
	public List<Equipment> GetEquipments(){
		return equipments;
	}
}
