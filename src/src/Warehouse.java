package src;

/**
 * <b>Warehouse class</b><br>
 * <i>Inherites from Field.</i><br><br>
 * Stores materials - aminoacid and/or nucleotid.<br>
 * Once a virologist enters a warehouse, can start its materials filling up.
 * @author Martin
 */
public class Warehouse extends Field{

	
	
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
		System.out.println("CreateMaterials");
	}
	
	/**
	 * Stores the given virologist. <br>
	 * Asks the virologist to fill its materials up.
	 * @param v - the given virologist who might need materials
	 */
	public void Accept(Virologist v) {
		this.things.add(v);
		v.FillMaterials(materialCollection);
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
		return "Warehouse" + ID;
	}
}

