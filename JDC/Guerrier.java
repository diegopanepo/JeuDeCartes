public class Guerrier extends Personnage implements Combattre {
  int pointsAttq;

  public Guerrier (String nom, int pointsAttq) {
    super(nom);
    this.pointsAttq = pointsAttq;
  }

  public void diminuerVie(Personnage cible) {
    cible.attacked(pointsAttq);
  }

  public String allInfo() {
    return super.allInfo() + "\n  > P. ATTQ : " + pointsAttq;
  }
}
