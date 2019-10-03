package structure;

public class Tuple implements Comparable<Tuple> {
    int priority;
    String element;

    public Tuple(int priority, String element) {
        this.priority = priority;
        this.element = element;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

    public String getElement() {
        return element;
    }

    @Override
    public int compareTo(Tuple t){
        if (this.priority > t.getPriority()){
            return 1;
        }
        if (this.priority < t.getPriority()) {
            return -1;
        }
        return 0;
    }


}
