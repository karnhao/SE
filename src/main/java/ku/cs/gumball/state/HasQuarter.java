package ku.cs.gumball.state;

public class HasQuarter extends State {

    @Override
    public Class<? extends State> transition(String[] args) {
        if (args[0].equalsIgnoreCase("eject_quarter")) {
            System.out.println("Quarter returned");
            return NoQuarter.class;
        }
        else if (args[0].equalsIgnoreCase("turns_crank"))
            return GumballSold.class;
        throw new IllegalArgumentException();
    }
}
