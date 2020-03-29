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
        int i = 1;
        int anzahlWiederholungen = 0;
        initialisierung();
        int anzahlZellen = eingabe.anzahlZellenDesSpielfelds();
        int wahrscheinlichkeit = eingabe.wahrscheinlichkeitDerBesiedelung();
        simulation.berechneAnfangsGeneration(anzahlZellen, wahrscheinlichkeit);
        while (i > 0) {
            i = eingabe.anzahlDerSimulationsSchritte();
            simulation.berechneFolgeGeneration(i);
        }

    }
    public void initialisierung(){
        darstellung = new SpielfeldDarstellung(new Interaktionsbrett());
        eingabe = new NutzerEingabe(new EinUndAusgabe());
        simulation.anmeldenFuerAktualisierungBeiAenderung(this);
    }
}