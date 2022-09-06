package app.frontend.windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;

@SuppressWarnings("serial")
public class  MainMenu extends StandardFrame implements ActionListener {

	private JButton btnWaiter;
	private JButton btnChef;
	private JButton btnCuoco;
	private JButton btnCash;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JSeparator jSeparator2;

	public MainMenu() {
		super("Restaurant Manager");initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel2 = new JLabel();
		jSeparator2 = new JSeparator();
		btnWaiter = new JButton();
		btnChef = new JButton();
		btnCuoco = new JButton();
		btnCash = new JButton();



		jPanel1.setBackground(new java.awt.Color(204, 204, 255));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 38)); 
		jLabel2.setForeground(new java.awt.Color(0, 0, 204));
		jLabel2.setText("PIPPO PIZZA");

		btnWaiter.setFont(new java.awt.Font("Verdana", 1, 12)); 
		btnWaiter.setForeground(new java.awt.Color(0, 0, 153));
		btnWaiter.setText("Waiter");
		btnWaiter.setToolTipText("Click here for take orders and check orders state");
		btnWaiter.addActionListener(this);

		btnChef.setFont(new java.awt.Font("Verdana", 1, 12)); 
		btnChef.setForeground(new java.awt.Color(0, 0, 153));
		btnChef.setText("Chef");
		btnChef.setToolTipText("Click here for create and modify the Menu");
		btnChef.setMargin(new java.awt.Insets(2, 12, 2, 14));
		btnChef.setName("btnChef"); 
		btnChef.addActionListener(this);

		btnCuoco.setFont(new java.awt.Font("Verdana", 1, 12)); 
		btnCuoco.setForeground(new java.awt.Color(0, 0, 153));
		btnCuoco.setText("Cook");
		btnCuoco.setToolTipText("Click here for check orders to prepare");
		btnCuoco.addActionListener(this);

		btnCash.setFont(new java.awt.Font("Verdana", 1, 12)); 
		btnCash.setForeground(new java.awt.Color(0, 0, 153));
		btnCash.setText("Cassa");
		btnCash.setToolTipText("Click here for generate receipts");
		btnCash.setMargin(new java.awt.Insets(2, 12, 2, 14));
		btnCash.addActionListener(this);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jSeparator2).addContainerGap())
						.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
								.addGap(0, 126, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(GroupLayout.Alignment.TRAILING,
												jPanel1Layout.createSequentialGroup().addComponent(jLabel2).addGap(126,
														126, 126))
										.addGroup(GroupLayout.Alignment.TRAILING,
												jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
														.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
														.addComponent(btnChef, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCuoco, GroupLayout.DEFAULT_SIZE, 197,
																Short.MAX_VALUE)
														.addComponent(btnWaiter, GroupLayout.Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnCash, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGap(117, 117, 117)))))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(jLabel2)
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
						.addContainerGap(53, Short.MAX_VALUE)));

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
		jPanel1.getAccessibleContext().setAccessibleName("");

		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btnWaiter)) {
			WaiterFrame a = new WaiterFrame();
			a.setVisible(true);

		}

		if (e.getSource().equals(btnChef)) {

			ChefFrame a = new ChefFrame();
			a.setVisible(true);
		}

		if (e.getSource().equals(btnCuoco)) {

			CookFrame a = new CookFrame();
			a.setVisible(true);
		}

		if (e.getSource().equals(btnCash)) {
			CashFrame a = new CashFrame();
			a.setVisible(true);

		}
		dispose();

	}
}
