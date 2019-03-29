public class Demon extends Paladin {
  //pointsAttq = 15;
  //pointsSoin = 8;

  public Demon(String nom, int pointsAttq, int pointsSoin) {
    super(nom, pointsAttq, pointsSoin);
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n  > Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
