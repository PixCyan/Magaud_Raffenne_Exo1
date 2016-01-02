import java.util.*;

/**
 * Created by raffennn on 16/12/15.
 */
public class Systeme {
    //private Map<String, Joueur> joueurs;
    private LinkedList<Joueur> joueurs;
    private Set<Integer> pionsUtilises;
    private static int nbJoueurs = 0;
    private Plateau plateau;
    private int nbTour = 0;
    private Menu menu;
    private int joueurCourant = 0;

    public Systeme() {
        //this.joueurs = new HashMap<>();
        this.menu = new Menu(this);
        this.joueurs = new LinkedList<>();
        this.pionsUtilises = new HashSet<>();
        this.plateau = new Plateau();
    }

    public void inscrireJoueur() {
        Scanner entree = new Scanner(System.in);
        String choix2 = "o";
        if (nbJoueurs == 6) {
            System.out.println("Nombre de joueur max atteind ! Vous pouvez commencer la partie.");
            choix2 = "n";
        } else {
            do {
                System.out.println("Entrez le nom du joueur : ");
                String nom = entree.nextLine();
                if (joueurExiste(nom)) {
                    System.out.println("Ce nom existe déjà, saisissez-en un nouveau");
                } else {
                    Pions pion = choixPion();
                    int argent = 1500;
                    Joueur joueur = new Joueur(nom, pion, argent);
                    //joueurs.put(nom, joueur);
                    joueurs.add(joueur);
                    this.plateau.ajouterJoueurCarreau(joueur, 0);
                    System.out.println("Ce joueur a bien été enregistré.");
                    nbJoueurs++;
                    if (nbJoueurs == 6) {
                        System.out.println("Nombre de joeur max atteind ! Vous pouvez commencer la partie.");
                        choix2 = "n";
                    }else if(nbJoueurs < 2) {
                        System.out.println("Nombre de joueur insuffisant");
                    } else {
                        System.out.println("Souhaitez vous ajouter un autre joueur ? (o pour oui / n pour non)");
                        choix2 = entree.nextLine();
                        while (!choix2.equals("o") && !choix2.equals("n")) {
                            System.out.println("Saisie incorrect, voulez vous entrez un autre joueur ? (o pour oui et n pour non)");
                            choix2 = entree.nextLine();
                        }
                    }
                }
            } while (nbJoueurs <= 6 && choix2.equals("o"));
        }
    }

    public boolean joueurExiste(String nom) {
        boolean res = false;
        for(Joueur j : joueurs) {
            if(j.getNom().equals(nom)) {
                res = true;
            }
        }
        return res;
    }

    public Pions choixPion() {
        Scanner entree = new Scanner(System.in);
        int i = 1;
        System.out.println("Choisissez un pion : ");
        Pions pion = Pions.Blanc;
        for (Pions pions : Pions.values()) {
            System.out.println(i++ + " " + " " + pions.toString());
        }
        int choix;
        do {
            choix = entree.nextInt();
            switch (choix) {
                case 1:
                    pion = Pions.Blanc;
                    break;
                case 2:
                    pion = Pions.Noir;
                    break;
                case 3:
                    pion = Pions.Rouge;
                    break;
                case 4:
                    pion = Pions.Jaune;
                    break;
                case 5:
                    pion = Pions.Violet;
                    break;
                case 6:
                    pion = Pions.Bleu;
                    break;
                default:
                    break;
            }
        } while (pionPrit(choix));
        pionsUtilises.add(choix);
        return pion;
    }


    public void commencerSysteme() {
        int dePlusHaut = 0;
        if(!joueurs.isEmpty()) {
            Joueur joueurCommence = new Joueur();
            for (Joueur joueur : joueurs) {
                joueur.setArgent(1000);
                /*int res = lancerDe();
                System.out.println("Joueur " + joueur.getNom() + " : " + res);
                if(res > dePlusHaut){
                    joueurCommence = joueur;
                    dePlusHaut = res;
                }*/
            }
            //System.out.println("Le joueur qui commence est : " + joueurCommence.getNom());
            //this.plateau.parcourirPlateau();
            this.tourSuivant();
        } else {
            System.out.println("Aucun joueur inscrit !");
        }

    }

    public void tourSuivant() {
        //début d'un tour
        System.out.println("+--------------- Tour : " + this.nbTour + " ----------------+");
        this.nbTour++;
        this.menu.menuEnJeu(joueurs.getFirst());
    }

    public void tourJoueur(Joueur j) {
        int res = lancerDe();
        System.out.println("Le joueur "+ j.getNom() + " lance le dé et avance de " + res + " cases.");
        int numCarreau = j.getCarreauActuel()+res;
        if(numCarreau <= this.plateau.getNbCarreaux()) {
            //retire le joueur du carreau où il est
            this.plateau.retirerJoueurCarreau(j, j.getCarreauActuel());
            //place le joueur sur le nouveau carreau
            this.plateau.ajouterJoueurCarreau(j, numCarreau);
            Carreau c = this.plateau.getCarreauById(numCarreau);
            System.out.println("Vous arrivez sur la case : " + c.getNom());
            if (!c.aProprietaire() && c instanceof Maison) {
                System.out.println("Cette propriété n'est pas achetée.\n" +
                        "Vous êtes obligé de l'acheter, coût : " + ((Maison) c).getPrixAchat());
            } else if(c instanceof AireDeRepos) {
                System.out.println("Vous êtes sur une aire de repos.");
            }
        } else {
            System.out.println("Dépassement du nombre de carreau !");
            //TODO gestion du nb de carreau (tour)
        }


    }

    public void afficherListeJoueurs() {
        for (Joueur joueur : joueurs) {
            System.out.println(joueur.getNom());
        }
    }


    //------- Private -------//
    private boolean pionPrit(int choix) {
        for (int p : pionsUtilises) {
            if (choix == p) {
                System.out.println("Ce pion est déjà prit, choisissez-en un autre.");
                return true;
            }
        }
        return false;
    }

    private Integer lancerDe() {
        De de = new De();
        return de.getDe1()+1;
    }
}
