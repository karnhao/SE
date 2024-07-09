package ku.cs.monopoly;

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Square)) return false;
        return this.name.equals(((Square) obj).name);
    }
}
