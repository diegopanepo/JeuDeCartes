import java.util.Random;

public class Archer extends Guerrier {
  //pointsAttq = 10;

  public Archer(String nom, int pointsAttq) {
    super(nom, pointsAttq);
  }

  public void diminuerVie(Personnage cible) {
    //Archer n'attaque que si l'ennemi est loin
    Random rand = new Random();
    int distance = rand.nextInt(20);
    if(distance > 10) {
      cible.attacked(pointsAttq);
      System.out.println(cible.nom + "a été attaqué\n");
    }
    else
      System.out.println(cible.nom + "est trop proche pour l'attaquer\n");
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n> Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
