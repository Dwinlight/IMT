package implementation;

import Interface.PQueue;
import structure.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PQueueImplNonTrieeSimple<T extends Comparable<T>> implements PQueue<T> {

    protected List<T> elements;

    public PQueueImplNonTrieeSimple() {
        this.elements = new ArrayList<T>();
    }
    public PQueueImplNonTrieeSimple(List<T> elements) {
        this.elements = elements;
    }
    @Override
    public void ajouter(T e) {
        this.elements.add(e);
    }

    @Override
    public Optional<T> retirer() {
        if(!this.estVide()){
            T t = Collections.max(this.elements);
            this.elements.remove(Collections.max(this.elements));
            return Optional.of(t);
        }
        return Optional.of(null);
    }

    @Override
    public boolean estVide() {
        return this.elements.size() == 0;
    }

    @Override
    public PQueue<T> fusion(PQueue<T> q) {

        PQueue<T> fusionne = new PQueueImplNonTrieeSimple<>();
        List<T> temp = new ArrayList<>();

        for(T el: this.elements){
            fusionne.ajouter(el);
        }

        while(!q.estVide()){
            T ele = q.retirer().get();
            temp.add(ele);
            fusionne.ajouter(ele);
        }
        for(T el2: temp){
            q.ajouter(el2);
        }

        return fusionne;
    }


}
