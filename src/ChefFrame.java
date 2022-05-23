import javax.swing.*;
import java.awt.*;

public class ChefFrame extends JFrame {
    final int WIDTH = 700;
    final int HEIGHT = 400;
    DishMenu menu = new DishMenu();
    
    MenuPanel menuPanel = new MenuPanel(menu.toArrayList());
    public ChefFrame(){
        super("Chef");
        Box p = Box.createHorizontalBox();
        this.getContentPane().add(new JScrollPane(menuPanel));
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



}
