package app.frontend.components;

import java.awt.Dimension;

import javax.swing.*;

@SuppressWarnings("serial")

/**
 * this class is a Button that represents a table
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class TableButton extends JButton {
	/**
	 * table's number
	 */
	int table;
	/**
	 * Creates a new TableButton with its table number and it defines the style of the button
	 * @param table
	 */
	public TableButton (int table) {
		this.table=table;
		super.setText("Table "+table);
		super.setFont(new java.awt.Font("Verdana", 1, 10));
		super.setForeground(new java.awt.Color(255, 255, 255));
		super.setMaximumSize(new Dimension(50,30));
		setLocation(table, table);
	}
	/**
	 * Returns the number of the table
	 * @return
	 */
	public  int getTable() {
		return table;
	}
	
}

