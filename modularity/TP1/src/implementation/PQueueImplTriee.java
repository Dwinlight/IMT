package implementation;

import Interface.PQueueExtend;
import structure.Couple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PQueueImplTriee<T,P extends  Comparable<P>> implements PQueueExtend<T,P> {

    List<Couple<T,P>> elements;

    public PQueueImplTriee() {
        this.elements = new ArrayList<>();
    }


    @Override
    public void ajouter(Couple<T, P> e) {
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
    public Optional retirer() {
        if(!this.estVide()){
            Couple<T,P> temp = this.elements.get(0);
            this.elements.remove(0);
            return Optional.of(temp);
        }
        return Optional.of(null);
    }

    @Override
    public boolean estVide() {
        return this.elements.isEmpty();
    }



    @Override
    public P getPriotity(T e) {
        int j = 0;
        int l = this.elements.size();
        while(j<l && !this.elements.get(j).getElement().equals(e)) {
            j++;
        }
        if (j == l){

            try {
                throw new Exception("Element inexistant");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return this.elements.get(j).getPriority();
    }

    @Override
    public void remplacer(T e, P i) {
        int j = 0;
        int l = this.elements.size();
        while(j<l && !this.elements.get(j).getElement().equals(e)) {
            j++;
        }
        if (j == l){

            try {
                throw new Exception("Element inexistant");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        this.elements.set(j, new Couple<>(i,e));
        this.elements.sort(Couple::compareTo);
        Collections.reverse(this.elements);
    }




}
