import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CheckBoxPopup extends JFrame implements ActionListener {
  ArrayList<JCheckBox> cb;
  ArrayList<Integer> indexes;
  int table;

  public CheckBoxPopup(int table){
      cb=new ArrayList<JCheckBox>();
      indexes=new ArrayList<Integer>();
      this.table=table;
      initComponents();
    }

  public void initComponents(){
    setTitle("Ordinazioni tavolo "+table);
    

    JPanel panel = new JPanel(new GridLayout(0, 1));
    Border border = BorderFactory.createTitledBorder("Pizza Toppings");
    panel.setBorder(border);

    OrderManager om = new OrderManager();
    om.load();
    ArrayList<Order> orders =om.getRegister().get(table);


    for(int i=0; i<orders.size();i++){
      //System.out.println(o.getState().length());
        if(orders.get(i).getState().equals("in preparazione")){
          JCheckBox temp = new JCheckBox(orders.get(i).getDishName());
          cb.add(temp);
          indexes.add(i);
          panel.add(temp);
        }
    }

    JButton button = new JButton("Conferma");
    button.addActionListener(this);
    Container contentPane = this.getContentPane();
    contentPane.add(panel, BorderLayout.CENTER);
    contentPane.add(button, BorderLayout.SOUTH);
    this.setSize(300, 200);
    this.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
    if (e.getSource().getClass().getName() =="javax.swing.JButton" ){
      OrderManager om = new OrderManager();
      om.load();
      for (int i=0; i<cb.size();i++){
        if(cb.get(i).isSelected()){
          changeState(indexes.get(i), table, om);
        }
      }
      this.dispose();
    }
  }

  public void changeState(int indexOrder, int table, OrderManager om){

    om.getRegister().get(table).get(indexOrder).setNextState(); //Spacchettamento del HashMap e cambio lo stato dell'ordine
    om.save();  //Aggiornamento nel json
}

}
