package JDC;

public class Minotaure extends Guerrier {
  //pointsAttq = 15;

  public Minotaure(String nom, int pointsAttq) {
    super(nom, pointsAttq);
  }

  public String allInfo() {
    return nom + "\nClasse : " + this.getClass().getSuperclass().getName() +
    "\nSousclasse : " + this.getClass().getName() + super.allInfo();
  }
}
