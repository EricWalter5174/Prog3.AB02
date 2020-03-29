/*
 * Conways Game of Life
 * Autor: Eric Walter
 * Prog3 AB02 SoSe20
 * Prof. Heiko Tapken
 * */
package de.hsos.prog3.ab02.ui;

import de.hsos.prog3.ab02.util.EinUndAusgabe;

public class NutzerEingabe {
    private static int konstanteZellen = 100;
    private static int konstanteSchritte = 50;
    private EinUndAusgabe io;

    public NutzerEingabe(EinUndAusgabe io){
        this.io = io;
    }
    public int anzahlZellenDesSpielfelds(){
        System.out.println("Anzahl der Zellen eingeben (10-100): ");
        int eingabe = io.leseInteger();
        if(eingabe <= konstanteZellen || eingabe > 9){
            return eingabe;
        }
        System.err.println("Eingabe außerhalb der Grenzen.");
        return -1;
    }
    public int wahrscheinlichkeitDerBesiedelung(){
        System.out.println("Wahrscheinlichkeit der Besiedelung eingeben (1-100): ");
        int eingabe = io.leseInteger();
        if(eingabe <= 100 || eingabe > 0){
            return eingabe;
        }
        System.err.println("Eingabe außerhalb der Grenzen.");
        return -1;
    }
    public int anzahlDerSimulationsSchritte(){
        System.out.println("Anzahl der Simulationsschritte eingeben (1 - 50) [negative Zahl für Abbruch]: ");
        int schritte = io.leseInteger();
        if (schritte > 1 && schritte <= konstanteSchritte) {
            return schritte;
        }
        System.err.println("Eingabe außerhalb der Grenzen.");
        return -1;
    }
}
