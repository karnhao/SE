package ku.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Board {
    private List<Square> squares = new ArrayList<>(); 
    private final byte SIZE = 40;

    Board(TreeSet<Square> squares) {
        if (squares.size() != SIZE) throw new IllegalArgumentException("Square size must be " + SIZE + ".");
        this.squares.addAll(squares);
    }

    public Square getSquare(Square oldLocation, byte faceValueTotal) {
        byte index = getSquareIndex(oldLocation);

        byte newIndex = (byte) (index + faceValueTotal);

        if (newIndex >= this.squares.size()) newIndex %= this.squares.size();

        return this.squares.get(newIndex);
    }

    public List<Square> getSquares() {
        return this.squares;
    }

    private byte getSquareIndex(Square square) {
        // binary search ใน ordered list
        byte index = getSquareIndex(square, (byte) 0, (byte) (this.squares.size() - 1));

        return index;
    }

    // Binary Search for the square index.
    private byte getSquareIndex(Square square, byte startIndex, byte endIndex) {
        if (startIndex >= endIndex) return startIndex;
        byte mid = (byte) ((startIndex + endIndex) / 2);

        Square midSquare = this.squares.get(mid);
        if (midSquare.equals(square)) return mid;
        

        if (midSquare.compareTo(square) > 0) return getSquareIndex(square, startIndex, (byte) (mid - 1));
        return getSquareIndex(square,(byte) (mid + 1), endIndex);

    }

    public Square getStartSquare() {
        if (this.squares == null || this.squares.size() == 0) return null;
        return this.squares.get(0);
    }
}
