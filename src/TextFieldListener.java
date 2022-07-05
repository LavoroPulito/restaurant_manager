import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TextFieldListener implements MouseListener{
    public void TextListener(){}

    private void clearText(JTextField tf){
        tf.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clearText((JTextField)e.getSource());
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
     
}
