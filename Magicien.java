import java.util.Random;

public class Magicien extends Paladin {
  //pointsAttq = 10;
  //pointsSoin = 10;

	public Magicien(String nom, int pointsAttq, int pointsSoin) {
		super(nom, pointsAttq, pointsSoin);
	}

	public Magicien(String nom) {
		super(nom);
	}

	public String diminuerVie(Personnage cible) {
		//Magicien a une chance sur 3 d'attaquer avec un bonus
		Random rand = new Random();
		int de = rand.nextInt(15);
		String mess = this.nom + "  ->  " + cible.nom + " -" + pointsAttq + "PV";
		if(de % 5 == 0) {
			mess = mess + " -3PV ! (bonus)\n";
			cible.attacked(pointsAttq + 3);
			System.out.println(mess);
		}
		else {
			mess = mess + "\n";
			cible.attacked(pointsAttq);
			System.out.println(mess);
		}
		return mess;
	}

	public String augmenteVie(Personnage cible) {
		//Magicien cure effectivement a ses allies
		String mess = this.nom + "  ->  " + cible.nom + " +" + pointsSoin + "PV\n";
		cible.healed(pointsSoin);
		System.out.println(mess);
		return mess;
	}

	public String allInfo() {
		return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
		/*"\n> Sousclasse : " + this.getClass().getName() +*/ super.allInfo() + "\n";
	}
}
