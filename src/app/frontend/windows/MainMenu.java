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
     * button to open waiter frame
     */
    private JButton btnWaiter;

    /**
     * button to open chef frame
     */
    private JButton btnChef;

    /**
     * button to open cook frame
     */
    private JButton btnCook;

    /**
     * button to open cash frame
     */
    private JButton btnCash;

    /**
     * ratio for frame dimension
     */
    private static final double ratio = 0.0578;

    /**
     * create a new main menu'
     */
    public MainMenu() {
        super("Restaurant Manager");
        initComponents();
    }

    /**
     * initialize all the component
     */
    private void initComponents() {
        int cornice = (int) (getContentPane().getHeight() * ratio);
        BackgroundPanel panel = new BackgroundPanel();
        JLabel mainTitle = new JLabel();
        btnWaiter = new JButton();
        btnChef = new JButton();
        btnCook = new JButton();
        btnCash = new JButton();
        JPanel btnPanel = new JPanel();



        mainTitle.setFont(new java.awt.Font("Chalkboard SE", 1, 55));
        mainTitle.setForeground(new java.awt.Color(0, 70, 0));
        mainTitle.setText("PIPPO PIZZA");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);

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

        GridLayout gridLayout = new GridLayout(4,1,0, cornice /4);
        btnPanel.setOpaque(false);
        btnPanel.setLayout(gridLayout);
        btnPanel.add(btnChef);
        btnPanel.add(btnWaiter);
        btnPanel.add(btnCook);
        btnPanel.add(btnCash);

        SpringLayout springLayout = new SpringLayout();
        panel.setLayout(springLayout);


        springLayout.putConstraint(SpringLayout.NORTH, mainTitle, cornice *2, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.SOUTH, mainTitle, 50+ cornice *2, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.EAST, mainTitle, -cornice, SpringLayout.EAST, panel);
        springLayout.putConstraint(SpringLayout.WEST, mainTitle, cornice, SpringLayout.WEST, panel);

        springLayout.putConstraint(SpringLayout.NORTH, btnPanel, cornice *2, SpringLayout.SOUTH, mainTitle);
		springLayout.putConstraint(SpringLayout.EAST, btnPanel, -cornice, SpringLayout.EAST,panel);
		springLayout.putConstraint(SpringLayout.WEST, btnPanel, cornice, SpringLayout.WEST,panel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPanel, -cornice, SpringLayout.SOUTH,panel);




        panel.add(btnPanel);
        panel.add(mainTitle);

        getContentPane().add(panel);
		
    }

    /**
     * open the selected frame and close this frame
     * @param e the event to be processed
     */
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
