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
    private int streckenLaenge;
    ArrayList<Pferd> Pferde = new ArrayList<>();
    
    public Pferderennen(int streckenLaenge, int anzahlPferde) {
        this.streckenLaenge = streckenLaenge;
        for (int i = 0; i < anzahlPferde; i++) {
            Pferde.add(new Pferd("Pferd "+i, i));
        }
    }
    
    private String gerannteStreckeAlsBalken(Pferd pferd){
        
        return "";
    }
    
    public void lassPferdeRennen(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
   
    public void createPferde(){
        for (Pferd pferd : Pferde) {
      
        }
    }
}
