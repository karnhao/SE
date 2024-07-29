package ku.cs.duck;

public class PigeonAmongDuckAdaptor implements Quackable {

    private Pigeon pigeonThatWantToBeADuck;


    public PigeonAmongDuckAdaptor(Pigeon pigeonThatWantToBeADuck) {
        this.pigeonThatWantToBeADuck = pigeonThatWantToBeADuck;
    }



    @Override
    public void quack() {
        pigeonThatWantToBeADuck.coo();
        pigeonThatWantToBeADuck.coo();
    }
}
