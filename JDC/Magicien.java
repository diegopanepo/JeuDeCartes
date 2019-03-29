public class Magicien extends Paladin {
  //pointsAttq = 10;
  //pointsSoin = 10;

  public Magicien(String nom, int pointsAttq, int pointsSoin) {
    super(nom, pointsAttq, pointsSoin);
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n  > Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
