import java.util.Random;

public class Chaman extends Soigneur {
	//pointsSoin = 15;

	public Chaman(String nom, int pointsSoin) {
		super(nom, pointsSoin);
	}

	public Chaman(String nom) {
		super(nom);
	}

	public String augmenteVie(Personnage cible) {
		//Chaman a une chance sur 5 de soigner avec un bonus
		Random rand = new Random();
		int de = rand.nextInt(20);
		String mess = this.nom + "  ->  " + cible.nom + " +" + pointsSoin + "PV";
		if(de % 4 == 0) {
			mess = mess + " +5PV ! (bonus)\n";
			cible.healed(pointsSoin + 5);
			System.out.println(mess);
		}
		else {
			mess = mess + "\n";
			cible.healed(pointsSoin);
			System.out.println(mess);
		}
		return mess;
	}

	public String allInfo() {
		return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
		/*"\n> Sousclasse : " + this.getClass().getName() +*/ super.allInfo() + "\n";
  }
}
