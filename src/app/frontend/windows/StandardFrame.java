package app.frontend.windows;

import javax.swing.*;
import java.awt.*;

/**
 * This class is a standard frame with attributes in common to the other windows 
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class StandardFrame extends JFrame {

/**
 * Width
*/ 
    private final int WIDTH = 1080;

/**
 * Height
 */
    private final int HEIGHT = 720;

/**
 * Window's Dimension
 */
    final Dimension dimension = new Dimension(WIDTH, HEIGHT);

/**
 * Creates a new StandardFrame defining the style and the dimensions
 * @param title
 */
    public StandardFrame(String title) {
        super(title);
        setSize(dimension);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
