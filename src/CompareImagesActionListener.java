import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


// ActionListener pour comparer les images
	public class CompareImagesActionListener implements ActionListener {
		
		// On recupere l'image
		 static BufferedImage image = LoadImageActionListener.img ;
		
		public static BufferedImage secondImage;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(UI.mainFrame);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();

				try {
					secondImage = ImageIO.read(selectedFile);
					showImageComparison();
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(UI.mainFrame, "Erreur lors du chargement de la deuxième image", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	    // Affiche le panneau de comparaison d'images
		private void showImageComparison() {
			JFrame compareFrame = new JFrame("Comparer les Images");
			compareFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        // Redimensionne la première image pour l'afficher dans le panneau
			Image resizedFirstImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
			JLabel firstImageLabel = new JLabel(new ImageIcon(resizedFirstImage));
	 
	        // Redimensionne la deuxième image pour l'afficher dans le panneau
			Image resizedSecondImage = secondImage.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
			JLabel secondImageLabel = new JLabel(new ImageIcon(resizedSecondImage));
			
            // bouton comparer 
			JButton compareButton = new JButton("Comparer");
			CompareImagesButtonListener compareButtonListener = new CompareImagesButtonListener();
			compareButton.addActionListener(compareButtonListener);

			JPanel imagePanel = new JPanel(new FlowLayout());
			imagePanel.add(firstImageLabel);
			imagePanel.add(secondImageLabel);

			JPanel buttonPanel = new JPanel(new FlowLayout());
			buttonPanel.add(compareButton);

			// parametres de la fenetre
			compareFrame.add(imagePanel, BorderLayout.CENTER);
			compareFrame.add(buttonPanel, BorderLayout.SOUTH);
			compareFrame.setSize(900, 400);
			compareFrame.setLocationRelativeTo(null);
			compareFrame.setVisible(true);
		}
	}
