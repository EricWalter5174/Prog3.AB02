package de.hsos.prog3.ab02;

import de.hsos.prog3.ab02.ui.Steuerung;

public class Main {
    public static void main(String[] args) {
        Steuerung steuerung = new Steuerung();
        try {
            steuerung.startDesSpiels();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
