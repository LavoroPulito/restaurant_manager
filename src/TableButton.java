import javax.swing.*;

@SuppressWarnings("serial")
public class TableButton extends JButton {
	int table;
	
	public TableButton (int table) {
		this.table=table;
		super.setText("Tavolo "+table);
		super.setFont(new java.awt.Font("Verdana", 1, 10));
		super.setForeground(new java.awt.Color(255, 255, 255));

	}
	
	public  int getTable() {
		return table;
	}
	
}

