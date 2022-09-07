package app.frontend.windows;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.backend.OrderManager;
import app.backend.Receipt;

import app.frontend.components.BackMenuButton;
import app.frontend.components.NumberField;

import javax.swing.*;

public class CashFrame extends StandardFrame {
    private NumberField amountField;

    private OrderManager orderManager;
    private Receipt receipt;

    public CashFrame() {
        super("Cash");
        orderManager = new OrderManager();
        orderManager.load();

        getContentPane().setLayout(new GridLayout(1, 3, 0, 0));

        JPanel textPanel = new JPanel();
        getContentPane().add(textPanel);
        textPanel.setLayout(new BorderLayout(0, 0));

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Andale Mono", Font.PLAIN, 12));
        textPanel.add(textArea);

        JButton titleButton = new JButton("change title");
        textPanel.add(titleButton, BorderLayout.SOUTH);

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
        reciptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        textArea.setText(receipt.getReciptText());
                        receipt.save();
                        orderManager.cleanTable((int) list.getSelectedValue());
                        orderManager.save();
                        list.setListData(orderManager.getRegister().keySet().toArray());

                    }
                }
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

        titleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTitle = JOptionPane.showInputDialog(CashFrame.this,
                        "insert new title:\n add '/n' to start a new line");
                if (newTitle != null) {
                    receipt.setTitle(newTitle);
                    textArea.setText(receipt.getReciptText());
                }

            }
        });


    }

}
