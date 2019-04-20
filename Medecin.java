import java.util.Random;

public class Medecin extends Soigneur {
	//pointsSoin = 10;

	public Medecin(String nom, int pointsSoin) {
		super(nom, pointsSoin);
	}

	public Medecin(String nom) {
		super(nom);
	}

	public String augmenteVie(Personnage cible) {
		//Medecin reçoit un peu de dommage quand il soigne
		Random rand = new Random();
		int de = rand.nextInt(6);
		String mess = this.nom + "  ->  " + cible.nom + " +" + pointsSoin +
			"PV\n -" + de + "PV (recul)\n";
		cible.healed(pointsSoin);
		this.attacked(de);
		System.out.println(mess);
		return mess;
	}

	public String allInfo() {
		return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
			/*"\n> Sousclasse : " + this.getClass().getName() +*/ super.allInfo() + "\n";
	}
}
