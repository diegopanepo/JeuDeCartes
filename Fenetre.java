import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.applet.Applet;
import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Fenetre extends JFrame {

	static ArrayList<Personnage> joueur1, joueur2;
	protected boolean tour = true; // joueur1 = true // joueur2 = false //
	protected String attente = "-----   En attente de votre ordre   -----";
	protected JPanel nor = new JPanel();
	protected JPanel cen = new JPanel();
	protected JPanel sud = new JPanel();
	protected JPanel panelEq1 = new JPanel();
	protected JPanel panelEq2 = new JPanel();
	protected JPanel panelInfo1 = new JPanel();
	protected JPanel panelInfo2 = new JPanel();
	protected JButton combBut = new JButton("Combat");
	protected JButton soigBut = new JButton("Soigne");
	protected JTextArea tourJoueur1 = new JTextArea("Equipe1\nJOUE ->", 1, 4);
	protected JTextArea tourJoueur2 = new JTextArea("Equipe2", 1, 4);
	protected JTextArea info1 = new JTextArea(6, 12);
	protected JTextArea info2 = new JTextArea(6, 12);
	protected JTextArea descrip = new JTextArea(attente, 3, 18);
	protected JList JLequipe1, JLequipe2;
	protected DefaultListModel<String> model1 = new DefaultListModel<String>();
	protected DefaultListModel<String> model2 = new DefaultListModel<String>();

	public Fenetre(ArrayList<Personnage> joueur1, ArrayList<Personnage> joueur2) {

		this.joueur1 = joueur1;
		this.joueur2 = joueur2;

		this.setTitle("COMBAT");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 300);
		this.setResizable(false);
		this.setLayout(new GridLayout(3, 1));

		//initialisation des JLists
		for(Personnage perso : joueur1)
			model1.addElement(perso.nom);
		JLequipe1 = new JList(model1);

		for(Personnage perso : joueur2)
			model2.addElement(perso.nom);
		JLequipe2 = new JList(model2);

		//initialisation des ListSelectionListeners
		panelEq1.add(JLequipe1);
		//panelEq1.setPreferredSize(new Dimension(90, 90));
		panelEq2.add(JLequipe2);
		//panelEq2.setPreferredSize(new Dimension(90, 90));

		JLequipe1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent clic) {
				int index = JLequipe1.getSelectedIndex();
				info1.setText(joueur1.get(index).allInfo());
			}
		});
		JLequipe2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent clic) {
				int index = JLequipe2.getSelectedIndex();
				info2.setText(joueur2.get(index).allInfo());
			}
		});
		//initialisation des JButtons et MouseListeners
		combBut.setPreferredSize(new Dimension(90, 30));
		soigBut.setPreferredSize(new Dimension(90, 30));
		combBut.addMouseListener(new ActionCombat());
		soigBut.addMouseListener(new ActionSoigne());
		nor.add(tourJoueur1);
		nor.add(panelEq1);
		nor.add(combBut);
		nor.add(soigBut);
		nor.add(panelEq2);
		nor.add(tourJoueur2);
		this.getContentPane().add(nor);

		panelInfo1.setPreferredSize(new Dimension(250, 100));
		panelInfo2.setPreferredSize(new Dimension(250, 100));
		panelInfo1.add(info1);
		panelInfo2.add(info2);
		cen.add(panelInfo1);
		cen.add(panelInfo2);
		this.getContentPane().add(cen);

		sud.add(descrip);
		this.getContentPane().add(sud);

		this.setVisible(true);
	}

	//Dans cette classe, on évalue d'abord si des personnages ont été séléctionnés
	//dans les deux listes. Après on vérifie si le personnage joueur est toujours
	//vivant, puis on vérifie si ce personnage peut faire un attaque
	//Si le personnage attaque l'ennemi, une brève description sera affichée
	//dans la boîte en bas et les points de vie de l'ennemi seront mis à jour;
	//sinon, des exceptions vont se produire avec des pop-ups
	class ActionCombat extends MouseAdapter {
		public void mouseClicked(MouseEvent att) {
			try {

				analyserVictoire();

				if(JLequipe1.isSelectionEmpty())
					throw new ExceptionNonSelectionne();
				if(JLequipe2.isSelectionEmpty())
					throw new ExceptionNonSelectionne();

				int index1 = JLequipe1.getSelectedIndex();
				int index2 = JLequipe2.getSelectedIndex();
				Personnage perso1 = joueur1.get(index1);
				Personnage perso2 = joueur2.get(index2);
				String mess;
				String class1 = perso1.getClass().getSuperclass().getName();
				String class2 = perso2.getClass().getSuperclass().getName();
				if(tour) { //tour du joueur 1
					if(perso1.pointsVie <= 0)
						throw new ExceptionPersoMort(perso1);
					if(class1 == "Guerrier") {
						if(perso2.pointsVie <= 0)
							throw new ExceptionPersoMort(perso2);
						mess = ((Guerrier)perso1).diminuerVie(perso2);
					}
					else if(class1 == "Paladin") {
						if(perso2.pointsVie <= 0)
							throw new ExceptionPersoMort(perso2);
						mess = ((Paladin)perso1).diminuerVie(perso2);
					}
					else
						throw new ExceptionActionIncomp(perso1, class1, "attaquer");
					info2.setText(perso2.allInfo());
					tour = false;
					tourJoueur1.setText("Equipe1");
					tourJoueur2.setText("Equipe2\n<- JOUE");
					descrip.setText(mess);
				}
				else { // tour du joueur 2
					if(perso2.pointsVie <= 0)
						throw new ExceptionPersoMort(perso2);
					if(class2 == "Guerrier") {
						if(perso1.pointsVie <= 0)
							throw new ExceptionPersoMort(perso1);
						mess = ((Guerrier)perso2).diminuerVie(perso1);
					}
					else if(class2 == "Paladin") {
						if(perso1.pointsVie <= 0)
							throw new ExceptionPersoMort(perso1);
						mess = ((Paladin)perso2).diminuerVie(perso1);
					}
					else
						throw new ExceptionActionIncomp(perso2, class2, "attaquer");
					info1.setText(perso1.allInfo());
					tour = true;
					tourJoueur1.setText("Equipe1\nJOUE ->");
					tourJoueur2.setText("Equipe2");
					descrip.setText(mess);
				}

			} catch(ExceptionActionIncomp soig) {
						descrip.setText(attente);
			} catch(ExceptionPersoMort mort) {
					descrip.setText(attente);
			} catch(ExceptionNonSelectionne selec) {
					descrip.setText(attente);
			} catch(ExceptionGameOver over) {}
		}
	}

	//Dans cette classe, on choisit aléatoirement une cible non morte de la même équipe
	//du personnage séléctionné pour soigner, puis on évalue si le personnage
	//joueur est toujours vivant, puis on vérifie si ce personnage peut faire soigner
	//Si le personnage soigne l'allié, une brève description sera affichée
	//dans la boîte en bas et les points de vie de l'allié seront mis à jour;
	//sinon, des exceptions vont se produire avec des pop-ups
	class ActionSoigne extends MouseAdapter {
		public void mouseClicked(MouseEvent att) {
			try {
				if(tour && JLequipe1.isSelectionEmpty())
					throw new ExceptionNonSelectionne();
				if(!tour && JLequipe2.isSelectionEmpty())
					throw new ExceptionNonSelectionne();

				int index1, index2; // ind1 = soigneur // ind2 = allie aléatoire //
				Personnage perso1, perso2;
				String mess, class1, class2;
				Random rand = new Random();

				if(tour) { //tour du joueur 1

					analyserVictoire();

					index1 = JLequipe1.getSelectedIndex();
					perso1 = joueur1.get(index1);
					class1 = perso1.getClass().getSuperclass().getName();

					if(perso1.pointsVie <= 0)
						throw new ExceptionPersoMort(perso1);

					do {
						index2 = rand.nextInt(joueur1.size());
					} while(joueur1.get(index2).pointsVie <= 0);
					perso2 = joueur1.get(index2);
					class2 = perso1.getClass().getSuperclass().getName();

					if(class1 == "Soigneur") {
						if(perso2.pointsVie <= 0)
							throw new ExceptionPersoMort(perso2);
						mess = ((Soigneur)perso1).augmenteVie(perso2);
					}
					else if(class1 == "Paladin") {
						if(perso2.pointsVie <= 0)
							throw new ExceptionPersoMort(perso2);
						mess = ((Paladin)perso1).augmenteVie(perso2);
					}
					else
						throw new ExceptionActionIncomp(perso1, class1, "soigner");
					info1.setText(perso2.allInfo());
					tour = false;
					tourJoueur1.setText("Equipe1");
					tourJoueur2.setText("Equipe2\n<- JOUE");
					descrip.setText(mess);
				}
				else { //tour du joueur 2
					index1 = JLequipe2.getSelectedIndex();
					perso1 = joueur2.get(index1);
					class1 = perso1.getClass().getSuperclass().getName();

					if(perso1.pointsVie <= 0)
						throw new ExceptionPersoMort(perso1);

					do {
						index2 = rand.nextInt(joueur2.size());
					} while(joueur2.get(index2).pointsVie <= 0);
					perso2 = joueur2.get(index2);
					class2 = perso2.getClass().getSuperclass().getName();

					if(class1 == "Soigneur") {
						if(perso2.pointsVie <= 0)
							throw new ExceptionPersoMort(perso2);
						mess = ((Soigneur)perso1).augmenteVie(perso2);
					}
					else if(class1 == "Paladin") {
						if(perso2.pointsVie <= 0)
							throw new ExceptionPersoMort(perso2);
						mess = ((Paladin)perso1).augmenteVie(perso2);
					}
					else
						throw new ExceptionActionIncomp(perso1, class1, "soigner");
					info2.setText(perso2.allInfo());
					tour = true;
					tourJoueur1.setText("Equipe1\nJOUE ->");
					tourJoueur2.setText("Equipe2");
					descrip.setText(mess);
				}

			} catch(ExceptionActionIncomp soig) {
					descrip.setText(attente);
			} catch(ExceptionPersoMort mort) {
					descrip.setText(attente);
			}	catch(ExceptionNonSelectionne selec) {
						descrip.setText(attente);
			} catch(ExceptionGameOver over) {}
		}
	}

	//Victoire par extermination totale ou par eliminer tous les guerriers/paladins
	public void analyserVictoire() throws ExceptionGameOver {
		boolean win = true;
		String vic = "                 GAME OVER\n" +
			"           *\\* FELICITATIONS */*\n              Joueur ";
		for(Personnage p : joueur1) {
			if((p.getClass().getSuperclass().getName() == "Guerrier" ||
					p.getClass().getSuperclass().getName() == "Paladin") && p.pointsVie > 0)
				win = false;
		}
		if(win)	Victoire(vic, 2);

		win = true;
		for(Personnage p : joueur2) {
			if((p.getClass().getSuperclass().getName() == "Guerrier" ||
					p.getClass().getSuperclass().getName() == "Paladin") && p.pointsVie > 0)
				win = false;
		}
		if(win)	Victoire(vic, 1);
	}

	public void Victoire(String vic, int joueur) throws ExceptionGameOver {
		JOptionPane.showMessageDialog(null, vic + joueur + " gagnant");
		descrip.setText(vic + joueur + " gagnant");
		combBut.setEnabled(false);
		soigBut.setEnabled(false);
		throw new ExceptionGameOver();
	}

}
