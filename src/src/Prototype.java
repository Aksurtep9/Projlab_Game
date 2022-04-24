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
	private static File wd;
	
	private static boolean logEnabled;
	static String logPath;
	static File logFile=new File(wd, logPath);
	
	private boolean start;
	
	/**
	 * Initializes the game and the commands.
	 */
	public void Initialize() {
		//TO-DO: Give the files' path!
		wd = new File(System.getProperty("user.dir"), "src/src");
		logEnabled = false;
		logFile = null;
		start = true;
		ags.add(new Chorea()); // 0th agent is Chorea.
		ags.add(new Protect());// 1st agent is Protect.
		eqs.add(new Gloves()); // 0th equip is Gloves
		eqs.add(new Gloves()); // 1st equip is Gloves.
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
		logger("The map has been generated.", logFile);
	}
	
	/**
	 * Adds the desired equipment to the chosen virologist's equipmentcollection.
	 * @param cmd - the command
	 */
	public void AddEq(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		int ViroNum=Integer.parseInt(cmd[2]);
		if(EqNum>eqs.size()||ViroNum>game.getPlayers().size())return;
		game.getPlayers().get(ViroNum-1).GetEquipmentCollection().Add(eqs.get(EqNum-1));
		game.getPlayers().get(ViroNum-1).GetEffectCollection().Add(eqs.get(EqNum-1), game.getPlayers().get(ViroNum-1));
		logger("Added "+eqs.get(EqNum-1).GetEffectName()+"to Virologist "+ViroNum,logFile);
	}
	
	/**
	 * Adds the desired agent to the chosen virologist's collection of crafted agents.
	 * @param cmd - the command
	 */
	public void AddAgCraft(String[] cmd) {
		int AgNum=Integer.parseInt(cmd[1]);
		int ViroNum=Integer.parseInt(cmd[2]);
		if(AgNum>ags.size()||ViroNum>game.getPlayers().size())return;
		game.getPlayers().get(ViroNum-1).GetCraftedACollection().Add(ags.get(AgNum-1));
		logger("Added "+ags.get(AgNum-1).GetEffectName()+"to Virologist "+ViroNum,logFile);
	}
	
	/**
	 * Sets the given material (either aminoacid or nucleotid) of the desired virologist to the given number.
	 * @param cmd - the command
	 */
	public void SetMat(String[] cmd) {
		int amount=Integer.parseInt(cmd[2]);
		int ViroNum=Integer.parseInt(cmd[3]);
		if(ViroNum>game.getPlayers().size())return;
		if(cmd[1].equals("a")) {
			if(game.getPlayers().get(ViroNum).GetMaterialCollection().GetAmino().GetAmount()+amount>game.getPlayers().get(ViroNum).GetMaxAmino())
				game.getPlayers().get(ViroNum).GetMaterialCollection().GetAmino().AddAmount(amount);
		} else {
			if(game.getPlayers().get(ViroNum).GetMaterialCollection().GetNucle().GetAmount()+amount>game.getPlayers().get(ViroNum-1).GetMaxNucle())
				game.getPlayers().get(ViroNum).GetMaterialCollection().GetNucle().AddAmount(amount);
		}
		
	}
	
	/**
	 * Makes the virologist, whose turn it is pick up an equipment from the field it's on.
	 * @param cmd - the command
	 */
	public void PickUp(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		
		game.getCurrentPlayer().PickUpEquipment(EqNum);
	}
	
	/**
	 * Makes the virologist, whose turn it is drop a selected piece of equipment.
	 * @param cmd - the command
	 */
	public void Drop(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		if(EqNum>game.getCurrentPlayer().GetEquipmentCollection().GetSize())return;
		logger("Dropped "+game.getCurrentPlayer().GetEquipmentCollection().GetEquipments().get(EqNum-1).toString(),logFile);
		game.getCurrentPlayer().DropEquipment(EqNum);
	}
	
	/**
	 * Makes the virologist, whose turn it is steal a piece of equipment from an other virologist.
	 * @param cmd - the command
	 */
	public void StealEq(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[2]);
		int ViroNum=Integer.parseInt(cmd[1]);
		
		game.getCurrentPlayer().StealEquipment(ViroNum,EqNum);
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
			logPath = cmd[2];
			logFile = new File(wd, logPath);
			if(start) {
				logFile.delete();
				start = false;
				logFile = new File(wd, logPath);
			}
			logEnabled = true;
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
	static void logger(String message, File logFile) {
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
	 * Sets the logFile output path.
	 * @param path - where the log should be saved.
	 * @return the reference to the file.
	 */
	public File GetLogFile() {
		return logFile;
	}
	
	/**
	 * Sets the program's randomness
	 * @param cmd - the command
	 */
	public void SetRandom(String[] cmd) {
		boolean randomEnabled = (cmd[1].contains("on")) ? true : false;
		game.setRandom(randomEnabled);
		if(randomEnabled)
			logger("Random is on.", logFile);
		else
			logger("Random is off.", logFile);
	}
	
	/**
	 * Calls a new round in the game.
	 * @param cmd - the command
	 */
	public void NewRound(String[] cmd) {
		game.NewRound();
		logger("Newround", logFile);
	}
	
	/**
	 * Put a Virologist on a Field
	 * @param cmd - the command
	 */
	public void PutViro(String[] cmd) {
		int ViroNum = Integer.parseInt(cmd[1]);
		int FieldNum = Integer.parseInt(cmd[2]);
		Virologist v = game.getPlayers().get(ViroNum);
		game.GetMap().GetFields().get(FieldNum).Accept(v);
	}
	
	/**
	 * Calls a new round in the game.
	 * @param cmd - the command
	 */
	public void PutEq(String[] cmd) {
		int EqNum=Integer.parseInt(cmd[1]);
		int FieldNum = Integer.parseInt(cmd[2]);
		Equipment e = eqs.get(EqNum);
		game.GetMap().GetFields().get(FieldNum).Accept(e);
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
	 * Anoint a virologist choosen by the player with the specified agent
	 * @param cmd - the command
	 */
	public void Move(String[] cmd) {
		int field =Integer.parseInt(cmd[1]);
		game.getCurrentPlayer().Move(field);
		logger("Virologist have been moved", logFile);
	}
	
	/**
	 * Anoint a virologist choosen by the player with the specified agent
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
		logger("Virologist stole material.", logFile);
	}
	
	public void Attack(String[] cmd) {
		int victim = Integer.parseInt(cmd[1]);
		game.getCurrentPlayer().Attack(victim);
		logger("Virologus used axe! Bear fainted.", logFile);
	}
	
	public void Ls(String[] cmd) {
		int ViroNum = Integer.parseInt(cmd[1]);
		Virologist viro = game.getPlayers().get(ViroNum);
		
		if(cmd[2].equals("pl")) {
			int index = 0;
			for(Thing t : viro.field.GetThings())
			{
				if(t.toString().contains("Virologist")) {
					index++;
					logger(index + ": Virologist:" + t.ID, logFile);
				}
			}
		}
		
		else if(cmd[2].equals("fi")) {
			logger("Current: "+ viro.field.toString(), logFile);
			int index = 0;
			for(Thing t : viro.field.GetThings())
			{
				logger(index + ": "+ t.toString(), logFile);
				index++;
			}
			System.out.println("----------------------------------------------------");
			for(Field f : viro.field.GetNeighbours()) {
				logger(index + ": " + f.toString(), logFile);
				index++;
			}
		}
		
		else if(cmd[2].equals("ge")) {
			logger("Learnt agents: ", logFile);
			int index = 0;
			for(Agent a : viro.GetGenCodeCollection().GetAgents()) {
				logger(index + ": " + a.toString(), logFile);
				index++;
			}
		}
		else if(cmd[2].equals("ag")) {
			logger("Crafted agents: ", logFile);
			int index = 0;
			for(Agent a : viro.GetCraftedACollection().GetAgents()) {
				logger(index + ": " + a.toString(), logFile);
			}
		}
		else if(cmd[2].equals("eq")) {
			logger("Owned equipments: ", logFile);
			int index = 0;
			for(Equipment e : viro.GetEquipmentCollection().GetEquipments()) {
				logger(index + ": " + e.toString(), logFile);
			}
		}
		
		else if(cmd[2].equals("ef")) {
			logger("Effects on the Virologist: ", logFile);
			logger(viro.GetEffectCollection().toString(), logFile);
		}
		else if(cmd[2].equals("ag")) {
			logger("Crafted agents: ", logFile);
			int index = 0;
			for(Agent a : viro.GetCraftedACollection().GetAgents()) {
				logger(index + ": " + a.toString(), logFile);
			}
		}
		
		else if(cmd[2].equals("ma")) {
			logger(viro.GetMaterialCollection().toString(), logFile);
		}
		
		else if(cmd[2].equals("vi")) {
			logger(viro.VirologistStat(), logFile);
		}
	}
	
	
	
}
