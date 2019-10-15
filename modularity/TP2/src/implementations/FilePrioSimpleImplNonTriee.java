package implementations;

import bibliotheque.Liste;
import bibliotheque.Listes;
import factorisation.FilePrioSimpleFacto;
import interfaces.FilePrioSimple;

public class FilePrioSimpleImplNonTriee<T extends Comparable<T>> extends FilePrioSimpleFacto<T> {


    public FilePrioSimpleImplNonTriee(Liste liste) {
        super.elements = liste;
    }

    @Override
    public FilePrioSimple<T> fabrique(Liste l) {
        return new FilePrioSimpleImplNonTriee(l);
    }

    @Override
    public FilePrioSimple<T> ajouter(T t) {
        return fabrique(Liste.cons(t, super.elements));
    }

    @Override
    public FilePrioSimple<T> retirer() {
        return new FilePrioSimpleTriee<T>(Listes.retraitMinimumListe(super.elements).deux);
    }
}
