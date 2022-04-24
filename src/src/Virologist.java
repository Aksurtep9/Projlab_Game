package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
	
	/**
	 * A boolean that shows if the player is still alive in the game
	 */
	
	private boolean alive;
	
	/**
	 * The number of maximum aminoacid a player can hold at one time.
	 */
	private int maxAmino = 20;
	
	/**
	 * The number of maximum nucleotid a player can hold at one time.
	 */
	private int maxNucle = 20;
	
	
	/**If the Virologist picks up an Equipment it gets into the equipmentCollection.*/
	private EquipmentCollection equipmentCollection;
	
	/**If the Virologist picks up an Equipment or gets an Agents Effect it gets into the effectCollection*/
	private EffectCollection effectCollection;
	
	/**If the Virologist crafts an Agent it gets into the craftedAgentCollection*/
	private AgentCollection craftedAgentCollection;
	
	/**If the Virologist learns a genCode in a Laboratory it gets into the genCodeCollection*/
	private AgentCollection genCodeCollection;
	
	/**The Materials owned by the Virologist are in the materialCollection*/
	private MaterialCollection materialCollection;
	
	public Virologist() {
		equipmentCollection = new EquipmentCollection();
		effectCollection = new EffectCollection();
		craftedAgentCollection = new AgentCollection();
		genCodeCollection = new AgentCollection();
		materialCollection = new MaterialCollection();
		alive = true;
		
	}
	
	/**
	 * returns how much aminoacid fits into the virologist's collection
	 * @return maxAmino
	 */
	public int GetMaxAmino() {
		return maxAmino;
	}
	
	/**
	 * returns how much mucleotid fits into the virologist's collection
	 * @return maxNucle
	 */
	public int GetMaxNucle() {
		return maxNucle;
	}
	
	/**
	* The method stores the genCode in the parameter.
	* @param genCode - The Agent that will be stored.
	**/
	public void CloneGenCode(Agent genCode) {
		
		System.out.println("CloneGenCode");
		//Checks if the virologist already has this genCode
		boolean contains = false;

		if(this.genCodeCollection.Contains(genCode.GetEffectName())) contains = true;

		
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
	public void Move(int field) {
		
		/**Guard for index out of range*/
		if(this.field.GetNeighbours().size()<=field)
			return;
		
		/**The destination field*/
		Field tomoveto = this.field.GetNeighbours().get(field);
		
		this.field.Remove(this);
		this.field = tomoveto;
		tomoveto.Accept(this);
	}
	
	/**
	* Shows the available Fields to the Player -> Moves the Virologist.
	**/
	public void MoveTo(Field whereToMove) {
		field.Remove(this);
		whereToMove.Accept(this);
	}
	
	/**
	* Starts the interaction with the Virologist on the same Field, opens the menu
	**/
	public void Encounter() {
		System.out.println("Encounter");
		List<Thing> things = this.field.GetThings();
		Skeleton.Interaction.PrintList(things);
		int choosenNumber = Skeleton.Interaction.ListItemNumber(things.size());
		//Virologist enemy = null;
		
		if(choosenNumber == 0) {
			//empty
		}
		else {
			Thing enemyThing = things.get(choosenNumber-1);
			if(enemyThing.toString().contains("Virologist")) {
				Virologist enemy = (Virologist)enemyThing;
				Touch(enemy);
			}
			
		}
		
	}
	
	/**
	* If the Virologist in the parameter is touchable, it shows the interaction menu to the Player
	* @param v - A Virologist on our Field
	**/
	public void Touch(Virologist v) {
		System.out.println("Touch");
		EffectCollection effectCol = v.GetEffectCollection();
		boolean containsProtect = effectCol.Contains("protect");
		boolean containsCloak = effectCol.Contains("cloak");
		
		if(!containsProtect && !containsCloak) {
			
		}
		StealMaterial(v);
	}
	
	/**
	* The method adds the Agent (from our craftedAgentCollection) in the parameters to the victims EffectCollection
	* @param agent - An Agent from the craftedAgentCollection
	* @param victim - the choosen Virologist we wish to anoint
	**/
	public void Anoint(int victim, int agent) {
		
		/**Guard for index out of range*/
		if(this.GetCraftedACollection().GetAgents().size()<=agent)
			return;
		
		/**Agent to be used*/
		Agent a =this.craftedAgentCollection.GetAgents().get(agent);
		
		/**The possible victims*/
		ArrayList<Virologist> vir= new ArrayList<Virologist>();
		for(Thing t : this.field.GetThings())
		{
			if(t.toString().contains("Virologist")) {
				vir.add((Virologist) t);
			}
		}
		
		/**Guard for index out of range*/
		if(vir.size()<=victim)
			return;
		
		/**The Victim*/
		Virologist vic = vir.get(victim-1);
		
		/**Checking for gloves*/
		if(vic.GetEquipmentCollection().Contains("Gloves")) {
			Gloves g=null;
			for(Equipment e: this.GetEquipmentCollection().GetEquipments()) {
				if(e.GetEffectName().equals("Gloves")) {
					g=(Gloves) e;
				}
			}
			
			/**Checking if the gloves are still usable*/
			if(g.GetUseTime()>0)
			{
				effectCollection.Add((Effect)a,this);
				craftedAgentCollection.Remove(a.GetEffectName());
				for(Equipment e: equipmentCollection.GetEquipments()) {
					if(vic.GetEquipmentCollection().Contains("Gloves"))
						e.DecreaseUseTime();
				}
			}
		}
		else {
			/**Checking for cloak*/
			if(vic.GetEquipmentCollection().Contains("Cloak")) {
				Cloak c=null;
				for(Equipment e: this.GetEquipmentCollection().GetEquipments()) {
					if(e.GetEffectName().equals("Cloak")) {
						c=(Cloak) e;
					}
				}
				//**Initiating the cloaks defense mechanism*/
				if(c.Chance()){	
					vic.GetEffectCollection().Add((Effect)a,vic);
				}		
			}
			else {
				vic.GetEffectCollection().Add((Effect)a,vic);
			}
			/**Removing the used agent*/
			craftedAgentCollection.Remove(a.GetEffectName());
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
	public void Craft(int index) {
		
		/**Guard for index out of range*/
		if(index>=this.GetGenCodeCollection().GetAgents().size())
			return;
		
		/**the agent to be crafted*/
		Agent genCode = genCodeCollection.ListAll().get(index-1);
		
		/**Checking whether its possible to craft the agent*/
		if(genCode.GetCostAmino() <= materialCollection.GetAmino().GetAmount() && genCode.GetCostNucle() <= materialCollection.GetNucle().GetAmount()) {
				CreateAgent(genCode);
		}
	}
	
	/**
	* Puts the Agent in the parameter to the craftedAgentCollection (checks if it is craftable)
	* @param genCode - The Agent we wish to craft
	* @return The crafted Agent
	**/
	public Agent CreateAgent(Agent genCode) {
		
		/**Creating the specific agent*/
		Agent a = null;
		if(genCode.GetEffectName().equals("Chorea"))
			a= new Chorea();
		else if(genCode.GetEffectName().equals("Amnesia"))
			a=new Amnesia();
		else if(genCode.GetEffectName().equals("Paralyze"))
			a=new Paralyze();
		else if(genCode.GetEffectName().equals("Protect"))
			a= new Protect();
		
		/**Adding it to the collection*/
		this.craftedAgentCollection.Add(a);
		
		/**Removes the amount required crafting the agent*/
		materialCollection.GetAmino().RemoveAmount(genCode.GetCostAmino());
		materialCollection.GetNucle().RemoveAmount(genCode.GetCostNucle());
		return a;
	}
	
	/**
	* Removes the selected Equipment from the Virologists (in the parameter) equipmentCollection and adds it to its own (checks if v is paralyzed) 
	* @param victim - the number of a virologist on a certain Field
	* @param eqNum - the number of the equipment that should be stolen
	**/
	public void StealEquipment(int vic, int eqNum) {
		ArrayList<Virologist> vir= new ArrayList<Virologist>();
		for(Thing t : this.field.GetThings())
		{
			if(t.toString().contains("Virologist")) {
				vir.add((Virologist) t);
			}
		}
		Virologist victim;
		if(vir.size()>=vic) {
			victim = vir.get(vic-1);
		}else {
			return;
		}
		boolean paralyzed=victim.GetEffectCollection().Contains("Paralyze");
		if(paralyzed) {
			EquipmentCollection eqVictim=victim.GetEquipmentCollection();
			
			if(eqNum>victim.GetEquipmentCollection().GetSize()) {
				return;
			} else {
				Equipment choosenEquipment = eqVictim.GetEquipments().get(eqNum-1);
				EquipmentCollection eqSelf=this.GetEquipmentCollection();
				eqSelf.Add(choosenEquipment);
				eqVictim.Remove(choosenEquipment.GetEffectName());
				victim.GetEffectCollection().Remove(choosenEquipment.GetEffectName());
				effectCollection.Add(choosenEquipment,this);
			}
		}
	}
	
	/**
	* Removes Materials from the Virologists (in the parameter) MaterialCollection and adds it to its own (checks if v is paralyzed) 
	* @param victim - A Virologist on our Field
	**/
	public void StealMaterial(int victim) {
		ArrayList<Virologist> vir= new ArrayList<Virologist>();
		for(Thing t : this.field.GetThings())
		{
			if(t.toString().contains("Virologist")) {
				vir.add((Virologist) t);
			}
		}
		if(vir.size()>=victim)
		{
			Virologist vic = vir.get(victim-1);
			MaterialCollection materialColl2 = vic.GetMaterialCollection();
			FillMaterials(materialColl2);
		}
	}
	
	/**
	* Drops the selected Equipment from the equipmentCollection of the Player to the Field that it is standing on
	* @param eqNum the number of the equipment which should be dropped
	**/
	public void DropEquipment(int eqNum) {
		List<Equipment> equipments = this.equipmentCollection.GetEquipments();
		
		Equipment choosenEquipment = equipments.get(eqNum-1);
		field.Accept(choosenEquipment);
		effectCollection.Remove(choosenEquipment.GetEffectName());
		equipmentCollection.Remove(choosenEquipment.GetEffectName());
			
	}
	
	/**
	* Picks up the selected Equipment from the Field the Player is standing on
	* @param eqNum the number of the equipment which should be picked up
	**/
	public void PickUpEquipment(int eqNum) {
		ArrayList<Thing> thingsList = this.field.GetThings();
		
		if(eqNum>thingsList.size())return;
		else {
			if(!thingsList.get(eqNum).toString().contains("Virologist")) {
				Thing equipmentThing = thingsList.get(eqNum);
				Equipment equipment = (Equipment)equipmentThing;
				if(equipment != null) {
					if(equipmentCollection.GetSize() < 3) {
						equipmentCollection.Add(equipment);
						effectCollection.Add(equipment, this);
						field.Remove(equipment);
						//logger()
					}	
				}
			}
			
		}
	}
	
	/**
	* The method chooses a random neighbour of the Field that the Virologist is standing on.
	* Calls the MoveTo(Field f) method.
	**/
	public void RandomField() {
		System.out.println("RandomField");
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
		System.out.println("DeleteLearntAgent");
		genCodeCollection.ClearAll();
	}
	
	/**
	* The method fills the Virologists Material amounts from another MaterialCollection
	* @param m - A Warehouse or another Virologist MaterialCollection
	**/
	public void FillMaterials(MaterialCollection m) {
		System.out.println("FillMaterial");
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
		if(victimAminoAmount <= fillAminoWithAmount) {
			victimAminoAmount -= victimAminoAmount;
			Amino.amount += victimAminoAmount;
		}
		/*else if(Amino.amount > fillAminoWithAmount) {
			fillAminoWithAmount = fillAminoWithAmount - Amino.amount;
			victimAminoAmount -= fillAminoWithAmount;
			Amino.amount += fillAminoWithAmount;
		}
		else {
			victimAminoAmount -= fillAminoWithAmount;
			Amino.amount += fillAminoWithAmount;
		}
		*/
		else if(victimAminoAmount > fillAminoWithAmount) {
			victimAminoAmount -= fillAminoWithAmount;
			Amino.amount += fillAminoWithAmount;
		}
		
		
		if(victimNucleAmount <= fillNucleWithAmount) {
			victimNucle.amount -= victimNucleAmount;
			Nucle.amount += victimNucleAmount;
		}
		/*else if(Nucle.amount > fillNucleWithAmount) {
			fillNucleWithAmount = fillNucleWithAmount - Nucle.amount;
			victimNucle.amount -= fillNucleWithAmount;
			Nucle.amount += fillNucleWithAmount;
		}
		else {
			victimNucle.amount -= fillNucleWithAmount;
			Nucle.amount += fillNucleWithAmount;
		}*/
		else if(victimNucleAmount > fillNucleWithAmount) {
			victimNucleAmount -= fillNucleWithAmount;
			Nucle.amount += fillNucleWithAmount;
		}
		
	}
	
	/**
	 * Anoints the Virologist given in the parameters with bear dance. Gets an instance of a cloak which is being held by the victim
	 * then applies BearDance to the virologist if the conditions are correct.
	 * @param v2 The virologist which will be anointed with bear dance.
	 */
	public void BearDanceAnoint(Virologist v2) {
		Cloak eq = null;
		boolean containsCloak = false;
		
		
		
		for(Equipment item: v2.GetEquipmentCollection().GetEquipments()) {
			if(item.toString().contains("cloak") && !containsCloak) {
				containsCloak = true;
				eq = (Cloak)item;
			}
		}
		
		boolean isVictimProtected = v2.GetEffectCollection().Contains("Protect");
		boolean haveCloak = v2.GetEffectCollection().Contains("Cloak");
		if(haveCloak) {
			boolean protectingCloak = eq.Chance();
			boolean hasBearDanceAlready = v2.GetEffectCollection().Contains("BearDance");

			if(!(isVictimProtected && protectingCloak && hasBearDanceAlready)) {
				Agent bearDance = new BearDance();
				v2.effectCollection.Add(bearDance, v2);
			}
		}
	}
	
	/**
	* The method is called at the start of each turn and it calls every Effect from the effectCollection
	**/
	public void CallAffectWithAll() {
		System.out.println("CallAffectWithAll");
	}
	
	
	public void CallDecreaseAgentTime() {
		System.out.println("CallDecreaseAgentTime Virologistcall");
		craftedAgentCollection.DecreaseAgentTimeAColl(this);
		effectCollection.DecreaseAgentTimeEColl(this);
	}
	
	public void RemoveAgentFromAgentColl(Agent a) {
		System.out.println("RemoveAgentFromAgentColl");
		effectCollection.Remove((Effect) a);
		
	}
	
	/**
	* Default ToString method for console printout.
	* @return String with every attribute of the Virologist
	**/
	@Override
	public String toString() {
		return "Virologist"+ID;
	}
	
	/**
	* Default ToString method for console printout.
	* @return String with every attribute of the Virologist
	**/
	public String VirologistStat() {
		String stat="";
		stat+=this.toString();
		stat+=System.lineSeparator();
		stat+=this.GetMaterialCollection().GetAmino();
		stat+=System.lineSeparator();
		stat+=this.GetMaterialCollection().GetNucle().ToString();
		stat+="Equipments: "+System.lineSeparator();
		stat+=this.GetEquipmentCollection().toString();
		stat+="Effects: "+System.lineSeparator();
		stat+=this.GetEffectCollection().toString();
		stat+="Learnt Gencodes: "+System.lineSeparator();
		stat+=this.GetGenCodeCollection().toString();
		stat+="Crafted Agents: "+System.lineSeparator();
		stat+=this.GetCraftedACollection().toString();
		return stat;
	}
	
	
	/**
	* Getter to the materialCollection
	* @return materialCollection
	**/
	public MaterialCollection GetMaterialCollection() {
		System.out.println("GetMaterialCollection");
		return materialCollection;
	}
	
	/**
	* Getter to the equipmentCollection
	* @return equipmentCollection
	**/
	public EquipmentCollection GetEquipmentCollection() {
		System.out.println("GetEquipmentCollection");
		return equipmentCollection;
	}
	
	/**
	* Getter to the effectCollection
	* @return effectCollection
	**/
	public EffectCollection GetEffectCollection() {
		System.out.println("GetEffectCollection");
		return effectCollection;
	}
	
	public AgentCollection GetGenCodeCollection() {
		System.out.println("GetGenCodeCollection");
		return genCodeCollection;
	}
	
	public AgentCollection GetCraftedACollection() {
		System.out.println("GetCraftedACollection");
		return craftedAgentCollection;
	}
	
	/**
	 * Setting the alive attribute to false
	 */
	public void setDead() {
		alive = false;
	}
	
	/**
	 * Gives TRUE back if the virologist is alive
	 * @return TRUE if the virologist is alive
	 */
	public boolean IsAlive() {
		return alive;
	}
	
	public int GetId() {
		return ID;
	}
	
	/**
	 * 
	 * @param v - the virologist who's become bear
	 */
	public void KillTheBear(Virologist v) {
		v.setDead();
	}
	
	public void Attack(int victim) {
		
		ArrayList<Virologist> vir= new ArrayList<Virologist>();
		for(Thing t : this.field.GetThings())
		{
			if(t.toString().contains("Virologist")) {
				vir.add((Virologist) t);
			}
		}
		
		/**Guard for index out of range*/
		if(vir.size()<=victim)
			return;
		
		/**The Victim*/
		Virologist vic = vir.get(victim-1);
		
		/**Checking for the bear*/
		if(!vic.IsAlive())
		{
			ArrayList<Axe> axes=new ArrayList<Axe>();
			for(Equipment e: this.GetEquipmentCollection().GetEquipments()) {
				if(e.GetEffectName().equals("Axe")) {
					axes.add((Axe) e);
				}
			}
			
			
			for(Axe a : axes)
			{
				if(a.GetUseTime()>0)
				{
					/**KILL THE BEAR*/
					KillTheBear(vic);
				
					/**Axe goes to the trash*/
					a.DecreaseUseTime();
					return;
				}
			}
		}
	}
}
