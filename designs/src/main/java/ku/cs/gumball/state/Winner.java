package ku.cs.gumball.state;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Winner extends GumballMachineState {

    private static final short GUMBALL_OUT = 2;

    public Winner(StateMachine<GumballMachineState> machine) {
        super(machine);
    }

    @Override
    public void entry() {
        System.out.println("YOU ARE THE WINNER! You get two gumballs for your quarter.");
    }

    @Override
    public void dispenseGumball() {

        short gumballRemaining = this.getMachine().getGumballCount();
        short gumballOut = GUMBALL_OUT;

        if (gumballRemaining < gumballOut)
            gumballOut = 1; // Poor winner, not enough gumball :(

        this.getMachine().removeGumball(gumballOut);
        for (short i = 0; i < gumballOut; i++)
            System.out.println("A " + this.getMachine().getFlavour()  + " gumball comes rolling out the slot");

        if (this.getMachine().getGumballCount() > 0)
            this.getMachine().changeState(NoQuarter.class);
        else
            this.getMachine().changeState(OutOfGumballs.class);
    }

}
