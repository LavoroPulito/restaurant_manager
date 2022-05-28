import java.awt.*;
public class TablesPanelColored extends TablesPanel { 
        public TablesPanelColored(){
        super();
        OrderManager om = new OrderManager();
        om.load();
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

}
