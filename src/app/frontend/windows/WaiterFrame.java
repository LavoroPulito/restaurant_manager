package app.frontend.windows;

import app.frontend.components.BackMenuButton;
import app.frontend.components.NumberField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import app.backend.*;

/**
 * This class is the graphical interface of the Waiter, who manages the Orders: sends order to prepare and removes those delivered
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class WaiterFrame extends StandardFrame {

    /**
     * menu' to select order
     */
    private DishMenu menu;
    /**
     * preview register to take and manage orders from a table
     */
    private PreviewsRegister previewsRegister;

    /**
     * Order register about all table to place new orders and see what is ready
     */
    private OrderManager orderManager;

    /**
     * field to enter the table number from which to take orders
     */
    private NumberField numberField;

    /**
     * ist of orders to be delivered
     */
    private JList deliverList;

    /**
     * list menu'
     */
    private JList listMenu;

    /**
     * list preview orders
     */
    private JList listPreview;


/**
 * Dish menu
 */
    private DishMenu menu;

/**
 * Previews register
 */
    private PreviewsRegister previewsRegister;

/**
 * Order manager
 */
    private OrderManager orderManager;

/** 
*Field where you can write only numbers
*/
    private NumberField numberField;

/**
 * Opens a new window WaiterFrame, adds informations into components and sets the style
 */
    public WaiterFrame() {

        super("Waiter");
        init();
    }

    /**
     * initialize all component of the frame
     */
    private void init() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 0, 0, 0));

        menu = new DishMenu();
        menu.load();

        orderManager = new OrderManager();
        orderManager.load();

        previewsRegister = new PreviewsRegister();

        numberField = new NumberField();

        JPanel menùPanel = new JPanel();
        JScrollPane spMenu = new JScrollPane();
        panel.add(spMenu);
        spMenu.setRowHeaderView(spMenu.getVerticalScrollBar());
        spMenu.setViewportView(menùPanel);
        menùPanel.setLayout(new BorderLayout(0, 0));

        listMenu = new JList(menu.toArrayList().toArray());
        listMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showDish();
            }
        });


        menùPanel.add(listMenu, BorderLayout.CENTER);

        JPanel previewPanel = new JPanel();
        panel.add(previewPanel);
        previewPanel.setLayout(new BorderLayout(0, 0));

        JPanel quantityPanel = new JPanel();
        previewPanel.add(quantityPanel, BorderLayout.SOUTH);
        quantityPanel.setLayout(new GridLayout(1, 3, 0, 0));

        JButton subButton = new JButton("-");
        subButton.addActionListener(e -> {
            changeOrderQuantity('-');
        });
        quantityPanel.add(subButton);

        JButton addButton = new JButton("+");
        addButton.addActionListener(e -> {
            changeOrderQuantity('+');
        });
        quantityPanel.add(addButton);

        listPreview = new JList(previewsRegister.getPreviews().toArray());
        previewPanel.add(listPreview, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        panel.add(rightPanel);
        rightPanel.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel buttonPanel = new JPanel();
        rightPanel.add(buttonPanel);

        JLabel tableLabel = new JLabel("table:");
        buttonPanel.add(tableLabel);
        buttonPanel.add(numberField);

        JButton placeButton = new JButton("place orders");
        placeButton.addActionListener(e -> {
            placeOrder();
        });
        buttonPanel.add(placeButton);

        BackMenuButton menuButton = new BackMenuButton(WaiterFrame.this);
        buttonPanel.add(menuButton);

        JPanel checkBoxPanel = new JPanel();
        rightPanel.add(checkBoxPanel);
        checkBoxPanel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        checkBoxPanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);

        deliverList = new JList(orderManager.getOrdersToDeliver().toArray());
        scrollPane.setViewportView(deliverList);
        deliverList.addMouseListener(new MouseAdapter() {
            /**
             * Method that occours when a components is clicked
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseReleased(e);
                deliverOrder();
            }
        });
        subButton.addActionListener(new ActionListener() {
            /**Method that occours when there is an anction on a component
             * @param e event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listPreview.getSelectedValue() != null) {
                    OrderPreview selectedValue = (OrderPreview) listPreview.getSelectedValue();
                    previewsRegister.decrement(selectedValue);
                    listPreview.setListData(previewsRegister.getPreviews().toArray());
                    listPreview.setSelectedValue(selectedValue, true);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            /**Method that occours when there is an anction on a component
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listPreview.getSelectedValue() != null) {
                    OrderPreview selectedValue = (OrderPreview) listPreview.getSelectedValue();
                    previewsRegister.increment(selectedValue);
                    listPreview.setListData(previewsRegister.getPreviews().toArray());
                    listPreview.setSelectedValue(selectedValue, true);
                }
            }
        });

        placeButton.addActionListener(new ActionListener() {
            /**Method that occours when there is an anction on a component
             */
            public void actionPerformed(ActionEvent e) {
                if (!previewsRegister.getPreviews().isEmpty()) {
                    orderManager.add(previewsRegister.toOrders());
                    orderManager.save();
                    previewsRegister.clear();
                    listPreview.setListData(previewsRegister.getPreviews().toArray());
                }
            }
        });
        listMenu.addMouseListener(new MouseAdapter() {
            /**
            Method that occours when a components is clicked
            */
            @Override
            public void mouseReleased(MouseEvent e) {
                if (listMenu.getSelectedValue() != null) {
                    Dish dish = (Dish) listMenu.getSelectedValue();
                    if (numberField.getText().equals("")) {
                        JOptionPane.showMessageDialog(WaiterFrame.this,
                                "WARNING: Please select a table before adding orders", "warning",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (!dish.isAvailable()) {
                        JOptionPane.showMessageDialog(WaiterFrame.this, "This dish is not available", "not available", JOptionPane.WARNING_MESSAGE);
                    } else {

                        String note = JOptionPane.showInputDialog(WaiterFrame.this,
                                dish.getName() + '\n' + "category: " + dish.getCategory() + '\n' + "description: "
                                        + dish.getDescription() + '\n' + "price: " + dish.getPrice() + "€\n"
                                        + "note: ");
                        if (note != null) {
                            previewsRegister.addOrder(new OrderPreview(dish, numberField.getInt(), note));
                            listPreview.setListData(previewsRegister.getPreviews().toArray());
                        }

                    }
                }
            }
        });


    }

    /**
     * open a JOptionPane to see the dish info, add notes, add the dish to the order preview
     */
    private void showDish() {
        if (listMenu.getSelectedValue() != null) {
            Dish dish = (Dish) listMenu.getSelectedValue();
            if (numberField.getText().equals("")) {
                JOptionPane.showMessageDialog(WaiterFrame.this,
                        "WARNING: Please select a table before adding orders", "warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (!dish.isAvailable()) {
                JOptionPane.showMessageDialog(WaiterFrame.this, "This dish is not available", "not available", JOptionPane.WARNING_MESSAGE);
            } else {

                String note = JOptionPane.showInputDialog(WaiterFrame.this,
                        dish.getName() + '\n' + "category: " + dish.getCategory() + '\n' + "description: "
                                + dish.getDescription() + '\n' + "price: " + dish.getPrice() + "€\n"
                                + "note: ");
                if (note != null) {
                    previewsRegister.addOrder(new OrderPreview(dish, numberField.getInt(), note));
                    listPreview.setListData(previewsRegister.getPreviews().toArray());
                }

            }
        }
    }

    /**
     * adds orders in preview Register to order register
     */
    private void placeOrder() {
        if (!previewsRegister.getPreviews().isEmpty()) {
            orderManager.add(previewsRegister.toOrders());
            orderManager.save();
            previewsRegister.clear();
            listPreview.setListData(previewsRegister.getPreviews().toArray());
        }
    }

    /**
     * increment or decrement the quantity of the selected order by one unity
     * @param c char to chose if incremento or decrement
     */
    private void changeOrderQuantity(char c) {
        if (listPreview.getSelectedValue() != null) {
            OrderPreview selectedValue = (OrderPreview) listPreview.getSelectedValue();
            if (c == '-') {
                previewsRegister.decrement(selectedValue);
            } else if (c == '+') {
                previewsRegister.increment(selectedValue);
            }
            listPreview.setListData(previewsRegister.getPreviews().toArray());
            listPreview.setSelectedValue(selectedValue, true);
        }
    }

    /**
     * change the state of selected order to mark that it has been delivered
     */
    private void deliverOrder() {
        orderManager.setNextState((Order) deliverList.getSelectedValue());
        orderManager.save();
        deliverList.setListData(orderManager.getOrdersToDeliver().toArray());

    }
}
