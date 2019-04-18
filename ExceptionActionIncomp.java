import javax.swing.JOptionPane;

public class ExceptionActionIncomp extends Exception {
	public ExceptionActionIncomp() {
		JOptionPane.showMessageDialog(null,
			"L'action n'est pas possible pour ce personnage\n");
	}
}
