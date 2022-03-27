package src;

import java.util.List;
import java.util.Scanner;

/**
 * <b>Skeleton class</b><br><br>
 * Use this class to interact with the user.<br>
 * Prints out the menu.
 * @author Martin
 */
public class Skeleton {

	//Instances
	private Game game;
	private Field moveHere;
	private Field hereWeAre;
	private Virologist viroPlayer1;
	private Virologist viroPlayer2;
	
	/**
	 * Constructor for the test program.
	 */
	public Skeleton() {
		System.out.print("Welcome to the skeleton program!\n");
	}
	
	/**
	 * Initializes all the declared instance for this test program
	 */
	public void Initialize() {
		game = new Game(3);
		moveHere = new Field();
		hereWeAre = new Field();
		viroPlayer1 = game.getPlayers().get(0);
		viroPlayer2=game.getPlayers().get(1);
		viroPlayer1.SetField(hereWeAre);
	}
	
	public void AddCloak() {
		EquipmentCollection eq= viroPlayer1.GetEquipmentCollection();
		EffectCollection ef=viroPlayer1.GetEffectCollection();
		Cloak clk=new Cloak();
		eq.Add(clk);
		ef.Add(clk);		
	}
	
	public void Chorea() {
		Agent chorea = new Chorea();
		viroPlayer1.effectCollection.Add((Effect)chorea);
	}
	
	public void Sack() {
		Equipment sack = new Sack();
		EquipmentCollection ec = new EquipmentCollection();
		ec.Add(sack);
	}
	
	public void StealMaterial() {
		viroPlayer1.Touch(viroPlayer2);
	}
	
	public static Agent ProtectConstr() {
		Agent pr = new Protect();
		return pr;
	}
	/**
	 * Runs the skeleton class with its menu system.<br>
	 * Test program.
	 */
	public void Run() {
		
		do {
			Menu.PrintMainMenu();
			int menuItem = Interaction.MenuNumber(0, 15);
			
			switch(menuItem) {
			case 0: System.exit(0); break;
			case 1: game.NewGame(); break;
			case 2: viroPlayer1.Move(); break;
			case 3: viroPlayer1.Move(); break; //But only to laboratory
			case 4: viroPlayer1.Move(); break; //But only to warehouse
			case 5: viroPlayer1.Move(); break; //But only to shelter
			case 6:  break;
			case 7:  break;
			case 8:  break;
			case 9: 
				Menu.PrintSubMenu();
				int menuSubItem = Interaction.MenuNumber(0, 3);
				switch(menuSubItem) {
				case 0: /*do nothing*/ break;
				case 1:  break;
				case 2: viroPlayer1.StealEquipment(viroPlayer2); break;
				case 3: StealMaterial(); break;
				}
				break;
			case 10: Chorea(); break;
			case 11:  break;
			case 12: Sack(); break;
			case 13: AddCloak(); break;

			case 14:  break;
			case 15: Game.EndGame(); break;
			}
			
		}while(true);
		
	}
	
	/**
	 * <b>Menu class</b><br>
	 * Prints out the menu system so that the user can communicate with the program.
	 * @author Martin
	 */
	public static class Menu{
		
		/**
		 * Prints out the menu.
		 */
		public static void PrintMainMenu() {
			System.out.print("The menu is the following:\n"
					+ "0"+"\t"+":Kilepes"+"\n"
					+ "1"+"\t"+":Jatek inditasa"+"\n"
					+ "2"+"\t"+":Lepes mezore"+"\n"
					+ "3"+"\t"+":Lepes laborra"+"\n"
					+ "4"+"\t"+":Lepes raktarra"+"\n"
					+ "5"+"\t"+":Lepes ovohelyre"+"\n"
					+ "6"+"\t"+":Barkacsol"+"\n"
					+ "7"+"\t"+":Felvesz"+"\n"
					+ "8"+"\t"+":Eldob"+"\n"
					+ "9"+"\t"+":Interakcio mas virologussal"+"\n"
					+ "10"+"\t"+":Vitustanc"+"\n"
					+ "11"+"\t"+":Amnezia"+"\n"
					+ "12"+"\t"+":Zsak"+"\n"
					+ "13"+"\t"+":Kopeny"+"\n"
					+ "14"+"\t"+":Uj kor"+"\n"
					+ "15"+"\t"+":Jatek vege"+"\n");
		}
		
		public static void PrintSubMenu() {
			System.out.print("A menu az alabbi:\n  "
					+ "0"+"\t"+":Megsem interaktalok"+"\n"
					+ "1"+"\t"+":Virologus agenst hasznal"+"\n"
					+ "2"+"\t"+":Felszereles rablas"+"\n"
					+ "3"+"\t"+":Anyag rablas"+"\n");
		}
	}
	
	/**
	 * <b>Interaction class</b><br>
	 * Communicate with the user.<br>
	 * Here you can ask a number from the user.<br>
	 * Here you can print a list out to the user.
	 * @author Martin
	 */
	public static class Interaction{
		
		/**
		 * Asks the user which menu item is being chosen.
		 * @param min - the start index of the menu
		 * @param max - the index of the last menu item
		 * @return the menu item which the user chose.
		 */
		public static int MenuNumber(int min, int max) {
			int chosenItem = 0;
			System.out.print("Kerlek valassz egy menupontot: ");
			Scanner scan = new Scanner(System.in);
			
			do {
				if(scan.hasNextInt())
					chosenItem = scan.nextInt();
			}while(chosenItem<min || chosenItem>max);
			
			scan.close();
			return chosenItem;
		}
		
		/**
		 * Prints out the given list.
		 * @param <T> - the type of the list items
		 * @param listItem - the things which are being printed out to the user
		 */
		public static <T> void PrintList(List<T> listItem){
			System.out.print("A kovetkezo dolgok talalhatoak itt.\n");
			System.out.print("0\t:Megsem\n");
			for(int i = 0; i<listItem.size(); ++i)
				System.out.print((i+1) + "\t:" + listItem.get(i).toString() + "\n");
		}
		
		/**
		 * Asks the user which list item is being chosen.
		 * @param max - the size of the list
		 * @return the index of the list item
		 */
		public static int ListItemNumber(int max) {
			int chosenItem = 0;
			Scanner scan = new Scanner(System.in);
			do {
				if(scan.hasNextInt())
					chosenItem = scan.nextInt();
			}while(chosenItem<0 || chosenItem>max);
			scan.close();
			return chosenItem;
		}
	}
	
}
