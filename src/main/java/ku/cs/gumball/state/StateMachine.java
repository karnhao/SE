package ku.cs.gumball.state;

import java.util.List;

public class StateMachine {
    private State startState;
    private List<State> states;

    public StateMachine(List<State> states) {
        this(states, 0);
    }

    public StateMachine(List<State> states, int startStateIndex) {
        if (states.size() < 1) throw new IllegalArgumentException();

        this.states = states;
        this.startState = this.states.get(startStateIndex);
    }

    public void start() {

        State currentState = this.startState;
        State outputState = null;
        while (currentState != null) {

            currentState.entry();
            TransitionOutput output = currentState.transition();
            currentState.exit();

            // search for output state

            for (State s : states) 
                if (s.getClass().equals(output.getStateClass())) outputState = s;
            

            currentState = outputState;
            currentState.setArgs(output.getArgs());
        }
    }

    public void step(String[] args) {

    }

    private TransitionOutput runState(State state) {
        return null;
        // TODO : runState
    }
}
