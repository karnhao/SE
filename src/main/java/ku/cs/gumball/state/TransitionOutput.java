package ku.cs.gumball.state;

/**
 * @deprecated
 */
public class TransitionOutput {
    private Class<State> clazz;
    private String[] args;

    private TransitionOutput(){};

    public static TransitionOutput create(Class<State> stateClass, String[] args) {
        TransitionOutput output = new TransitionOutput();
        output.clazz = stateClass;
        output.args = args;
        return output;
    }

    public String[] getArgs() {
        return args;
    }

    public Class<State> getStateClass() {
        return clazz;
    }
}
