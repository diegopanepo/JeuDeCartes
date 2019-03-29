public class Demon extends Paladin {
  //pointsAttq = 15;
  //pointsSoin = 8;

  public Demon(String nom, int pointsAttq, int pointsSoin) {
    super(nom, pointsAttq, pointsSoin);
  }

  public String allInfo() {
    return nom + "\nClasse : " + this.getClass().getSuperclass().getName() +
    "\nSousclasse : " + this.getClass().getName() + super.allInfo();
  }
}
