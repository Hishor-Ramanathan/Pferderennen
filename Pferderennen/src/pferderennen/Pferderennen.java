/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pferderennen;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Hisho
 */
public class Pferderennen {

    private int streckenLaenge;
    ArrayList<Pferd> Pferde = new ArrayList<>();
    ArrayList<Pferd> RanglisteMitDuplikate = new ArrayList<>();

    public Pferderennen(int streckenLaenge, int anzahlPferde) {
        this.streckenLaenge = streckenLaenge;
        for (int i = 0; i < anzahlPferde; i++) {
            Pferde.add(new Pferd("Pferd " + i, i));
        }
    }

    private String gerannteStreckeAlsBalken(Pferd pferd) {

        String balken = "|";
        double x = getStreckenLaenge() / 20;
        int stern = (int) (pferd.getGerannteStrecke() / x);
        for (int i = 0; i < stern; i++) {
            balken += "*";
        }
        if (getStreckenLaenge() <= pferd.getGerannteStrecke() || stern >= 20) {
            return "|********************|";
        }
        for (int i = 0; i < 20 - stern; i++) {
            balken += " ";
        }
        balken += "|";

        return balken;
    }

    public void lassPferdeRennen() {
        int rang = 1;
        while (rennenZuEnde()) {
            System.out.println(getStand());
            for (Pferd pferd : Pferde) {
                if (pferd.getGerannteStrecke() >= getStreckenLaenge()) {
                    RanglisteMitDuplikate.add(pferd);
                } else {
                    pferd.rennen();
                }

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // Kein Problem
            }

        }
        for (Pferd pferd : Pferde) {
                if (pferd.getGerannteStrecke() >= getStreckenLaenge()) {
                    RanglisteMitDuplikate.add(pferd);
                } 
        }
        System.out.println(getStand());
    }

    public boolean rennenZuEnde() {
        boolean rennenzuende = false;
        for (Pferd pferd : Pferde) {
            if (pferd.getGerannteStrecke() < getStreckenLaenge()) {
                rennenzuende = true;
                break;
            }
        }
        return rennenzuende;
    }

    public String getStand() {
        String stand = "Aktuellerstand:\n";
        for (Pferd pferd : Pferde) {
            stand += pferd.toString() + gerannteStreckeAlsBalken(pferd) + "\n";
        }

        return stand;
    }

    public String getRangliste() {
        String rangliste = "";
        
        ArrayList<Pferd> Rangliste = new ArrayList<>(
                new HashSet<>(RanglisteMitDuplikate));
        int rang = Rangliste.size();
        for (Pferd pferd : Rangliste) {
            rangliste += rang + ". Rang: " + pferd.toString() + "\n";
            rang--;

        }
        return rangliste;
    }

    public int getStreckenLaenge() {
        return streckenLaenge;
    }

}
