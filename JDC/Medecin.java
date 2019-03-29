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
    System.out.println(cible.nom + " a été soigné mais " + nom +
      " a reçu " + de + " de dommage\n");
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n> Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
