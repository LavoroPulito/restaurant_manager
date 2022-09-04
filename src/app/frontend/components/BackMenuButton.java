package app.frontend.components;

import app.frontend.window.MainMenu;
import app.frontend.window.MainMenu2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackMenuButton extends JButton {
    public BackMenuButton(JFrame frame){
        super();
        setText("back to main menù");
        setBackground(Color.RED);
        setOpaque(true);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu2 f = new MainMenu2();
                f.setVisible(true);
                frame.dispose();
            }
        });
    }

}
