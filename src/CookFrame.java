import javax.swing.JFrame;
import java.awt.event.*;
import java.util.ArrayList;
public class CookFrame extends JFrame {

    private TablesPanel pt;

    public CookFrame(){
        this.initComponents();
    }

//TODO: Manca relativo popup di checkbox e aggiustamento stile
    private void initComponents(){
         
        

        pt =new TablesPanel();
        pt.addActionListener(new Listener());
        
		pt.getAccessibleContext().setAccessibleName("");
        super.add(pt);
		super.setResizable(true);
		super.pack();
    }


private class Listener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        if( e.getSource().getClass().getName() .equals("TableButton")){
          int table = ((TableButton) e.getSource()).getTable();
            new CheckBoxPopup(table);
        }
         
     }
}


}  

