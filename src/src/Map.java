package src;

import java.util.ArrayList;

/**
 * 
 * @author Vili
 * Map
 * It is responsible for drawing fields.
 *
 */
public class Map {
	
	/**
	 * Stores all the fields.
	 */
	ArrayList<Field> fields;
	
	/**
	 * Constructor for Map
	 */
	public Map() {
		
		fields = new ArrayList<Field>();
	}
	
	public ArrayList<Field> GetFields(){
		return fields;
	}
	/**
	 * It creates the fields for the game and sets their neighbours.
	 */
	public void GenerateFields(ArrayList<Virologist> players) {
		System.out.println("GenerateFields");
		Field hereWeAre = new Field();
		Warehouse warehouse = new Warehouse();
		Shelter shelter = new Shelter();
		Laboratory labor = new Laboratory();
		try {
			hereWeAre.Accept(players.get(0));
			//warehouse.Accept(players.get(1));
			//shelter.Accept(players.get(2));
		}
		catch(NullPointerException e) {
			System.out.println("Nincs kezdomezo!" + e);
		}
		
		hereWeAre.AddNeighbours(labor);
		hereWeAre.AddNeighbours(warehouse);
		hereWeAre.AddNeighbours(shelter);
		
		players.get(0).SetField(hereWeAre);
		players.get(1).SetField(labor);
		players.get(2).SetField(shelter);
		
		fields.add(players.get(0).GetField());
		fields.add(labor);
		fields.add(shelter);
		fields.add(warehouse);
		
		labor.CreateGenCode();
		shelter.CreateEquipment();
		warehouse.CreateMaterials();
		
	}
}
