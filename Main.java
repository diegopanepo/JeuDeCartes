import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
//import java.util.InputMismatchException;
//import javax.swing.JOptionPane;

public class Main {
	static ArrayList<Personnage> joueur1 = new ArrayList<Personnage>();
	static ArrayList<Personnage> joueur2 = new ArrayList<Personnage>();
	static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\nBIENVENU AU JEU DE CARTES\n");
		System.out.println("Chaque joueur aura le droit à 4 personnages");

		initEquipe(joueur1);
		initEquipe(joueur2);

		System.out.println("\nEQUIPE 1\n");
		for(Personnage perso : joueur1)
			System.out.println(perso.allInfo());

		System.out.println("\nEQUIPE 2\n");
		for(Personnage perso : joueur2)
			System.out.println(perso.allInfo());
  }

	public static void initEquipe(ArrayList<Personnage> joueur)
		throws IndexOutOfBoundsException {
		int i, option;
		String[] perso = {"Archer","Chaman","Demon","Magicien","Medecin","Minotaure"};

		for(i = 0; i < 4; i++) {
			Random rand = new Random();
			option = rand.nextInt(perso.length - 1);
			if(perso[option] == "") {
				i--;
				continue;
			}
			else
				switch(option) {
					case 0 :
						joueur.add(new Archer(perso[option]));
						perso[option] = "";
						break;
					case 1 :
						joueur.add(new Chaman(perso[option]));
						perso[option] = "";
						break;
					case 2 :
						joueur.add(new Demon(perso[option]));
						perso[option] = "";
						break;
					case 3:
						joueur.add(new Magicien(perso[option]));
						perso[option] = "";
						break;
					case 4:
						joueur.add(new Medecin(perso[option]));
						perso[option] = "";
						break;
					case 5:
						joueur.add(new Minotaure(perso[option]));
						perso[option] = "";
				}
		}
  }
}
