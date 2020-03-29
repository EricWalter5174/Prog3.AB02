/*
 * Conways Game of Life
 * Autor: Eric Walter
 * Prog3 AB02 SoSe20
 * Prof. Heiko Tapken
 * */
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
