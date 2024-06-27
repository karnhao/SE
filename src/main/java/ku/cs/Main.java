package ku.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Main {

    public static final byte PLAYER_COUNT = 4;

    public static void main(String[] args) {

        // สร้าง squares
        TreeSet<Square> squares = createSquares(MGame.SQUARE_COUNT);

        // สร้างผู้เล่น
        TreeSet<Player> players = createPlayers(PLAYER_COUNT);

        // สร้าง Dice
        List<Die> dice = createDice(MGame.DICE_COUNT);

        // สร้าง board
        Board board = new Board(squares);


        MGame game = new MGame(board, players, dice);

        // เริ่มเกม 10 rounds
        game.playGame(10);
    }


    /**
     * สร้าง TreeSet ของ Square ด้วยชื่อจะอยู่ในรูปแบบ S00, S01, S02, ... ,
     * @param count จำนวน Square ที่ต้องการสร้าง
     * @return TreeSet ของ Square
     */
    private static TreeSet<Square> createSquares(byte count) {
        TreeSet<Square> squares = new TreeSet<>();
        for (byte i = 0; i < count; i++) {
            Square square = new Square( String.format("S%02d", i) );
            squares.add(square);
        }

        return squares;
    }

    /**
     * สร้างผู้เล่นมาจำนวนที่กำหนด n โดยผู้เล่นจะมีชื่อเป็น P1, P2, P3, P4, P5, ..., Pn 
     * @param count จำนวนของผู้เล่นที่จะถูกสร้าง
     * @return TreeSet ของ {@link ku.cs.Player}
     */
    private static TreeSet<Player> createPlayers(byte count) {
        TreeSet<Player> players = new TreeSet<>();

        for (byte i = 0; i < count; i++) {
            Player newPlayer = new Player("P" + (i + 1));
            players.add(newPlayer);
        }

        return players;

    }

    /**
     * สร้างลิสของลูกเต๋าขนาด count
     * @param count
     * @return ลิสของลูกเต๋า
     */
    private static List<Die> createDice(byte count) {

        ArrayList<Die> dice = new ArrayList<>();
        for (byte i = 0; i < count; i++) dice.add(new Die());
        return dice;
        
    }
}