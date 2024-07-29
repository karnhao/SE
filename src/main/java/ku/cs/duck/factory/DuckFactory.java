package ku.cs.duck.factory;

import ku.cs.duck.DuckCall;
import ku.cs.duck.MallardDuck;
import ku.cs.duck.Quackable;
import ku.cs.duck.RedheadDuck;
import ku.cs.duck.RubberDuck;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
    
}
