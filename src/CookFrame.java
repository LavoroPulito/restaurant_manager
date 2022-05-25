import javax.swing.JFrame;
import java.awt.event.*;
import java.util.ArrayList;
public class CookFrame extends JFrame implements ActionListener{

    private TablesPanel pt;

    public CookFrame(){
        this.initComponents();
    }

//Manca connessione ad ActionListener con relativo popup di checkbox e aggiustamento stile
    private void initComponents(){
        OrderManager om = new OrderManager();
        om.load();
        ArrayList<Integer> tables=om.getTableList();
        ArrayList<TableButton>buttons= new ArrayList<TableButton>();
        for (int t:tables){
            buttons.add(new TableButton(t));
        }

        pt =new TablesPanel(buttons);

        
		pt.getAccessibleContext().setAccessibleName("");
        add(pt);
		setResizable(true);
		pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
    
}
