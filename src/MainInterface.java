import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainInterface {
	
	public static JLabel imageLabel;
	
	// On recupere l'image
	 static BufferedImage image = LoadImageActionListener.img ;
	
    // notre fenetre principale
	public static void showImageViewer() {
		JFrame imageFrame = new JFrame("Image Viewer");
		imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bouton pour afficher les dimensions et les valeurs des pixels
		JButton showDimensionsButton = new JButton("Afficher Dimensions");
		showDimensionsButton.addActionListener(new ShowDimensionsActionListener());
		imageFrame.add(showDimensionsButton, BorderLayout.NORTH);

		// Bouton pour afficher la valeur RGB des pixels 
		JButton showPixelValuesButton = new JButton("Valeur des pixels");
		showPixelValuesButton.addActionListener(new ShowPixelValuesActionListener());
		imageFrame.add(showPixelValuesButton, BorderLayout.SOUTH);

        // Redimensionne l'image pour l'afficher dans le panneau
		Image resizedImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
		JPanel imagePanel = new JPanel(new FlowLayout());

		imageLabel = new JLabel(new ImageIcon(resizedImage));
		imagePanel.add(imageLabel);
		imageFrame.add(imagePanel, BorderLayout.CENTER);

        // Ajout du bouton "Comparer" 
		JButton compareButton = new JButton("Comparer");
		compareButton.addActionListener(new CompareImagesActionListener());
		imagePanel.add(compareButton);
		
		// Ajout du bouton "image origine" 
		JButton originalphotoButton = new JButton("image d'origine");
		originalphotoButton.addActionListener(new OriginalphotoActionListener());
		imagePanel.add(originalphotoButton);
		
		// Ajout du bouton "niveau gris" 
		JButton applygrisFilterButton = new JButton("niveau de gris");
		applygrisFilterButton.addActionListener(new ApplygrisFilterActionListener());
		imagePanel.add(applygrisFilterButton);

		
		// Ajout du bouton "Appliquer Filtre Gaussien" 
		JButton applyGaussianFilterButton = new JButton("Filtre Gaussien");
		applyGaussianFilterButton.addActionListener(new ApplyGaussianFilterActionListener());
		imagePanel.add(applyGaussianFilterButton);
		
		// Ajout du bouton "Filtre Sobel" 
		JButton applySobelFilterButton = new JButton("Filtre Sobel");
		applySobelFilterButton.addActionListener(new ApplySobelFilterActionListener());
		imagePanel.add(applySobelFilterButton);
		
		// Ajout du bouton "Filtre moyen" 
		JButton applyMoyenFilterButton = new JButton("Filtre Moyen");
		applyMoyenFilterButton.addActionListener(new ApplyMoyenFilterActionListener());
		imagePanel.add(applyMoyenFilterButton);


		// parametres de la fenetre 
		imageFrame.setSize(800, 600);
		imageFrame.setLocationRelativeTo(null);
		imageFrame.setVisible(true);
	}

}
