package app.frontend.windows;

import app.frontend.components.BackgroundPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends StandardFrame implements ActionListener {

    private JButton btnWaiter;
    private JButton btnChef;
    private JButton btnCuoco;
    private JButton btnCash;
    private JLabel programTitle;
    private JPanel panel;
    private JPanel btnPanel;
    private int cornice;
    private static final double ratio = 0.0578;
    public MainMenu() {
        super("Restaurant Manager");
        initComponents();
    }

    private void initComponents() {
        cornice = (int) (getContentPane().getHeight()*ratio);
        panel = new BackgroundPanel();
        programTitle = new JLabel();
        btnWaiter = new JButton();
        btnChef = new JButton();
        btnCuoco = new JButton();
        btnCash = new JButton();
        btnPanel = new JPanel();


        //jPanel1.setBackground(new java.awt.Color(204, 204, 255));

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

        btnCuoco.setFont(new java.awt.Font("Chalkduster", 1, 32));
        btnCuoco.setForeground(new java.awt.Color(0, 90, 0));
        btnCuoco.setText("Cook");
        btnCuoco.setToolTipText("Click here for check orders to prepare");
        btnCuoco.addActionListener(this);

        btnCash.setFont(new java.awt.Font("Chalkduster", 1, 32));
        btnCash.setForeground(new java.awt.Color(0, 90, 0));
        btnCash.setText("Cash");
        btnCash.setToolTipText("Click here for generate receipts");
        btnCash.addActionListener(this);

        GridLayout gridLayout = new GridLayout(4,1,0,cornice/4);
        btnPanel.setOpaque(false);
        btnPanel.setLayout(gridLayout);
        btnPanel.add(btnChef);
        btnPanel.add(btnWaiter);
        btnPanel.add(btnCuoco);
        btnPanel.add(btnCash);

        SpringLayout springLayout = new SpringLayout();
        panel.setLayout(springLayout);


        springLayout.putConstraint(SpringLayout.NORTH, programTitle, cornice*2, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.SOUTH, programTitle, 50+cornice*2, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.EAST, programTitle, -cornice, SpringLayout.EAST, panel);
        springLayout.putConstraint(SpringLayout.WEST, programTitle, cornice, SpringLayout.WEST, panel);

        springLayout.putConstraint(SpringLayout.NORTH, btnPanel, cornice*2, SpringLayout.SOUTH,programTitle);
		springLayout.putConstraint(SpringLayout.EAST, btnPanel, -cornice, SpringLayout.EAST,panel);
		springLayout.putConstraint(SpringLayout.WEST, btnPanel, cornice, SpringLayout.WEST,panel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPanel, -cornice, SpringLayout.SOUTH,panel);




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

        if (e.getSource().equals(btnCuoco)) {

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
