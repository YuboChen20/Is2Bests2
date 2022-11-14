package domain;
import javax.swing.table.AbstractTableModel;


import java.util.ArrayList;

public class UserAdapter extends AbstractTableModel{
	private String[] columnNames= {"Event","Question","Event Date","Bet €"};
	private ArrayList<Bet> myList;
	public UserAdapter(ArrayList<Bet>apuestas) {
		myList= apuestas;
	}
	public int getColumnCount() {
		return columnNames.length;
	}
	public int getRowCount() {
		int size;
		if(myList == null) {
			size=0;
		}else {
			size=myList.size();
		}
		return size;
	}
	public Object getValueAt(int row,int col) {
		Object temp=null;
		if(col==0) {
			temp=myList.get(row).getPronostico().getQuestion().getEvent().getDescription();
		} else if (col == 1) {
	         temp = myList.get(row).getPronostico().getQuestion().getQuestion();
	    }else if (col == 2) {
	         temp = myList.get(row).getPronostico().getQuestion().getEvent().getEventDate();
	    }else if (col == 3) {
	         temp = myList.get(row).getBet()+" €";
	    }
		return temp;
	}
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
}