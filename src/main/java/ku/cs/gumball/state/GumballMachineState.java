package ku.cs.gumball.state;

import ku.cs.gumball.GumballMachine;

public abstract class GumballMachineState extends State<GumballMachineState> {
    
    public GumballMachineState(StateMachine<GumballMachineState> machine) {
        super(machine);
    }

    public GumballMachineState(StateMachine<GumballMachineState> machine, boolean accepting) {
        super(machine, accepting);
    }

    protected GumballMachine getMachine() {
        return (GumballMachine) super.getMachine();
    }

    public void insertQuarter() {
        throw new IllegalStateException();
    }

    public void ejectQuarter() {
        throw new IllegalStateException();
    }

    public void turnsCrank() {
        throw new IllegalStateException();
    }
    
    public void dispenseGumball() {
        throw new IllegalStateException();
    }

    public void chooseFlavour(String flavour) {
        throw new IllegalStateException();
    }
}
