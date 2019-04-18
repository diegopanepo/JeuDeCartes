import javax.swing.JOptionPane;

public class ExceptionSoinEnnemi extends Exception {
	public ExceptionSoinEnnemi() {
		JOptionPane.showMessageDialog(null,
			"Vous ne pouvez pas soigner un ennemi\nRéfléchisez votre tactique !");
	}
}
