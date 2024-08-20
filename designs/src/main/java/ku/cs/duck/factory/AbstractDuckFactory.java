package ku.cs.duck.factory;

import ku.cs.duck.Quackable;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedHeadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}
