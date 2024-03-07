import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


    // ActionListener pour afficher les valeurs des pixels
	public class ShowPixelValuesActionListener implements ActionListener {
		
		public static JLabel imageLabel;
		
		// On recupere l'image
		 static BufferedImage image = LoadImageActionListener.img ;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame pixelValuesFrame = new JFrame("Valeurs des Pixels");
			pixelValuesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Redimensionne l'image pour l'afficher dans le panneau
			Image resizedImage = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
			JPanel imagePanel = new JPanel(new FlowLayout());

			imageLabel = new JLabel(new ImageIcon(resizedImage));
			imagePanel.add(imageLabel);

			pixelValuesFrame.add(imagePanel, BorderLayout.CENTER);
			imageLabel.addMouseListener(new ROIMouseAdapter());
			
			// zone text
			JTextField textField = new JTextField("^^ Cliquez avec la souris quelque part sur l'image ^^");
		    textField.setEditable(false); // Empêcher l'édition par l'utilisateur
		    textField.setHorizontalAlignment(JTextField.CENTER); // Centrer le texte
		    textField.setFont(new Font("Arial", Font.PLAIN, 25)); // Ajuster la polic
			pixelValuesFrame.add(textField, BorderLayout.SOUTH);


			pixelValuesFrame.setSize(700, 500);
			pixelValuesFrame.setLocationRelativeTo(null);
			pixelValuesFrame.setVisible(true);
		}
	}