package ku.cs.gumball;

import java.util.LinkedList;
import java.util.List;

import ku.cs.gumball.state.GumballSold;
import ku.cs.gumball.state.HasQuarter;
import ku.cs.gumball.state.NoQuarter;
import ku.cs.gumball.state.OutOfGumballs;
import ku.cs.gumball.state.State;
import ku.cs.gumball.state.StateMachine;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class GumballMachine extends StateMachine {
    private short gumballCount;

    public GumballMachine() {
        this((short) 0);
    }

    public GumballMachine(short gumballCount) {
        super();
        this.setStates(createStates(), 0);
        this.gumballCount = gumballCount;

        this.start(null); // call entry method of start state
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

    private List<State> createStates() {
        List<State> states = new LinkedList<>();

        states.add(new NoQuarter(this)); // start state
        states.add(new HasQuarter());
        states.add(new GumballSold(this));
        states.add(new OutOfGumballs());

        return states;
    }

    private void basicStep(String arg1) {
        this.step(new String[]{arg1});
    }

    public void insertQuarter() {
        System.out.println("You inserted a quarter.");
        this.basicStep("insert_quarter");
    }

    public void ejectQuarter() {
        System.out.println("You request to eject a quarter.");
        this.basicStep("eject_quarter");
    }

    public void turnsCrank() {
        System.out.println("You turned...");
        this.basicStep("turns_crank");
    }

    public void dispenseGumball() {
        this.basicStep("dispense_gumball");
    }



}
