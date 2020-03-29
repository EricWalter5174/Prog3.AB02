package de.hsos.prog3.ab02.logik;

public interface Simulation {
    void berechneAnfangsGeneration(int anzahlDerZellen, int wahrschkeitDerBesiedelung);
    void berechneFolgeGeneration(int berechnungsschritte) throws InterruptedException;
    void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung);
}
