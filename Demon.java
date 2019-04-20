import java.util.ArrayList;

public class Demon extends Paladin {
	//pointsAttq = 15;
	//pointsSoin = 8;

	public Demon(String nom, int pointsAttq, int pointsSoin) {
		super(nom, pointsAttq, pointsSoin);
	}

	public Demon(String nom) {
		super(nom);
		this.pointsSoin -= 4;
	}

	public String diminuerVie(Personnage cible) {
		//Demon attaque au cible mais aussi à un co-équipier ou lui même au hasard
		//encore en construction
		String mess = this.nom + "  ->  " + cible.nom + " -" + pointsAttq + "PV\n";
		cible.attacked(pointsAttq);
		System.out.println(mess);
		//System.out.println(coequipier.nom + " - " + pointsAttq + " PV\n");
		return mess;
	}

	public String augmenteVie(Personnage cible) {
		//Demon n'a jamais beaucoup de points de soin mais ne rate pas
		String mess = cible.nom + " +" + pointsSoin + "PV\n";
		cible.healed(pointsSoin);
		System.out.println(mess);
		return mess;
	}

	public String allInfo() {
		return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
		/*"\n> Sousclasse : " + this.getClass().getName() +*/ super.allInfo() + "\n";
	}
}
