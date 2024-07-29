package ku.cs.duck;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class QuackCounter implements Quackable {

    Quackable duck;
    static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }


    @Override
    public void quack() {
        duck.quack();

        numberOfQuacks ++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }
    
}
