package src;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ThingData<T> extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<? super T> thingList;
	
	public ThingData(ArrayList<? super T> _t){
		thingList = _t;
	}
	
	public String getColumnName(int col) {
		switch(col) {
		case 0: return "Data";
		default: return "Empty";
		}
	}
	
	public int getRowCount() {
		return thingList.size();
	}
	
	public int getColumnCount() {
		return 1;
	}
	
	public Class<? extends Object> getColumnClass(int column){
		return getValueAt(0, column).getClass();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return thingList.get(rowIndex);
	}
	
	public void setValueAt(Object value, int row, int col) {}
}
