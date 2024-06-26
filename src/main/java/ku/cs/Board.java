package ku.cs;

import java.util.TreeSet;

public class Board {
    private TreeSet<Square> squares; 
    private final int SIZE = 40;

    Board(TreeSet<Square> squares) {
        if (squares.size() != SIZE) throw new IllegalArgumentException("Square size must be " + SIZE + ".");
        this.squares = squares;
    }

    public int getSquare(Square oldLocation, int faceValueTotal) {
        return 0;
    }
}
