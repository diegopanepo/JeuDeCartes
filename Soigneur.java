import java.util.Random;

abstract class Soigneur extends Personnage implements Soigner {
	protected int pointsSoin;

	public Soigneur(String nom, int pointsSoin) {
		super(nom);
		this.pointsSoin = pointsSoin;
	}

	public Soigneur(String nom) {
		super(nom);
		Random rand = new Random();
		this.pointsSoin = rand.nextInt(5) + 10;
	}

	public abstract void augmenteVie(Personnage cible);

	public String allInfo () {
		return super.allInfo() + "\n  > P. SOIN : " + pointsSoin;
	}
}
