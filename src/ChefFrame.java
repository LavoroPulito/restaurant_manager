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
	private JCheckBox availableCkBx = new JCheckBox("available");
	final int WIDTH = 700;
	final int HEIGHT = 400;
	final Dimension dimension = new Dimension(WIDTH, HEIGHT);

	public ChefFrame() {
		super("Chef");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JPanel menuPanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, menuPanel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, menuPanel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, menuPanel, -10, SpringLayout.SOUTH, panel);
		panel.add(menuPanel);

		JPanel settingsPanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.EAST, menuPanel, -4, SpringLayout.WEST, settingsPanel);
		sl_panel.putConstraint(SpringLayout.WEST, settingsPanel, 147, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, settingsPanel, 0, SpringLayout.SOUTH, menuPanel);
		sl_panel.putConstraint(SpringLayout.EAST, settingsPanel, -10, SpringLayout.EAST, panel);
		menuPanel.setLayout(new BorderLayout(0, 0));

		DishMenu menu = new DishMenu();
		menu.load();
		JList list = new JList(menu.toArrayList().toArray());
		list.getSelectionModel().addListSelectionListener(e -> {

			inCreation = false;
			Dish dish = (Dish) list.getSelectedValue();
			if (dish != null) {
				txtNameDish.setText(dish.getName());
				txtPrice.setText("" + dish.getPrice());
				txtCateg.setText(dish.getCategory());
				availableCkBx.setSelected(dish.isAvailable());
				txtDescription.setText(dish.getDescription());
			}
		});

		menuPanel.add(list, BorderLayout.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, settingsPanel, 10, SpringLayout.NORTH, panel);
		panel.add(settingsPanel);
		settingsPanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel attributesPanel = new JPanel();
		settingsPanel.add(attributesPanel);
		attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.X_AXIS));

		JPanel sideFieldPanel = new JPanel();
		attributesPanel.add(sideFieldPanel);
		sideFieldPanel.setLayout(new GridLayout(0, 1, 0, 0));

		txtNameDish = new JTextField();
		sideFieldPanel.add(txtNameDish);
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
		sideFieldPanel.add(txtPrice);
		txtPrice.setColumns(10);

		txtCateg = new JTextField();
		sideFieldPanel.add(txtCateg);
		txtCateg.setColumns(10);

		sideFieldPanel.add(availableCkBx);

		txtDescription = new JTextField();
		attributesPanel.add(txtDescription);
		txtDescription.setColumns(10);

		JPanel controlPanel = new JPanel();
		settingsPanel.add(controlPanel);
		initInput();
		SpringLayout sl_controlPanel = new SpringLayout();
		sl_controlPanel.putConstraint(SpringLayout.NORTH, textArea, 98, SpringLayout.NORTH, controlPanel);
		sl_controlPanel.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, controlPanel);
		sl_controlPanel.putConstraint(SpringLayout.SOUTH, textArea, 176, SpringLayout.NORTH, controlPanel);
		sl_controlPanel.putConstraint(SpringLayout.EAST, textArea, 543, SpringLayout.WEST, controlPanel);
		controlPanel.setLayout(sl_controlPanel);

		JPanel buttonPanel = new JPanel();
		sl_controlPanel.putConstraint(SpringLayout.NORTH, buttonPanel, 0, SpringLayout.NORTH, controlPanel);
		sl_controlPanel.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, controlPanel);
		sl_controlPanel.putConstraint(SpringLayout.SOUTH, buttonPanel, -84, SpringLayout.SOUTH, controlPanel);
		sl_controlPanel.putConstraint(SpringLayout.EAST, buttonPanel, 543, SpringLayout.WEST, controlPanel);
		controlPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(2, 2, 0, 0));

		JButton save_menu = new JButton("Save menù");
		buttonPanel.add(save_menu);
		save_menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (inCreation) { // se ho premuto Add dish
					menu.add(new Dish(txtNameDish.getText(), Double.parseDouble(txtPrice.getText()),
							txtDescription.getText(), txtCateg.getText()));
					inCreation = false;
				} else {
					if (list.getSelectedValue() != null) {
						Dish selected = (Dish) list.getSelectedValue();

						if (menu.removeDish(selected)) {
							menu.add(new Dish(txtNameDish.getText(), Double.parseDouble(txtPrice.getText()),
									txtDescription.getText(), txtCateg.getText()));
						}
					}
				}
				menu.save();
				menu.load();
				list.setListData(menu.toArrayList().toArray());
			}
		});

		JButton remove_dish = new JButton("Remove dish");
		buttonPanel.add(remove_dish);
		remove_dish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() != null) {
					menu.removeDish((Dish) list.getSelectedValue());

				}
			}
		});

		JButton add_new_dish = new JButton("Add new dish");
		buttonPanel.add(add_new_dish);

		JButton mainMenu = new JButton("Back to main menù");
		buttonPanel.add(mainMenu);
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add_new_dish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inCreation = true;
				list.clearSelection();
				initInput();
			}
		});

		controlPanel.add(textArea);

		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void initInput() {
		txtNameDish.setText("Name");
		txtPrice.setText("Price");
		txtCateg.setText("category");
		txtDescription.setText("Description");
		availableCkBx.setSelected(true);
		textArea.setText("select a dish to view its attributes or to modify it.\n"
				+ "use the keys to modify the menu.\n" + "remember to save or your changes will be lost");

	}

}
