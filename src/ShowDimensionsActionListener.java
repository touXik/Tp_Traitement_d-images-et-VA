import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

    // ActionListener pour afficher les dimensions de l'image
	public class ShowDimensionsActionListener implements ActionListener {
		
		// On recupere l'image
		 static BufferedImage image = LoadImageActionListener.img ;
		 
		@Override
		public void actionPerformed(ActionEvent e) {
			if (image != null) {
				// recuperation de la hauteur et de la largeur de l'image 
				int largeur = image.getWidth();
				int hauteur = image.getHeight();
				
				// affichage des dimensions a travers une fenetre de dialogue 
				JOptionPane.showMessageDialog(UI.mainFrame, "Dimensions de l'image : " + largeur + " x " + hauteur,
						"Dimensions", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
