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
            Color color;
            boolean avaible=true;
            for (Order o:om.getRegister().get(t)){
                if (o.getState().equals("pronto")||o.getState().equals("consegnato")){
                    avaible=false;
                }
            }
            
            boolean avaible2=true;
            for (Order o:om.getRegister().get(t)){
                if (o.getState().equals("in preparazione")){
                    avaible2=false;
                }
            }

            if (avaible==true){color=new Color(36, 181, 16);}
            else if (avaible2==true){color=new Color(214, 34, 34);}
            else{color=new Color(230, 219, 21);}


            TableButton temp = new TableButton(t);
            temp.addActionListener(this);
            temp.setBackground(color);

            buttons.add(temp);
            add(temp);
        }
        int rows=(int)tn.size()/5 +1;
        setLayout(new GridLayout(rows,5) );
        
        tb=buttons;
    }


    public void addActionListener(ActionListener act){
        for(TableButton t: tb) {
            t.addActionListener(act);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
