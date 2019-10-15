package implementation;

import org.junit.Test;
import structure.Couple;
import structure.Tuple;
import static org.junit.Assert.*;

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


    }

    @Test
    public void testTriee(){
        PQueueImplTriee<String,Integer> file = new PQueueImplTriee<>();
        Couple<String,Integer> t1 = new Couple<>(1,"FIRST");
        Couple<String,Integer> t2 = new Couple<>(2,"SECOND");
        Couple<String,Integer> t3 = new Couple<>(3,"THIRD");
        Couple<String,Integer> t4 = new Couple<>(6,"FOURTH");
        Couple<String,Integer> t5 = new Couple<>(5,"FIFTH");
        Couple<String,Integer> t6 = new Couple<>(8,"SIXTH");
        assertTrue(file.estVide());

        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);
        assertFalse(file.estVide());
        Couple<String,Integer> r1 = (Couple<String, Integer>) file.retirer().get();
        Couple<String,Integer> r2 = (Couple<String, Integer>)file.retirer().get();
        Couple<String,Integer> r3 = (Couple<String, Integer>)file.retirer().get();
        Couple<String,Integer> r4 = (Couple<String, Integer>)file.retirer().get();
        Couple<String,Integer> r5 = (Couple<String, Integer>)file.retirer().get();
        Couple<String,Integer> r6 = (Couple<String, Integer>)file.retirer().get();

        assertEquals(t6,r1);
        assertEquals(t4,r2);
        assertEquals(t5,r3);
        assertEquals(t3,r4);
        assertEquals(t2,r5);
        assertEquals(t1,r6);


        assertTrue(file.estVide());
        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);

        file.remplacer("FOURTH", 0);
        file.retirer();
        file.retirer();
        file.retirer();
        file.retirer();
        file.retirer();
        Couple<String,Integer> r = (Couple<String, Integer>) file.retirer().get();
        assertEquals(0, r.getPriority().compareTo(0));
        assertEquals("FOURTH", r.getElement());




    }

    @Test
    public void testNonTriee(){
        PQueueImplNonTriee<String,Integer> file = new PQueueImplNonTriee<>();
        Couple<String,Integer> t1 = new Couple<>(1,"FIRST");
        Couple<String,Integer> t2 = new Couple<>(2,"SECOND");
        Couple<String,Integer> t3 = new Couple<>(3,"THIRD");
        Couple<String,Integer> t4 = new Couple<>(6,"FOURTH");
        Couple<String,Integer> t5 = new Couple<>(5,"FIFTH");
        Couple<String,Integer> t6 = new Couple<>(8,"SIXTH");
        assertTrue(file.estVide());

        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);
        assertFalse(file.estVide());
        Couple<String,Integer> r1 = (Couple<String, Integer>) file.retirer().get();
        Couple<String,Integer> r2 = (Couple<String, Integer>)file.retirer().get();
        Couple<String,Integer> r3 = (Couple<String, Integer>)file.retirer().get();
        Couple<String,Integer> r4 = (Couple<String, Integer>)file.retirer().get();
        Couple<String,Integer> r5 = (Couple<String, Integer>)file.retirer().get();
        Couple<String,Integer> r6 = (Couple<String, Integer>)file.retirer().get();

        assertEquals(t6,r1);
        System.out.println(t4.getPriority());
        System.out.println(r2.getPriority());

        assertEquals(t4,r2);
        assertEquals(t5,r3);
        assertEquals(t3,r4);
        assertEquals(t2,r5);
        assertEquals(t1,r6);

        assertTrue(file.estVide());
        file.ajouter(t1);
        file.ajouter(t2);
        file.ajouter(t3);
        file.ajouter(t4);
        file.ajouter(t5);
        file.ajouter(t6);

        file.remplacer("FOURTH", 0);
        file.retirer();
        file.retirer();
        file.retirer();
        file.retirer();
        file.retirer();
        Couple<String,Integer> r = (Couple<String, Integer>) file.retirer().get();
        assertEquals(0, r.getPriority().compareTo(0));
        assertEquals("FOURTH", r.getElement());



    }


}
