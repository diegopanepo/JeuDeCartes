public class Paladin extends Personnage implements Combattre, Soigner{
  int pointsAttq;
  int pointsSoin;

  public Paladin (String nom, int pointsAttq, int pointsSoin) {
    super(nom);
    this.pointsAttq = pointsAttq;
    this.pointsSoin = pointsSoin;
  }

  public void diminuerVie(Personnage cible) {
    cible.attacked(pointsAttq);
  }

  public void augmenteVie(Personnage cible) {
    cible.healed(pointsSoin);
  }

  public String allInfo () {
    return super.allInfo() + "\n Points d'Attaque : " + pointsAttq +
    "\n Points de Soin : " + pointsSoin;
  }
}
