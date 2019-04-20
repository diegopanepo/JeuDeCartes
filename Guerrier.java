import java.util.Random;

abstract class Guerrier extends Personnage implements Combattre {
	protected int pointsAttq;

	public Guerrier(String nom, int pointsAttq) {
		super(nom);
		this.pointsAttq = pointsAttq;
	}

	public Guerrier(String nom) {
		super(nom);
		Random rand = new Random();
		this.pointsAttq = rand.nextInt(5) + 15;
	}

	public abstract String diminuerVie(Personnage cible);

	public String allInfo() {
		return super.allInfo() + "\n  > P. ATTQ : " + pointsAttq;
	}
}
