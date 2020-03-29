/*
 * Conways Game of Life
 * Autor: Eric Walter
 * Prog3 AB02 SoSe20
 * Prof. Heiko Tapken
 * */
package de.hsos.prog3.ab02.ui;

import de.hsos.prog3.ab02.util.Interaktionsbrett;

public class Quadrat {
    private int x;
    private int y;
    private int seitenlaenge;

    public Quadrat(int x, int y, int seitenlaenge){
        setX(x);
        setY(y);
        setSeitenlaenge(seitenlaenge);
    }

    public void setX(int x) {
        if(x >= 1) {this.x = x;}
    }

    public void setY(int y) {
        if(y >= 1) {this.y = y;}
    }

    public void setSeitenlaenge(int seitenlaenge) {
        if(seitenlaenge >= 1) {this.seitenlaenge = seitenlaenge;}
    }

    public void darstellenRahmen(Interaktionsbrett ib){
        ib.neuesRechteck(x, y, seitenlaenge, seitenlaenge);
    }
    public void darstellenFuellung(Interaktionsbrett ib){
        ib.neuesRechteck(x, y, seitenlaenge, seitenlaenge);
        for(int i = 1; i < seitenlaenge; i++){
            ib.neueLinie(x,y+i, x+seitenlaenge, y+i);
        }
    }
}
