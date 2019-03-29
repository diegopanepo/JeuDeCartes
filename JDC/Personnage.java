import java.util.Random;

abstract class Personnage {
  protected String nom;
  protected int pointsVie;

  public Personnage(String nom) {
    Random rand = new Random();
    this.nom = nom;
    this.pointsVie = rand.nextInt(10) + 100;
  }

  public void attacked(int degat) {
    pointsVie -= degat;
  }

  public void healed(int heal) {
    pointsVie += heal;
  }

  public String allInfo() {
    return "\n  > P. VIE  : " + pointsVie;
  }
}
