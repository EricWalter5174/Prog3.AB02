package de.hsos.prog3.ab02.ui;

import de.hsos.prog3.ab02.logik.Simulation;
import de.hsos.prog3.ab02.util.Interaktionsbrett;

public class SpielfeldDarstellung {
    private Interaktionsbrett ib;
    private static final  int seitenlaengeSpielfeld = 500;
    private static final  int margin = 50;

    public SpielfeldDarstellung(Interaktionsbrett ib){
        this.ib = ib;
    }

    public void spielfeldDarstellen(boolean[][] spielfeld){
        int seitenlaenge = seitenlaengeSpielfeld / spielfeld.length;
        int x = margin;
        int y = margin;
        for(int i = 0; i < spielfeld.length; i++){
            for(int k = 0; k < spielfeld[i].length; k++){
                Quadrat quadrat = new Quadrat(x, y, seitenlaenge);
                if(spielfeld[i][k])
                    quadrat.darstellenFuellung(ib);
                else
                    quadrat.darstellenRahmen(ib);

                x = x+seitenlaenge;
            }
            x = margin;
            y = y+seitenlaenge;
        }
    }

    public void abwischen(){
        ib.abwischen();
    }
}
