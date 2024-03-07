import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

// MouseAdapter pour obtenir les valeurs des pixels lors du clic
	public class ROIMouseAdapter extends MouseAdapter {
		
		// On recupere l'image
		 static BufferedImage image = LoadImageActionListener.img ;
		 static BufferedImage image2 = resize ( image , 600 , 400 ) ;
		 
		@Override
		public void mouseClicked(MouseEvent e) {
			
			// on recupere les cordonnées de la souris 
			int mouseX = e.getX();
			int mouseY = e.getY();
			
		    
			// on recupere la valeur des pixels ici
			Color pixelColor = new Color(image2.getRGB(mouseX, mouseY));
			
            // affichage
			String pixelValuesText = "Valeurs du pixel : R=" + pixelColor.getRed() + ", G=" + pixelColor.getGreen()
					+ ", B=" + pixelColor.getBlue();
			JOptionPane.showMessageDialog(UI.mainFrame, pixelValuesText, "Valeurs des Pixels",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		// petite fonction pour redimentioner une image de classe BufferedImage 
		public static BufferedImage resize(BufferedImage originalImage, int newWidth, int newHeight) {
	        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
	        Graphics2D g = resizedImage.createGraphics();

	        // Utiliser AffineTransformOp pour redimensionner l'image
	        AffineTransform transform = AffineTransform.getScaleInstance((double) newWidth / originalImage.getWidth(),
	                                                                    (double) newHeight / originalImage.getHeight());
	        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
	        op.filter(originalImage, resizedImage);

	        g.dispose();

	        return resizedImage;
	    }
		
		
	}

