/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pferderennen;

import java.util.Random;

/**
 *
 * @author Hisho
 */
public class Pferd {

    private String name;
    private int startnummer;
    private int gerannteStrecke = 0;
    private boolean aufrangliste = false;

    public Pferd(String name, int startnummer) {
        this.name = name;
        this.startnummer = startnummer;

    }

    public String getName() {
        return name;
    }

    public void rennen() {
        Random rand = new Random();
        int upperbound = 11;
        int int_random = rand.nextInt(upperbound);
        gerannteStrecke += int_random;
    }

    public int getGerannteStrecke() {
        return gerannteStrecke;
    }

    public void setAufrangliste(boolean aufrangliste) {
        this.aufrangliste = aufrangliste;
    }

    public boolean getAufrangliste() {
        return aufrangliste;
    }

    @Override
    public String toString() {
        return "Pferd " + name + ", Startnummer " + startnummer + ": ";
    }

}
