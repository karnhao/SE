package ku.cs.duck.factory;

import ku.cs.duck.Quackable;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class CountingPoliteDuckFactory extends AbstractDuckFactory  {
    
    private AbstractDuckFactory originFactory = new DuckFactory();

    public CountingPoliteDuckFactory(AbstractDuckFactory originFactory) { 
        this.originFactory = new CountingDuckFactory(new PoliteDuckFactory(originFactory));
    }

    public CountingPoliteDuckFactory() {
        this(new DuckFactory());
    }

    @Override
    public Quackable createDuckCall() {
        return originFactory.createDuckCall();
    }

    @Override
    public Quackable createMallardDuck() {
        return originFactory.createMallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return originFactory.createRedHeadDuck();
    }

    @Override
    public Quackable createRubberDuck() {
        return originFactory.createRubberDuck();
    }
}
