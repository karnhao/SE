package ku.cs.duck;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
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
