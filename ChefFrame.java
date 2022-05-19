import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChefFrame  extends JFrame
{
    JFrame frame = new JFrame();

    /*JButton bottoneAdd = new JButton("Aggiungi");
    JButton bottoneDel = new JButton("Elimina");
    JButton bottoneCarica = new JButton("Carica");
    JButton bottoneMod = new JButton("Modifica");*/
 

    public ChefFrame()
    {
        setLayout(null);


        JPanel pannellomenu = new JPanel();
        JLabel labelmenu = new JLabel("\t MENU \t");
        pannellomenu.add(labelmenu);
        pannellomenu.setBackground(Color.GRAY);
        pannellomenu.setBounds(10,10,850,990);
        pannellomenu.add(new JButton("viu"));
        frame.add(pannellomenu);
        //per il menu



        JPanel pannellofield = new JPanel();
        pannellofield.setBounds(950, 10, 900, 460);
        pannellofield.setBackground(Color.BLACK);
        frame.add(pannellofield);
        //per i field di aggiunta degli attributi


        frame.setResizable(false);
        frame.setSize(1930,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        
    }

    

    
    

}
