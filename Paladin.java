import java.util.Random;

abstract class Paladin extends Personnage implements Combattre, Soigner{
	protected int pointsAttq;
	protected int pointsSoin;

	public Paladin(String nom, int pointsAttq, int pointsSoin) {
		super(nom);
		this.pointsAttq = pointsAttq;
		this.pointsSoin = pointsSoin;
	}

	public Paladin(String nom) {
		super(nom);
		Random rand = new Random();
		this.pointsAttq = rand.nextInt(3) + 10;
		rand = new Random();
		this.pointsSoin = rand.nextInt(3) + 8;
	}

	public abstract String diminuerVie(Personnage cible);

	public abstract String augmenteVie(Personnage cible);

	public String allInfo() {
		return super.allInfo() + "\n  > P. ATTQ : " + pointsAttq +
			"\n  > P. SOIN : " + pointsSoin;
	}
}
