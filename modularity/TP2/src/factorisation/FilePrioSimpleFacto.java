package factorisation;

import bibliotheque.Liste;
import interfaces.FilePrioSimple;

import java.util.List;

public abstract class FilePrioSimpleFacto<T> implements FilePrioSimple<T> {

    protected Liste<T> elements;

    // Abstract method
    protected abstract FilePrioSimple<T> fabrique(Liste l);

    public FilePrioSimple<T> fabrique(){
        return fabrique(Liste.vide());
    }
    // Accesseurs

    public Liste<T> getListe(){
        return this.elements;
    }
    @Override
    public boolean estVide() {
        return this.elements.estVide();
    }

    @Override
    public int taille() {
        return this.elements.taille();
    }

    @Override
    public Liste<T> toListe() {
        return this.elements;
    }

    // Service 1


}
