import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private boolean openNew = false;
    final Dimension dimension = new Dimension(WIDTH, HEIGHT);
    private DishMenu menu;
    private PreviewsRegister previewsRegister;
    private JTextField tableField;
    public JFrame frame;
    private JTextField quantityField;

    public WaiterFrame() {

        super("Waiter");

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 0, 0, 0));

        menu = new DishMenu();
        menu.load();
        previewsRegister = new PreviewsRegister();

        tableField = new JTextField();
        tableField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c != KeyEvent.VK_PERIOD) {
                    e.consume(); // if it's not a number, ignore the event
                }
            }
        });
        tableField.setColumns(10);

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

        JButton lessButton = new JButton("-");
        quantityPanel.add(lessButton);

        quantityField = new JTextField();
        quantityPanel.add(quantityField);
        quantityField.setColumns(10);

        JButton moreButton = new JButton("+");
        quantityPanel.add(moreButton);

        JList listPreview = new JList(previewsRegister.getPreviews().toArray());
        previewPanel.add(listPreview, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        panel.add(rightPanel);
        rightPanel.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel buttonPanel = new JPanel();
        rightPanel.add(buttonPanel);

        JLabel tableLabel = new JLabel("table:");
        buttonPanel.add(tableLabel);
        buttonPanel.add(tableField);

        JButton placeButton = new JButton("place orders");
        placeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPanel.add(placeButton);

        JButton menuButton = new JButton("Back to main menu");
        menuButton.setBackground(Color.RED);
        menuButton.setOpaque(true);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
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
        int index = 0;
        for (Order order : orderManager.getOrdersToDeliver()) {
            String nome = order.getDishName();
            int tavolo = order.getTable();
            JCheckBox cb = new JCheckBox("" + tavolo + "- " + nome);

            pContainer.add(cb);

            // scrollPane.setViewportView(chckbxNewCheckBox);

        }
        listMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (listMenu.getSelectedValue() != null) {
                    if (tableField.getText().equals("")) {
                        JOptionPane.showMessageDialog(WaiterFrame.this, "WARNING: Please select a table before adding orders", "warning", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Dish dish = (Dish) listMenu.getSelectedValue();
                        String note = JOptionPane.showInputDialog(WaiterFrame.this,
                                dish.getName() + '\n' + "category: " + dish.getCategory() + '\n' + "description: "
                                        + dish.getDescription() + '\n' + "price: " + dish.getPrice() + "€\n" + "note: ");
                        if (note != null) {
                            previewsRegister.addOrder(new OrderPreview(dish, Integer.parseInt(tableField.getText()), note));
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
