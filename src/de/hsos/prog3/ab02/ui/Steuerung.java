/*
 * Conways Game of Life
 * Autor: Eric Walter
 * Prog3 AB02 SoSe20
 * Prof. Heiko Tapken
 * */
package de.hsos.prog3.ab02.ui;
import de.hsos.prog3.ab02.logik.BeiAenderung;
import de.hsos.prog3.ab02.logik.Simulation;
import de.hsos.prog3.ab02.logik.Simulator;
import de.hsos.prog3.ab02.util.*;

public class Steuerung implements BeiAenderung {
    private SpielfeldDarstellung darstellung;
    private NutzerEingabe eingabe;
    private Simulation simulation = new Simulator();

    @Override
    public void aktualisiere(boolean[][] neu) {
        darstellung.spielfeldDarstellen(neu);
    }

    public void startDesSpiels() throws InterruptedException {
        int anzahlSchritte = 1;
        initialisierung();
        int anzahlZellen = eingabe.anzahlZellenDesSpielfelds();
        int wahrscheinlichkeit = eingabe.wahrscheinlichkeitDerBesiedelung();
        simulation.berechneAnfangsGeneration(anzahlZellen, wahrscheinlichkeit);

        while (anzahlSchritte > 0) {
            anzahlSchritte = eingabe.anzahlDerSimulationsSchritte();
            simulation.berechneFolgeGeneration(anzahlSchritte);
        }

    }
    public void initialisierung(){
        darstellung = new SpielfeldDarstellung(new Interaktionsbrett());
        eingabe = new NutzerEingabe(new EinUndAusgabe());
        simulation.anmeldenFuerAktualisierungBeiAenderung(this);
    }
}