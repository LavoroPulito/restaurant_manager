package app.frontend.windows;

import app.frontend.components.BackMenuButton;
import app.frontend.components.BackgroundPanel;
import app.frontend.components.NumberField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import app.backend.*;

/**
 * This class is the graphical interface of the Waiter, who manages the Orders: sends order to prepare and removes those delivered
 *
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class WaiterFrame extends StandardFrame {

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
     * list of orders to be delivered
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
     * Opens a new window WaiterFrame, adds information into components and sets the style
     */
    public WaiterFrame() {

        super("Waiter");
        init();
    }

    /**
     * initialize all component of the frame
     */
    private void init() {
        BackgroundPanel panel = new BackgroundPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 0, 0, 0));


        DishMenu menu = new DishMenu();
        menu.load();

        orderManager = new OrderManager();
        orderManager.load();

        previewsRegister = new PreviewsRegister();

        numberField = new NumberField();

        JPanel menuPanel = new JPanel();
        JScrollPane spMenu = new JScrollPane();
        panel.add(spMenu);
        spMenu.setRowHeaderView(spMenu.getVerticalScrollBar());
        spMenu.setViewportView(menuPanel);
        menuPanel.setLayout(new BorderLayout(0, 0));

        listMenu = new JList(menu.toArrayList().toArray());
        listMenu.setFont(new Font("Verdana", 0, 18));
        listMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showDish();
            }
        });


        menuPanel.add(listMenu, BorderLayout.CENTER);

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

        JScrollPane spPreview = new JScrollPane();
        listPreview = new JList(previewsRegister.getPreviews().toArray());
        previewPanel.add(spPreview, BorderLayout.CENTER);
        spPreview.setRowHeaderView(spPreview.getVerticalScrollBar());
        spPreview.setViewportView(listPreview);

        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        panel.add(rightPanel);
        rightPanel.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        SpringLayout springLayout = new SpringLayout();
        buttonPanel.setLayout(springLayout);
        rightPanel.add(buttonPanel);

        JLabel tableLabel = new JLabel("table:");
        tableLabel.setForeground(new java.awt.Color(0, 90, 0));
        tableLabel.setFont(new Font("Chalkboard SE", Font.BOLD, 24));
        numberField.setFont(new Font("Chalkboard SE", Font.ITALIC, 24));

        JButton placeButton = new JButton("Place orders");
        placeButton.setForeground(new java.awt.Color(0, 90, 0));
        placeButton.setFont(new Font("Chalkboard SE", Font.BOLD, 24));
        placeButton.addActionListener(e -> {
            placeOrder();
        });

        BackMenuButton menuButton = new BackMenuButton(WaiterFrame.this);

        springLayout.putConstraint(SpringLayout.WEST, tableLabel, 0, SpringLayout.WEST, buttonPanel);
        springLayout.putConstraint(SpringLayout.NORTH, tableLabel, 0, SpringLayout.NORTH, buttonPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, tableLabel, 0, SpringLayout.SOUTH, numberField);
        springLayout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.EAST, tableLabel);
        springLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, buttonPanel);
        springLayout.putConstraint(SpringLayout.NORTH, numberField, 0, SpringLayout.NORTH, buttonPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, numberField, 50, SpringLayout.NORTH, buttonPanel);
        springLayout.putConstraint(SpringLayout.NORTH, placeButton, (getContentPane().getHeight() / 4) - 25, SpringLayout.NORTH, buttonPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, placeButton, (getContentPane().getHeight() / 4) + 25, SpringLayout.NORTH, buttonPanel);
        springLayout.putConstraint(SpringLayout.WEST, placeButton, 10, SpringLayout.WEST, buttonPanel);
        springLayout.putConstraint(SpringLayout.EAST, placeButton, -10, SpringLayout.EAST, buttonPanel);
        springLayout.putConstraint(SpringLayout.NORTH, menuButton, -60, SpringLayout.SOUTH, buttonPanel);
        springLayout.putConstraint(SpringLayout.WEST, menuButton, 10, SpringLayout.WEST, buttonPanel);
        springLayout.putConstraint(SpringLayout.EAST, menuButton, -10, SpringLayout.EAST, buttonPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, menuButton, -10, SpringLayout.SOUTH, buttonPanel);

        buttonPanel.add(tableLabel);
        buttonPanel.add(numberField);
        buttonPanel.add(placeButton);
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
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseReleased(e);
                deliverOrder();
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
     *
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
        if (!deliverList.isSelectionEmpty()) {
            orderManager.setNextState((Order) deliverList.getSelectedValue());
            orderManager.save();
            deliverList.setListData(orderManager.getOrdersToDeliver().toArray());

        }
    }
}
