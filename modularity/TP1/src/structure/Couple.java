package structure;


public class Couple<T,P extends Comparable<P>> implements Comparable<Couple<T, P >> {

    private P priority;
    private T element;

    public Couple(P priority, T element) {
        this.priority = priority;
        this.element = element;
    }

    public P getPriority() {
        return priority;
    }

    public T getElement() {
        return element;
    }

    @Override
    public int compareTo(Couple couple) {
        return this.priority.compareTo((P) couple.getPriority());
    }
}
