public class Guerrier extends Personnage implements Combattre {
  int pointsAttq;

  public Guerrier (String nom, int pointsAttq) {
    super(nom);
    this.pointsAttq = pointsAttq;
  }

  public void diminuerVie(Personnage cible) {
    //cible.attacked(pointsAttq);
    //System.out.println("Mammal eats");
  }

  public String allInfo() {
    return super.allInfo() + "\n  > Points d'Attaque : " + pointsAttq;
  }
}
