package ku.cs.duck;

import java.util.Random;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class PoliteDuck implements Quackable {

    Quackable quackable;
    private static final Random r = new Random(System.currentTimeMillis());

    public PoliteDuck(Quackable quackable) {
        this.quackable = quackable;
    }



    @Override
    public void quack() {
        int randomInt = r.nextInt(3);
        this.quackable.quack();

        switch (randomInt) {
            case 0: System.out.println("\tJa"); break;
            case 1: System.out.println("\tKrub"); break;
            case 2: System.out.println("\tKa"); break;
            default: System.out.println("\tHello, World.");
        }
    }
    
}
