package src;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SelectThingsMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3144941765010925027L;
	
	private JButton btOk;
	private GameMenu previous;
	private JTable table;
	@SuppressWarnings("rawtypes")
	private ThingData data;
	
	private JPanel panel;
	
	//private static Thread thread;
	
	//private static Object lock = new Object();
	
	public SelectThingsMenu(Thing t, String info, GameMenu p){
		synchronized (p.getLock()) {
			previous = p;
			btOk = new JButton("OK");
			table = new JTable();
			
			Virologist player = (Virologist)t;
			
			if(info.equals("genCode")) {
				data = new ThingData<Agent>(player.GetGenCodeCollection().GetAgents());
			}
			else if(info.equals("Virologists")) {
				ArrayList<Virologist> lista = new ArrayList<>();
				for(Thing item: player.GetField().GetThings()) {
					if(item.toString().contains("Virologist"))
						lista.add((Virologist)item);
				}
				data = new ThingData<Virologist>(lista);
			}
			else if(info.equals("Crafts")) {
				data = new ThingData<Agent>(player.GetCraftedACollection().GetAgents());
			}
			
			table = new JTable(data);
			
			View();
		}
	}
	
	private void View() {
		this.setSize(1120, 1020);
		
		panel = new JPanel(new BorderLayout());
		JScrollPane scrollPanel;
		
		// Table
		table.setRowHeight(150);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setFillsViewportHeight(true);
		scrollPanel = new JScrollPane(table);
		panel.add(scrollPanel, "Center");
		
		// Button
		btOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				Thing t = null;
				if(row == -1) {
					// Do nothing
				}else {
					t = (Thing) table.getValueAt(row, 0);
				}
				
				CallOk(t);
			}
		});
		panel.add(btOk, "South");
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public void CallOk(Thing t) {
		synchronized (previous.getLock()) {
			previous.SetSelectedItem(t);
			this.setVisible(false);
			previous.getLock().notify();
		}
	}
}
