package ku.cs.duck.factory;

import ku.cs.duck.PoliteDuck;
import ku.cs.duck.Quackable;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class PoliteDuckFactory extends AbstractDuckFactory {
    
    private AbstractDuckFactory originFactory;

    public PoliteDuckFactory(AbstractDuckFactory originFactory) { 
        this.originFactory = originFactory;
    }

    public PoliteDuckFactory() {
        this.originFactory = new DuckFactory();
    }

    @Override
    public Quackable createDuckCall() {
        return new PoliteDuck(originFactory.createDuckCall());
    }

    @Override
    public Quackable createMallardDuck() {
        return new PoliteDuck(originFactory.createMallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new PoliteDuck(originFactory.createRedHeadDuck());
    }

    @Override
    public Quackable createRubberDuck() {
        return new PoliteDuck(originFactory.createRubberDuck());
    }
    
}
