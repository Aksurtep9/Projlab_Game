package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Vili
 * Map
 * It is responsible for drawing fields.
 */
public class Map implements Serializable{
	
	/**unique id*/
	private static final long serialVersionUID = 1111398592626854842L;

	/**
	 * Stores all the fields.
	 */
	private ArrayList<Field> fields;
	
	private File mapFile = new File(System.getProperty("user.dir"), "src/src/mapFile.txt");
	
	/**
	 * Constructor for Map
	 */
	public Map() {
		fields = new ArrayList<Field>();
		GenerateFields(mapFile);
		//GenerateFields(.getFile());
	}
	
	/**
	 * The list where the user can choose the number of players going to be playing the game
	 * @return the array of fields
	 */
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
				if(whatField.contains("Field")) {
					Field f = new Field();
					f.setId(i+1);
					fields.add(f);
				}
				else if(whatField.contains("Laboratory")) {
					Laboratory l = new Laboratory();
					l.setId(i+1);
					fields.add(l);
				}
				else if(whatField.contains("Shelter")) {
					Shelter s = new Shelter();
					s.setId(i+1);
					fields.add(s);
				}
				else if(whatField.contains("Warehouse")) {
					Warehouse w = new Warehouse();
					w.setId(i+1);
					fields.add(w);
				}
					
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
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
