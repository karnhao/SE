package ku.cs.gumball.state;

import java.util.List;

public class StateMachine {
    private State currentState;
    private List<State> states;


    public StateMachine() {
    }

    public StateMachine(List<State> states) {
        this(states, 0);
    }

    public StateMachine(List<State> states, int startStateIndex) {
        if (states.size() < 1) throw new IllegalArgumentException();

        this.states = states;
        this.currentState = this.states.get(startStateIndex);
    }

    protected void setStates(List<State> states, int startStateIndex) {
        this.states = states;
        this.currentState = states.get(startStateIndex);
    }

    /**
     * @deprecated Use {@link #step(String[])} instead
     * @param args
     */
    protected void start(String[] args) {
        step(args);
    }

    protected void step(String[] args) {
        Class<? extends State> output = this.runState(this.currentState, args);

            // search for output state
            if (output == null || output.equals(this.currentState.getClass())) return;
            for (State s : states) 
                if (s.getClass().equals(output)) {
                    this.currentState = s;
                    break;
                }

            // No State found = Still at same state
    }

    private Class<? extends State> runState(State state, String[] args) {
        state.entry(args);
        Class<? extends State> output;
        try {
            
            output = state.transition(args);
            if ( ! output.equals(state.getClass()))
                state.exit(args);
            
                return output;

        } catch (Exception e) {
            System.out.println(e.getClass().toString() + e.getMessage());
        }
        
        return null;
    }
}
