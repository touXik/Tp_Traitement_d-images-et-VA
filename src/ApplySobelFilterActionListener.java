import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.ImageIcon;

public class ApplySobelFilterActionListener implements ActionListener {
	
		// On recupere l'image
		static BufferedImage image = LoadImageActionListener.img ;
	 
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        
	    	
	    	// Appliquer le filtre Sobel sur l'image
	        BufferedImage filteredImage = applySobelFilter(image);
	        
	        // Redimensionner l'image filtr�e
	        Image resizedImage = filteredImage.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

	        // Mettez � jour l'image affich�e dans l'interface
	        MainInterface.imageLabel.setIcon(new ImageIcon(resizedImage));
	    }

	    private BufferedImage applySobelFilter(BufferedImage img) {
	    	
	    	
    		BufferedImage originalImage = new BufferedImage(
	    			img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
	    		Graphics g = originalImage.getGraphics();
	    		g.drawImage(img, 0, 0, null);
	    		g.dispose();
	    	
	    	
	    	
	        // D�finir la matrice 1
	        float[] matrix1 = {
	                -1f, 0f, 1f,
	                -2f, 0f, 2f,
	                -1f, 0f, 1f
	        };
	        
	        // D�finir la matrice 2
	        float[] matrix2 = {
	                -1f, -2f,-1f,
	                0f, 0f, 0f,
	                1f, 2f, 1f
	        };
	          

	        // Appliquer le filtre Sobel � l'image
	        Kernel kernel1 = new Kernel(3, 3, matrix1);
	        ConvolveOp convultion1 = new ConvolveOp(kernel1);
	        BufferedImage resultatint = convultion1.filter(originalImage , null) ;
	        
	        Kernel kernel2 = new Kernel(3, 3, matrix2);
	        ConvolveOp convultion2 = new ConvolveOp(kernel2);
	        
	        return convultion2.filter(resultatint, null);
	    }
	}