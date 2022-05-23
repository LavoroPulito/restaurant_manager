import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel {

    public MenuPanel(ArrayList<Dish> list){
        Box m = Box.createVerticalBox();
        for (Dish e:
             list) {
            m.add(new JButton(e.getName()));

        }


    }
}
