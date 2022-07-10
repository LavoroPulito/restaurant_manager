import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class WaiterFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    final int WIDTH = 700;
    final int HEIGHT = 400;
    final Dimension dimension = new Dimension(WIDTH, HEIGHT);
    private DishMenu menu;
    private PreviewsRegister previewsRegister;
    private OrderManager orderManager;
    private NumberField numberField;
    public JFrame frame;


    public WaiterFrame() {

        super("Waiter");

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

        JList listMenu = new JList(menu.toArrayList().toArray());

        menùPanel.add(listMenu, BorderLayout.CENTER);

        JPanel previewPanel = new JPanel();
        panel.add(previewPanel);
        previewPanel.setLayout(new BorderLayout(0, 0));

        JPanel quantityPanel = new JPanel();
        previewPanel.add(quantityPanel, BorderLayout.SOUTH);
        quantityPanel.setLayout(new GridLayout(1, 3, 0, 0));

        JButton subButton = new JButton("-");
        quantityPanel.add(subButton);

        JButton addButton = new JButton("+");
        quantityPanel.add(addButton);

        JList listPreview = new JList(previewsRegister.getPreviews().toArray());
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
        buttonPanel.add(placeButton);

        BackMenuButton menuButton = new BackMenuButton(WaiterFrame.this);
        buttonPanel.add(menuButton);

        JPanel checkBoxPanel = new JPanel();
        rightPanel.add(checkBoxPanel);
        checkBoxPanel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        checkBoxPanel.add(scrollPane, BorderLayout.CENTER);
        JPanel pContainer = new JPanel();
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);
        pContainer.setLayout(new BoxLayout(pContainer, BoxLayout.PAGE_AXIS));
        scrollPane.setViewportView(pContainer);
        OrderManager orderManager = new OrderManager();
        orderManager.load();
        for (Order order : orderManager.getOrdersToDeliver()) {
            String nome = order.getDishName();
            int tavolo = order.getTable();
            JCheckBox cb = new JCheckBox("" + tavolo + "- " + nome);

            pContainer.add(cb);

            // scrollPane.setViewportView(chckbxNewCheckBox);

        }


        subButton.addActionListener(new ActionListener() {
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
            public void actionPerformed(ActionEvent e) {
                orderManager.add(previewsRegister.toOrders());
                orderManager.save();
                previewsRegister.clear();
                listPreview.setListData(previewsRegister.getPreviews().toArray());
            }
        });
        listMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (listMenu.getSelectedValue() != null) {
                    if (numberField.getText().equals("")) {
                        JOptionPane.showMessageDialog(WaiterFrame.this, "WARNING: Please select a table before adding orders", "warning", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Dish dish = (Dish) listMenu.getSelectedValue();
                        String note = JOptionPane.showInputDialog(WaiterFrame.this,
                                dish.getName() + '\n' + "category: " + dish.getCategory() + '\n' + "description: "
                                        + dish.getDescription() + '\n' + "price: " + dish.getPrice() + "€\n" + "note: ");
                        if (note != null) {
                            previewsRegister.addOrder(new OrderPreview(dish, numberField.getInt(), note));
                            listPreview.setListData(previewsRegister.getPreviews().toArray());
                        }


                    }
                }
            }
        });

        setMinimumSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
