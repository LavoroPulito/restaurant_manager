import javax.swing.*;
import java.awt.*;

public class ChefFrame extends JFrame {
    final int WIDTH = 700;
    final int HEIGHT = 400;
    DishMenu menu = new DishMenu();
    public ChefFrame(){
        super("Chef");
        menu.load();
        MenuPanel menuPanel = new MenuPanel(menu.toArrayList());
        Box p = Box.createHorizontalBox();
        p.add(new JScrollPane(menuPanel));
        setSize(WIDTH, HEIGHT);
        //setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



}
