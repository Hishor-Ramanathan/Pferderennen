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
    ArrayList<Pferd> Rangliste = new ArrayList<>();

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
        while (rennenZuEnde()) {
            System.out.println(getStand());
            for (Pferd pferd : Pferde) {
                pferd.rennen();
                if (pferd.getGerannteStrecke() >= getStreckenLaenge()) {
                    if (!pferd.getAufrangliste()) {
                        pferd.setAufrangliste(true);
                        Rangliste.add(pferd);
                    }
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
            if (pferd.getGerannteStrecke() < getStreckenLaenge()) {
                return true;
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
    public ArrayList<Pferd> getRanglisteArrayList(){
        return Rangliste;
    }
    public String getRangliste() {
        String rangliste = "";
        int rang = Rangliste.size();

        for (int i = 1; i < rang + 1; i++) {

            rangliste += i + ". Rang: " + Rangliste.get(--i).toString() + "\n";

            ++i;

        }
        return rangliste;
    }

    public int getStreckenLaenge() {
        return streckenLaenge;
    }
    
    
}
