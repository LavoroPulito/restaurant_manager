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
        
        
        
        pt =new TablesPanelColored();
        pt.addActionListener(new Listener());
        
        JPanel pt1 = new JPanel();

        
        
        add(pt1);
		setResizable(true);
        int buttons=pt.getNButtons();
        int col=buttons/4;
        int rows=buttons/col;
		setSize(col*100,rows*50+80);
        setContentPane(pt);
        add(new BackMenuButton(this),BorderLayout.SOUTH);
        
        
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

