package app.frontend.components;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberField extends JTextField {

    public NumberField(){
        setColumns(8);
        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c != KeyEvent.VK_PERIOD) {
                    e.consume(); // if it's not a number, ignore the event
                }
            }
        });
    }

    public int getInt(){
        return Integer.parseInt(getText());
    }
    public boolean isDouble(){
        try {
            Double.parseDouble(getText());
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public double getDouble(){
        return Double.parseDouble(getText());
    }
}
