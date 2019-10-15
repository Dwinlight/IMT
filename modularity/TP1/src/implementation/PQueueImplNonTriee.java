package implementation;

import Interface.PQueueExtend;
import structure.Couple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PQueueImplNonTriee<T,P extends  Comparable<P>> implements PQueueExtend<T,P> {

    List<Couple<T,P>> elements;

    public PQueueImplNonTriee() {
        this.elements = new ArrayList<>();
    }


    @Override
    public void ajouter(Couple<T, P> e) {
        this.elements.add(e);
    }

    @Override
    public Optional retirer() {
        P maximum = this.elements.get(0).getPriority();
        int indexMaximum = 0;
        for(int z=1; z<this.elements.size(); z++){
            if (this.elements.get(z).getPriority().compareTo(maximum)>0){
                maximum = this.elements.get(z).getPriority();
                indexMaximum = z;
            }
        }
        Couple<T,P> temp  = this.elements.get(indexMaximum);
        this.elements.remove(indexMaximum);
        return Optional.of(temp);
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
    }




}
