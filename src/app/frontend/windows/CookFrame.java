package app.frontend.windows;

import app.frontend.components.BackMenuButton;
import app.frontend.components.CheckBoxPopup;
import app.frontend.components.TableButton;
import app.frontend.components.TablesPanelColored;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class CookFrame extends StandardFrame {

    private TablesPanelColored pt;

    public CookFrame() {
        super("Cook");
        this.initComponents();
    }

    private void initComponents() {

        pt = new TablesPanelColored();
        pt.addActionListener(new Listener());

        JPanel pt1 = new JPanel();


        add(pt1);

        int buttons = pt.getNButtons();
        if (buttons == 0) {
            setSize(300, 200);
        }
        int col = buttons / 4;
        if (col == 0) {
            col = 1;
        }
        int rows = buttons / col;
        setSize(col * 100, rows * 50 + 80);
        setContentPane(pt);
        add(new BackMenuButton(this), BorderLayout.SOUTH);


    }

    private void clear() {
        this.getContentPane().remove(pt);
    }


    private class Listener implements ActionListener, WindowListener {

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

