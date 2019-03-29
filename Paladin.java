abstract class Paladin extends Personnage implements Combattre, Soigner{
  int pointsAttq;
  int pointsSoin;

  public Paladin (String nom, int pointsAttq, int pointsSoin) {
    super(nom);
    this.pointsAttq = pointsAttq;
    this.pointsSoin = pointsSoin;
  }

  public abstract void diminuerVie(Personnage cible);

  public abstract void augmenteVie(Personnage cible);

  public String allInfo () {
    return super.allInfo() + "\n  > P. ATTQ : " + pointsAttq +
    "\n  > P. SOIN : " + pointsSoin;
  }
}
