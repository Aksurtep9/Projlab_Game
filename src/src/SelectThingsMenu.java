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
	
	
	public SelectThingsMenu(Thing t, String info, JFrame p){
		previous=p;
		btOk = new JButton("OK");
		table = new JTable();
		data = new ThingData();
		
		
	}

	public SelectThingsMenu(ArrayList<Thing> t, JFrame p){
		previous=p;
		btOk = new JButton("OK");
		table = new JTable();
		data = new ThingData();
	}
	
	public void Initialize() {
		btOk = new JButton();
		previous = new JFrame();
		
	}
	
	void CallOk(Thing t) {
		
	}

}