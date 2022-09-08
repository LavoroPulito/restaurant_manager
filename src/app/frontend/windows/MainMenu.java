package app.frontend.windows;

import app.frontend.components.BackgroundPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
/**
 * Menu of the project, you can select the role
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class MainMenu extends StandardFrame implements ActionListener {

/**
 * Waiter button
 */
    private JButton btnWaiter;

/**
 * Chef button
 */
    private JButton btnChef;

/**
 * Cook button
 */
    private JButton btnCook;

/**
 * Cash button
 */    
    private JButton btnCash;

/**
 * Title of the restaurant
 */
    private JLabel programTitle;

/**
 * Panel
 */
    private JPanel panel;

/**
 * Buttons' panel 
 */
    private JPanel btnPanel;

/**
 *Distance by the board
 */    
    private int padding;

/**
 * Ratio of distance by the board
 */
    private static final double ratio = 0.0578;

/**
 * Opens a new MainMenu window
 */
    public MainMenu() {
        super("Restaurant Manager");
        initComponents();
    }

    private void initComponents() {
        padding = (int) (getContentPane().getHeight()*ratio);
        panel = new BackgroundPanel();
        programTitle = new JLabel();
        btnWaiter = new JButton();
        btnChef = new JButton();
        btnCook = new JButton();
        btnCash = new JButton();
        btnPanel = new JPanel();



        programTitle.setFont(new java.awt.Font("Chalkboard SE", 1, 55));
        programTitle.setForeground(new java.awt.Color(0, 70, 0));
        programTitle.setText("PIPPO PIZZA");
        programTitle.setHorizontalAlignment(JLabel.CENTER);

        btnWaiter.setFont(new java.awt.Font("Chalkduster", 1, 32));
        btnWaiter.setForeground(new java.awt.Color(0, 90, 0));
        btnWaiter.setText("Waiter");
        btnWaiter.setToolTipText("Click here for take orders and check orders state");
        btnWaiter.addActionListener(this);

        btnChef.setFont(new java.awt.Font("Chalkduster", 1, 32));
        btnChef.setForeground(new java.awt.Color(0, 90, 0));
        btnChef.setText("Chef");
        btnChef.setToolTipText("Click here for create and modify the Menu");
        btnChef.setName("btnChef");
        btnChef.addActionListener(this);

        btnCook.setFont(new java.awt.Font("Chalkduster", 1, 32));
        btnCook.setForeground(new java.awt.Color(0, 90, 0));
        btnCook.setText("Cook");
        btnCook.setToolTipText("Click here for check orders to prepare");
        btnCook.addActionListener(this);

        btnCash.setFont(new java.awt.Font("Chalkduster", 1, 32));
        btnCash.setForeground(new java.awt.Color(0, 90, 0));
        btnCash.setText("Cash");
        btnCash.setToolTipText("Click here for generate receipts");
        btnCash.addActionListener(this);

        GridLayout gridLayout = new GridLayout(4,1,0,padding/4);
        btnPanel.setOpaque(false);
        btnPanel.setLayout(gridLayout);
        btnPanel.add(btnChef);
        btnPanel.add(btnWaiter);
        btnPanel.add(btnCook);
        btnPanel.add(btnCash);

        SpringLayout springLayout = new SpringLayout();
        panel.setLayout(springLayout);


        springLayout.putConstraint(SpringLayout.NORTH, programTitle, padding*2, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.SOUTH, programTitle, 50+padding*2, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.EAST, programTitle, -padding, SpringLayout.EAST, panel);
        springLayout.putConstraint(SpringLayout.WEST, programTitle, padding, SpringLayout.WEST, panel);

        springLayout.putConstraint(SpringLayout.NORTH, btnPanel, padding*2, SpringLayout.SOUTH,programTitle);
		springLayout.putConstraint(SpringLayout.EAST, btnPanel, -padding, SpringLayout.EAST,panel);
		springLayout.putConstraint(SpringLayout.WEST, btnPanel, padding, SpringLayout.WEST,panel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPanel, -padding, SpringLayout.SOUTH,panel);




        panel.add(btnPanel);
        panel.add(programTitle);

        getContentPane().add(panel);
		
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(btnWaiter)) {
            WaiterFrame a = new WaiterFrame();
            a.setVisible(true);

        }

        if (e.getSource().equals(btnChef)) {

            ChefFrame a = new ChefFrame();
            a.setVisible(true);
        }

        if (e.getSource().equals(btnCook)) {

            CookFrame a = new CookFrame();
            a.setVisible(true);
        }

        if (e.getSource().equals(btnCash)) {
            CashFrame a = new CashFrame();
            a.setVisible(true);

        }
        dispose();

    }
}
