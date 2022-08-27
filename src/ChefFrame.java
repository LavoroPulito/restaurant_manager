import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;

public class ChefFrame extends JFrame {

    private DishMenu menu;
    private JTextField txtDescription;
    private JTextField txtNameDish;
    private NumberField price;
    private JTextField txtCateg;
    private JTextArea textArea = new JTextArea();
    private JCheckBox availableCkBx;
    private JToggleButton add_new_dish = new JToggleButton("Add new dish: OFF");
    final int WIDTH = 700;
    final int HEIGHT = 400;
    final Dimension dimension = new Dimension(WIDTH, HEIGHT);

    public ChefFrame() {
        super("Chef");
        init();

        setMinimumSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public void init() {

        // Main panel
        JPanel background = new JPanel();
        getContentPane().add(background, BorderLayout.CENTER);
        SpringLayout sl_panel = new SpringLayout();
        background.setLayout(sl_panel);

        // menu' panel on the left
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout(0, 0));
        background.add(menuPanel);

        // settings panel with field for change attributes and button to manage the menù
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(2, 1, 0, 0));
        background.add(settingsPanel);

        sl_panel.putConstraint(SpringLayout.NORTH, menuPanel, 10, SpringLayout.NORTH, background);
        sl_panel.putConstraint(SpringLayout.WEST, menuPanel, 10, SpringLayout.WEST, background);
        sl_panel.putConstraint(SpringLayout.SOUTH, menuPanel, -10, SpringLayout.SOUTH, background);
        sl_panel.putConstraint(SpringLayout.EAST, menuPanel, -4, SpringLayout.WEST, settingsPanel);
        sl_panel.putConstraint(SpringLayout.WEST, settingsPanel, 147, SpringLayout.WEST, background);
        sl_panel.putConstraint(SpringLayout.EAST, settingsPanel, -10, SpringLayout.EAST, background);
        sl_panel.putConstraint(SpringLayout.NORTH, settingsPanel, 10, SpringLayout.NORTH, background);
        sl_panel.putConstraint(SpringLayout.SOUTH, settingsPanel, 0, SpringLayout.SOUTH, menuPanel);

        menu = new DishMenu();
        menu.load();

        JList list = new JList(menu.toArrayList().toArray());
        menuPanel.add(list, BorderLayout.CENTER);

        JPanel attributesPanel = new JPanel();
        attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.X_AXIS));
        settingsPanel.add(attributesPanel);

        JPanel sideFieldPanel = new JPanel();
        sideFieldPanel.setLayout(new GridLayout(0, 1, 0, 0));
        attributesPanel.add(sideFieldPanel);

        txtNameDish = new JTextField();
        txtNameDish.setColumns(10);
        sideFieldPanel.add(txtNameDish);

        price = new NumberField();
        sideFieldPanel.add(price);

        txtCateg = new JTextField();
        txtCateg.setColumns(10);
        sideFieldPanel.add(txtCateg);

        availableCkBx = new JCheckBox("available");
        sideFieldPanel.add(availableCkBx);

        txtDescription = new JTextField();
        txtDescription.setColumns(10);
        attributesPanel.add(txtDescription);


        JPanel controlPanel = new JPanel();
        settingsPanel.add(controlPanel);
        resetInput();
        controlPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel buttonPanel = new JPanel();
        controlPanel.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(2, 2, 0, 0));
        add_new_dish.setToolTipText("turn it on to add new dishes, turn it off to view or edit other dishes");
        buttonPanel.add(add_new_dish);

        BackMenuButton menuButton = new BackMenuButton(ChefFrame.this);
        buttonPanel.add(menuButton);

        textArea.setWrapStyleWord(true);
        controlPanel.add(textArea);
        JButton save_menu = new JButton("Save menù");
        buttonPanel.add(save_menu);
        save_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (list.getSelectedValue() != null) { // if a value has been selected
                    Dish selected = (Dish) list.getSelectedValue(); //take selected object
                    if (!add_new_dish.isSelected()) { // the selected dish is removed from the menu to be
                        menu.removeDish(selected);
                    } else {
                        if (menu.getDish(txtNameDish.getText()) != null) {
                            return;
                        }
                    }
                    menu.add(new Dish(txtNameDish.getText(), price.getDouble(),
                            txtDescription.getText(), txtCateg.getText(), availableCkBx.isSelected()));
                }
                add_new_dish.setSelected(false);
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
                    list.clearSelection();
                }
            }
        });

        add_new_dish.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (add_new_dish.isSelected()) {
                    add_new_dish.setText("add new dish: ON");
                } else {
                    add_new_dish.setText("add new dish: OFF");
                }
            }
        });

        list.getSelectionModel().addListSelectionListener(e -> {

            add_new_dish.setSelected(false);
            Dish dish = (Dish) list.getSelectedValue();
            if (dish != null) {
                txtNameDish.setText(dish.getName());
                price.setText("" + dish.getPrice());
                txtCateg.setText(dish.getCategory());
                availableCkBx.setSelected(dish.isAvailable());
                txtDescription.setText(dish.getDescription());
            }
        });


    }

    public void resetInput() {
        txtNameDish.setText("Name");
        price.setText("Price");
        txtCateg.setText("category");
        txtDescription.setText("Description");
        availableCkBx.setSelected(true);
        textArea.setText("select a dish to view its attributes or to modify it.\n"
                + "use the keys to modify the menu.\n" + "remember to save or your changes will be lost");

    }
}
