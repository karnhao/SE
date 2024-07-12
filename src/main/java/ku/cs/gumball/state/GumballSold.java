package ku.cs.gumball.state;

import ku.cs.gumball.GumballMachine;

public class GumballSold extends State {

    private GumballMachine machine;

    public GumballSold(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public Class<? extends State> transition(String[] args) {
        if (args[0].equalsIgnoreCase("dispense_gumball")) {
            machine.removeGumball((short) 1);
            System.out.println("A gumball comes rolling out the slot");
            if (machine.getGumballCount() > 0)
                return NoQuarter.class;
            return OutOfGumballs.class;
        }
        return null;
    }
}
