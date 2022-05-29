import java.awt.Dimension;

import javax.swing.*;

@SuppressWarnings("serial")
public class TableButton extends JButton {
	int table;
	
	public TableButton (int table) {
		this.table=table;
		super.setText("Table "+table);
		super.setFont(new java.awt.Font("Verdana", 1, 10));
		super.setForeground(new java.awt.Color(255, 255, 255));
		super.setPreferredSize(new Dimension(90,60));
		super.setMaximumSize(new Dimension(50,30));
		setLocation(table, table);
	}
	
	public  int getTable() {
		return table;
	}
	
}

