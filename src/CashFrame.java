import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class CashFrame extends JFrame {
    private NumberField amountField;
    private final int WIDTH = 700;
    private final int HEIGHT = 400;
    private final Dimension dimension = new Dimension(WIDTH, HEIGHT);
    private Bill bill = new Bill();
    private int table;

    public CashFrame() {
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

        OrderManager om = new OrderManager();
        om.load();
        JList list = new JList(om.getRegister().keySet().toArray());

        list.getSelectionModel().addListSelectionListener(e -> {
            int i = (list.getSelectedIndex()) + 1;
            String left;
            String s = Integer.toString(i);
            if (s.length() < 2) {
                left = s.substring(0, 1);
            } else {
                int f = s.length() - 1;
                left = s.substring(0, f);
            }
            this.table = Integer.parseInt(left);
            textArea.setText(" ");
            textArea.append(bill.preConto(table));

        });
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
        // textArea.append();
        ;

        buttonPanel.add(reciptButton);


        BackMenuButton menuButton = new BackMenuButton(CashFrame.this);
        sl_buttonPanel.putConstraint(SpringLayout.WEST, menuButton, 0, SpringLayout.WEST, amountField);
        sl_buttonPanel.putConstraint(SpringLayout.SOUTH, menuButton, -10, SpringLayout.SOUTH, buttonPanel);
        sl_buttonPanel.putConstraint(SpringLayout.EAST, menuButton, 0, SpringLayout.EAST, amountField);
        buttonPanel.add(menuButton);
        reciptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bill.getBill(amountField.getDouble());
            }

        });
        setMinimumSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
