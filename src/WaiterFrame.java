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
	private JTextField quantityField;

	public WaiterFrame() {

		super("Waiter");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel menùPanel = new JPanel();
		panel.add(menùPanel);
		menùPanel.setLayout(new BorderLayout(0, 0));

		JList listMenu = new JList();
		menùPanel.add(listMenu, BorderLayout.CENTER);

		JPanel previewPanel = new JPanel();
		panel.add(previewPanel);
		previewPanel.setLayout(new BorderLayout(0, 0));

		JPanel quantityPanel = new JPanel();
		previewPanel.add(quantityPanel, BorderLayout.SOUTH);
		quantityPanel.setLayout(new GridLayout(1, 3, 0, 0));

		JButton lessButton = new JButton("-");
		quantityPanel.add(lessButton);

		quantityField = new JTextField();
		quantityPanel.add(quantityField);
		quantityField.setColumns(10);

		JButton moreButton = new JButton("+");
		quantityPanel.add(moreButton);

		JList listPreview = new JList();
		previewPanel.add(listPreview, BorderLayout.CENTER);

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
