package app.frontend.components;

import app.backend.Order;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import app.backend.OrderManager;

public class TablesPanelColored extends BackgroundPanel implements ActionListener {
    ArrayList<TableButton> tb;
    ArrayList<Integer> tn;
        public TablesPanelColored(){
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
        
        
        int i=0;
        for (int t:tn){
            Color color;
            boolean avaible=true;
            for (Order o:om.getRegister().get(t)){
                if (o.getState().equals("ready")||o.getState().equals("delivered")){
                    avaible=false;
                }
            }
            
            boolean avaible2=true;
            for (Order o:om.getRegister().get(t)){
                if (o.getState().equals("preparation")){
                    avaible2=false;
                }
            }

            if (avaible==true){color=new Color(36, 181, 16);}
            else if (avaible2==true){color=new Color(214, 34, 34);}
            else{color=new Color(230, 219, 21);}
            
            
            tb.get(i).setBackground(color);
            i++;
            
        }
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
