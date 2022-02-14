/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pferderennen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hisho
 */
public class Wetten {   
  
   private Pferd pferd1;
   private Pferd pferd2;
   private Pferd pferd3;
   private int einsatz;
    public Wetten(int einsatz,Pferd pferd1, Pferd pferd2, Pferd pferd3) {
        this.pferd1 = pferd1;
        this.pferd2 = pferd2;
        this.pferd3 = pferd3;
        this.einsatz=einsatz;
    }
    
    public Wetten(int einsatz,Pferd pferd1, Pferd pferd2) {
         this.einsatz=einsatz;
        this.pferd1 = pferd1;
        this.pferd2 = pferd2;
        this.pferd3 = null;
     
    }
     public Wetten(int einsatz,Pferd pferd1) {
         this.einsatz=einsatz;
         this.pferd1 = pferd1;
         this.pferd2 = null;
        this.pferd3 = null;
    }
    
    public int checkWette(ArrayList<Pferd> pferde){
        if(pferd3!=null){
             if(pferde.get(0).getName().equals(pferd1.getName())||pferd2.getName().equals(pferde.get(0).getName())||pferde.get(0).equals(pferd3.getName())){
               return einsatz*4;
            }
        }else if(pferd2!=null){
            if(pferde.get(0).getName().equals(pferd1.getName())||pferd2.getName().equals(pferde.get(0).getName())){
               return einsatz*6;
           }
        }else if(pferd1!=null){
           if(pferde.get(0).getName().equals(pferd1.getName())){
               return einsatz*8;
           }
        }       
            return -einsatz;
    }
    
}
