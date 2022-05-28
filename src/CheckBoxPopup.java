import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class CheckBoxPopup extends JFrame implements ActionListener {
  ArrayList<JCheckBox> cb;
  ArrayList<Integer> indexes;
  int table;
  JButton confirm;

  public CheckBoxPopup(int table){
      cb=new ArrayList<JCheckBox>();
      indexes=new ArrayList<Integer>();
      this.table=table;
      initComponents();
    }

  public void initComponents(){
    setTitle("Orders table "+table);
    

    JPanel panel = new JPanel(new GridLayout(0, 2));
    Border border = BorderFactory.createTitledBorder("Cook Pippo Pizza");
    panel.setBorder(border);

    OrderManager om = new OrderManager();
    om.load();
    ArrayList<Order> orders =om.getRegister().get(table);


    for(int i=0; i<orders.size();i++){
        if(orders.get(i).getState().equals("preparation")){
          JCheckBox temp = new JCheckBox(orders.get(i).getDishName());
          cb.add(temp);
          indexes.add(i);
          panel.add(temp);

          JButton notes = new JButton("View Notes");
          notes.addActionListener(this);
          notes.setName(orders.get(i).getNote());
          
          if(orders.get(i).getNote().equals("")){
            notes.setVisible(false);
          }

          panel.add(notes);
        }
    }

    confirm = new JButton("Confirm");
    confirm.addActionListener(this);
    confirm.setName("confirm");
    Container contentPane = this.getContentPane();
    contentPane.add(panel, BorderLayout.CENTER);
    contentPane.add(confirm, BorderLayout.SOUTH);
    this.setSize(300, 200);
    this.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
    if(e.getSource().equals(confirm)) {
        OrderManager om = new OrderManager();
        om.load();
        for (int i=0; i<cb.size();i++){
          if(cb.get(i).isSelected()){
            changeState(indexes.get(i), table, om);
          }
        }
        this.dispose();
      }
      else{
        JButton a=(JButton)e.getSource();
        JFrame noteFrame = new JFrame("Notes");
        noteFrame.add(new JTextArea(a.getName()));
        noteFrame.setVisible(true);
        noteFrame.setSize(300, 200);
        //noteFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    }
  

  public void changeState(int indexOrder, int table, OrderManager om){

    om.getRegister().get(table).get(indexOrder).setNextState(); //Spacchettamento del HashMap e cambio lo stato dell'ordine
    om.save();  //Aggiornamento nel json
}

}
