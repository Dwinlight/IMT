package implementations;

import bibliotheque.Liste;
import bibliotheque.Listes;
import factorisation.FilePrioSimpleFacto;
import interfaces.FilePrioSimple;

import java.util.List;

public class FilePrioSimpleTriee<T extends Comparable<T>> extends FilePrioSimpleFacto<T> {


    public FilePrioSimpleTriee(Liste l){
        super.elements = l;
    }
    @Override
    protected FilePrioSimple<T> fabrique(Liste l) {
        return new FilePrioSimpleTriee<T>(l);
    }

    @Override
    public FilePrioSimple<T> ajouter(T t) {
        return new FilePrioSimpleTriee<T>(Listes.insertionListeOrdonnee(t,super.elements));
    }

    @Override
    public FilePrioSimple<T> retirer() {
        return new FilePrioSimpleTriee<T>(Listes.retraitMinimumListe(super.elements).deux);
    }
}
