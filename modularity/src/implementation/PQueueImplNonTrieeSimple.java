package implementation;

import Interface.PQueue;
import structure.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PQueueImplNonTrieeSimple<T extends Comparable<T>> implements PQueue<T> {

    private List<T> elements;

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
        PQueue<T> fusionne = new PQueueImplNonTrieeSimple<>(this.elements);
        while(!q.estVide()) {
            fusionne.ajouter(q.retirer().get());
        }
        System.out.println(this.elements.size());
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

        PQueueImplNonTrieeSimple<Tuple> file2 = new PQueueImplNonTrieeSimple<Tuple>();
        Tuple c1 = new Tuple(4,"ICHI");
        Tuple c2 = new Tuple(8,"NI");
        Tuple c3 = new Tuple(12,"SAN");
        Tuple c4 = new Tuple(0,"YON");
        Tuple c5 = new Tuple(7,"GO");
        Tuple c6 = new Tuple(5,"ROKU");

        ArrayList<Tuple> check = new ArrayList<Tuple>();
        check.add(c1);
        check.add(c2);
        check.add(c3);
        check.add(c4);
        check.add(c5);
        check.add(c6);
        check.add(t1);
        check.add(t2);
        check.add(t3);
        check.add(t4);
        check.add(t5);
        check.add(t6);
        PQueue<Tuple> merge = file.fusion(file2);
        System.out.println(file.elements.size() == 6 ?"[Test 10]: OK": "[Test 10]: FAILED");
        int j = 0;
        while(!merge.estVide() && check.contains(merge.retirer())){
            j++;
        }

        System.out.println(j == 12 && merge.estVide() ?"[Test 11]: OK": "[Test 11]: FAILED  ---- length= "+j+" and empty = "+ merge.estVide());





    }
}
