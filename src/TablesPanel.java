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
        tn=om.getTableList("preparation");
        if (tn.size()==0){
            JLabel l=new JLabel("Non ci sono ordinazioni da preparare al momento");
            l.setSize(new Dimension(200,100));
            add(l);
        }
        setLayout(new GridBagLayout());
        ArrayList<TableButton>buttons= new ArrayList<TableButton>();
        for (int t:tn){
            TableButton temp = new TableButton(t);
            temp.addActionListener(this);
            

            buttons.add(temp);
            add(temp);
        }
        int rows=(int)tn.size()/5 +1;
       /*  GridLayout layout =new GridLayout(rows,5);
        layout.setHgap(30);
        layout.setVgap(30);
        setLayout(layout);*/
        //setPreferredSize(new Dimension(500,600));
        setAutoscrolls(true);
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
