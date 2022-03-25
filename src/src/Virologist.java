package src;

/**
* Oszt�ly neve
* �soszt�ly neve
* Mi(ke)t t�rol?
* Mire haszn�ljuk az oszt�ly �ltal�noss�gban?
**/

/**Mit csin�l, mire val� az adattag*/
//private int adattag;

/**
* Mit csin�l, mire val� a f�ggv�ny
* @param param�terNeve - Mit jel�l az adott param�ter, ha van?
* @return Mit t�r�t vissza a f�ggv�ny, ha van visszat�r�si �rt�ke.
**/
//public int F�ggv�ny() {;}

public class Virologist extends Thing {
	
	EquipmentCollection equipmentCollection;
	
	EffectCollection effectCollection;
	
	AgentCollection craftedAgentCollection;
	
	AgentCollection genCodeCollection;
	
	MaterialCollection materialCollection;
	
	/**
	* The method stores the genCode in the parameter.
	* @param genCode - The Agent that will be stored.
	**/
	public void CloneGenCode(Agent genCode) {
		
	}
	
	/**
	* Shows the available Fields to the Player -> Moves the Virologist.
	**/
	public void Move() {
		
	}
	
	/**
	* Shows the available Fields to the Player -> Moves the Virologist.
	**/
	public void MoveTo() {
		
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
		
	}
	
	/**
	* The method adds the Agent (from our craftedAgentCollection) in the parameters to the victims EffectCollection
	* @param a - An Agent from the craftedAgentCollection
	* @param victom - the choosen Virologist we wish to anoint
	**/
	public void Anoint(Agent a, Virologist victim) {
		
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
		
	}
	
	/**
	* Puts the Agent in the parameter to the craftedAgentCollection (checks if it is crafteble)
	* @param genCode - The Agent we wish to craft
	* @return The crafted Agent
	**/
	public Agent CreateAgent(Agent genCode) {
		return genCode;
	}
	
	/**
	* Removes an Equipment from the Virologists (in the parameter) equipmentCollection and adds it to its own (checks if v is paralyzed) 
	* @param v - A Virologist on our Field
	**/
	public void StealEquipment(Virologist v) {
		
	}
	
	public void StealMaterial(Virologist victim) {
		
	}
	
	public void DropEquipment() {
		
	}
	
	public void PickUpEquipment() {
		
	}
	
	public void RandomField() {
		
	}
	
	public void DeleteLearntAgent() {
		
	}
	
	public void FillMaterials(MaterialCollection m) {
		
	}
	
	public void CallAffectWithAll() {
		
	}
	
	public String ToString() {
		
	}
	
	public MaterialCollection GetMaterialCollection() {
		return materialCollection;
	}
	
	public EquipmentCollection GetEquipmentCollection() {
		return equipmentCollection;
	}
	
	public EffectCollection GetEffectCollection() {
		return effectCollection;
	}
}
