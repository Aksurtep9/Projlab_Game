package src;

import java.util.ArrayList;

/**
 * <b>Warehouse class</b><br>
 * <i>Inherites from Field.</i><br><br>
 * Stores materials - aminoacid and/or nucleotid.<br>
 * Once a virologist enters a warehouse, it can start filling up its materials.
 * @author Martin
 */
public class Warehouse extends Field{

	/**unique id*/
	private static final long serialVersionUID = -495876710085396712L;
	/**Stores the warehouse's materials.*/
	private MaterialCollection materialCollection;
	
	
	/**
	 * Constructor for the Warehouse
	 */
	public Warehouse() {
		super();
		
		materialCollection = new MaterialCollection();
	}
	
	
	/**
	 * Allocates and creates a collection for the warehouse's materials.
	 */
	public void CreateMaterials() {
	}
	
	/**
	 * Stores the given virologist. <br>
	 * Asks the virologist to fill its materials up.
	 * @param v - the given virologist who might need materials
	 */
	public void Accept(Virologist v) {
		this.things.add(v);
		v.FillMaterials(materialCollection);
		v.SetField(this);
	}
	
	/**
	 * Removes the given thing from its store.
	 * @param t - the removable thing
	 */
	public void Remove(Thing t) {
		this.things.remove(t);
	}
	
	/**
	 * Gives back the things.
	 * @return the things that can be found on the field
	 */
	public ArrayList<Thing> GetThings(){
		return things;
	}
	
	/**
	 * Gives all the neighbour back that has been picked out.
	 * @return the chosen neigbhour
	 */
	public ArrayList<Field> GetNeighbours() {
		return this.neighbours;
	}
	
	/**
	 * Gives back the Warehouse's material collection.
	 * @return the warehouse's materials
	 */
	public MaterialCollection GetMaterialCollection() {
		return materialCollection;
	}
	
	/**
	 * Gives the field's type back
	 * @return the type of the field
	 */
	@Override
	public String toString() {
		return "Warehouse";
	}
	
	public void setId(int id) { this.ID = id; }
	
	/**
	 * Removes every Material from the materialCollection
	 */
	public void DestroyMaterialCollection() {
		materialCollection.DestroyMaterials();
	}
}

