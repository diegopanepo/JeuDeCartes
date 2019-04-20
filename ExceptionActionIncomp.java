import javax.swing.JOptionPane;

public class ExceptionActionIncomp extends Exception {
	public ExceptionActionIncomp(Personnage perso, String classe, String act) {
		JOptionPane.showMessageDialog(null, perso.nom + " est de classe " +
			classe + " et ne peut pas " + act);
	}
}
