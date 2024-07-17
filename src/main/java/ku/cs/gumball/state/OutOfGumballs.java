package ku.cs.gumball.state;

import ku.cs.gumball.GumballMachine;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class OutOfGumballs extends GumballMachineState {

    public OutOfGumballs(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void entry() {
        System.out.println("Oops, out of gumballs!");

        System.out.println("Mighty Gumball, Inc.");
        System.out.println("Java-enabled Standing Gumball Model #2004");
        System.out.println("Machine is sold out");
    }

    @Override
    public void exit() {
        System.err.println("How!?");
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter returned. And Nothing happened.");
    }

    @Override
    public void turnsCrank() {
        System.out.println("Nothing happened");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Nothing happened.");
    }
}
