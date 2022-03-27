package src;

/**
 * <b>Laboratory class</b><br>
 * <i>Inherites from Field.</i><br><br>
 * Stores one genetic code which can be learnt by a virologist.<br>
 * Once a virologist enters a laboratory, can start learning the foundable genetic code.
 * @author Martin
 */
public class Laboratory extends Field{

	/**
	 * Constructor for the Laboratory
	 */
	public Laboratory() {
		super();
		System.out.println("Laboratory");
	}
	
	/**Stores the laboratory's one and only genetic code.*/
	private Agent genCode;
	
	/**
	 * Allocates and creates a genetic code for the laboratory.
	 */
	public void CreateGenCode() {
		System.out.println("CreateGenCode");
		
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
	}
	
	/**
	 * Gives the field's type back
	 * @return the type of the field
	 */
	@Override
	public String toString() {
		System.out.println("toString");
		return "Laboratory" + ID;
	}
}
