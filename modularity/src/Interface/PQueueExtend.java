package Interface;

public interface PQueueExtend<T> extends PQueue {
    public Double getPriotity(T e);
    public void remplacer(T e, Double i);
    public void ajouter (T e, Double i);
}
