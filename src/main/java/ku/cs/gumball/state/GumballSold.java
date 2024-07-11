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
            if (machine.getGumballCount() > 0)
                return HasQuarter.class;
            return OutOfGumballs.class;
        }
        return null;
    }
}
