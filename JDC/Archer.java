package JDC;

public class Archer extends Guerrier {
  //pointsAttq = 10;

  public Archer(String nom, int pointsAttq) {
    super(nom, pointsAttq);
  }

  public String allInfo() {
    return nom + "\nClasse : " + this.getClass().getSuperclass().getName() +
    "\nSousclasse : " + this.getClass().getName() + super.allInfo();
  }
}
