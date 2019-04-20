import java.util.Random;

public class Archer extends Guerrier {
	//pointsAttq = 10;

	public Archer(String nom, int pointsAttq) {
		super(nom, pointsAttq);
	}

	public Archer(String nom) {
		super(nom);
	}

	public String diminuerVie(Personnage cible) {
		//Archer n'attaque que si l'ennemi est loin
		Random rand = new Random();
		String mess;
		int distance = rand.nextInt(20);
		if(distance > 10) {
			cible.attacked(pointsAttq);
			mess = this.nom + "  ->  " + cible.nom + " -" + pointsAttq + "PV\n";
			System.out.println(mess);
		}
		else {
			mess = this.nom + "  ->  " + cible.nom + " est trop proche pour l'attaquer\n";
			System.out.println(mess);
		}
		return mess;
	}

	public String allInfo() {
	return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
	/*"\n> Sousclasse : " + this.getClass().getName() +*/ super.allInfo() + "\n";
	}
}
