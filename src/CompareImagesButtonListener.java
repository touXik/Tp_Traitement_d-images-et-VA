import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

public class CompareImagesButtonListener implements ActionListener {
	
		// On recupere l'image
	 	static BufferedImage image = LoadImageActionListener.img ;
	 	


		@Override
		public void actionPerformed(ActionEvent e) {

            // appeler la methode pour comparer
			double similarity = compareImages(image, CompareImagesActionListener.secondImage);

            // Affichez le résultat de la comparaison
			String message = "Similarité des images : " + similarity + "%";
			JOptionPane.showMessageDialog(UI.mainFrame, message, "Comparaison", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// on effectue la comparaison avec cette methode
		public static double compareImages(BufferedImage img1, BufferedImage img2) {
			if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
				String message = "Les dimensions des images ne correspondent pas.";
				JOptionPane.showMessageDialog(UI.mainFrame, message, "Comparaison", JOptionPane.INFORMATION_MESSAGE);
				throw new IllegalArgumentException("Les dimensions des images ne correspondent pas.");
			}

			int width = img1.getWidth();
			int height = img1.getHeight();
			int matchingPixels = 0;

			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (img1.getRGB(x, y) == img2.getRGB(x, y)) {
						matchingPixels++;
					}
				}
			}

			int totalPixels = width * height;
			return (double) matchingPixels / totalPixels * 100.0;
		}
	}
