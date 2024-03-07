import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;





public class UI {
	
	public static JFrame mainFrame;


	public  UI() {
		// création de la fenetre pour charger une image
		mainFrame = new JFrame("Charger une image");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bouton pour charger une image
		JButton loadImageButton = new JButton("Charger une image");
		loadImageButton.addActionListener(new LoadImageActionListener());
		mainFrame.add(loadImageButton);

		// parametrage de la fenetre
		mainFrame.setSize(300, 100);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
    // Point d'entrée de l'application
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UI());
	}

}
