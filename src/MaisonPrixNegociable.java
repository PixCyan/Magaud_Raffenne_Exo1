/**
 * Created by raffennn on 02/01/16.
 */
public class MaisonPrixNegociable extends Maison {
    private static final int pourcentage = 20;
    private static final int seuil = 500;

    public MaisonPrixNegociable(String nom, int prixAchat, int prixLoyer) {
        super(nom, prixAchat, prixLoyer);
    }

    public int calculerPrixAchat(int sommeJoueur) {
        int prix = super.getPrixAchat();
        if(sommeJoueur < seuil) {
            prix = (super.getPrixAchat()*pourcentage)/100;
        }
        return prix;
    }
}
