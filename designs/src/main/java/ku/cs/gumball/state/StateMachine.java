package ku.cs.gumball.state;

import java.util.List;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class StateMachine<T extends State<T>> {
    private T currentState;
    private List<T> states;


    public StateMachine() {
    }

    public StateMachine(List<T> states) {
        this(states, 0);
    }

    public StateMachine(List<T> states, int startStateIndex) {
        if (states.size() < 1) throw new IllegalArgumentException();

        this.states = states;
        this.currentState = this.states.get(startStateIndex);
    }

    protected void setStates(List<T> states, int startStateIndex) {
        this.states = states;
        this.currentState = states.get(startStateIndex);
    }

    protected T getCurrentState() {
        return this.currentState;
    }

    protected void start(String[] args) {
        this.currentState.entry();
    }

    protected void changeState(Class<? extends T> targetStateClass) {
        T targetState = null;

        // Search for the target state
        for (T s : states) {
            if (s.getClass().equals(targetStateClass)) {
                targetState = s;
                break;
            }
        }

        // State not found or Same state will do nothing
        if (targetState == null || targetState.getClass().equals(this.currentState.getClass())) return;

        this.currentState.exit(); // exit old state
        this.currentState = targetState;
        this.currentState.entry();
    }
}
