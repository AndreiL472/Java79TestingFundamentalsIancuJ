package org.exemple.task1;

public class Perimetru {
    //se mai poate crea un atrubut double diametru
    // si metoda de calcul se modifica la parametri, devine neparametrizata
    //iar pe retunr invocam this.diametru

    public double calculeazaPerimetru(double diametru) {
        return Math.PI * diametru;
    }

}
