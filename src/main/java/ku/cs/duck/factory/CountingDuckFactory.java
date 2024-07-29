package ku.cs.duck.factory;

import ku.cs.duck.QuackCounter;
import ku.cs.duck.Quackable;

public class CountingDuckFactory extends AbstractDuckFactory {

    private AbstractDuckFactory originFactory;

    public CountingDuckFactory(AbstractDuckFactory originFactory) { 
        this.originFactory = originFactory;
    }

    public CountingDuckFactory() {
        this.originFactory = new DuckFactory();
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(originFactory.createDuckCall());
    }

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(originFactory.createMallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounter(originFactory.createRedHeadDuck());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(originFactory.createRubberDuck());
    }
    
}
