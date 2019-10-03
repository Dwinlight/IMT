package implementation;

import Interface.PQueue;
import structure.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PQueueImplNonTrieeSimple<T extends Comparable<T>> implements PQueue<T> {

    private List<T> elements;

    public PQueueImplNonTrieeSimple() {
        this.elements = new ArrayList<T>();
    }

    @Override
    public void ajouter(T e) {
        this.elements.add(e);
    }

    @Override
    public Optional<T> retirer() {
        if(!this.estVide()){
            T temp = this.elements.get(0);
            int flag = 0;
            for (int i = 0; i < this.elements.size(); i++) {
                if(this.elements.get(i).compareTo(temp) > 0){
                    temp = this.elements.get(i);
                    flag = i;
                }
            }
            temp = this.elements.get(flag);
            this.elements.remove(flag);
            return Optional.of(temp);
        }
        return Optional.of(null);
    }

    @Override
    public boolean estVide() {
        return this.elements.size() == 0;
    }

    @Override
    public PQueue<T> fusion(PQueue<T> q) {
        PQueue<T> fusionne = this;
        while(!q.estVide()) {
            fusionne.ajouter(q.retirer().get());
        }
        return fusionne;
    }

    public static void main (String[] args){
        PQueueImplNonTrieeSimple<Tuple> file = new PQueueImplNonTrieeSimple<Tuple>();
        Tuple t1 = new Tuple(1,"FIRST");
        Tuple t2 = new Tuple(2,"SECOND");
        Tuple t3 = new Tuple(3,"THIRD");
        Tuple t4 = new Tuple(6,"FOURTH");
        Tuple t5 = new Tuple(5,"FIFTH");
        Tuple t6 = new Tuple(8,"SIXTH");
        System.out.println(file.estVide() == true ? "[Test 1]: OK": "[Test 1]: FAILED");
        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);
        System.out.println(file.estVide() == false ? "[Test 2]: OK": "[Test 2]: FAILED");
        Tuple r1 = file.retirer().get();
        Tuple r2 = file.retirer().get();
        Tuple r3 = file.retirer().get();
        Tuple r4 = file.retirer().get();
        Tuple r5 = file.retirer().get();
        Tuple r6 = file.retirer().get();

        System.out.println(r1.equals(t6) ? "[Test 3]: OK": "[Test 3]: FAILED ----- Should get: " + t6.getElement() + " but get: " + r1.getElement());
        System.out.println(r2.equals(t4) ? "[Test 4]: OK": "[Test 4]: FAILED ----- Should get: " + t4.getElement() + " but get: " + r2.getElement());
        System.out.println(r3.equals(t5) ? "[Test 5]: OK": "[Test 5]: FAILED ----- Should get: " + t5.getElement() + " but get: " + r3.getElement());
        System.out.println(r4.equals(t3) ? "[Test 6]: OK": "[Test 6]: FAILED ----- Should get: " + t3.getElement() + " but get: " + r4.getElement());
        System.out.println(r5.equals(t2) ? "[Test 7]: OK": "[Test 7]: FAILED ----- Should get: " + t2.getElement() + " but get: " + r5.getElement());
        System.out.println(r6.equals(t1) ? "[Test 8]: OK": "[Test 8]: FAILED ----- Should get: " + t1.getElement() + " but get: " + r6.getElement());
        System.out.println(file.estVide() == true ? "[Test 9]: OK": "[Test 9]: FAILED");


    }
}
