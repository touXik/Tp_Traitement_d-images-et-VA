import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.ImageIcon;

public class ApplyMoyenFilterActionListener implements ActionListener {
	
		// On recupere l'image
	 	static BufferedImage image = LoadImageActionListener.img ;
	 	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Appliquer le filtre moyen sur l'image
	        
	        BufferedImage filteredImage = applyMoyenFilter(image);
	        image = filteredImage ;
	        
	        
	        // Redimensionner l'image filtrée
	        Image resizedImage = filteredImage.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

	        // Mettez à jour l'image affichée dans l'interface
	        MainInterface.imageLabel.setIcon(new ImageIcon(resizedImage));
	    }

	    private BufferedImage applyMoyenFilter(BufferedImage img) {
	    	
	    	
	        // Définir la matrice de filtre moyen 3x3 prédéfinie
	    	
	        float[] matrix = {
	                1f/9f, 1f/9f, 1f/9f,
	                1f/9f, 1f/9f, 1f/9f,
	                1f/9f, 1f/9f, 1f/9f
	        };



	        // Appliquer le filtre moyen à l'image
	        Kernel kernel = new Kernel(3, 3, matrix);
	        ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
	        return convolveOp.filter(img, null);
	    }
	}
