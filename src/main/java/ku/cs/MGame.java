package ku.cs;

import java.util.List;
import java.util.TreeSet;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class MGame {
    private int roundCount;
    private List<Die> dice;
    private List<Player> players;
    private Board board;

    /**
     * Game class constructor. This constructor require necessary data for initialization and play the game. 
     * 
     * This constructor will not copy the data from the parameters but will copy the pointers for space efficient.
     * @param board the board to be played.
     * @param players players to play, must have at least 2 players and not more than 8 players.
     * @param dice the dice to be used for the game, must have 2 dice only.
     */
    MGame(Board board, List<Player> players, List<Die> dice) {
        // 2 dice
        if (dice.size() != 2) throw new IllegalArgumentException("Must have 2 dice");
        this.dice = dice; // referrence

        if (players.size() < 2 || players.size() > 8) throw new IllegalArgumentException("Must have at least 2 players and not more than 8 players");
        this.players = players; // referrence
    }

    public void playGame() {

    }

    private void playRound() {

    }

    public int getRoundCount() {
        return roundCount;
    }
}
