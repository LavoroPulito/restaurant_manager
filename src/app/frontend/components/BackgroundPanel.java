package app.frontend.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	private Image img;

	@Override
	protected void paintComponent(Graphics g) {
		setOpaque(false);
		g.drawImage(img, 0, 0, null);
		super.paintComponent(g);
	}

	public BackgroundPanel() {
		img = Toolkit.getDefaultToolkit()
				.createImage("/Users/armandocoppola/Documents/restaurant_manager/src/sfondoMargherita.jpg");
		loadImage(img);
	}

	public BackgroundPanel(String imgPath) {
		this.img = Toolkit.getDefaultToolkit().createImage(imgPath);
		loadImage(img);
	}

	private void loadImage(Image img) {
		try {
			MediaTracker track = new MediaTracker(this);
			track.addImage(img, 0);
			track.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
