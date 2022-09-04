package app.frontend.window;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import app.frontend.components.BackgroundPanel;

public class MainMenu2 extends StandardFrame {
    private JLabel titleLabel;
    private JButton chefButton;
    private JButton cookButton;
    private JButton cashButton;
    private JButton waiterButton;

    private int space = getContentPane().getWidth() / 25;

    public MainMenu2() {
        super("Main Menù");
        getContentPane().setLayout(new BorderLayout(0, 0));

        titleLabel = new JLabel("PIPPO PIZZA");
        titleLabel.setFont(new Font("Maku", Font.BOLD | Font.ITALIC, space));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        getContentPane().add(backgroundPanel);

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        backgroundPanel.add(topPanel);
        System.out.println(titleLabel.getHeight());
        SpringLayout sl_topPanel = new SpringLayout();
        topPanel.setLayout(sl_topPanel);

        chefButton = new JButton("Chef");
        chefButton.setToolTipText("Click here for create and modify the Menu");
        chefButton.addActionListener(this::actionPerformed);
        cookButton = new JButton("Cook");
        chefButton.setToolTipText("Click here for check orders to prepare");
        chefButton.addActionListener(this::actionPerformed);

        sl_topPanel.putConstraint(SpringLayout.WEST, chefButton, space, SpringLayout.WEST, topPanel);
        sl_topPanel.putConstraint(SpringLayout.EAST, chefButton, (-space - getContentPane().getWidth()) / 2, SpringLayout.EAST, topPanel);
        sl_topPanel.putConstraint(SpringLayout.NORTH, chefButton, space, SpringLayout.NORTH, topPanel);
        sl_topPanel.putConstraint(SpringLayout.SOUTH, chefButton, 0, SpringLayout.SOUTH, topPanel);

        sl_topPanel.putConstraint(SpringLayout.EAST, cookButton, -space, SpringLayout.EAST, topPanel);
        sl_topPanel.putConstraint(SpringLayout.NORTH, cookButton, space, SpringLayout.NORTH, topPanel);
        sl_topPanel.putConstraint(SpringLayout.WEST, cookButton, (space + getContentPane().getWidth()) / 2, SpringLayout.WEST, topPanel);
        sl_topPanel.putConstraint(SpringLayout.SOUTH, cookButton, 0, SpringLayout.SOUTH, topPanel);

        topPanel.add(cookButton);
        topPanel.add(chefButton);


        backgroundPanel.add(titleLabel);

        JPanel downPanel = new JPanel();
        downPanel.setOpaque(false);
        backgroundPanel.add(downPanel);
        SpringLayout sl_downPanel = new SpringLayout();
        downPanel.setLayout(sl_downPanel);

        cashButton = new JButton("Cash");
        cashButton.setToolTipText("Click here for generate receipts");
        cashButton.addActionListener(this::actionPerformed);
        waiterButton = new JButton("Waiter");
        waiterButton.setToolTipText("Click here for take orders and check orders state");
        waiterButton.addActionListener(this::actionPerformed);

        sl_downPanel.putConstraint(SpringLayout.NORTH, waiterButton, 0, SpringLayout.NORTH, downPanel);
        sl_downPanel.putConstraint(SpringLayout.WEST, waiterButton, space, SpringLayout.WEST, downPanel);
        sl_downPanel.putConstraint(SpringLayout.EAST, waiterButton, (-space - getContentPane().getWidth()) / 2, SpringLayout.EAST, downPanel);
        sl_downPanel.putConstraint(SpringLayout.SOUTH, waiterButton, -space, SpringLayout.SOUTH, downPanel);

        sl_downPanel.putConstraint(SpringLayout.EAST, cashButton, -space, SpringLayout.EAST, downPanel);
        sl_downPanel.putConstraint(SpringLayout.NORTH, cashButton, 0, SpringLayout.NORTH, downPanel);
        sl_downPanel.putConstraint(SpringLayout.WEST, cashButton, (space + getContentPane().getWidth()) / 2, SpringLayout.WEST, downPanel);
        sl_downPanel.putConstraint(SpringLayout.SOUTH, cashButton, -space, SpringLayout.SOUTH, downPanel);


        downPanel.add(cashButton);
        downPanel.add(waiterButton);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(waiterButton)) {
            new WaiterFrame();
        }

        if (e.getSource().equals(chefButton)) {
            new ChefFrame();

        }

        if (e.getSource().equals(cookButton)) {
            new CookFrame();
        }

        if (e.getSource().equals(cashButton)) {
            new CashFrame();

        }
        dispose();

    }
}
