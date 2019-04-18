import javax.swing.JOptionPane;

public class ExceptionPersoMort extends Exception {
	public ExceptionPersoMort() {
		JOptionPane.showMessageDialog(null,
			"Ce personnage est déjà mort !");
	}
}
