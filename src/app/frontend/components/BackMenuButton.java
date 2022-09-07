package app.frontend.components;

import javax.swing.*;

import app.frontend.windows.MainMenu;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackMenuButton extends JButton {
    public BackMenuButton(JFrame frame){
        super();
        setText("back to main menù");
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
