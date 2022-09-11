package app.frontend.components;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
    private String imageDefaultPath = "assets/image/sfondoMargheritaSfocata.jpg";

    /**
     * Creates a new background with an image by default
     */
    public BackgroundPanel() {
        try {
            img = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(imageDefaultPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
