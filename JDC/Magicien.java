public class Magicien extends Paladin {
  //pointsAttq = 10;
  //pointsSoin = 10;

  public Magicien(String nom, int pointsAttq, int pointsSoin) {
    super(nom, pointsAttq, pointsSoin);
  }

  public String allInfo() {
    return nom + "\nClasse : " + this.getClass().getSuperclass().getName() +
    "\nSousclasse : " + this.getClass().getName() + super.allInfo();
  }
}
