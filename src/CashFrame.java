import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
public class CashFrame extends JFrame {
	private JTextField txtInserireI;

	final int WIDTH = 700;
	final int HEIGHT = 400;
	final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	Bill bill = new Bill();
	double amount = 0;
	int table;

	public CashFrame() {
		setTitle("cash desk");
		getContentPane().setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JTextArea textArea = new JTextArea();
		panel_2.add(textArea);
		
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		OrderManager om = new OrderManager();
		om.load();
		JList list = new JList(om.getRegister().keySet().toArray());
		list.getSelectionModel().addListSelectionListener(e ->{
		int i = (list.getSelectedIndex())+1;
        String left;
        String s = Integer.toString(i);
        if (s.length() <2 ){ 
             left = s.substring(0,1);
        }else{
            int f = s.length() -1;
            left = s.substring(0,f);
        }
		this.table = Integer.parseInt(left);
		textArea.setText(" ");
		textArea.append(bill.preConto(table));
		
			
		});
		panel_1.add(list, BorderLayout.CENTER);

		

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton_1 = new JButton("print receipt");
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -53, SpringLayout.EAST, panel);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
			}
			
		});
		//btnNewButton_1.addActionListener(this);

		JButton btnNewButton_2 = new JButton("Back to main menù");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, -26, SpringLayout.EAST, panel);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false); 
			}
		});

		txtInserireI = new JTextField();

		//textArea.append();
		sl_panel.putConstraint(SpringLayout.WEST, txtInserireI, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtInserireI, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, txtInserireI);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtInserireI, -333, SpringLayout.SOUTH, panel);
		txtInserireI.setText("enter amount received");
		panel.add(txtInserireI);
		String amountString = txtInserireI.getText();		
				//converting the JTextField text in double value
		 

		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		
	}
}
