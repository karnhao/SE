package ku.cs;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Square> squares = new TreeSet<>();
        for (int i = 0; i < 40; i++) {
            Square square = new Square( (char) ('a' + i) + "" );
        }

        Board board = new Board(squares);


        MGame game = new MGame(board, null, null);
    }
}