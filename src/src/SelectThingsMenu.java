package src;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

public class SelectThingsMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3144941765010925027L;
	
	JButton btOk;
	JFrame previous;
	JTable table;
	ThingData data;
	
	
	SelectThingsMenu(Thing t, String info, JFrame p){
		previous=p;
		
	}

	SelectThingsMenu(ArrayList<Thing> t, JFrame p){
		
	}
	
	void CallOk(Thing t) {
		
	}

}
