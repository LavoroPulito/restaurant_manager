package app.frontend.windows;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import app.backend.OrderManager;
import app.backend.Receipt;

import app.frontend.components.BackMenuButton;
import app.frontend.components.BackgroundPanel;
import app.frontend.components.NumberField;

import javax.swing.*;

/**
 * This class is the graphical interface of the Cash desk, who manages the receipts and the payments
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */

public class CashFrame extends StandardFrame {
    /**
     * field to enter the amount
     */
    private NumberField amountField;

    /**
     * list of the table
     */
    private JList list;

    /**
     * area in which to write the receipt
     */
    private JTextArea textArea;


    private OrderManager orderManager;


    private Receipt receipt;

    /**
     * create a new CashFrame
     */
    public CashFrame() {
        super("Cash");
        init();
    }

    /**
     * initializes the frame components
     */
    private void init() {
        orderManager = new OrderManager();
        orderManager.load();
        list = new JList(orderManager.getRegister().keySet().toArray());
        list.getSelectionModel().addListSelectionListener(e -> {
            showReceipt();
        });

        BackgroundPanel background = new BackgroundPanel();
        background.setLayout(new GridLayout(1, 3, 0, 0));
        getContentPane().add(background);
        //panel for text (on the left)
        JPanel textPanel = new JPanel();
        background.add(textPanel);
        textPanel.setLayout(new BorderLayout(0, 0));

        textArea = new JTextArea();
        textArea.setFont(new Font("Andale Mono", Font.PLAIN, 15));
        textPanel.add(textArea);

        //button to set the title
        JButton titleButton = new JButton("change title");
        titleButton.addActionListener(e -> {
            setTitle();
        });
        textPanel.add(titleButton, BorderLayout.SOUTH);

        //panel for the list of table (in the center)
        JPanel tablesPanel = new JPanel();
        background.add(tablesPanel);
        tablesPanel.setLayout(new BorderLayout(0, 0));
        tablesPanel.add(list, BorderLayout.CENTER);

        //panel for buttons and field (on the right)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        //layout of buttonPanel
        SpringLayout sl_buttonPanel = new SpringLayout();
        buttonPanel.setLayout(sl_buttonPanel);
        background.add(buttonPanel);

        JLabel tableLabel = new JLabel("Amount:");
        tableLabel.setForeground(new java.awt.Color(0, 90, 0));
        tableLabel.setFont(new Font("Chalkboard SE", Font.BOLD, 24));

        JButton receiptButton = new JButton("print receipt");
        receiptButton.setForeground(new java.awt.Color(0, 90, 0));
        receiptButton.setFont(new Font("Chalkboard SE", Font.BOLD, 24));
        receiptButton.addActionListener(e -> {
            printReceipt();
        });
        BackMenuButton menuButton = new BackMenuButton(CashFrame.this);
        amountField = new NumberField();

        sl_buttonPanel.putConstraint(SpringLayout.WEST, tableLabel, 10, SpringLayout.WEST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, tableLabel, 0, SpringLayout.NORTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, tableLabel, 60, SpringLayout.NORTH, buttonPanel);

        sl_buttonPanel.putConstraint(SpringLayout.WEST, receiptButton, 10, SpringLayout.WEST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, receiptButton, -10, SpringLayout.EAST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, receiptButton, 0, SpringLayout.SOUTH, amountField);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, receiptButton, 50, SpringLayout.SOUTH, tableLabel);

        sl_buttonPanel.putConstraint(SpringLayout.WEST, amountField, 0, SpringLayout.EAST, tableLabel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, amountField, 0, SpringLayout.EAST, receiptButton);
        sl_buttonPanel.putConstraint(SpringLayout.NORTH, amountField, 10, SpringLayout.NORTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, amountField, 60, SpringLayout.NORTH, buttonPanel);

        sl_buttonPanel.putConstraint(SpringLayout.NORTH, menuButton, -60, SpringLayout.SOUTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, menuButton, 10, SpringLayout.WEST, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, menuButton, -10, SpringLayout.SOUTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, menuButton, -10, SpringLayout.EAST, buttonPanel);
        buttonPanel.add(tableLabel);
        buttonPanel.add(menuButton);
        buttonPanel.add(amountField);
        buttonPanel.add(receiptButton);
    }

    /**
     * shows in the text area the receipt corresponding to the selected table
     */
    private void showReceipt() {
        if (list.getSelectedValue() != null) {
            amountField.setText("");
            receipt = new Receipt();
            receipt.addOrders(orderManager.getRegister().get((int) list.getSelectedValue()));
            receipt.writeReceipt();
            textArea.setText(receipt.getReceiptText());
        }
    }

    /**
     * shows the complete receipt on the screen and saves it as txt.
     * checks that the amount is entered and that it covers the total
     */
    private void printReceipt() {
        if (amountField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(CashFrame.this, "WARNING: insert amount before", "warning",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (list.getSelectedValue() != null) {
            if (amountField.getDouble() <= receipt.getTotal()) {
                JOptionPane.showMessageDialog(CashFrame.this, "WARNING: the amount is not enough", "warning",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                receipt.enterAmount(amountField.getDouble());
                receipt.writeEndReceipt();
                textArea.setText(receipt.getReceiptText());
                receipt.save();
                orderManager.cleanTable((int) list.getSelectedValue());
                orderManager.save();
                list.setListData(orderManager.getRegister().keySet().toArray());

            }
        }
    }

    /**
     * set the new head of the receipt
     */
    private void setTitle() {
        String newTitle = JOptionPane.showInputDialog(CashFrame.this,
                "insert new title:\n add '/n' to start a new line");
        if (newTitle != null) {
            receipt.setTitle(newTitle);
            textArea.setText(receipt.getReceiptText());
        }
    }

}
