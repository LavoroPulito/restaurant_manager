import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class TablesPanel extends JPanel{

    public TablesPanel(ArrayList<TableButton> bt){
        int rows=(int)bt.size()/5 +1;
        setLayout(new GridLayout(rows,5) );
        for (TableButton b:bt){
            add(b);
        }
    }
}
