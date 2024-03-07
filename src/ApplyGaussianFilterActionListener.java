import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.ImageIcon;

public class ApplyGaussianFilterActionListener implements ActionListener {
	
	
	    // On recupere l'image
	    static BufferedImage image1 = LoadImageActionListener.img ;
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    
	        // Appliquer le filtre gaussien sur l'image
	        
	        BufferedImage image2 = applyGaussianFilter(image1);
	        
	        image1 = image2 ;
	        
	        // Redimensionner l'image filtrée
	        Image resizedImage = image1.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

	        // Mise à jour de l'image affichée dans l'interface
	        MainInterface.imageLabel.setIcon(new ImageIcon(resizedImage));
	    }
	        
	        // methode pour appliquer le filtre gaussien
	        private BufferedImage applyGaussianFilter(BufferedImage img) {
	    	
		        // Définir la matrice de filtre moyen 3x3 prédéfinie
		    	
		        float[] matrix = {
		                0.075f, 0.125f, 0.075f,
		                0.125f, 0.200f, 0.125f,
		                0.075f, 0.125f, 0.075f
		        };

		        // Appliquer le filtre moyen à l'image
		        Kernel kernel = new Kernel(3, 3, matrix);
		        ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		        return convolveOp.filter(img, null);
	    }
	}