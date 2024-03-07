import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

    // ActionListener pour charger une image
	public class LoadImageActionListener implements ActionListener {
		
		public static BufferedImage img ;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// choix de l'image
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(UI.mainFrame);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();

				try {
					// lecture de l'image
					img = ImageIO.read(selectedFile);
					UI.mainFrame.dispose();
					MainInterface.showImageViewer();
					
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(UI.mainFrame, "Erreur lors du chargement de l'image", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
