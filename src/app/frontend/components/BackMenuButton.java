package app.frontend.components;

import javax.swing.*;

import app.frontend.windows.MainMenu;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * It's the button that sends to the MainMenu page, it's present in every window
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class BackMenuButton extends JButton {

    /** 
     * Creates a new BackMenuButton and defines its style
     */
    public BackMenuButton(JFrame frame){
        super();
        setText("Back to main menù");
        setBackground(Color.RED);
        setForeground(Color.WHITE);
        setOpaque(true);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu f = new MainMenu();
                f.setVisible(true);
                frame.dispose();
            }
        });
    }

}
