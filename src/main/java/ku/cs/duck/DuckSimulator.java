package ku.cs.duck;

import ku.cs.duck.factory.AbstractDuckFactory;
import ku.cs.duck.factory.CountingDuckFactory;
import ku.cs.duck.factory.CountingPoliteDuckFactory;
import ku.cs.duck.factory.DuckFactory;
import ku.cs.duck.factory.PoliteDuckFactory;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        DuckFactory duckFactory = new DuckFactory();
        CountingDuckFactory countingDuckFactory = new CountingDuckFactory();
        PoliteDuckFactory politeDuckFactory = new PoliteDuckFactory();
        CountingPoliteDuckFactory countingPoliteDuckFactory = new CountingPoliteDuckFactory();


        simulator.simulate();
        simulator.simulate(duckFactory);
        simulator.simulate(countingDuckFactory);
        simulator.simulate(politeDuckFactory);
        simulator.simulate(countingPoliteDuckFactory);
        
    }

    public void simulate() {

        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redhead = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());

        Quackable goose = new GooseAmongQuackAdaptor(new Goose());


        Flock flock1 = new Flock();
        flock1.add(mallardDuck);
        flock1.add(redhead);

        Flock flock2 = new Flock();
        flock2.add(duckCall);
        flock2.add(rubberDuck);
        flock2.add(goose);

        System.out.println("\n      [ Duck simulation ]\n");

        

        flock1.quack();
        flock2.quack();

        System.out.println("Number of Quacks = " + QuackCounter.getQuacks());
    }


    public void simulate(Quackable duck) {
        duck.quack();
    }

    public void simulate(AbstractDuckFactory duckFactory) {
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable redhead = duckFactory.createRedHeadDuck();
        Quackable mallard = duckFactory.createMallardDuck();
        Quackable rubber = duckFactory.createRubberDuck();

        Quackable goose = new GooseAmongQuackAdaptor(new Goose());

        duckCall.quack();
        redhead.quack();
        mallard.quack();
        rubber.quack();
        goose.quack();

        System.out.println("Number of Quacks = " + QuackCounter.getQuacks());
    }
}
