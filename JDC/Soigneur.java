package JDC;

public class Soigneur extends Personnage implements Soigner {
  int pointsSoin;

  public Soigneur (String nom, int pointsSoin) {
    super(nom);
    this.pointsSoin = pointsSoin;
  }

  public void augmenteVie(Personnage cible) {
    cible.healed(pointsSoin);
  }

  public String allInfo () {
    return super.allInfo() + "\n Points de Soin : " + pointsSoin;
  }
}
