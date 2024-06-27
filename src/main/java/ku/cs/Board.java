package ku.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Board {
    private List<Square> squares = new ArrayList<>(); 
    private final byte SIZE = 40; // จำนวน Square ของ board (ตั้งไว้ที่ 40 ตาม UML Class Diagram)

    Board(TreeSet<Square> squares) {
        if (squares.size() != SIZE) throw new IllegalArgumentException("Square size must be " + SIZE + ".");
        this.squares.addAll(squares);
    }

    /**
     * ส่งกลับ Location ใหม่จาก Location เก่าและคำนวน Location ใหม่จากจำนวนรวมของหน้าเต๋าทั้งหมด
     * @param oldLocation Square Location เก่า
     * @param faceValueTotal ผลการทอยลูกเต๋า (จำนวนที่จะเดิน)
     * @return
     */
    public Square getSquare(Square oldLocation, byte faceValueTotal) {

        // หา Index ของ Square เก่า โดยจะหาแบบ Binary Search
        byte index = getSquareIndex(oldLocation);

        byte newIndex = (byte) (index + faceValueTotal);

        if (newIndex >= this.squares.size()) newIndex %= this.squares.size(); // วนกระดาน

        return this.squares.get(newIndex);
    }

    public List<Square> getSquares() {
        return this.squares;
    }

    private byte getSquareIndex(Square square) {
        // binary search ใน ordered list
        // เป็น ordered list แล้วเพราะใน constructor รับ Square มาในรูปแบบ TreeSet
        byte index = getSquareIndex(square, (byte) 0, (byte) (this.squares.size() - 1));

        return index;
    }

    // Binary Search
    private byte getSquareIndex(Square square, byte startIndex, byte endIndex) {
        
        if (startIndex >= endIndex) return startIndex;

        // หาค่ากลาง
        byte mid = (byte) ((startIndex + endIndex) / 2);
        Square midSquare = this.squares.get(mid);
        if (midSquare.equals(square)) return mid; // ตรงกับค่ากลาง
        
        if (midSquare.compareTo(square) > 0) return getSquareIndex(square, startIndex, (byte) (mid - 1));
        return getSquareIndex(square,(byte) (mid + 1), endIndex);

    }

    /**
     * @return Square เริ่มต้นสำหรับ Piece
     */
    public Square getStartSquare() {
        if (this.squares == null || this.squares.size() == 0) return null;
        return this.squares.get(0);
    }
}
