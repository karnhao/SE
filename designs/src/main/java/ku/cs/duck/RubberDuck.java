package ku.cs.duck;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class RubberDuck implements Quackable{

    @Override
    public void quack() {
        System.out.println("Quack!");
    }

    public void squeeze() {
        System.out.println("Squeeze!");
    }
    
}
