package ku.cs.gumball.state;

import ku.cs.gumball.GumballMachine;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class HasQuarter extends GumballMachineState {

    public HasQuarter(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        this.getMachine().changeState(NoQuarter.class);
    }

    @Override
    public void turnsCrank() {
        runWithChance(0.1,
                () -> { // accepted
                    this.getMachine().changeState(Winner.class);
                },
                () -> { // rejected
                    this.getMachine().changeState(GumballSold.class);
                });
    }

    @Override
    public void chooseFlavour(String flavour) {
        System.out.println("You have chosen the flavor " + flavour);
        this.getMachine().setFlavour(flavour);
    }

    /**
     * @param possibility Possibility of acception. Double value between 0 and 1.
     * @param accept
     * @param reject
     */
    private void runWithChance(double possibility, Runnable accept, Runnable reject) {
        double r = Math.random();
        if (r < possibility)
            accept.run();
        else
            reject.run();
    }
}
