package ku.cs;

public class Die {
    private int faceValue;

    Die() {
        roll();
    }

    public void roll() {
        this.faceValue = (int) ( 1 + Math.random() * 6 );
    }

    public int getFaceValue() {
        return faceValue;
    }
}
