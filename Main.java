import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Personnage> listPerso = new ArrayList<Personnage>();
	static Scanner clavier = new Scanner(System.in);
	int i, j;

  public static void main(String[] args) {
    //System.out.println("Hola mundo");
    System.out.println("\nBIENVENU AU JEU DE CARTES\n");
		initEquipes();

	/*System.out.println("\nCreation de Medecin Michael, Psoin = 6\n");
	Medecin mike = new Medecin("Michael",6);
	listPerso.add(mike);
	//System.out.println(mike.allInfo());

	System.out.println("\nCreation de Minotaure Claudio, Pattq = 15\n");
    Minotaure claudio = new Minotaure("Claudio",15);
	listPerso.add(claudio);
    //System.out.println(claudio.allInfo());

	System.out.println("\nCreation de Demon Mefisto, Pattq = 20, Psoin = 3\n");
    Demon mefisto = new Demon("Mefisto",20,3);
	listPerso.add(mefisto);
	//System.out.println(mefisto.allInfo());

	for(int i = 0; i < listPerso.size(); i++)
		System.out.println(listPerso.get(i).allInfo());

	mefisto.diminuerVie(claudio);
    claudio.diminuerVie(mefisto);
    System.out.println(claudio.allInfo());
    System.out.println(mefisto.allInfo());
	mike.augmenteVie(mefisto);*/
  }

  public static void initEquipes() {
		int i, j, opcion;
		String nom;
		String[] perso = {"Archer","Chaman","Demon","Magicien","Medecin","Minotaure"};
		for(i = 1; i <= 2; i++) {
			System.out.println("Choissisez un personnage parmi :\n");
			for(j = 0; j < perso.length; j++)
				System.out.println((j+1) + ") " + perso[j]);
			System.out.print("\nCréer le personnage : ");
			opcion = clavier.nextInt() - 1;
			System.out.println("Quel nom lui donner ? ");
			nom = clavier.nextLine();
		}
  }
}
