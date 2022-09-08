package app.frontend.windows;

import app.frontend.components.*;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

/**
 * This class is the graphical interface of the Cookeer, who manages the Orders to prepare and prepared
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class CookFrame extends StandardFrame {
/**
 * Panel with all the tables with at least an order to prepare
 */
    private TablesPanelColored pt;

/**
 * Opens a window cook
 */
    public CookFrame() {
        super("Cook");
        this.initComponents();
    }

/**
 * initialize the components loading the table's informations and setting the dimensions and style
 */
    private void initComponents() {

        pt = new TablesPanelColored();
        pt.addActionListener(new Listener());

        JPanel pt1 = new JPanel();
        pt1.setOpaque(false);

        add(pt1);

        int buttons = pt.getNButtons();
        if (buttons == 0) {
            setSize(300, 200);
        }
        else{
            int col = buttons / 4;
            if (col == 0) {
                col = 1;
            }
            int rows = buttons / col;
            setSize(col * 100, rows * 50 + 80);
        }

        setResizable(true);
        setContentPane(pt);
        add(new BackMenuButton(this), BorderLayout.SOUTH);


    }

/**
 * Removes all the content in the page for reset
 */
    private void clear() {
        this.getContentPane().remove(pt);
    }

/**
 * This is an interface that has reference only at table's buttons
 */
    private class Listener implements ActionListener, WindowListener {

        /**
         * When a table's button is clicked a popup opens with the information of the relative table
         * @param event
         */
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().getClass().getName().equals("app.frontend.components.TableButton")) {
                int table = ((TableButton) e.getSource()).getTable();
                CheckBoxPopup a = new CheckBoxPopup(table);
                a.addWindowListener(this);
                dispose();
            }

        }

        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
        }

/**
 * When the popup closes the window reset the informations and reload them
 * @param event
 */
        @Override
        public void windowClosed(WindowEvent e) {
            clear();
            initComponents();

        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    }


}  

