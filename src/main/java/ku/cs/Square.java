package ku.cs;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Square implements Comparable<Square>{
    private String name;
    
    Square(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Square o) {
        return name.compareTo(o.getName());
    }
}
