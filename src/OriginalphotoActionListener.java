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

	        
	        // Redimensionner l'image filtrée
	        Image resizedImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

	        // Mise à jour de l'image affichée dans l'interface
	        MainInterface.imageLabel.setIcon(new ImageIcon(resizedImage));
	    }
	}