/**
 * Created by raffennn on 02/01/16.
 */
public class MaisonResidence extends Maison {
    private static final int taxe = 30;

    public MaisonResidence(String nom, int prixAchat, int prixLoyer) {
        super(nom, prixAchat, prixLoyer);
    }

    public int calculPrixAchat() {
        return (super.getPrixAchat()*taxe)/100;
    }

}
