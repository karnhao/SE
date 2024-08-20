package ku.cs.monopoly;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Piece {
    private Square location;

    Piece(Square location) {
        this.location = location;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }
}
