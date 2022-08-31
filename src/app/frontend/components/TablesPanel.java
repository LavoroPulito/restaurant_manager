package app.frontend.components;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import app.backend.OrderManager;

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
        setLayout(new FlowLayout());
        ArrayList<TableButton>buttons= new ArrayList<TableButton>();
        for (int t:tn){
            TableButton temp = new TableButton(t);
            temp.addActionListener(this);
            

            buttons.add(temp);
            add(temp);
        }
        setAutoscrolls(true);
        
        tb=buttons;
    }

    public int getNButtons(){
        return tn.size();
    }
    public void addActionListener(ActionListener act){ //da passare un oggetto di una classe con metodo actionListener (Vedi app.frontend.window.CookFrame)
        for(TableButton t: tb) {
            t.addActionListener(act);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
