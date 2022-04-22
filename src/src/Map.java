package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
	public void GenerateFields(File _map) {
		
		if(!_map.exists())
			return;
			
		Scanner sc;
		try {
			sc = new Scanner(_map);
			
			int numberOfFields = Integer.parseInt(sc.nextLine());
			for(int i = 0; i<numberOfFields; ++i) {
				String whatField = sc.nextLine();
				if(whatField.contains("Field"))
					fields.add(new Field());
				else if(whatField.contains("Laboratory"))
					fields.add(new Laboratory());
				else if(whatField.contains("Shelter"))
					fields.add(new Shelter());
				else if(whatField.contains("Warehouse"))
					fields.add(new Warehouse());
			}
			
			String line;
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				String[] data = line.split("-");
				int indexA = Integer.parseInt(data[0]);
				int indexB = Integer.parseInt(data[1]);
				Field A = fields.get(indexA);
				Field B = fields.get(indexB);
				A.AddNeighbours(B);
				B.AddNeighbours(A);
				System.out.println(B.GetNeighbours());
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*System.out.println("GenerateFields");
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
		warehouse.CreateMaterials();*/
		
	}
}
