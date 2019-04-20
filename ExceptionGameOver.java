import javax.swing.JOptionPane;

public class ExceptionGameOver extends Exception {
	public ExceptionGameOver() {
		JOptionPane.showMessageDialog(null, "Le jeu est fini\nMerci pour jouer");
	}
}
