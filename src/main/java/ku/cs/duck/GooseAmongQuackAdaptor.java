package ku.cs.duck;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class GooseAmongQuackAdaptor implements Quackable {

    private Goose goose;

    GooseAmongQuackAdaptor(Goose goose) {
        this.goose = goose;
    }


    @Override
    public void quack() {
        goose.honk();
    }
    
}
