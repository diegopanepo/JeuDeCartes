import java.util.Random;

public class Magicien extends Paladin {
  //pointsAttq = 10;
  //pointsSoin = 10;

  public Magicien(String nom, int pointsAttq, int pointsSoin) {
    super(nom, pointsAttq, pointsSoin);
  }

  public void diminuerVie(Personnage cible) {
    //Magicien a une chance sur 3 d'attaquer avec un bonus
    Random rand = new Random();
    int de = rand.nextInt(15);
    System.out.print(cible.nom + " -" + pointsAttq + "PV");
    if(de % 5 == 0) {
      cible.attacked(pointsAttq + 3);
      System.out.println(" +3PV ! (bonus)\n");
    }
    else {
      cible.attacked(pointsAttq);
      System.out.println("\n");
    }
  }

  public void augmenteVie(Personnage cible) {
    //Demon n'a jamais beaucoup de points de soin
    cible.healed(pointsSoin);
    System.out.println(cible.nom + " a été soigné");
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n> Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
