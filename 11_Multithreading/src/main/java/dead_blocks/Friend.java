package dead_blocks;

public class Friend implements Comparable<Friend> {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void throwBallTo(Friend throwTo) {
        System.out.printf("%s throw ball to %s%n", throwTo.getName(), this.name);
        synchronized (compareTo(throwTo) > 0 ? throwTo : this) {
            throwTo.throwBallTo(this);
        }
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
