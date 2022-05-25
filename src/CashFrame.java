import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class CashFrame extends JFrame {
	private JTextField txtInserireI;

	final int WIDTH = 700;
	final int HEIGHT = 400;
	final Dimension dimension = new Dimension(WIDTH, HEIGHT);

	public CashFrame() {
		setTitle("cash desk");
		getContentPane().setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JList list = new JList();
		panel_1.add(list, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JTextArea textArea = new JTextArea();
		panel_2.add(textArea);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton_1 = new JButton("print receipt");
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -53, SpringLayout.EAST, panel);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back to main menù");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, -26, SpringLayout.EAST, panel);
		panel.add(btnNewButton_2);

		txtInserireI = new JTextField();
		double amount= Double.parseDouble(txtInserireI.getText());
		textArea.append();
		sl_panel.putConstraint(SpringLayout.WEST, txtInserireI, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtInserireI, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, txtInserireI);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtInserireI, -333, SpringLayout.SOUTH, panel);
		txtInserireI.setText("enter amount received");
		panel.add(txtInserireI);
		txtInserireI.setColumns(10);

		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
