package app.frontend.window;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import app.frontend.components.BackgroundPanel;

public class MainMenu2 extends StandardFrame {
	private JLabel titleLabel;

	public MainMenu2() {
		super("Main Menù");
		getContentPane().setLayout(new BorderLayout(0, 0));

		titleLabel = new JLabel("PIPPO PIZZA");
		titleLabel.setFont(new Font("Maku", Font.BOLD | Font.ITALIC, 24));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		BackgroundPanel backgroundPanel = new BackgroundPanel();
		backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

		getContentPane().add(backgroundPanel);

		JPanel topPanel = new JPanel();
		topPanel.setOpaque(false);
		backgroundPanel.add(topPanel);
		System.out.println(titleLabel.getHeight());
		SpringLayout sl_topPanel = new SpringLayout();
		topPanel.setLayout(sl_topPanel);

		JButton chefButton = new JButton("Chef");
		sl_topPanel.putConstraint(SpringLayout.WEST, chefButton, 10, SpringLayout.WEST, topPanel);
		sl_topPanel.putConstraint(SpringLayout.SOUTH, chefButton, 165, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.EAST, chefButton, 338, SpringLayout.WEST, topPanel);

		topPanel.add(chefButton);

		JButton cookButton = new JButton("Cook");
		sl_topPanel.putConstraint(SpringLayout.NORTH, chefButton, 0, SpringLayout.NORTH, cookButton);
		sl_topPanel.putConstraint(SpringLayout.NORTH, cookButton, 10, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.WEST, cookButton, 362, SpringLayout.WEST, topPanel);
		sl_topPanel.putConstraint(SpringLayout.SOUTH, cookButton, 165, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.EAST, cookButton, 690, SpringLayout.WEST, topPanel);
		topPanel.add(cookButton);

		backgroundPanel.add(titleLabel);

		JPanel downPanel = new JPanel();
		downPanel.setOpaque(false);
		backgroundPanel.add(downPanel);
		SpringLayout sl_downPanel = new SpringLayout();
		downPanel.setLayout(sl_downPanel);

		JButton waiterButton = new JButton("Waiter");
		sl_downPanel.putConstraint(SpringLayout.NORTH, waiterButton, 0, SpringLayout.NORTH, downPanel);
		sl_downPanel.putConstraint(SpringLayout.WEST, waiterButton, 10, SpringLayout.WEST, downPanel);
		sl_downPanel.putConstraint(SpringLayout.SOUTH, waiterButton, -10, SpringLayout.SOUTH, downPanel);
		sl_downPanel.putConstraint(SpringLayout.EAST, waiterButton, 338, SpringLayout.WEST, downPanel);
		downPanel.add(waiterButton);

		JButton cashButton = new JButton("Cash");
		sl_downPanel.putConstraint(SpringLayout.NORTH, cashButton, 0, SpringLayout.NORTH, downPanel);
		sl_downPanel.putConstraint(SpringLayout.WEST, cashButton, 362, SpringLayout.WEST, downPanel);
		sl_downPanel.putConstraint(SpringLayout.SOUTH, cashButton, -10, SpringLayout.SOUTH, downPanel);
		sl_downPanel.putConstraint(SpringLayout.EAST, cashButton, 690, SpringLayout.WEST, downPanel);
		downPanel.add(cashButton);

	}
}
