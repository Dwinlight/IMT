package Interface;

import structure.Couple;

public interface PQueueExtend<T,P extends Comparable<P>> extends PQueue<Couple<T,P>> {
    public P getPriotity(T e);
    public void remplacer(T e, P i);
}
