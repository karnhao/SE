package ku.cs.duck;

public class RubberDuck implements Quackable{

    @Override
    public void quack() {
        System.out.println("Quack!");
    }

    public void squeeze() {
        System.out.println("Squeeze!");
    }
    
}
