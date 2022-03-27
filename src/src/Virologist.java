package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


/**
* Virologist class
* Inherited from Thing
* Attributes:
* equipmentCollection
* effectCollection
* craftedAgentCollection
* genCodeCollection
* materialCollection
* 
* Each player has its own Virologist instance that they control during the game. 
**/
public class Virologist extends Thing {
	
	/**If the Virologist picks up an Equipment it gets into the equipmentCollection.*/
	EquipmentCollection equipmentCollection;
	
	/**If the Virologist picks up an Equipment or gets an Agents Effect it gets into the effectCollection*/
	EffectCollection effectCollection;
	
	/**If the Virologist crafts an Agent it gets into the craftedAgentCollection*/
	AgentCollection craftedAgentCollection;
	
	/**If the Virologist learns a genCode in a Laboratory it gets into the genCodeCollection*/
	AgentCollection genCodeCollection;
	
	/**The Materials owned by the Virologist are in the materialCollection*/
	MaterialCollection materialCollection;
	
	/**
	* The method stores the genCode in the parameter.
	* @param genCode - The Agent that will be stored.
	**/
	public void CloneGenCode(Agent genCode) {
		
		//Checks if the virologist already has this genCode
		boolean contains = false;
		if(this.genCodeCollection.Contains(genCode)) contains = true;
		
		//If the genCode is new
		if(!contains) {
			this.genCodeCollection.Add(genCode);
			Game.CheckWin();
			
			boolean gameOver = false;
			//If the virologist won
			if(gameOver) {
				Game.EndGame();
			}
		}
	}
	
	/**
	* Shows the available Fields to the Player -> Moves the Virologist.
	**/
	public void Move() {
		List<Field> neighbours = this.field.GetNeighbours();
		
		//Asks the user which neighbour is needed.
		Skeleton.Interaction.PrintList(neighbours);
		int index = Skeleton.Interaction.ListItemNumber(neighbours.size());
		
		//If the user chose the 0: Maradok
		if(index == 0)
			System.out.print("Maradok");
		else {
			Field selected = neighbours.get(0);
			if(selected != null && selected != this.field) {
				
				this.field.Remove(this);
				selected.Accept(this);
			}
		}
	}
	
	/**
	* Shows the available Fields to the Player -> Moves the Virologist.
	**/
	public void MoveTo(Field whereToMove) {
		field.Remove(this);
		whereToMove.Accept(this);
	}
	
	/**
	* Starts the interraction with the Virologist in the parameter (calls Touch() method)
	* @param v - A Virologist on our Field
	**/
	public void Encounter(Virologist v) {
		
	}
	
	/**
	* If the Virologist in the parameter is touchable, shows the iterraction menu to the Player
	* @param v - A Virologist on our Field
	**/
	public void Touch(Virologist v) {
		StealMaterial(v);
	}
	
	/**
	* The method adds the Agent (from our craftedAgentCollection) in the parameters to the victims EffectCollection
	* @param a - An Agent from the craftedAgentCollection
	* @param victom - the choosen Virologist we wish to anoint
	**/
	public void Anoint(Agent a, Virologist victim) {
		
		System.out.println("The following vaccines are known to you:");
		/**Stores all crafted vaccines to the Virologist.*/
		List<Agent> agents=new ArrayList<Agent>(); 
		agents = craftedAgentCollection.ListAll();
		
		/**opt Checking whether the Virologist has any vaccines*/
		if(agents.isEmpty())
		{
			System.out.println("You do not have any vaccines yet, so you cannot anoint");
			return;
		}
		
//		//System.out.println("0. Cancel");
//		/**List every known genetic code with a serial number*/
//		for(int i=0;i<agents.size();i++){
//			int sernum = i+1;
//		    System.out.print(sernum);
//		    System.out.println(agents.get(i));
//		} 
//		
//		String serialnumber;
//		
//		boolean usable = false;
//		
//		do {
//			System.out.println("Please write the number of the agent you would like to use");
//			Scanner sc = new Scanner(System.in);
//			serialnumber=sc.nextLine();*/
			/**Handling the string type exception*/
//			try {
//				/**Number must be between 1 and the size of the list+1, so if its smaller then 1 or greater than the size of the list the loop will go on*/
//				if(Integer.parseInt(serialnumber) > 0 || Integer.parseInt(serialnumber) < agents.size()+1) {
//					usable = true;
//				}
//				else {
//					System.out.println("Please use the numbers provided to you above to choose an agent to use");
//					
//				}
//					
//					/**Checking whether the Virologist has enough materials to craft*/
//			}
//			catch(NumberFormatException e) {
//				System.out.println("Please use the proper formats like numbers");
//				serialnumber = "";
//			}
//			
//		}/**Whether there is a usable agent selected by the Virologist*/
//		while(!usable);
	
		Skeleton.Interaction.PrintList(agents);
		
		int serialnumber = Skeleton.Interaction.ListItemNumber(agents.size());
		
		Agent craftedAgent = agents.get(serialnumber-1);
		
		if(victim.GetEquipmentCollection().Contains("Gloves")) {
			
			effectCollection.Add(craftedAgent);
			victim.GetEquipmentCollection().Remove("Gloves");
			craftedAgentCollection.Remove(craftedAgent);
		}
		else {
			if(victim.GetEquipmentCollection().Contains("Cloak")) {
				
				double random = ThreadLocalRandom.current().nextDouble(0,100);
				if(random<=82.3){
					
					
				}
				else
					victim.GetEffectCollection().Add(craftedAgent);
				
			}
			else {
				
			victim.GetEffectCollection().Add(craftedAgent);
			
			}
			craftedAgentCollection.Remove(craftedAgent);
		}
		
	}
	
