package ku.cs.gumball.state;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public abstract class State<T extends State<T>> {
    private final boolean accepting;
    private final StateMachine<T> machine;

    public State(StateMachine<T> machine) {
        this(machine, false);
    }

    public State(StateMachine<T> machine, boolean accepting) {
        this.accepting = accepting;
        this.machine = machine;
    }
    
    public void entry() {}
    public void exit() {}

    public final boolean isAcceptState() {
        return this.accepting;
    }

    protected StateMachine<T> getMachine() {
        return this.machine;
    }
}
