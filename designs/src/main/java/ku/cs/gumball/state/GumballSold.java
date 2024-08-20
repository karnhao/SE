package ku.cs.gumball.state;

import ku.cs.gumball.GumballMachine;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class GumballSold extends GumballMachineState {

    public GumballSold(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void dispenseGumball() {
        this.getMachine().removeGumball((short) 1);
        System.out.println("A " + this.getMachine().getFlavour() + " gumball comes rolling out the slot");

        if (this.getMachine().getGumballCount() > 0)
            this.getMachine().changeState(NoQuarter.class);
        else this.getMachine().changeState(OutOfGumballs.class);
    }
}
