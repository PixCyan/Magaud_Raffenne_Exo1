import java.util.Random;

/**
 * Created by raffennn on 16/12/15.
 */
public class De {
    private static final Random random = new Random();
    private int de1;

    public De() {
        initDe();
    }

    private void initDe() {
        de1 = random.nextInt(6);
    }

    //------ Getters ------//

    public int getDe1() {
        return de1;
    }

}