package src;

import java.util.Random;

/**
 * <b>Laboratory class</b><br>
 * <i>Inherits from Field.</i><br><br>
 * Stores one genetic code which can be learnt by a virologist.<br>
 * Once a virologist enters a laboratory, it can start learning the foundable genetic code.
 * @author Martin
 */
public class Laboratory extends Field{

	
	
	/**Stores the laboratory's one and only genetic code.*/
	private Agent genCode;
	
	/**Stores the laboratory's one and only bearDanceCode if it has or not.*/
	private Agent bearDanceCode;
	
	/**
	 * Constructor for the Laboratory
	 */
	public Laboratory() {
		super();
		genCode = new Protect();
		bearDanceCode = null;
		
		Random rand = new Random();
		double bearDanceSpawnChance = rand.nextDouble() * 100;
		if(bearDanceSpawnChance >= 0.85) {
			bearDanceCode = new BearDance();
		}
	}
	
	/**
	 * Allocates and creates a genetic code for the laboratory.
	 */
	public void CreateGenCode() {
		System.out.println("CreateGenCode");
		
	}
	
	/**
	 * Setting the genCode manually
	 */
	public void SetGenCode(Agent a) {
		genCode = a;
	}
	
	/**
	 * Stores the given virologist. <br>
	 * Laboratory asks the virologist to learn its genetic code.
	 * @param v - the given virologist who might not know the genetic code
	 */
	@Override
	public void Accept(Virologist v) {
		System.out.println("Accept");
		this.things.add(v);
		v.CloneGenCode(genCode);
		
		if(bearDanceCode != null) {
			v.BearDanceAnoint(v);
		}
	}
	
	/**
	 * Gives the field's type back
	 * @return the type of the field
	 */
	@Override
	public String toString() {
		System.out.println("toString");
		return "Laboratory";
	}
}
