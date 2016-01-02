/**
 * Created by raffennn on 16/12/15.
 */
public class Main {
    private static Systeme systeme;

    public static void main(String[] args) {
        systeme = new Systeme();
        new Menu(systeme).afficherMenu();
    }
}
