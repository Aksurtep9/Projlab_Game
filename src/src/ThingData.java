package src;

import javax.swing.table.AbstractTableModel;

public class ThingData extends AbstractTableModel {
	
	Thing t;
	int maxRows = 5;
	
	ThingData(){
		
	}
	
	public String getColumnName(int col) {
		switch(col) {
		case 0: return "ID";
		case 1: return "Name";
		case 2: return "Info";
		}
	}
	
	@Override
	public int getRowCount() {
		return maxRows;
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	public Class<? extends Object> getColumnClass(int column){
		return getValueAt(0, column).getClass();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
	}


}
