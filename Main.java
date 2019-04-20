import java.util.ArrayList;
import java.util.Random;

//****************************************************************//
//	EXPLICATION JEU DE CARTES par Diego Moreno Villanueva EISE3		//
//	Le jeu consiste en deux équipes avec 4 personnages chacun			//
//	Le but du jeu est d'éliminer le plus vite possible à l'autre	//
//	équipe, et pour ce faire il suffit d'éliminer tous les perso	//
//	autres que les Soigneurs (puisqu'ils ne peuvent que soigner)	//
//	L'interface du jeu inclut les listes avec les personnages dont//
//	les caractéristiques sont affichées avec un appui; les boutons//
//	pour attaquer ou soigner et un tableau qui indique la dernière//
//	action faite. Le futur du projet est d'améliorer l'interface	//
// en demandant aux joueurs de nommer eux mêmes les personnages		//
//****************************************************************//

public class Main {

	static ArrayList<Personnage> joueur1 = new ArrayList<Personnage>();
	static ArrayList<Personnage> joueur2 = new ArrayList<Personnage>();

	public static void main(String[] args) {

		System.out.println("\nBIENVENU AU JEU DE CARTES\n");
		System.out.println("Chaque joueur aura le droit à 4 personnages\n");

		initEquipe(joueur1);
		initEquipe(joueur2);
/*
		System.out.println("\nEQUIPE 1\n");
		for(Personnage perso : joueur1)
			System.out.println(perso.allInfo());

		System.out.println("\nEQUIPE 2\n");
		for(Personnage perso : joueur2)
			System.out.println(perso.allInfo());
*/
		Fenetre combat = new Fenetre(joueur1, joueur2);
  }

	public static void initEquipe(ArrayList<Personnage> joueur) {//, int nb)
		//throws IndexOutOfBoundsException {
		int i, option;
		//String nom;
		//String[] ordre = {"premier","deuxième","troisième","quatrième"};
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
		//System.out.println("\nJOUEUR "+nb+"\nChoissisez vos personnages parmi :");
		//for(j = 0; j < perso.length; j++)
		//	System.out.println(j+1 + ") " + perso[j]);
		/*for(j = 0; j < 4; j++) {
			System.out.print("\nEntrez le nombre du " + ordre[j] + " personnage : ");
			try {
				opcion = clavier.nextInt() - 1;
				//if(perso[opcion] == "VerifierBound") continue;
				if(opcion < 0 || opcion > 5) throw new IndexOutOfBoundsException();
				clavier.nextLine();
				System.out.print("Quel nom lui donner ? ");
				nom = clavier.nextLine();
				switch(opcion) {
					case 0 :
						joueur.add(new Archer(nom,opcion));
						break;
					case 1 :
						joueur.add(new Chaman(nom,opcion));
						break;
					case 2 :
						joueur.add(new Demon(nom,opcion,opcion));
						break;
					case 3:
						joueur.add(new Magicien(nom,opcion,opcion));
						break;
					case 4:
						joueur.add(new Medecin(nom,opcion));
						break;
					case 5:
						joueur.add(new Minotaure(nom,opcion));
				}
			} catch(InputMismatchException nombre){
				JOptionPane.showMessageDialog(null,"Ce champ n'accepte que des" +
					" nombres\nReessayez");
				j--;
			} catch(IndexOutOfBoundsException array) {
				JOptionPane.showMessageDialog(null,"Le nombre n'est pas valable");
				j--;
			}
		}*/
	}

}
