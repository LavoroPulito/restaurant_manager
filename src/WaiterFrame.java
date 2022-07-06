import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class WaiterFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	final int WIDTH = 700;
	final int HEIGHT = 400;
	private boolean openNew = false;
	final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	DishMenu menu = new DishMenu();
	private JTextField txtSelezionaIlTavolo;
	public JFrame frame;
	private JTextField quantityField;

	public WaiterFrame() {

		super("Waiter");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel menùPanel = new JPanel();
        JScrollPane spMenu = new JScrollPane();
		panel.add(spMenu);
        spMenu.setRowHeaderView(spMenu.getVerticalScrollBar());
        spMenu.setViewportView(menùPanel);
		menùPanel.setLayout(new BorderLayout(0, 0));
		menu.load();
		JList listMenu = new JList(menu.toArrayList().toArray());

		listMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (listMenu.getSelectedValue() != null) {
					DishPreviewFrame previewFrame = new DishPreviewFrame((Dish) listMenu.getSelectedValue());
					
				}
			}
		});
		menùPanel.add(listMenu, BorderLayout.CENTER);

		JPanel previewPanel = new JPanel();
		panel.add(previewPanel);
		previewPanel.setLayout(new BorderLayout(0, 0));

		JPanel quantityPanel = new JPanel();
		previewPanel.add(quantityPanel, BorderLayout.SOUTH);
		quantityPanel.setLayout(new GridLayout(1, 3, 0, 0));

		JButton lessButton = new JButton("-");
		quantityPanel.add(lessButton);

		quantityField = new JTextField();
		quantityPanel.add(quantityField);
		quantityField.setColumns(10);

		JButton moreButton = new JButton("+");
		quantityPanel.add(moreButton);

		JList listPreview = new JList();
		previewPanel.add(listPreview, BorderLayout.CENTER);

		JPanel rightPanel = new JPanel();
		panel.add(rightPanel);
		rightPanel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel buttonPanel = new JPanel();
		rightPanel.add(buttonPanel);

		txtSelezionaIlTavolo = new JTextField();
		txtSelezionaIlTavolo.setText("Select a table");
		buttonPanel.add(txtSelezionaIlTavolo);
		txtSelezionaIlTavolo.setColumns(10);

		JButton btnNewButton = new JButton("place orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back to main menu");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonPanel.add(btnNewButton_1);

		JPanel checkBoxPanel = new JPanel();
		rightPanel.add(checkBoxPanel);
		checkBoxPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		checkBoxPanel.add(scrollPane, BorderLayout.CENTER);
        JPanel pContainer = new JPanel();
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);
        pContainer.setLayout(new BoxLayout(pContainer, BoxLayout.PAGE_AXIS));
        scrollPane.setViewportView(pContainer);
		OrderManager orderManager = new OrderManager();
		orderManager.load();
        int index=0;
		for (Order order:
			 orderManager.getOrdersToDeliver()) {
                String nome=order.getDishName();
                int tavolo = order.getTable();
                JCheckBox cb= new JCheckBox(""+tavolo+"- "+nome);
                
                pContainer.add(cb);
                
                //scrollPane.setViewportView(chckbxNewCheckBox);

		}
		
		
		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass()== JButton.class){
			JButton but = (JButton) e.getSource();
			if(but.getText().equals("add to order")){
				System.out.println("va");
			}
		}

	}
}
