package ku.cs.gumball.state;

import ku.cs.gumball.GumballMachine;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class NoQuarter extends State {

    private GumballMachine machine;
    public NoQuarter(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void entry(String[] args) {
        short gumballCount = machine.getGumballCount();

        if (args == null || args[0].equalsIgnoreCase("dispense_gumball")) { // no arguments แปลว่าเพิ่งเปิด machine
            System.out.println("Mighty Gumball, Inc.");
            System.out.println("Java-enabled Standing Gumball Model #2004");
            System.out.println("Inventory: " + gumballCount + " Gumball(s)");
            if (gumballCount > 0) System.out.println("Machine is waiting for quarter");
            else System.out.println("Machine is sold out");
        } else {
            System.out.println("Inventory: " + gumballCount + " Gumball(s)");
            if (gumballCount > 0) System.out.println("Machine is waiting for quarter");
            else System.out.println("Machine is sold out");
        }
    }

    @Override
    public Class<? extends State> transition(String[] args) {
        if (args[0].equalsIgnoreCase("insert_quarter")) 
            return HasQuarter.class; // Go to state HasQuarter :)
        else if (args[0].equalsIgnoreCase("eject_quarter"))
            throw new IllegalArgumentException("Cannot eject a quarter from No Quarters state");
        throw new IllegalArgumentException("No.");
    }
}
