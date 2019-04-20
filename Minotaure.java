import java.util.Random;

public class Minotaure extends Guerrier {
	//pointsAttq = 15;

	public Minotaure(String nom, int pointsAttq) {
		super(nom, pointsAttq);
	}

	public Minotaure(String nom) {
		super(nom);
	}

	public String diminuerVie(Personnage cible) {
		//Minotaure n'attaque que si l'ennemi est proche
		Random rand = new Random();
		int distance = rand.nextInt(20);
		String mess = this.nom + "  ->  ";
		if(distance < 8) {
			cible.attacked(pointsAttq);
			mess = mess + cible.nom + " -" + pointsAttq + "PV\n";
			System.out.println(mess);
		}
		else {
			mess = mess + cible.nom + " est trop loin pour l'attaquer\n";
			System.out.println(mess);
		}
		return mess;
	}

	public String allInfo() {
		return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
			/*"\n> Sousclasse : " + this.getClass().getName() +*/ super.allInfo() + "\n";
	}
}
