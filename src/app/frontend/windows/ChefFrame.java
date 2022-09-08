package app.frontend.windows;

import app.frontend.components.BackMenuButton;
import app.frontend.components.NumberField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

import app.backend.DishMenu;
import app.backend.Dish;
/**
 * This class is the graphical interface of the Chef, who manages the menu in the restaurant
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class ChefFrame extends StandardFrame {
/**
 * Object DishMenu, it's the restaurant's menu 
 */
    private DishMenu menu;

/**
 *Field where is written the description  
*/    
    private JTextField txtDescription;

/**
 *Field where is written the name's dish 
*/        
    private JTextField txtNameDish;

/**
 *Field where is written the price's dish 
*/     
    private NumberField price;

/**
 *Field where is written the category's dish 
*/     
    private JTextField txtCateg;

/**
 *Text area where is written the istruction for use the window
*/     
    private JTextArea textArea;

/**
 *
 * CheckBox that indicates if a plate is avaible or not, it can be changed
*/     
    private JCheckBox availableCkBx;

/**
 *Button that allow to add a new dish at the menu
*/     
    private JToggleButton add_new_dish;

/**
 *Dish's list  
*/    
    private JList list;

/**
 * Opens a window chef
 */
    public ChefFrame() {
        super("Chef");
        init();

    }

/**
 * initialize the components loading the informations into them and sets the layout 
 */
    public void init() {
        // Main panel
        JPanel background = new JPanel();
        getContentPane().add(background, BorderLayout.CENTER);
        SpringLayout sl_panel = new SpringLayout();
        background.setLayout(sl_panel);


        // menu' panel on the left
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout(0, 0));
        JScrollPane scrollPane = new JScrollPane();
        background.add(scrollPane);
        scrollPane.setRowHeaderView(scrollPane.getVerticalScrollBar());
        scrollPane.setViewportView(menuPanel);


        // settings panel with field for change attributes and button to manage the menù
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(2, 1, 0, 0));
        background.add(settingsPanel);

        sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, background);
        sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, background);
        sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, background);
        sl_panel.putConstraint(SpringLayout.EAST, scrollPane, -4, SpringLayout.WEST, settingsPanel);
        sl_panel.putConstraint(SpringLayout.WEST, settingsPanel, 147, SpringLayout.WEST, background);
        sl_panel.putConstraint(SpringLayout.EAST, settingsPanel, -10, SpringLayout.EAST, background);
        sl_panel.putConstraint(SpringLayout.NORTH, settingsPanel, 10, SpringLayout.NORTH, background);
        sl_panel.putConstraint(SpringLayout.SOUTH, settingsPanel, 0, SpringLayout.SOUTH, scrollPane);

        JPanel attributesPanel = new JPanel();
        attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.X_AXIS));
        settingsPanel.add(attributesPanel);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(0, 1, 0, 0));
        settingsPanel.add(controlPanel);



        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 0, 0));
        controlPanel.add(buttonPanel);

        JPanel sideFieldPanel = new JPanel();
        sideFieldPanel.setLayout(new GridLayout(0, 1, 0, 0));
        attributesPanel.add(sideFieldPanel);

        menu = new DishMenu();
        menu.load();

        list = new JList(menu.toArrayList().toArray());
        list.getSelectionModel().addListSelectionListener(e -> {
            setTextAreas();
        });
        menuPanel.add(list, BorderLayout.CENTER);

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

        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        controlPanel.add(textArea);



        add_new_dish = new JToggleButton("Add new dish: OFF");
        add_new_dish.setToolTipText("turn it on to add new dishes, turn it off to view or edit other dishes");
        add_new_dish.addItemListener(e -> {
            manageAddButton();
        });
        buttonPanel.add(add_new_dish);

        BackMenuButton menuButton = new BackMenuButton(ChefFrame.this);
        buttonPanel.add(menuButton);

        JButton save_menu = new JButton("Save menù");
        save_menu.setToolTipText("click here to save your changes, \nif you close this screen without saving your changes they will be lost");
        buttonPanel.add(save_menu);
        save_menu.addActionListener(e->{
                saveProtocol();
        });

        JButton remove_dish = new JButton("Remove dish");
        buttonPanel.add(remove_dish);
        remove_dish.setToolTipText("select a dish and click here to remove, then click save");
        remove_dish.addActionListener(e -> {
                removeProtocol();

        });

        resetInput();

    }
/**
 * Resets the text in the fields and write the istructions to use the window
 */
    private void resetInput() {
        list.clearSelection();
        txtNameDish.setText("Name");
        price.setText("Price");
        txtCateg.setText("Category");
        txtDescription.setText("Description");
        availableCkBx.setSelected(true);
        textArea.setText("select a dish to view its attributes or to modify it.\n"
                + "use the button to modify the menu.\n" + "remember to save or your changes will be lost");

    }

    /**
     * If there is a Dish selected its informations will be write in the fields
     */
    private void setTextAreas() {
        add_new_dish.setSelected(false);
        textArea.setText("select a dish to view its attributes or to modify it.\n"
                + "use the keys to modify the menu.\n" + "remember to save or your changes will be lost");
        Dish dish = (Dish) list.getSelectedValue();
        if (dish != null) {
            txtNameDish.setText(dish.getName());
            price.setText("" + dish.getPrice());
            txtCateg.setText(dish.getCategory());
            availableCkBx.setSelected(dish.isAvailable());
            txtDescription.setText(dish.getDescription());
        }
    }
/**
 * Manages the button add dish
 */
    private void manageAddButton() {
        if (add_new_dish.isSelected()) {
            add_new_dish.setText("add new dish: ON");
            resetInput();
            textArea.setText("fill in the fields to create a new dish." + "\nclick on save menu to save the changes");
        } else {
            add_new_dish.setText("add new dish: OFF");
            textArea.setText("select a dish to view its attributes or to modify it.\n"
                    + "use the keys to modify the menu.\n" + "remember to save or your changes will be lost");

        }
    }
/**
 * Saves the menu
 */
    private void saveProtocol(){
        if (price.isDouble()) { // if price.getText has no alphabetic characters
            if (!add_new_dish.isSelected()) { // if we are not adding a new dish
                menu.removeDish((Dish) list.getSelectedValue());

            }
            menu.add(new Dish(txtNameDish.getText(), price.getDouble(),
                    txtDescription.getText(), txtCateg.getText(), availableCkBx.isSelected()));
        }

        add_new_dish.setSelected(false);
        textArea.setText("select a dish to view its attributes or to modify it.\n"
                + "use the keys to modify the menu.\n" + "remember to save or your changes will be lost");
        menu.save();
        menu.load();
        list.setListData(menu.toArrayList().toArray());
        resetInput();
    }
/**
 * Removes a dish from the menu
 */
    private void removeProtocol(){
        if (list.getSelectedValue() != null) {
            menu.removeDish((Dish) list.getSelectedValue());
            resetInput();
        }
    }

}


