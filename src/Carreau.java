import java.util.LinkedList;

/**
 * Created by raffennn on 16/12/15.
 */
public class Carreau {
    private static int numeroDeLaCase;
    private String nom;
    private LinkedList<Joueur> joueurs;
    private boolean proprietaire = false;

    public Carreau(String nom) {
        numeroDeLaCase++;
        this.nom = nom;
        this.joueurs = new LinkedList<>();
    }

    public void ajouterJoueur(Joueur j) {
        joueurs.add(j);
    }

    public void retirerUnJoueur(Joueur j) {
        joueurs.remove(j.getCarreauActuel());
    }

    //------ Getters & Setters -------//
    public LinkedList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(LinkedList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean aProprietaire() {
        return this.proprietaire;
    }

    public int getNumeroDeLaCase() {
        return numeroDeLaCase;
    }

    public void setNumeroDeLaCase(int numeroDeLaCase) {
        numeroDeLaCase = numeroDeLaCase;
    }
}
