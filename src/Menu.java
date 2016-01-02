/**
 * Created by raffennn on 16/12/15.
 */
import java.util.Scanner;

/**
 * Sert à lancer le menu
 *
 * @author PixCyan
 */
public class Menu {
    private Systeme systeme;

    public Menu(Systeme systeme) {
        this.systeme = systeme;
    }

    public void afficherMenu() {
        Integer choix;
        Scanner entree = new Scanner(System.in);
        do {
            System.out.println("================================");
            System.out.println("| 1. Inscrire des joueurs      |");
            System.out.println("| 2. Commencer le jeu          |");
            System.out.println("| 3. Afficher les participants |");
            System.out.println("| 4. Quitter                   |");
            System.out.println("================================");
            choix = entree.nextInt();

            switch (choix) {
                case 1:
                    systeme.inscrireJoueur();
                    break;
                case 2:
                    systeme.commencerSysteme();
                    break;
                case 3:
                    systeme.afficherListeJoueurs();
                    break;
                default:
                    break;
            }
        } while (choix != 4);
    }

    public void menuEnJeu(Joueur j) {
        Integer choix;
        Scanner entree = new Scanner(System.in);
        do {
            System.out.println("===================================");
            System.out.println("        Joueur : "+ j.getNom() +"      ");
            System.out.println("| 1. Lancer le dé                 |");
            System.out.println("| 2. Afficher les infos du joueur |");
            System.out.println("| 4. Stoper le jeu (retour menu)  |");
            System.out.println("===================================");
            choix = entree.nextInt();

            switch (choix) {
                case 1:
                    systeme.tourJoueur(j);
                    break;
                case 2:
                    j.afficheInfosJoueur();
                    break;
                default:
                    break;
            }
        } while (choix != 4);
    }
}
