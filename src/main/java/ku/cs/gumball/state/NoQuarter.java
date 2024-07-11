package ku.cs.gumball.state;

public class NoQuarter extends State {
    @Override
    public Class<? extends State> transition(String[] args) {
        if (args[0].equalsIgnoreCase("insert_quarter")) 
            return HasQuarter.class; // Go to state HasQuarter :)
        else if (args[0].equalsIgnoreCase("eject_quarter"))
            throw new IllegalArgumentException("Cannot eject a quarter from No Quarters state");
        throw new IllegalArgumentException("No.");
    }
}
