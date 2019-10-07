package implementation;

import Interface.PQueue;
import Interface.PQueueExtend;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public abstract class PQueueImplNonTriee<T> implements PQueueExtend<T> {

    List<Pair<T,Double>> elements;

    public PQueueImplNonTriee() {
        this.elements = new ArrayList<>();
    }

    public PQueueImplNonTriee(List<Pair<T, Double>> elements) {
        this.elements = elements;
    }



    @Override
    public Optional retirer() {
        Double maximum = this.elements.get(0).getValue();
        int indexMaximum = 0;
        for(int z=1; z<this.elements.size(); z++){
            if (this.elements.get(z).getValue()>maximum){
                indexMaximum = z;
            }
        }
        T temp  = this.elements.get(indexMaximum).getKey();
        this.elements.remove(indexMaximum);
        return Optional.of(temp);
    }

    @Override
    public boolean estVide() {
        return this.elements.isEmpty();
    }

    @Override
    public PQueue fusion(PQueue q) {
        PQueue<T> fusionne = new PQueueImplNonTriee<>();
        List<Pair<T,Double>> temp = new ArrayList<>();

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

    @Override
    public Double getPriotity(T e) {
        int j = 0;
        int l = this.elements.size();
        while(j<l && !this.elements.get(j).getKey().equals(e)) {
            j++;
        }
        if (j == l){

            try {
                throw new Exception("Element inexistant");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return this.elements.get(j).getValue();
    }

    @Override
    public void remplacer(T e, Double i) {
        int j = 0;
        int l = this.elements.size();
        while(j<l && !this.elements.get(j).getKey().equals(e)) {
            j++;
        }
        if (j == l){

            try {
                throw new Exception("Element inexistant");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        this.elements.set(j, new Pair<>(e, i));
    }

    @Override
    public void ajouter(T e, Double i) {
        try{
            int j = 0;
            while(j<this.elements.size() && !this.elements.get(j).equals(e)){
                j++;
            }
            if(j!=this.elements.size()){
                throw new Exception("Erreur la liste contient déjà cet élément");
            }
        }
        catch (Exception exp) {
            exp.printStackTrace();
        }
        this.elements.add(new Pair<>(e,i));
    }
}
