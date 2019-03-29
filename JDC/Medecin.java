public class Medecin extends Soigneur {
  //pointsSoin = 10;

  public Medecin(String nom, int pointsSoin) {
    super(nom, pointsSoin);
  }

  public String allInfo() {
    return nom + "\nClasse : " + this.getClass().getSuperclass().getName() +
    "\nSousclasse : " + this.getClass().getName() + super.allInfo();
  }
}
