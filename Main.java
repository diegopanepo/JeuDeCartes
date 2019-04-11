import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Personnage> listPerso = new ArrayList<Personnage>();
	static Scanner clavier = new Scanner(System.in);

  public static void main(String[] args) {
    //System.out.println("Hola mundo");
    System.out.println("\nBIENVENU AU JEU DE CARTES\n");
    //System.out.println("Choisissez un personnage parmi :");

	System.out.println("\nCreation de Medecin Michael, Psoin = 6\n");
	Medecin mike = new Medecin("Michael",6);
	System.out.println(mike.allInfo());

	System.out.println("\nCreation de Minotaure Claudio, Pattq = 15\n");
    Minotaure claudio = new Minotaure("Claudio",15);
    System.out.println(claudio.allInfo());

	System.out.println("\nCreation de Demon Mefisto, Pattq = 20, Psoin = 3\n");
    Demon mefisto = new Demon("Mefisto",20,3);
	System.out.println(mefisto.allInfo());

	mefisto.diminuerVie(claudio);
    claudio.diminuerVie(mefisto);
    System.out.println(claudio.allInfo());
    System.out.println(mefisto.allInfo());
	mike.augmenteVie(mefisto);
  }
}
