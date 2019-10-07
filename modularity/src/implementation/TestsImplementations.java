package implementation;

import Interface.PQueue;
import org.junit.Test;
import structure.Tuple;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class TestsImplementations {
    @Test
    public void testSimpleTriee(){

        PQueueImplTrieeSimple<Tuple> file = new PQueueImplTrieeSimple<Tuple>();
        Tuple t1 = new Tuple(1,"FIRST");
        Tuple t2 = new Tuple(2,"SECOND");
        Tuple t3 = new Tuple(3,"THIRD");
        Tuple t4 = new Tuple(6,"FOURTH");
        Tuple t5 = new Tuple(5,"FIFTH");
        Tuple t6 = new Tuple(8,"SIXTH");
        assertTrue(file.estVide());

        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);
        assertFalse(file.estVide());
        Tuple r1 = file.retirer().get();
        Tuple r2 = file.retirer().get();
        Tuple r3 = file.retirer().get();
        Tuple r4 = file.retirer().get();
        Tuple r5 = file.retirer().get();
        Tuple r6 = file.retirer().get();

        assertEquals(t6,r1);
        assertEquals(t4,r2);
        assertEquals(t5,r3);
        assertEquals(t3,r4);
        assertEquals(t2,r5);
        assertEquals(t1,r6);

        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);
        PQueueImplTrieeSimple<Tuple> file2 = new PQueueImplTrieeSimple<Tuple>();
        Tuple c1 = new Tuple(4,"ICHI");
        Tuple c2 = new Tuple(8,"NI");
        Tuple c3 = new Tuple(12,"SAN");
        Tuple c4 = new Tuple(0,"YON");
        Tuple c5 = new Tuple(7,"GO");
        Tuple c6 = new Tuple(5,"ROKU");
        file2.ajouter(c1);
        file2.ajouter(c2);
        file2.ajouter(c3);
        file2.ajouter(c4);
        file2.ajouter(c5);
        file2.ajouter(c6);
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
        assertEquals(6, file.elements.size());
        int j = 0;

        while(!merge.estVide() && check.contains(merge.retirer().get())){
            j++;
        }
        assertEquals(12, j);
        assertTrue(merge.estVide());

    }
    @Test
    public void testSimpleNonTriee(){
        PQueueImplNonTrieeSimple<Tuple> file = new PQueueImplNonTrieeSimple<Tuple>();
        Tuple t1 = new Tuple(1,"FIRST");
        Tuple t2 = new Tuple(2,"SECOND");
        Tuple t3 = new Tuple(3,"THIRD");
        Tuple t4 = new Tuple(6,"FOURTH");
        Tuple t5 = new Tuple(5,"FIFTH");
        Tuple t6 = new Tuple(8,"SIXTH");
        assertTrue(file.estVide());

        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);
        assertFalse(file.estVide());
        Tuple r1 = file.retirer().get();
        Tuple r2 = file.retirer().get();
        Tuple r3 = file.retirer().get();
        Tuple r4 = file.retirer().get();
        Tuple r5 = file.retirer().get();
        Tuple r6 = file.retirer().get();

        assertEquals(t6,r1);
        assertEquals(t4,r2);
        assertEquals(t5,r3);
        assertEquals(t3,r4);
        assertEquals(t2,r5);
        assertEquals(t1,r6);

        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);
        PQueueImplNonTrieeSimple<Tuple> file2 = new PQueueImplNonTrieeSimple<Tuple>();
        Tuple c1 = new Tuple(4,"ICHI");
        Tuple c2 = new Tuple(8,"NI");
        Tuple c3 = new Tuple(12,"SAN");
        Tuple c4 = new Tuple(0,"YON");
        Tuple c5 = new Tuple(7,"GO");
        Tuple c6 = new Tuple(5,"ROKU");
        file2.ajouter(c1);
        file2.ajouter(c2);
        file2.ajouter(c3);
        file2.ajouter(c4);
        file2.ajouter(c5);
        file2.ajouter(c6);
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
        assertEquals(6, file.elements.size());
        int j = 0;

        while(!merge.estVide() && check.contains(merge.retirer().get())){
            j++;
        }
        assertEquals(12, j);
        assertTrue(merge.estVide());


    }


}
