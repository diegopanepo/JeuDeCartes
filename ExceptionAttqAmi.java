import javax.swing.JOptionPane;

public class ExceptionAttqAmi extends Exception {
	public ExceptionAttqAmi() {
		JOptionPane.showMessageDialog(null,
			"Vous ne pouvez pas attaquer un ami\nRéfléchisez votre tactique !");
	}
}
