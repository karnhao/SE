package ku.cs.gumball;

import java.util.LinkedList;
import java.util.List;

import ku.cs.gumball.state.GumballSold;
import ku.cs.gumball.state.HasQuarter;
import ku.cs.gumball.state.NoQuarter;
import ku.cs.gumball.state.OutOfGumballs;
import ku.cs.gumball.state.State;
import ku.cs.gumball.state.StateMachine;

public class GumballMachine extends StateMachine {
    private short gumballCount;

    public GumballMachine(short gumballCount) {
        super();
        this.setStates(createStates(), 0);
        this.gumballCount = gumballCount;
    }

    public short getGumballCount() {
        return gumballCount;
    }

    public void removeGumball(short count) {
        if (gumballCount < count) throw new IllegalArgumentException("Not enough gumball to dispense");
        this.gumballCount -= count;
    }

    public void addGumball(short count) {
        this.gumballCount += count;
    }

    private List<State> createStates() {
        List<State> states = new LinkedList<>();

        states.add(new NoQuarter()); // start state
        states.add(new HasQuarter());
        states.add(new GumballSold(this));
        states.add(new OutOfGumballs());

        return states;
    }

    private void basicStep(String arg1) {
        this.step(new String[]{arg1});
    }

    public void insertQuarter() {
        this.basicStep("insert_quarter");
    }

    public void ejectQuarter() {
        this.basicStep("eject_quarter");
    }

    public void turnsCrank() {
        this.basicStep("turns_crank");
    }

    public void dispenseGumball() {
        this.basicStep("dispense_gumball");
    }



}
