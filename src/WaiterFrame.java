import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class WaiterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	final int WIDTH = 700;
	final int HEIGHT = 400;
	final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	DishMenu menu = new DishMenu();
	private JTextField txtSelezionaIlTavolo;
	public JFrame frame;
	private JTextField textField;

	public WaiterFrame() {

		super("Waiter");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JList list = new JList();
		panel_1.add(list, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1, 3, 0, 0));

		JButton btnNewButton_2 = new JButton("New button");
		panel_6.add(btnNewButton_2);

		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_3 = new JButton("New button");
		panel_6.add(btnNewButton_3);

		JList list_1 = new JList();
		panel_2.add(list_1, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		txtSelezionaIlTavolo = new JTextField();
		txtSelezionaIlTavolo.setText("Select a table");
		panel_4.add(txtSelezionaIlTavolo);
		txtSelezionaIlTavolo.setColumns(10);

		JButton btnNewButton = new JButton("place orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back to main menu");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton_1);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		scrollPane.setViewportView(chckbxNewCheckBox);
		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
