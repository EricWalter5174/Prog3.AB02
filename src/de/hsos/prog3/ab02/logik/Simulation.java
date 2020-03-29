/*
 * Conways Game of Life
 * Autor: Eric Walter
 * Prog3 AB02 SoSe20
 * Prof. Heiko Tapken
 * */
package de.hsos.prog3.ab02.logik;

public interface Simulation {
    void berechneAnfangsGeneration(int anzahlDerZellen, int wahrschkeitDerBesiedelung);
    void berechneFolgeGeneration(int berechnungsschritte) throws InterruptedException, java.lang.InterruptedException;
    void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung);
}
