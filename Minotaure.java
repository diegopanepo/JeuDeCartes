import java.util.Random;

public class Minotaure extends Guerrier {
	//pointsAttq = 15;

	public Minotaure(String nom, int pointsAttq) {
		super(nom, pointsAttq);
	}

	public Minotaure(String nom) {
		super(nom);
	}

	public void diminuerVie(Personnage cible) {
		//Minotaure n'attaque que si l'ennemi est proche
		Random rand = new Random();
		int distance = rand.nextInt(20);
		if(distance < 8) {
			cible.attacked(pointsAttq);
			System.out.println(cible.nom + " -" + pointsAttq + "PV\n");
		}
		else
		System.out.println(cible.nom + " est trop loin pour l'attaquer\n");
	}

	public String allInfo() {
		return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
			/*"\n> Sousclasse : " + this.getClass().getName() +*/ super.allInfo() + "\n";
	}
}
