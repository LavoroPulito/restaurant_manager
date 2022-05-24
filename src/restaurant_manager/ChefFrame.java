package restaurant_manager;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ChefFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	final int WIDTH = 700;
	final int HEIGHT = 400;
	final Dimension dimension = new Dimension(WIDTH,HEIGHT);


	public ChefFrame() {
		super("Chef");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, panel);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 147, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -4, SpringLayout.WEST, panel_2);
		panel_1.setLayout(new BorderLayout(0, 0));

		JList list = new JList();
		panel_1.add(list, BorderLayout.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 262, SpringLayout.NORTH, panel);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		panel_5.add(textField_4);
		textField_4.setColumns(10);

		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);

		JButton btnNewButton = new JButton("New button");
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		panel_4.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		panel_4.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		panel_4.add(btnNewButton_3);
		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
