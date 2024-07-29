package ku.cs.duck;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Flock implements Quackable {
    List<Quackable> quackers = new LinkedList<>();

    public void add(Quackable quackable) {
        quackers.add(quackable);
    }

    public Flock() {
    }

    public Flock(List<Quackable> quackers) {
        this.quackers = quackers;
    }

    @Override
    public void quack() {
        if (quackers.size() > 0) {
            Quackable leader = quackers.get(0);
            leader.quack();
            leader.quack();
            leader.quack();
        }

        quackers.forEach((t)->t.quack());
    }
}
