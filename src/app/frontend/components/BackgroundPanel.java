package app.frontend.components;

import java.awt.*;

import javax.swing.JPanel;

/**
 * This class is a panel used as windows' background
 *
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class BackgroundPanel extends JPanel {
    /**
     * Image on the background
     */
    private Image img;

    /**
     * Creates a new background with an image by default
     */
    public BackgroundPanel() {
        img = Toolkit.getDefaultToolkit()
                .createImage("src/assets/image/sfondoMargheritaSfocata.jpg");

        loadImage(img);
    }

    /**
     * override the method for painting the background with the loaded image
     *
     * @param g the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        setOpaque(false);
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }

    /**
     * Creates a new background can choosing the image
     *
     * @param imgPath path where the image is stored
     */
    public BackgroundPanel(String imgPath) {
        this.img = Toolkit.getDefaultToolkit().createImage(imgPath);
        loadImage(img);
    }

    /**
     * Permits to put the image from the directory into the panel
     */
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
