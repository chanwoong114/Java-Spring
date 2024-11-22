package generic.test.ex2;

public class Pair<T, V> {
    private T first;
    private V second;

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public T getFirst() {
        return first;
    }
    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
