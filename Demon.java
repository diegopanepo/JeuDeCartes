public class Demon extends Paladin {
  //pointsAttq = 15;
  //pointsSoin = 8;

  public Demon(String nom, int pointsAttq, int pointsSoin) {
    super(nom, pointsAttq, pointsSoin);
  }

  public void diminuerVie(Personnage cible) {
    //Demon attaque au cible mais aussi à un co-équipier ou lui même au hasard
    //encore en construction
    cible.attacked(pointsAttq);
    System.out.println(cible.nom + " -" + pointsAttq + "PV\n");
		//System.out.println(coequipier.nom + " - " + pointsAttq + " PV\n");
  }

  public void augmenteVie(Personnage cible) {
    //Demon n'a jamais beaucoup de points de soin mais ne rate pas
    cible.healed(pointsSoin);
    System.out.println(cible.nom + " +" + pointsSoin + "PV\n");
  }

  public String allInfo() {
    return nom + "\n> Classe : " + this.getClass().getSuperclass().getName() +
    "\n> Sousclasse : " + this.getClass().getName() + super.allInfo() + "\n";
  }
}
