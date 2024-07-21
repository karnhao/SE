package ku.cs.gumball;

import java.util.LinkedList;
import java.util.List;

import ku.cs.gumball.state.GumballMachineState;
import ku.cs.gumball.state.GumballSold;
import ku.cs.gumball.state.HasQuarter;
import ku.cs.gumball.state.NoQuarter;
import ku.cs.gumball.state.OutOfGumballs;
import ku.cs.gumball.state.StateMachine;
import ku.cs.gumball.state.Winner;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class GumballMachine extends StateMachine<GumballMachineState> {
    private short gumballCount;
    private String flavour = "random";

    public GumballMachine() {
        this((short) 0);
    }

    public GumballMachine(short gumballCount) {
        super();
        this.setStates(createStates(), 0);
        this.gumballCount = gumballCount;

        this.start(null); // call entry method of start state
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public short getGumballCount() {
        return gumballCount;
    }

    public void removeGumball(short count) {
        if (gumballCount < count) throw new IllegalArgumentException("Not enough gumball to remove");
        this.gumballCount -= count;
    }

    public void addGumball(short count) {
        this.gumballCount += count;
        System.out.printf("Gumball added +%d, Invetory: %d\n", count, this.gumballCount);
    }

    private List<GumballMachineState> createStates() {
        List<GumballMachineState> states = new LinkedList<>();

        states.add(new NoQuarter(this)); // start state
        states.add(new HasQuarter(this));
        states.add(new GumballSold(this));
        states.add(new OutOfGumballs(this));
        states.add(new Winner(this));

        return states;
    }

    private void printErr(Exception e) {
        System.err.println("ERROR: " + e.getClass().getName() + " - " + e.getMessage());
    }

    public void insertQuarter() {
        System.out.println("You inserted a quarter.");

        try {
            this.getCurrentState().insertQuarter();
        } catch (Exception e) {
            printErr(e);
        }
    }

    public void ejectQuarter() {
        System.out.println("You request to eject a quarter.");

        try {
            this.getCurrentState().ejectQuarter();
        } catch (Exception e) {
            printErr(e);
        }
    }

    public void turnsCrank() {
        System.out.println("You turned...");

        try {
            this.getCurrentState().turnsCrank();
        } catch (Exception e) {
            printErr(e);
        }
    }

    public void dispenseGumball() {
        try {
            this.getCurrentState().dispenseGumball();
        } catch (Exception e) {
            printErr(e);
        }
    }

    public void choose(String flavour) {
        try {
            this.getCurrentState().chooseFlavour(flavour);
        } catch (Exception e) {
            printErr(e);
        }
    }

}
