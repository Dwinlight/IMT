package implementation;

import Interface.PQueue;
import structure.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PQueueImplTrieeSimple<T extends Comparable<T>> implements PQueue<T> {

    protected List<T> elements;

    public PQueueImplTrieeSimple() {
        this.elements = new ArrayList<T>();
    }

    @Override
    public void ajouter(T e) {
        if(this.estVide()){
            this.elements.add(e);
        }
        else{
            int i = 0;
            while(i<this.elements.size() && e.compareTo(this.elements.get(i)) <= 0 ){
                i++;
            }
            this.elements.add(i, e);
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




}
