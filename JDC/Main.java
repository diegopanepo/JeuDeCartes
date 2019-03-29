public class Main {

  public static void main(String[] args) {
    //System.out.println("Hola mundo");
    System.out.println("BIENVENU AU JEU DE CARTES\n");
    //System.out.println("Choisissez un personnage parmi :")

    Minotaure claudio = new Minotaure("Claudio",15);
    System.out.println(claudio.allInfo());
    //println("Points de vie : " + super.super.this.pointsVie);
    Demon mefisto = new Demon("Mefisto",20,5);
    System.out.println(mefisto.allInfo());
  }
}
