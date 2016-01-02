/**
 * Created by raffennn on 01/01/16.
 */
public class AireDeRepos extends Carreau {

    public AireDeRepos(String nom) {
        super(nom);
    }

    public void afficheDetailsAire() {
        System.out.println("Nom propriété : "+ super.getNom() + "/n");
    }
}
