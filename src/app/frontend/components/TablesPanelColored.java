package app.frontend.components;

import app.backend.Order;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import app.backend.OrderManager;
/**
 * This class is a Panel that contains all the tables that has some order to prepare
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */

public class TablesPanelColored extends BackgroundPanel implements ActionListener {
    /**
     * list of tableButtons
     */
    ArrayList<TableButton> tb;
    /**
     * list of table numbers
     */
    ArrayList<Integer> tn;

    /**
     * this method creates a new TablesPanelColored. It loads all the tables, if the tables has at least an order to prepare
     * it will add to the panel with the TableButton. If in the order at least one is ready the button will be yellow otherwise
     * the table's order are all to prepare and the button will be green 
     */
        public TablesPanelColored(){
            OrderManager om = new OrderManager();
            om.load();
            tn=om.getTableList("preparation");
            if (tn.size()==0){
                JLabel l=new JLabel("There aren't order to prepare at this moment");
                l.setForeground(Color.BLACK);
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

    /**
     * returns the number of buttons 
     * @return
     */
    public int getNButtons(){
        return tn.size();
    }
    /**
     * Sets the actionListener of all TableButton
     */
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
