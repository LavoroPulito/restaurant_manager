package app.frontend.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class StandardFrame extends JFrame {
    private final int WIDTH = 1080;
    private final int HEIGHT = 720;
    final Dimension dimension = new Dimension(WIDTH, HEIGHT);

    public StandardFrame(String title) {
        super(title);
        setSize(dimension);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
