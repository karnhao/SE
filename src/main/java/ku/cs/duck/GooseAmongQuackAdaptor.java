package ku.cs.duck;

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
