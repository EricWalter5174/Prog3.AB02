package de.hsos.prog3.ab02.logik;

import java.util.Random;

public class Simulator implements Simulation {
    private BeiAenderung beiAenderung;
    private boolean[][] spielfeld;
    private int anzahlFelder;

    @Override
    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedelung) {
        anzahlFelder = anzahlDerZellen;
        Random random = new Random();
        spielfeld = new boolean[anzahlDerZellen][anzahlDerZellen];
        for(int i = 0; i < anzahlDerZellen; i++){
            for(int k = 0; k < anzahlDerZellen; k++){
                int randomValue = random.nextInt(100);
                spielfeld[i][k] = randomValue > wahrscheinlichkeitDerBesiedelung;
            }
        }
        if(beiAenderung != null) {
            beiAenderung.aktualisiere(spielfeld);
        }
    }

    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) throws InterruptedException {
        int durchlaufNr = 0;
        while(durchlaufNr < berechnungsschritte){
            for(int x = 0; x < anzahlFelder; x++){
                for(int y = 0; y < anzahlFelder; y++){
                    int anzahlNachbarn = berechneNachbarn(x, y);

                    //1. Regel: Zelle mit 3 Nachbarn wird wiederbelebt
                    if(anzahlNachbarn == 3 && !spielfeld[x][y]){
                        spielfeld[x][y] = true;
                    }

                    //2. Regel: Tod durch Unterbevoelkerung mit weniger als 2 Nachbarn
                    if(anzahlNachbarn < 2){
                        spielfeld[x][y] = false;
                    }

                    //3. Regel: Bleibt unverändert bei 2 oder 3 Nachbarn
                    if(anzahlNachbarn == 2 || anzahlNachbarn == 3){
                        //Mache nichts
                    }
                    //4. Regel: Tod durch Ueberbevoelkerung
                    if(anzahlNachbarn > 3){
                        spielfeld[x][y] = false;
                    }
                }
            }
            if(beiAenderung != null) {
                beiAenderung.aktualisiere(spielfeld);
            }
            Thread.sleep(200);
            durchlaufNr++;
        }
    }

    private int berechneNachbarn(int x, int y){
        int nachbarn = 0;
            //Pruefe oben
            if(istInnerhalbSpielfeldUndHatNachbarn(x-1, y-1)) {nachbarn++;}
            if(istInnerhalbSpielfeldUndHatNachbarn(x, y-1)) {nachbarn++;}
            if(istInnerhalbSpielfeldUndHatNachbarn(x+1, y-1)) {nachbarn++;}

            //Pruefe Mitte
            if(istInnerhalbSpielfeldUndHatNachbarn(x-1, y)) {nachbarn++;}
            if(istInnerhalbSpielfeldUndHatNachbarn(x+1, y)) {nachbarn++;}

            //Pruefe unten
            if(istInnerhalbSpielfeldUndHatNachbarn(x-1, y+1)) {nachbarn++;}
            if(istInnerhalbSpielfeldUndHatNachbarn(x, y+1)) {nachbarn++;}
            if(istInnerhalbSpielfeldUndHatNachbarn(x+1, y+1)) {nachbarn++;}
        return nachbarn;
    }

    private boolean istInnerhalbSpielfeldUndHatNachbarn(int x, int y){
        boolean istAusserhalb = false;
        if(x < 0 || y < 0 || x >= spielfeld.length || y >= spielfeld[x].length) {istAusserhalb = true;}
        if(istAusserhalb) {
            return false;
        }
        if(spielfeld[x][y]) {
            return true;
        }
        return false;

    }

    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        this.beiAenderung = beiAenderung;
    }
}
