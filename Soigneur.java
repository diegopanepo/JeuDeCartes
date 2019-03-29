abstract class Soigneur extends Personnage implements Soigner {
  int pointsSoin;

  public Soigneur (String nom, int pointsSoin) {
    super(nom);
    this.pointsSoin = pointsSoin;
  }

  public abstract void augmenteVie(Personnage cible);

  public String allInfo () {
    return super.allInfo() + "\n  > P. SOIN : " + pointsSoin;
  }
}
