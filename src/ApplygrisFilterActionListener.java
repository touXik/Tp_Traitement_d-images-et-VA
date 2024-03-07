import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ApplygrisFilterActionListener implements ActionListener {
	
	    // On recupere l'image
	    static BufferedImage image = LoadImageActionListener.img ;
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Appliquer le filtre moyen sur l'image
	        
	        BufferedImage filteredImage = applygrisFilter(image);
	        
	        // Redimensionner l'image filtrée
	        Image resizedImage = filteredImage.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

	        // Mettez à jour l'image affichée dans l'interface
	        MainInterface.imageLabel.setIcon(new ImageIcon(resizedImage));
	    }

	    private BufferedImage applygrisFilter(BufferedImage img1) {
    		BufferedImage img = new BufferedImage(
	    			img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
	    		Graphics g = img.getGraphics();
	    		g.drawImage(img1, 0, 0, null);
	    		g.dispose();
	    		
	    		return img ;
	    		
	    	

	    }
	}