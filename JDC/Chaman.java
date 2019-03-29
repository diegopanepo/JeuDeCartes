import java.util.Random;

public class Chaman extends Soigneur {
  //pointsSoin = 15;

  public Chaman(String nom, int pointsSoin) {
    super(nom, pointsSoin);
  }

  public void augmenteVie(Personnage cible) {
    //Chaman a une chance sur 5 de soigner avec un bonus
    Random rand = new Random();
    int de = rand.nextInt(20);
    System.out.print(cible.nom + " a été soigné");
    if(de % 4 == 0) {
      cible.healed(pointsSoin + 5);
      System.out.println(" avec un bonus de vie\n");
    }
    else {
      cible.healed(pointsSoin);
      System.out.println("\n");
    }
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n> Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
