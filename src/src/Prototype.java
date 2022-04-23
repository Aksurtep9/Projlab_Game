package src;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * <b>The program's prototype class.</b><br><br>
 * Use this class to run the prototype.<br>
 * Contains the available commands so that the user and the program can interact with each other.
 * @author Martin
 */
public class Prototype {
	
	private static Scanner scan = new Scanner(System.in);
	
	private Game game;
	private ArrayList<Equipment> eqs=new ArrayList<Equipment>();
	private ArrayList<Agent> ags=new ArrayList<Agent>();
	static File wd;
	
	boolean logEnabled;
	File logFile;
	
	boolean start;
	
	/**
	 * Initializes the game and the commands.
	 */
	public void Initialize() {
		//TO-DO: Give the files' path!
		wd = new File(System.getProperty("user.dir"), "src/src");
		logEnabled = false;
		logFile = null;
		start = true;
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
				else if(whatCommand.equals("load"))
					LoadGame(cmd);
				else if(whatCommand.equals("log"))
					Log(cmd);
				else if(whatCommand.equals("setrandom"))
					SetRandom(cmd);
				else if(whatCommand.equals("newround"))
					NewRound(cmd);
				else if(whatCommand.equals("move"))
					Move(cmd);
				else if(whatCommand.equals("anoint"))
					Anoint(cmd);
				else if(whatCommand.equals("craft"))
					Craft(cmd);
				else if(whatCommand.equals("putViro"))
					PutViro(cmd);
				else if(whatCommand.equals("putEq"))
					PutEq(cmd);
				else if(whatCommand.equals("putAg"))
					PutAg(cmd);
				else if(whatCommand.equals("addAgEff"))
					AddAgEff(cmd);
				else if(whatCommand.equals("ls"))
					Ls(cmd);
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
		logger("Game has been set.", logFile);
	}
	
	public void AddEq(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		int ViroNum=Integer.parseInt(cmd[2]);
		game.getPlayers().get(ViroNum-1).GetEquipmentCollection().Add(eqs.get(EqNum-1));
		game.getPlayers().get(ViroNum-1).GetEffectCollection().Add(eqs.get(EqNum-1), game.getPlayers().get(ViroNum-1));
	}
	
	public void AddAgCraft(String[] cmd) {
		int AgNum=Integer.parseInt(cmd[1]);
		int ViroNum=Integer.parseInt(cmd[2]);
		game.getPlayers().get(ViroNum-1).GetCraftedACollection().Add(ags.get(AgNum-1));
	}
	
	public void SetMat(String[] cmd) {
		int amount=Integer.parseInt(cmd[2]);
		int ViroNum=Integer.parseInt(cmd[3]);
		if(cmd[1].equals("a")) {
			game.getPlayers().get(ViroNum-1).GetMaterialCollection().GetAmino().AddAmount(amount);
		} else {
			game.getPlayers().get(ViroNum-1).GetMaterialCollection().GetNucle().AddAmount(amount);
		}
		
	}
	
	public void PickUp(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		game.getCurrentPlayer().PickUpEquipment();
	}
	
	public void Drop(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		game.getCurrentPlayer().DropEquipment();
	}
	
