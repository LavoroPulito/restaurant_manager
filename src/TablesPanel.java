import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TablesPanel extends JPanel implements ActionListener{
    ArrayList<TableButton> tb;
    ArrayList<Integer> tn;
    public TablesPanel(){
        OrderManager om = new OrderManager();
        om.load();
        tn=om.getTableList();

        ArrayList<TableButton>buttons= new ArrayList<TableButton>();
        for (int t:tn){
            TableButton temp = new TableButton(t);
            temp.addActionListener(this);
            

            buttons.add(temp);
            add(temp);
        }
        int rows=(int)tn.size()/5 +1;
        setLayout(new GridLayout(rows,5) );
        
        tb=buttons;
    }


    public void addActionListener(ActionListener act){ //da passare un oggetto di una classe con metodo actionListener (Vedi CookFrame)
        for(TableButton t: tb) {
            t.addActionListener(act);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
