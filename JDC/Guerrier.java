abstract class Guerrier extends Personnage implements Combattre {
  int pointsAttq;

  public Guerrier (String nom, int pointsAttq) {
    super(nom);
    this.pointsAttq = pointsAttq;
  }

  public abstract void diminuerVie(Personnage cible);

  public String allInfo() {
    return super.allInfo() + "\n  > P. ATTQ : " + pointsAttq;
  }
}
