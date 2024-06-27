package ku.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class MGame {
    public static final byte SQUARE_COUNT = 40;
    public static final byte DICE_COUNT = 2;

    public static final byte MAX_PLAYERS = 8;
    public static final byte MIN_PLAYERS = 2;

    private int roundCount;
    private List<Player> players = new ArrayList<>();
    private List<Die> dice;
    private Board board;

    /**
     * Game class constructor. constructor นี้จำเป็นต้องใช้ข้อมูลที่สำคัญเพื่อใช้ในการเริ่มต้นและเล่นเกม. 
     * 
     * จะไม่มีการ copy list ของ dice เพื่อลดพื้นที่ใน visual memory
     * @param board the board to be played.
     * @param players players to play, must have at least 2 players and not more than 8 players.
     * @param dice the dice to be used for the game, must have 2 dice only.
     */
    MGame(Board board, TreeSet<Player> players, List<Die> dice) {
        this.board = board;

        // 2 dice เท่านั้น
        if (dice.size() != DICE_COUNT) throw new IllegalArgumentException("Must have 2 dice");
        this.dice = dice;

        // ผู้เล่นมีได้น้อยสุด 2 ผู้เล่นแต่ไม่มากกว่า 8
        if (players.size() < MIN_PLAYERS || players.size() > MAX_PLAYERS) throw new IllegalArgumentException("Must have at least 2 players and not more than 8 players");
        
        // เพิ่มผู้เล่นไปในเกมแล้วให้ลูกเต๋า ลูกหมาก และกระดานเกม
        for (Player p : players) {
            p.setDice(dice);
            p.setBoard(board);
            p.setPiece(new Piece(board.getStartSquare()));
            this.players.add(p);
        }
    }

    public void playGame(int n) {
        roundCount = 0;
        while (roundCount < n) {
            playRound();
            roundCount++;
        }

        System.out.println("Game Over");
    }

    private void playRound() {
        for (Player p : players) { 

            System.out.println(p.getName() + "'s Turn");

            p.takeTurn();

            System.out.println();
        }
        
        System.out.println("-- END of round --\n");
    }

    public int getRoundCount() {
        return roundCount;
    }

    public List<Die> getDice() {
        return dice;
    }

    public Board getBoard() {
        return board;
    }
}
