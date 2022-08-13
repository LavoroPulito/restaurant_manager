import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CashFrame extends JFrame {
    private NumberField amountField;
    private final int WIDTH = 700;
    private final int HEIGHT = 400;
    private final Dimension dimension = new Dimension(WIDTH, HEIGHT);
    private OrderManager orderManager;
    private Receipt receipt;


    public CashFrame() {
        orderManager = new OrderManager();
        orderManager.load();
        setTitle("cash desk");
        getContentPane().setLayout(new GridLayout(1, 3, 0, 0));

        JPanel textPanel = new JPanel();
        getContentPane().add(textPanel);
        textPanel.setLayout(new BorderLayout(0, 0));

        JTextArea textArea = new JTextArea();
        textPanel.add(textArea);

        JPanel tablesPanel = new JPanel();
        getContentPane().add(tablesPanel);
        tablesPanel.setLayout(new BorderLayout(0, 0));


        JList list = new JList(orderManager.getRegister().keySet().toArray());

        tablesPanel.add(list, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        SpringLayout sl_buttonPanel = new SpringLayout();
        buttonPanel.setLayout(sl_buttonPanel);
        getContentPane().add(buttonPanel);

        JButton reciptButton = new JButton("print receipt");
        sl_buttonPanel.putConstraint(SpringLayout.WEST, reciptButton, 10, SpringLayout.WEST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, reciptButton, -10, SpringLayout.EAST, buttonPanel);

        amountField = new NumberField();
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, reciptButton, 6, SpringLayout.SOUTH, amountField);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, amountField, 0, SpringLayout.WEST, reciptButton);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, amountField, 0, SpringLayout.EAST, reciptButton);
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, amountField, 0, SpringLayout.NORTH, buttonPanel);
        amountField.setText("enter amount received");
        buttonPanel.add(amountField);
        ;

        buttonPanel.add(reciptButton);


        BackMenuButton menuButton = new BackMenuButton(CashFrame.this);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, menuButton, 0, SpringLayout.WEST, amountField);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, menuButton, -10, SpringLayout.SOUTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, menuButton, 0, SpringLayout.EAST, amountField);
        buttonPanel.add(menuButton);
        reciptButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (list.getSelectedValue()!= null) {

                    receipt.enterAmount(amountField.getDouble());
                    receipt.writeEndRecipit();
                    textArea.setText(receipt.getReciptText());
                    receipt.save();
                    orderManager.cleanTable((int) list.getSelectedValue());
                    orderManager.save();
                    list.setListData(orderManager.getRegister().keySet().toArray());

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        list.getSelectionModel().addListSelectionListener(e -> {
            if (list.getSelectedValue() != null) {
                amountField.setText("");
                receipt = new Receipt();
                receipt.addOrders(orderManager.getRegister().get((int) list.getSelectedValue()));
                receipt.writeRecipt();
                textArea.setText(receipt.getReciptText());
            }

        });
        setMinimumSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
