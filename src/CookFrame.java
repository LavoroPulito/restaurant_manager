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
         
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pt =new TablesPanelColored();
        pt.addActionListener(new Listener());
        
		pt.getAccessibleContext().setAccessibleName("");
        super.add(pt);
		super.setResizable(true);
		super.pack();
    }

    private void clear(){
        this.getContentPane().remove(pt);
    }


private class Listener implements ActionListener, WindowListener{

    public void actionPerformed(ActionEvent e) {
        if( e.getSource().getClass().getName() .equals("TableButton")){
          int table = ((TableButton) e.getSource()).getTable();
            CheckBoxPopup a= new CheckBoxPopup(table);
            a.addWindowListener(this);
        }
         
     }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e){} 

    @Override
    public void windowClosed(WindowEvent e) {
        clear();
        initComponents();
        
    }

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}


}  

