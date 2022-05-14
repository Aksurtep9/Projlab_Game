package src;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JFrame previous;
	private JTable table;
	@SuppressWarnings("rawtypes")
	private ThingData data;
	
	private JPanel panel;
	
	
	public SelectThingsMenu(Thing t, String info, JFrame p){
		previous=p;
		btOk = new JButton("OK");
		table = new JTable();
		
		Virologist player = (Virologist)t;
		
		if(info.equals("gencodecollection")) {
			data = new ThingData<Agent>(player.GetGenCodeCollection().GetAgents());
		}
		
		table = new JTable(data);
		
		View();
		
	}
	
	private void View() {
		this.setSize(1120, 1020);
		this.setVisible(true);
		
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
	}
	
	public void CallOk(Thing t) {
		GameMenu prev = (GameMenu) previous;
		prev.SetSelectedItem(t);
		this.dispose();
	}
}
