package ku.cs;

import java.security.InvalidParameterException;
import java.util.List;

public class MGame {
    private int roundCount;
    private List<Die> dice;
    private List<Player> players;
    private final int DICE_COUNT = 2;

    MGame(List<Player> players) {
        // 2 dice
        for (int i = 0; i < DICE_COUNT; i++) dice.add(new Die());

        if (players.size() < 2 || players.size() > 8) throw new InvalidParameterException();
    }

    public void playGame() {

    }

    private void playRound() {

    }

    public int getRoundCount() {
        return roundCount;
    }
}
