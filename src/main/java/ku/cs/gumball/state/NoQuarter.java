package ku.cs.gumball.state;

import ku.cs.gumball.GumballMachine;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class NoQuarter extends GumballMachineState {

    public NoQuarter(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void entry() {
        short gumballCount = this.getMachine().getGumballCount();
        System.out.println("Mighty Gumball, Inc.");
        System.out.println("Java-enabled Standing Gumball Model #2004");
        System.out.println("Inventory: " + gumballCount + " Gumball(s)");
        if (gumballCount > 0) System.out.println("Machine is waiting for quarter");
        else System.out.println("Machine is sold out");

        this.getMachine().setFlavour("random");
    }

    @Override
    public void insertQuarter() {
        this.getMachine().changeState(HasQuarter.class);
    }

    @Override
    public void ejectQuarter() {
        throw new IllegalArgumentException("No Quarters to eject");
    }
}
