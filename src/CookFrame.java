import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
public class CookFrame extends JFrame {

    private TablesPanelColored pt;

    public CookFrame(){
        this.initComponents();
    }

//TODO: Manca aggiustamento stile
    private void initComponents(){
        GridBagLayout lt = new GridBagLayout();
        setSize(700,400);
        
        pt =new TablesPanelColored();
        pt.addActionListener(new Listener());
        
        JPanel pt1 = new JPanel();
        Dimension size = pt.getSize();
        pt1.setSize(700-(int)size.getWidth(), 400-(int)size.getHeight());
        pt1.add(pt);
        add(pt1);
		setResizable(true);
		
        setContentPane(pt);
        
        
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

