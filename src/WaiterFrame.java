import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WaiterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	final int WIDTH = 700;
	final int HEIGHT = 400;
	final Dimension dimension = new Dimension(WIDTH,HEIGHT);
	DishMenu menu = new DishMenu();
	private JTextField txtSelezionaIlTavolo;
	public JFrame frame;

	public WaiterFrame() {
		
		super("Waiter");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		txtSelezionaIlTavolo = new JTextField();
		txtSelezionaIlTavolo.setText("Select a table");
		panel_4.add(txtSelezionaIlTavolo);
		txtSelezionaIlTavolo.setColumns(10);

		JButton btnNewButton = new JButton("place orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back to main menu");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton_1);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
