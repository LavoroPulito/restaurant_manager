import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ChefFrame extends JFrame {
	private boolean inCreation = false;
	private JTextField txtDescription;
	private JTextField txtNameDish;
	private JTextField txtPrice;
	private JTextField txtCateg;
	private JTextArea textArea = new JTextArea();
	private JCheckBox chckbxNewCheckBox = new JCheckBox("available");
	final int WIDTH = 700;
	final int HEIGHT = 400;
	final Dimension dimension = new Dimension(WIDTH, HEIGHT);

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
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -4, SpringLayout.WEST, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 147, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 0, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		panel_1.setLayout(new BorderLayout(0, 0));

		DishMenu menu = new DishMenu();
		menu.load();
		JList list = new JList(menu.toArrayList().toArray());
		list.getSelectionModel().addListSelectionListener(e -> {

			Dish dish = (Dish) list.getSelectedValue();
			if (dish != null) {
				txtNameDish.setText(dish.getName());
				txtPrice.setText("" + dish.getPrice());
				txtCateg.setText(dish.getCategory());
				chckbxNewCheckBox.setSelected(dish.isAvailable());
				txtDescription.setText(dish.getDescription());
			}
		});

		panel_1.add(list, BorderLayout.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		txtNameDish = new JTextField();
		panel_5.add(txtNameDish);
		txtNameDish.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c != KeyEvent.VK_PERIOD) {
					e.consume(); // if it's not a number, ignore the event
				}
			}
		});
		panel_5.add(txtPrice);
		txtPrice.setColumns(10);

		txtCateg = new JTextField();
		panel_5.add(txtCateg);
		txtCateg.setColumns(10);

		panel_5.add(chckbxNewCheckBox);

		txtDescription = new JTextField();
		panel_3.add(txtDescription);
		txtDescription.setColumns(10);

		JPanel controlPanel = new JPanel();
		panel_2.add(controlPanel);
		controlPanel.setLayout(new BorderLayout(0, 0));
		initInput();

		JPanel buttonPanel = new JPanel();
		controlPanel.add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		JButton save_menu = new JButton("Save menù");
		buttonPanel.add(save_menu);

		JButton mainMenu = new JButton("Back to main menù");
		buttonPanel.add(mainMenu);
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton remove_dish = new JButton("Remove dish");
		buttonPanel.add(remove_dish);

		JButton add_new_dish = new JButton("Add new dish");
		buttonPanel.add(add_new_dish);
		add_new_dish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inCreation = true;
				list.clearSelection();
				initInput();
			}
		});

		controlPanel.add(textArea, BorderLayout.CENTER);

		save_menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (inCreation) {
					menu.add(new Dish(txtNameDish.getText(), Double.parseDouble(txtPrice.getText()),
							txtDescription.getText(), txtCateg.getText()));
					inCreation = false;
				}
				menu.save();
				menu.load();
				list.setListData(menu.toArrayList().toArray());
			}
		});
		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void initInput() {
		txtNameDish.setText("Name");
		txtPrice.setText("Price");
		txtCateg.setText("category");
		txtDescription.setText("Description");
		chckbxNewCheckBox.setSelected(true);
		textArea.setText(
				"select a dish to view its attributes or to modify it.\n" + "use the keys to modify the menu.");

	}

}
