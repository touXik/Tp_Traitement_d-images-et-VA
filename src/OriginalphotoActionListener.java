import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class OriginalphotoActionListener implements ActionListener {
	
	    // On recupere l'image
	    static BufferedImage image = LoadImageActionListener.img ;
	   
	    @Override
	    public void actionPerformed(ActionEvent e) {

	        
	        // Redimensionner l'image filtr�e
	        Image resizedImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

	        // Mise � jour de l'image affich�e dans l'interface
	        MainInterface.imageLabel.setIcon(new ImageIcon(resizedImage));
	    }
	}