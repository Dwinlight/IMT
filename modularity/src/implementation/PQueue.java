package implementation;

import java.util.Optional;

public interface PQueue<T extends Comparable<T>> {

    public void ajouter(T e);
    public Optional<T> retirer();
    public boolean estVide();
    public PQueue<T> fusion(PQueue<T> q);

}
