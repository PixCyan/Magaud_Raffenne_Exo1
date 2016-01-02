import java.util.LinkedList;
import java.util.Random;

/**
 * Created by raffennn on 16/12/15.
 */
public class Plateau {
    private static final int NB_CARREAUX = 16;
    private static final Random random = new Random();
    private Carreau[] carreaux;
    private int nbCarreaux = 0;

    public Plateau() {
        this.carreaux = new Carreau[NB_CARREAUX];
        this.ajouterCarreauMultiples(NB_CARREAUX);
    }

    /**
     * Ajoute une maison à prix fixe au plateau
     */
    public void ajouterUneMaison(int nbCarreau) {
        Maison carreau = new Maison("Maison " + nbCarreau, 100, 50);
        carreaux[nbCarreau] = carreau;
        this.nbCarreaux++;
    }

    /**
     * Ajoute une maison à prix negociable au plateau
     */
    public void ajouterUneMaisonNegociable(int nbCarreau) {
        MaisonPrixNegociable carreau = new MaisonPrixNegociable("Maison Négociable " + nbCarreau, 500, 250);
        carreaux[nbCarreau] = carreau;
        this.nbCarreaux++;
    }

    /**
     * Ajoute une maison de résidence au plateau
     */
    public void ajouterUneResidence(int nbCarreau) {
        MaisonResidence carreau = new MaisonResidence("Maison Résidence " + nbCarreau, 250, 150);
        carreaux[nbCarreau] = carreau;
        this.nbCarreaux++;
    }

    /**
     * Ajoute une aire de repos
     */
    public void ajouterAireDeRepos(int nbCarreau) {
        AireDeRepos carreau = new AireDeRepos("Aire de repos " + nbCarreau);
        carreaux[nbCarreau] = carreau;
        this.nbCarreaux++;
    }

    /**
     * Ajout de carreaux multiples
     */
    public void ajouterCarreauMultiples(int nbCases) {
        int rand;
        for(int i = 0; i < nbCases; i++) {
            //System.out.println(i);
            if (i == 0 || i == 4 || i == 8 || i == 12) {
                this.ajouterAireDeRepos(i);
            } else {
                rand = random.nextInt(3);
                if(rand == 0){
                    this.ajouterUneMaison(i);
                } else if(rand == 1) {
                    this.ajouterUneMaisonNegociable(i);
                } else if(rand == 2) {
                    this.ajouterUneResidence(i);
                }
            }
        }
    }

    /**
     * Permet d'afficher toutes les cases du plateau
     */
    public void parcourirPlateau() {
        for(Carreau c: carreaux) {
            System.out.println("Nom : " + c.getNom());

        }
    }

    /**
     * AJoute un joueur au carreau concerné
     * @param j le joueur à placer
     * @param c  le numéro du carreau
     */
    public void ajouterJoueurCarreau(Joueur j, int c) {
        carreaux[c].ajouterJoueur(j);
        j.setCarreauActuel(c);
    }

    public void retirerJoueurCarreau(Joueur j, int c) {
        carreaux[c].retirerUnJoueur(j);
    }

    public Carreau getCarreauById(int id) {
        return carreaux[id];
    }

    public int getNbCarreaux() {
        return nbCarreaux;
    }

    public void setNbCarreaux(int nbCarreaux) {
        this.nbCarreaux = nbCarreaux;
    }
}
