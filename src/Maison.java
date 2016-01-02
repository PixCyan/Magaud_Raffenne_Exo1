/**
 * Created by raffennn on 16/12/15.
 */
public class Maison extends Carreau {
    private int prixAchat;
    private int prixLoyer;
    private String proprietaire;

    public Maison(String nom, int prixAchat, int prixLoyer) {
        super(nom);
        this.prixAchat = prixAchat;
        this.prixLoyer = prixLoyer;
        this.proprietaire = "";
    }

    //------ Getters et Setters ------//

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getPrixLoyer() {
        return prixLoyer;
    }

    public void setPrixLoyer(int prixLoyer) {
        this.prixLoyer = prixLoyer;
    }

    public void afficheDetailsMaison() {
        System.out.println("Nom propriété : "+ super.getNom());
        System.out.println("Prix d'achat : "+ this.prixAchat);
        System.out.println("Prix de loyer : "+ this.prixLoyer);
    }
}
