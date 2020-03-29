/*
 * Conways Game of Life
 * Autor: Eric Walter
 * Prog3 AB02 SoSe20
 * Prof. Heiko Tapken
 * */
package de.hsos.prog3.ab02.ui;

import de.hsos.prog3.ab02.util.Interaktionsbrett;

public class SpielfeldDarstellung {
    private Interaktionsbrett ib;
    private static final  int seitenlaengeSpielfeld = 300;
    private static final  int margin = 30;

    public SpielfeldDarstellung(Interaktionsbrett ib){
        this.ib = ib;
    }

    public void spielfeldDarstellen(boolean[][] spielfeld){
        int seitenlaenge = seitenlaengeSpielfeld / spielfeld.length;
        int x = margin;
        int y = margin;
        for (boolean[] booleans : spielfeld) {
            for (boolean aBoolean : booleans) {
                Quadrat quadrat = new Quadrat(x, y, seitenlaenge);
                if (aBoolean)
                    quadrat.darstellenFuellung(ib);
                else
                    quadrat.darstellenRahmen(ib);

                x = x + seitenlaenge;
            }
            x = margin;
            y = y + seitenlaenge;
        }
    }

    public void abwischen(){
        ib.abwischen();
    }
}
