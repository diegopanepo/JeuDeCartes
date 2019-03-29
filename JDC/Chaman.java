public class Chaman extends Soigneur {
  //pointsSoin = 15;

  public Chaman(String nom, int pointsSoin) {
    super(nom, pointsSoin);
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n  > Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
