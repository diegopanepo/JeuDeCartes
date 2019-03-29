public class Main {

  public static void main(String[] args) {
    //System.out.println("Hola mundo");
    System.out.println("\nBIENVENU AU JEU DE CARTES\n");
    //System.out.println("Choisissez un personnage parmi :")

    Demon claudio = new Demon("Claudio",15,3);
    System.out.println(claudio.allInfo());
    //println("Points de vie : " + super.super.this.pointsVie);
    Magicien mefisto = new Magicien("Mefisto",20,8);
    System.out.println(mefisto.allInfo());
    mefisto.diminuerVie(claudio);
    claudio.augmenteVie(mefisto);
    System.out.println(claudio.allInfo());
    System.out.println(mefisto.allInfo());
  }
}