	/**
	* Shows a menu to the player of the craftedAgentCollection that he can choose from to vaccinate its own Virologist
	**/
	public void Vaccinate() {
		
	}
	
	/**
	* Shows a menu to the Player of the genCodeCollection that he can choose from to craft
	**/
	public void Craft() {
	
		System.out.println("The following genetic codes are known to you:");
		
		/**Stores all known genCodes to the Virologist.*/
		List<Agent> genCodes=new ArrayList<Agent>(); 
		genCodes = genCodeCollection.ListAll();
		
		/**opt Checking whether the Virologist knows any genetic codes*/
		if(genCodes.isEmpty())
		{
			System.out.println("You do not know any genetic codes yet, so you shall not craft");
			return;
		}
		
//		System.out.println("0. Cancel");
//		
//		/**List every known genetic code with a serial number*/
//		for(int i=0;i<genCodes.size();i++){
//			int sernum = i+1;
//		    System.out.print(sernum);
//		    System.out.println(genCodes.get(i));
//		} 
//		
//		/**Attributes to address the nucleotid and aminoacid counter of the Virologist*/
//		AminoAcid amino = materialCollection.GetAmino();
//		Nucleotid nucle =materialCollection.GetNucle();
//		
//		/**The amount of aminoacid and nucleotid the Virologist has*/
//		int aminoAmount = amino.GetAmount();
//		int nucleAmount = nucle.GetAmount();
//		
//		/**The expression required for the loop to function. If it's false that means the agent cannot be crafted and the loop must go on. */
//		boolean craftable = false;
//		
//		
//		/**The serial number of the agent in the list*/
//		String serialnumber;
//		do {
//				System.out.println("Please write the number of the agent you would like to craft");
//				
//				/**User input watcher*/
//				Scanner sc = new Scanner(System.in);
//				serialnumber=sc.nextLine();
//				sc.close();
//				
//				/**Handling the string type exception*/
//				try {
//					/**Number must be between 1 and the size of the list+1, so if its smaller then 1 or greater than the size of the list the loop will go on*/
//					if(Integer.parseInt(serialnumber) > 0 || Integer.parseInt(serialnumber) < genCodes.size()+1) {
//						int testamino = genCodes.get(Integer.parseInt(serialnumber)-1).GetCostAmino();
//						int testnucle = genCodes.get(Integer.parseInt(serialnumber)-1).GetCostNucle();
//						
//						/**Checking whether the Virologist has enough materials to craft*/
//						if(testamino <= aminoAmount && testnucle <= nucleAmount)
//							craftable=true;	
//					}
//					else {
//						System.out.println("Please use the numbers provided to you above to choose an agent to craft");
//						serialnumber="";
//					}
//				}
//				catch(NumberFormatException e) {
//					System.out.println("Please use the proper formats like numbers");
//				}
//				
//		}/**Whether the agent is craftable by the Virologist*/
//		while(!craftable);
		
		Skeleton.Interaction.PrintList(genCodes);
		int serialnumber = Skeleton.Interaction.ListItemNumber(genCodes.size());
		
		
//		int listnumber = Integer.parseInt(serialnumber);
		
		/**The agent to be crafted*/
		Agent genCode = genCodes.get(serialnumber-1);
		int aminoCost = genCode.GetCostAmino();
		int nucleCost = genCode.GetCostNucle();
		
		CreateAgent(genCode);
	}
	
	/**
	* Puts the Agent in the parameter to the craftedAgentCollection (checks if it is crafteble)
	* @param genCode - The Agent we wish to craft
	* @return The crafted Agent
	**/
	public Agent CreateAgent(Agent genCode) {//erdei
		
		Agent craftedAgent = new Agent();//kell?
		
		craftedAgentCollection.Add(craftedAgent);
		
		/**Removes the amount required crafting the agent*/
		materialCollection.GetAmino().RemoveAmount(genCode.GetCostAmino());
		materialCollection.GetNucle().RemoveAmount(genCode.GetCostNucle());
		return craftedAgent;
	}
	
