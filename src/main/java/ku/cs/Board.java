package ku.cs;

import java.util.TreeMap;
import java.util.TreeSet;

public class Board {
    private TreeMap<Square, Void> squares; 
    private final int SIZE = 40;

    Board(TreeSet<Square> squares) {
        if (squares.size() != SIZE) throw new IllegalArgumentException("Square size must be " + SIZE + ".");
        squares.forEach(t -> this.squares.put(t, null));
    }

    public int getSquare(Square oldLocation, int faceValueTotal) {
        return 0;
    }



    private int getSquareIndex(Square square) {
        
        return -1;
    }
}
