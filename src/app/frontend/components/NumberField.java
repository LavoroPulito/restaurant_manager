package app.frontend.components;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * this class is a TextField in which you can write only number
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */

public class NumberField extends JTextField {

    /**
     * Create a new NumberField and it does controls in the input because it can be only numeric
     */
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

    /**
     * this method returns the number written in the field in type Integer
     * @return number
     */
    public int getInt(){
        return Integer.parseInt(getText());
    }

    /**
     * This method checks if the number is a double
     * @return isDouble
     */
    public boolean isDouble(){
        try {
            Double.parseDouble(getText());
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    
    /**
     * this method returns the number written in the field in type Double
     * @return number
     */
    public double getDouble(){
        return Double.parseDouble(getText());
    }
}
