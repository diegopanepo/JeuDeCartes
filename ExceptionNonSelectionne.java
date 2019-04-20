import javax.swing.JOptionPane;

public class ExceptionNonSelectionne extends Exception {
	public ExceptionNonSelectionne() {
		JOptionPane.showMessageDialog(null,
			"Vous devez séléctionner votre personnage et sa cible\n" +
			"(en cas de soigne, votre personnage suffit)");
	}
}
