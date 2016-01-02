import java.util.*;

/**
 * Created by raffennn on 16/12/15.
 */
public class Joueur {
    private String nom;
    private Pions pion;
    private int argent;
    private Set<Maison> maisonsPossedes;
    private int carreauActuel = 0;

    public Joueur(String nom, Pions pion, int argent) {
        this.nom = nom;
        this.pion = pion;
        this.argent = argent;
        this.maisonsPossedes = new HashSet<>();
    }

    public Joueur() {
        //--
    }

    public void afficheInfosJoueur() {
        System.out.println("Nom : " + this.nom);
        System.out.println("Pions : " + this.pion);
        System.out.println("Argent : " + this.argent);
        System.out.println("Carreau actuel : " + this.carreauActuel);
        afficheMaisonsJoueur();
    }

    public void afficheMaisonsJoueur() {
        for (Maison p : maisonsPossedes) {
            //TODO : affichage detail maison => vérifier si ca marche
            p.afficheDetailsMaison();
        }
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", pion=" + pion +
                ", argent=" + argent +
                ", maisonsPossedes=" + maisonsPossedes +
                '}';
    }

    //------ Getters & Setters ------//

    public void setPion(Pions pion) {
        this.pion = pion;
    }

    public int getCarreauActuel() {
        return carreauActuel;
    }

    public void setCarreauActuel(int carreauActuel) {
        this.carreauActuel = carreauActuel;
    }

    public String getNom() {
        return this.nom;
    }

    public Pions getPion() {
        return this.pion;
    }

    public int getArgent() {
        return this.argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMaisonsPossedes(Set<Maison> maisonsPossedes) {
        this.maisonsPossedes = maisonsPossedes;
    }

    public Set<Maison> getMaisonsPossedes() {
        return this.maisonsPossedes;
    }
}
