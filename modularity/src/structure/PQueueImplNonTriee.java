package structure;

import implementation.PQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PQueueImplNonTriee<T extends Comparable<T>> implements PQueue<T> {

    private List<T> elements;

    public PQueueImplNonTriee() {
        this.elements = new ArrayList<T>();
    }

    @Override
    public void ajouter(T e) {
        if(this.estVide()){
            this.elements.add(e);
        }
        else{
            for (T el: this.elements){
                if(e.compareTo(el) > 0){
                    this.elements.add(this.elements.indexOf(el), e);
                }
            }
        }

    }

    @Override
    public Optional<T> retirer() {
        if(!this.estVide()){
            T temp = this.elements.get(0);
            this.elements.remove(0);
            return Optional.of(temp);
        }
        return Optional.of(null);
    }

    @Override
    public boolean estVide() {
        return this.elements.size() == 0;
    }

    @Override
    public PQueue<T> fusion() {
        return null;
    }
}
