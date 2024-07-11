package ku.cs.gumball.state;

public abstract class State {
    protected String[] args;
    
    public void entry(String[] args) {}
    public void exit(String[] args) {}
    public Class<? extends State> transition(String[] args) {
        throw new IllegalStateException();
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    
}
