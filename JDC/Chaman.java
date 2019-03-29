package JDC;

public class Chaman extends Soigneur {
  //pointsSoin = 15;

  public Chaman(String nom, int pointsSoin) {
    super(nom, pointsSoin);
  }

  public String allInfo() {
    return nom + "\nClasse : " + this.getClass().getSuperclass().getName() +
    "\nSousclasse : " + this.getClass().getName() + super.allInfo();
  }
}
