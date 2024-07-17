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
        this.getMachine().changeState(GumballSold.class);
    }
}
