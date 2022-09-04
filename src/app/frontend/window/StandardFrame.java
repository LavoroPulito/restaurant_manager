package app.frontend.window;

import javax.swing.*;
import java.awt.*;

public class StandardFrame extends JFrame {
    private final int WIDTH = 700;
    private final int HEIGHT = 400;
    final Dimension dimension = new Dimension(WIDTH, HEIGHT);
    public StandardFrame(String title){
        super(title);
        setMinimumSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
