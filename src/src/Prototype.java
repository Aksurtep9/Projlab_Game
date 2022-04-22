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
	private Game game;
	
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
				else if(whatCommand.equals("addAgCraft"))
					AddAgCraft(cmd);
				else if(whatCommand.equals("setMat"))
					SetMat(cmd);
				else if(whatCommand.equals("pickup"))
					PickUp(cmd);
				else if(whatCommand.equals("drop"))
					Drop(cmd);
				else if(whatCommand.equals("stealeq"))
					StealEq(cmd);
				else if(whatCommand.equals("save"))
					SaveGame(cmd);
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
		game = new Game(3);
		
		String mapPath = cmd[1];
		File mapFile = new File(wd, mapPath);
		game.GetMap().GenerateFields(mapFile);
	}
	
	public void AddEq(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		int ViroNum=Integer.parseInt(cmd[2]);
		
	}
	
	public void AddAgCraft(String[] cmd) {
		int AgNum=Integer.parseInt(cmd[1]);
		int ViroNum=Integer.parseInt(cmd[2]);
	}
	
	public void SetMat(String[] cmd) {
		boolean isAmino;
		if(cmd[1].equals("a")) {
			isAmino=true;
		} else {
			isAmino=false;
		}
		int amount=Integer.parseInt(cmd[2]);
		int ViroNum=Integer.parseInt(cmd[3]);
	}
	
	public void PickUp(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
	}
	
	public void Drop(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
	}
	
	public void StealEq(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[2]);
		int ViroNum=Integer.parseInt(cmd[1]);
	}
	
	/**
	 * Saves the current game.
	 * @param cmd - the command
	 */
	public void SaveGame(String[] cmd) {
		
	}
}
