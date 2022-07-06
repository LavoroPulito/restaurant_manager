import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DishPreviewFrame extends JFrame {
	private JTextField txtAddNotes;
	final int WIDTH = 700;
	final int HEIGHT = 400;
	final Dimension dimension = new Dimension(WIDTH, HEIGHT);

	private Order order;

	public DishPreviewFrame(Dish dish) {

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel labelPanel = new JPanel();
		panel.add(labelPanel);
		labelPanel.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel nameLabel = new JLabel(dish.getName());
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelPanel.add(nameLabel);

		JLabel priceLabel = new JLabel(""+dish.getPrice()+"€");
		priceLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelPanel.add(priceLabel);

		JLabel categoryLabel = new JLabel(dish.getCategory());
		categoryLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelPanel.add(categoryLabel);
		String available = "not available";
		if(dish.isAvailable()){
			available = "is available";
		}
		JLabel availableLabel = new JLabel(available);
		availableLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelPanel.add(availableLabel);

		JTextArea descriptionArea = new JTextArea("description:\n"+ dish.getDescription());

		panel.add(descriptionArea);
		descriptionArea.setEditable(false);

		txtAddNotes = new JTextField();
		txtAddNotes.setText("no notes");
		panel.add(txtAddNotes);
		txtAddNotes.setColumns(10);

		JButton addButton = new JButton("add to order");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(addButton);


		setMinimumSize(dimension);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public String getDescription() {
		return txtAddNotes.getText();
	}
}
