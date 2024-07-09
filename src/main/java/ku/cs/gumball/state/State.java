package ku.cs.gumball.state;

public abstract class State {

    protected String[] args;
    
    public void entry() {}
    public void exit() {}
    public TransitionOutput transition() {
        return null;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    
}
