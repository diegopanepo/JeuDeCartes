import javax.swing.JOptionPane;

public class ExceptionPersoMort extends Exception {
	public ExceptionPersoMort(Personnage perso) {
		JOptionPane.showMessageDialog(null, perso.nom + " est déjà mort !");
	}
}
