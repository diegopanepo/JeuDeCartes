public class Medecin extends Soigneur {
  //pointsSoin = 10;

  public Medecin(String nom, int pointsSoin) {
    super(nom, pointsSoin);
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n  > Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
