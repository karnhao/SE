package ku.cs.gumball.state;

public class OutOfGumballs extends State {
    @Override
    public void entry(String[] args) {
        System.out.println("Oops, out of gumballs!");

        System.out.println("Mighty Gumball, Inc.");
        System.out.println("Java-enabled Standing Gumball Model #2004");
        System.out.println("Machine is sold out");
    }

    @Override
    public void exit(String[] args) {
        System.err.println("How!?");
    }

    @Override
    public Class<? extends State> transition(String[] args) {
        if (args[0].equalsIgnoreCase("insert_quarter")) 
            System.out.println("Quarter returned. And Nothing happened.");
        else System.out.println("Nothing happened.");
        
        return null;
    }
}
