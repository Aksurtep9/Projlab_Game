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
			System.out.print("The menu is the following:\n  "
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
