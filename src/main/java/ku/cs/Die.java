package ku.cs;

/**
 * 6510451000 Sittipat Tepsutar
 */
public class Die {
    private byte faceValue;

    Die() {
        roll();
    }

    public void roll() {
        this.faceValue = (byte) ( 1 + Math.random() * 6 );
    }

    public byte getFaceValue() {
        return faceValue;
    }
}
