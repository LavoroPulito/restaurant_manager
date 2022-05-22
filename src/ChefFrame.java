import javax.swing.*;
import java.awt.*;

public class ChefFrame extends JFrame {
    JComboBox<String> menu = new JComboBox<String>();
    public ChefFrame(){
        super("Chef");
        setLayout(null);
        setSize(1920, 1080);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



}