	/**
	* Removes an Equipment from the Virologists (in the parameter) equipmentCollection and adds it to its own (checks if v is paralyzed) 
	* @param victim - A Virologist on our Field
	**/
	public void StealEquipment(Virologist victim) {
		
	}
	
	/**
	* Removes Materials from the Virologists (in the parameter) MaterialCollection and adds it to its own (checks if v is paralyzed) 
	* @param victim - A Virologist on our Field
	**/
	public void StealMaterial(Virologist victim) {
		MaterialCollection materialColl2 = victim.GetMaterialCollection();
		FillMaterials(materialColl2);
	}
	
	/**
	* Shows the Equipments from the equipmentCollection to the Player and he chooses one then drops it on the Field that its Virologist standing on 
	**/
	public void DropEquipment() {
		
	}
	
	/**
	* Shows the Equipments from the Field its Virologist standing on to the Player and he chooses one then picks it up.
	**/
	public void PickUpEquipment() {
		
	}
	
	/**
	* The method chooses a random neighbour of the Field that the Virologist is standing on.
	* Calls the MoveTo(Field f) method.
	**/
	public void RandomField() {
		List<Field> neighbours = field.GetNeighbours();
		Random rand = new Random();
		int numberOfSelectedField = rand.nextInt(neighbours.size());
		Field field = neighbours.get(numberOfSelectedField);
		
		MoveTo(field);
	}
	
	/**
	* Deletes all the Agents from the genCodeCollection.
	**/
	public void DeleteLearntAgent() {
		genCodeCollection.ClearAll();
	}
	
	/**
	* The method fills the Virologists Material amounts from another MaterialCollection
	* @param m - A Warehouse or another Virologist MaterialCollection
	**/
	public void FillMaterials(MaterialCollection m) {
		AminoAcid victimAmino = m.GetAmino();
		Nucleotid victimNucle = m.GetNucle();
		int victimAminoAmount = victimAmino.amount;
		int victimNucleAmount = victimNucle.amount;
		
		AminoAcid Amino = materialCollection.GetAmino();
		Nucleotid Nucle = materialCollection.GetNucle();
//		int AminoAmount = Amino.amount;
//		int NucleAmount = Nucle.amount;
		
		int fillAminoWithAmount = maxAmino - Amino.amount;
		int fillNucleWithAmount = maxNucle - Nucle.amount;
		if(victimAminoAmount < fillAminoWithAmount) {
			victimAminoAmount -= victimAminoAmount;
			Amino.amount += victimAminoAmount;
		}
		else if(Amino.amount > fillAminoWithAmount) {
			fillAminoWithAmount = fillAminoWithAmount - Amino.amount;
			victimAminoAmount -= fillAminoWithAmount;
			Amino.amount += fillAminoWithAmount;
		}
		else {
			victimAminoAmount -= fillAminoWithAmount;
			Amino.amount += fillAminoWithAmount;
		}
		
		
		if(victimNucleAmount < fillNucleWithAmount) {
			victimNucle.amount -= victimNucleAmount;
			Nucle.amount += victimNucleAmount;
		}
		else if(Nucle.amount > fillNucleWithAmount) {
			fillNucleWithAmount = fillNucleWithAmount - Nucle.amount;
			victimNucle.amount -= fillNucleWithAmount;
			Nucle.amount += fillNucleWithAmount;
		}
		else {
			victimNucle.amount -= fillNucleWithAmount;
			Nucle.amount += fillNucleWithAmount;
		}
		
	}
	
	/**
	* The method is called at the start of each turn and it calls every Effect from the effectCollection
	**/
	public void CallAffectWithAll() {
		
	}
	
	
	public void CallDecreaseAgentTime() {
		
	}
	
	public void RemoveAgentFromAgentColl(Agent a) {
		
		effectCollection.Remove((Effect) a);
		
	}
	
	/**
	* Default ToString method for console printout.
	* @return String with every attribute of the Virologist
	**/
	public String ToString() {
		
	}
	
	/**
	* Getter to the materialCollection
	* @return materialCollection
	**/
	public MaterialCollection GetMaterialCollection() {
		return materialCollection;
	}
	
	/**
	* Getter to the equipmentCollection
	* @return equipmentCollection
	**/
	public EquipmentCollection GetEquipmentCollection() {
		return equipmentCollection;
	}
	
	/**
	* Getter to the effectCollection
	* @return effectCollection
	**/
	public EffectCollection GetEffectCollection() {
		return effectCollection;
	}
}
