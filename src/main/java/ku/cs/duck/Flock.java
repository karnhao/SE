package ku.cs.duck;

import java.util.LinkedList;
import java.util.List;

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
            quackers.get(0).quack();
            quackers.get(0).quack();
        }

        quackers.forEach((t)->t.quack());
    }
}