	public void StealEq(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[2]);
		int ViroNum=Integer.parseInt(cmd[1]);
		game.getCurrentPlayer().StealEquipment(game.getPlayers().get(ViroNum-1));
	}
	
	/**
	 * Saves the current game.
	 * @param cmd - the command
	 */
	public void SaveGame(String[] cmd) {
		String saveGame = cmd[1];
		File saveHere = new File(wd, saveGame);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveHere));
			out.writeObject(game);
			out.close();
			logger("The game has been saved.", logFile);
		} catch (IOException e) {
			
		}
	}
	
	
	/**
	 * Loads the current game.
	 * @param cmd - the command
	 */
	public void LoadGame(String[] cmd) {
		String savedGame = cmd[1];
		File loadHere = new File(wd, savedGame);
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(loadHere));
			game = (Game)in.readObject();
			in.close();
			logger("The game has been loaded.", logFile);
		} catch (FileNotFoundException e) {
			logger("No such file.", logFile);
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
	}
	
	
	/**
	 * Logs
	 * @param cmd - the command
	 */
	public void Log(String[] cmd) {
		boolean enabled = (cmd[1].contains("on")) ? true : false;
		if(enabled && logFile == null) {
			String logPath = cmd[2];
			logFile = new File(wd, logPath);
			if(start) {
				logFile.delete();
				start = false;
				logFile = new File(wd, logPath);
			}
			logEnabled = true;
			logger("Logging is on.", logFile);
		}else {
			logFile = null;
			logEnabled = false;
		}
		
	}
	
	/**
	 * Logs depending on the parameters.
	 * @param message - the message that needs to logged.
	 * @param logFile - the file where the log is saved.
	 */
	private void logger(String message, File logFile) {
		if(logEnabled) {
			try {
				FileWriter fw = new FileWriter(logFile, true);
				BufferedWriter br = new BufferedWriter(fw);
				br.write(message + "\n");
				br.close();
				fw.close();
			} catch (IOException e) {
			}
		}
		else
			System.out.println(message);
	}
	
	/**
	 * Sets the program's randomness
	 * @param cmd - the command
	 */
	public void SetRandom(String[] cmd) {
		boolean randomEnabled = (cmd[1].contains("on")) ? true : false;
		game.setRandom(randomEnabled);
	}
	
	/**
	 * Calls a new round in the game.
	 * @param cmd - the command
	 */
	public void NewRound(String[] cmd) {
		game.NewRound();
	}
	
	/**
	 * Put a Virologist on a Field
	 * @param cmd - the command
	 */
	public void PutViro(String[] cmd) {
		int ViroNum=Integer.parseInt(cmd[1]);
		int FieldNum = Integer.parseInt(cmd[2]);
		Virologist v = game.getPlayers().get(ViroNum-1);
		game.GetMap().fields.get(FieldNum-1).Accept(v);
	}
	
	/**
	 * Calls a new round in the game.
	 * @param cmd - the command
	 */
	public void PutEq(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		int FieldNum = Integer.parseInt(cmd[2]);
		Equipment e = eqs.get(EqNum-1);
		game.GetMap().fields.get(FieldNum-1).Accept(e);
	}
	
	/**
	 * Puts an Agent on a Lab
	 * @param cmd - the command
	 */
	public void PutAg(String[] cmd) {
		int AgNum=Integer.parseInt(cmd[1]);
		int LabNum = Integer.parseInt(cmd[2]);
		Field f = game.GetMap().GetFields().get(LabNum-1);
		if(f.toString().contains("Laboratory")) {
			Laboratory l = (Laboratory)f;
			l.SetGenCode(ags.get(AgNum-1));
		}
	}
	
	/**
	 * Adds an Agent effect to the Virologist
	 * @param cmd - the command
	 */
	public void AddAgEff(String[] cmd) {
		int AgNum=Integer.parseInt(cmd[1]);
		int ViroNum=Integer.parseInt(cmd[2]);
		
		Virologist v = game.getPlayers().get(ViroNum-1);
		
		v.GetEffectCollection().Add(ags.get(AgNum-1), v);
	}
	
	/**
	 * Anoint a virologist cshoosen by the player with the specified agent
	 * @param cmd - the command
	 */
	public void Move(String[] cmd) {
		int field =Integer.parseInt(cmd[1]);
		game.getCurrentPlayer().Move(field);
		logger("Virologist have been moved", logFile);
	}
	
	/**
	 * Anoint a virologist cshoosen by the player with the specified agent
	 * @param cmd - the command
	 */
	public void Anoint(String[] cmd) {
		int victim = Integer.parseInt(cmd[1]);
		int agent = Integer.parseInt(cmd[2]);
		game.getCurrentPlayer().Anoint(victim, agent);
		logger("Virologist used agents. It's very effective", logFile);
	}
	
	public void Craft(String[] cmd) {
		int craft = Integer.parseInt(cmd[1]);
		if(game.getCurrentPlayer().GetGenCodeCollection().GetAgents().isEmpty())
			return;
		game.getCurrentPlayer().Craft(craft);
		logger("Virologist crafted agent.", logFile);
	}
	
	public void StealMat(String[] cmd){
		int victim = Integer.parseInt(cmd[1]);
		game.getCurrentPlayer().StealMaterial(victim);
	}
	
	
	public void Ls(String[] cmd) {
		int ViroNum = Integer.parseInt(cmd[1]);
		Virologist viro = game.getPlayers().get(ViroNum-1);
		
		if(cmd[2].equals("pl")) {
			int index = 0;
			for(Thing t : viro.field.GetThings())
			{
				if(t.toString().contains("Virologist")) {
					index++;
					System.out.println(index + ": Virologist:" + t.ID);
				}
			}
		}
		
		else if(cmd[2].equals("fi")) {
			System.out.println("Current: "+ viro.field.toString());
			int index = 0;
			for(Thing t : viro.field.GetThings())
			{
				System.out.println(index + ": "+ t.toString());
				index++;
			}
			System.out.println("----------------------------------------------------");
			for(Field f : viro.field.GetNeighbours()) {
				System.out.println(index + ": " + f.toString());
				index++;
			}
		}
		
		else if(cmd[2].equals("ge")) {
			System.out.println("Learnt agents: ");
			int index = 0;
			for(Agent a : viro.GetGenCodeCollection().GetAgents()) {
				System.out.println(index + ": " + a.toString());
				index++;
			}
		}
		else if(cmd[2].equals("ag")) {
			System.out.println("Crafted agents: ");
			int index = 0;
			for(Agent a : viro.GetCraftedACollection().GetAgents()) {
				System.out.println(index + ": " + a.toString());
			}
		}
		else if(cmd[2].equals("eq")) {
			System.out.println("Owned equipments: ");
			int index = 0;
			for(Equipment e : viro.GetEquipmentCollection().GetEquipments()) {
				System.out.println(index + ": " + e.toString());
			}
		}
		
		else if(cmd[2].equals("ef")) {
			System.out.println("Effects on the Virologist: ");
			System.out.println(viro.GetEffectCollection().toString());
		}
		else if(cmd[2].equals("ag")) {
			System.out.println("Crafted agents: ");
			int index = 0;
			for(Agent a : viro.GetCraftedACollection().GetAgents()) {
				System.out.println(index + ": " + a.toString());
			}
		}
		
		else if(cmd[2].equals("ma")) {
			System.out.println(viro.GetMaterialCollection().toString());
		}
		
		else if(cmd[2].equals("vi")) {
			System.out.println(viro.VirologistStat());
		}
	}
	
	
	
}
