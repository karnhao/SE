package ku.cs.gumball;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Main {
    public static void main(String[] args) {

        // Create Machine 🍬
        GumballMachine g = new GumballMachine();
        g.addGumball((short) 5); // Add 5 gumballs to the machine
        
        System.out.println("\n");



        
        System.out.println("=== Day 1 ===\n");
        g.insertQuarter();
        g.choose("orange");
        g.turnsCrank();
        g.dispenseGumball();
        System.out.println("End of Day 1\n\n");





        System.out.println("=== Day 2 ===\n");
        g.insertQuarter();
        g.ejectQuarter();
        g.turnsCrank();
        System.out.println("End of Day 2\n\n");





        System.out.println("=== Day 3 ===\n");
        g.insertQuarter();
        g.turnsCrank();
        g.dispenseGumball();

        g.insertQuarter();
        g.turnsCrank();
        g.dispenseGumball();

        g.turnsCrank();
        System.out.println("End of Day 3\n\n");




        System.out.println("=== Day 4 ===\n");
        g.insertQuarter();
        g.turnsCrank();
        g.dispenseGumball();

        g.insertQuarter();
        g.turnsCrank();
        g.dispenseGumball();

        g.insertQuarter();
        g.turnsCrank();
        g.dispenseGumball();
        System.out.println("End of Day 4\n\n");




        System.out.println("=== Day 5 ===\n");
        g.insertQuarter();
        g.turnsCrank();
        g.ejectQuarter();
        System.out.println("End of Day 5\n\n");
    }
}
