import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener{


	private JButton btnWaiter;
	private JButton btnChef;
	private JButton btnCuoco;
	private JButton btnCash;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JSeparator jSeparator2;


	public MainMenu() {
		initComponents();
	}


	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel2 = new JLabel();
		jSeparator2 = new JSeparator();
		btnWaiter = new JButton();
		btnChef = new JButton();
		btnCuoco = new JButton();
		btnCash = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(204, 204, 255));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(0, 0, 204));
		jLabel2.setText("PIPPO PIZZA");

		btnWaiter.setBackground(new java.awt.Color(255, 255, 255));
		btnWaiter.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
		btnWaiter.setForeground(new java.awt.Color(0, 0, 153));
		btnWaiter.setText("Cameriere");
		btnWaiter.setToolTipText("Clicca qui per prendere gli ordini e controllare lo stato");
		btnWaiter.addActionListener(this); 

		btnChef.setBackground(new java.awt.Color(0, 0, 0));
		btnChef.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
		btnChef.setForeground(new java.awt.Color(255, 255, 255));
		btnChef.setText("Chef");
		btnChef.setToolTipText("Clicca qui per creare e modificare il Menu");
		btnChef.setMargin(new java.awt.Insets(2, 12, 2, 14));
		btnChef.setName("btnChef"); // NOI18N
		btnChef.addActionListener(this);


		btnCuoco.setBackground(new java.awt.Color(255, 255, 255));
		btnCuoco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
		btnCuoco.setForeground(new java.awt.Color(0, 0, 153));
		btnCuoco.setText("Cuoco");
		btnCuoco.setToolTipText("Clicca qui per controllare gli ordini da preparare");
		btnCuoco.addActionListener(this);

		btnCash.setBackground(new Color(0, 0, 153));
		btnCash.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
		btnCash.setForeground(new java.awt.Color(255, 255, 255));
		btnCash.setText("Cassa");
		btnCash.setToolTipText("Clicca qui per generare gli scontrini");
		btnCash.setMargin(new java.awt.Insets(2, 12, 2, 14));
		btnCash.addActionListener(this);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jSeparator2)
										.addContainerGap())
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
										.addGap(0, 126, Short.MAX_VALUE)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel2)
														.addGap(126, 126, 126))
												.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
														.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
																.addComponent(btnChef, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnCuoco, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
																.addComponent(btnWaiter, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnCash, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGap(117, 117, 117))))))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(6, 6, 6)
						.addComponent(jLabel2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnWaiter, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnChef, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnCuoco, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnCash, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(53, Short.MAX_VALUE))
				);

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
		jPanel1.getAccessibleContext().setAccessibleName("");
		setResizable(false);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(btnWaiter)) {
			WaiterFrame a=new WaiterFrame();
			a.setVisible(true);
		}

		if(e.getSource().equals(btnChef)) {

				ChefFrame a =new ChefFrame();
				a.setVisible(true);
				a.pack();
		}
		

		if(e.getSource().equals(btnCuoco)) {

				CookFrame a =new CookFrame();
				a.setVisible(true);
		}

		if(e.getSource().equals(btnCash)) {
			CashFrame a = new CashFrame();
			a.setVisible(true);

		}

	}
}


