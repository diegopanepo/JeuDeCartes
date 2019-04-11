import java.util.Random;

public class Medecin extends Soigneur {
  //pointsSoin = 10;

  public Medecin(String nom, int pointsSoin) {
    super(nom, pointsSoin);
  }

  public void augmenteVie(Personnage cible) {
    //Medecin reçoit un peu de dommage quand il soigne
    Random rand = new Random();
    int de = rand.nextInt(6);
    cible.healed(pointsSoin);
    this.attacked(de);
    System.out.println(cible.nom + " +" + pointsSoin + "PV\n" + nom +
      " -" + de + "PV (recul)\n");
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n> Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
