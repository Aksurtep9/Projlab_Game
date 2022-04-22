package src;
import java.io.File;
import java.util.Scanner;

/**
 * <b>The program's prototype class.</b><br><br>
 * Use this class to run the prototype.<br>
 * Contains the available commands so that the user and the program can interact with each other.
 * @author Martin
 */
public class Prototype {
	
	private static Scanner scan = new Scanner(System.in);
	static File wd;
	
	/**
	 * Initializes the game and the commands.
	 */
	public void Initialize() {
		//TO-DO: Give the files' path!
	}
	
	
	
	/**
	 * Constructor for the class.
	 */
	public Prototype() {
		Initialize();
	}
	
	
	
	/**
	 * Runs the game.
	 */
	public void Run() {
		System.out.println("Hi there!");
		String line = "";
		wd = new File(System.getProperty("user.dir"), "src/src");
		
		//Waiting for commands
		while(true) {
			if(!scan.hasNext()) break;
			else {
				line = scan.nextLine();
				String[] cmd = line.split(" ");
				String whatCommand = cmd[0];
				
				// the available commands
				if(whatCommand.equals("exit"))
					Exit(cmd);
				else if(whatCommand.equals("newgame"))
					NewGame(cmd);
				else if(whatCommand.equals("addEq"))
					AddEq(cmd);
				else if(whatCommand.equals("addEq"))
					AddEq(cmd);
				else if(whatCommand.equals("addAgCraft"))
					AddAgCraft(cmd);
				else if(whatCommand.equals("setMat"))
					AddEq(cmd);
				else if(whatCommand.equals("pickup"))
					AddEq(cmd);
				else if(whatCommand.equals("drop"))
					AddEq(cmd);
				else if(whatCommand.equals("stealeq"))
					AddEq(cmd);
			}
		}
	}
	
	
	//TO-DO: Each commands has a method
	//-----IDE-----
	
	/**
	 * Close the program.
	 * @param cmd - the command
	 */
	public void Exit(String[] cmd) {
		scan.close();
		System.exit(0);
	}
	
	/**
	 * Generates the map with 3 player.
	 * @param cmd - the command
	 */
	public void NewGame(String[] cmd) {
		//TO-DO: Legenerál egy pályát, 3 játékossal
		
		String mapPath = cmd[1];
		File mapFile = new File(wd, mapPath);
		System.out.println(mapFile);
		System.out.println(wd);
		if(mapFile.exists()) {
			//TO-DO: Generate here
			System.out.println("The file does exist!");
		}
		else
			System.err.println("The file does not exist!");
	}
	
	public void AddEq(String[] cmd) {
		
	}
	
	public void AddAgCraft(String[] cmd) {
		
	}
	
	public void SetMat(String[] cmd) {
		
		
	}
	
	public void PickUp(String[] cmd) {
	
	}
	
	public void Drop(String[] cmd) {
	
	}
}
