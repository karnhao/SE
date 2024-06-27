package ku.cs;

import java.util.List;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Player implements Comparable<Player> {
    private String name;
    private List<Die> dice;
    private Piece piece;
    private Board board;

    Player(String name) {
        this.name = name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setDice(List<Die> dice) {
        if (dice.size() != MGame.DICE_COUNT) throw new IllegalArgumentException("Must have 2 dice");
        this.dice = dice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void takeTurn() {
        byte totalFaceValue = 0;

        // ทอยลูกเต๋าทั้งหมดและหาผลรวม
        for (Die die : this.dice) {
            die.roll();
            byte fv = die.getFaceValue();
            totalFaceValue += fv;
        }

        // แสดงผลลัพท์ Roll
        showRollResult(totalFaceValue);

        
        Square oldLocation = this.piece.getLocation();
        Square newLocation = this.board.getSquare(oldLocation, totalFaceValue);
        
        this.piece.setLocation(newLocation);

        // แสดงผลลัพท์การเดินลูกหมาก
        showLocationResult(oldLocation, newLocation);
    }


    private void showRollResult(byte totalFaceValue) {
        System.out.print("Player " + this.name + "'s Roll Result: ");
        for (Die die : this.dice) System.out.print(die.getFaceValue() + ", ");
        
        System.out.println("Total Face Value: " + totalFaceValue);
    }

    private void showLocationResult(Square oldLocation, Square newLocation) {
        System.out.println("Piece Location: " + oldLocation.getName() + " -> " + newLocation.getName());
    }

    /**
     * เปรียบเทียมด้วยชื่อผู้เล่น ใช้สำหรับเรียงลำดับผู้เล่นตามชื่อผู้เล่น
     */
    @Override
    public int compareTo(Player o) {
        return this.name.compareTo(o.name);
    }
}
