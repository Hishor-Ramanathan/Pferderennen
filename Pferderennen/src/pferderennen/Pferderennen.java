/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pferderennen;

import java.util.ArrayList;

/**
 *
 * @author Hisho
 */
public class Pferderennen {
    private  String rangliste;
    private int streckenLaenge;
    ArrayList<Pferd> Pferde = new ArrayList<>();

    public Pferderennen(int streckenLaenge, int anzahlPferde) {
        this.streckenLaenge = streckenLaenge;
        for (int i = 0; i < anzahlPferde; i++) {
            Pferde.add(new Pferd("Pferd " + i, i));
        }
    }

    private String gerannteStreckeAlsBalken(Pferd pferd) {

        return "";
    }

    public void lassPferdeRennen() {
        int rang = 0;
        while (rennenZuEnde()) {                       
        for (Pferd pferd : Pferde) {
            if(pferd.getGerannteStrecke()>=getStreckenLaenge()){
               rang++;  
               rangliste+= rang +". Rang: " + pferd.toString()+"\n";
            }else{
                pferd.rennen();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // Kein Problem
        }
        
        }
    }

    public boolean rennenZuEnde() {
        boolean rennenzuende = false;
        for (Pferd pferd : Pferde) {
            if(pferd.getGerannteStrecke()<getStreckenLaenge()){
            rennenzuende= true;
            break;
            }
        }
        return rennenzuende ;
    }

    public String getStand(){
        return "Aktuellerstand";
    }

    public String getRangliste() {
        return rangliste;
    }

    public int getStreckenLaenge() {
        return streckenLaenge;
    }

}
