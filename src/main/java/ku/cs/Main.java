package ku.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Main {

    public static final byte PLAYER_COUNT = 4;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // args ตอนเรียกใช้โปรแกรม
        List<String> argsList = Arrays.asList(args).stream().map(t->t.toLowerCase()).toList(); // แปลง String ทุกตัวที่อยู่ใน List เป็นตัวพิมพ์เล็ก

        // สร้าง squares
        TreeSet<Square> squares = createSquares(MGame.SQUARE_COUNT);

        // สร้างผู้เล่น
        TreeSet<Player> players = argsList.contains("-p") ? createPlayers(PLAYER_COUNT) : createPlayersFromInput(scanner); // ถ้าใน argsList มี option -p อยู่จะไปเรียกใช้ createPlayers แทน ซึ่งจะสร้าง Default Players มา 4 คนให้

        // สร้าง Dice
        List<Die> dice = createDice(MGame.DICE_COUNT);

        // สร้าง board
        Board board = new Board(squares);


        MGame game = new MGame(board, players, dice);

        // เริ่มเกม n rounds
        int n;
        while (true) {
            try {
                System.out.print("Enter Rounds (Integer): ");
                n = scanner.nextInt();
                if (n < 0) throw new IllegalArgumentException();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Number, try again.");
                scanner.nextLine(); // flush the buffer
            }
        }
        scanner.close();
        System.out.print("\n -- Game Start -- \n\n");
        game.playGame(n);
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

    /**
     * สร้าง TreeSet ของ player โดยผู้ใช้สามารถกำหนดชื่อ player ได้ผ่าน InputStream
     * @param in InputStream
     * @return TreeSet of Player
     */
    private static TreeSet<Player> createPlayersFromInput(Scanner scanner) {
        int playerCount; // ให้เป็น int แทน byte เพื่อป้องกันไม่ให้เกิด overflow จาก input ของผู้ใช้ได้ง่ายเกินไป

        while (true) {
            System.out.printf("Input Player Count (%d to %d players): ", MGame.MIN_PLAYERS, MGame.MAX_PLAYERS);
            try {
                playerCount = scanner.nextByte();
                if (playerCount > MGame.MAX_PLAYERS || playerCount < MGame.MIN_PLAYERS) throw new IllegalArgumentException("Must have at least 2 players and not more than 8 players");
                break;
            } catch (Exception e) {
                System.out.printf("Error : " + e.getClass().getName() + " " + e.getMessage() + "\n");
                scanner.nextLine(); // flush the buffer
            }
        }

        TreeSet<Player> players = new TreeSet<Player>();
        for (byte i = 0; i < playerCount; i++) {
            System.out.printf("Input Player " + (i + 1) + "'s name: ");
            Player player = new Player(scanner.next());
            players.add(player);
        }

        return players;
    }
}