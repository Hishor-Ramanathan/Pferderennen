/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pferderennen;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Hisho
 */
public class GUI {

    private int anzahlpferde = 0;
    private int strecke = 0;

    public Pferderennen GUIPferderennen() {
        boolean askfor = false;
        
        do {
            
            String eingabe = JOptionPane.showInputDialog(null, "Geben Sie bitte die Anzahl der Pferde ein.",
                    "Pferderennen",
                    JOptionPane.PLAIN_MESSAGE);
            askfor = false;
            try {
                if (eingabe == null) {
                    System.exit(0);
                }
                anzahlpferde = Integer.parseInt(eingabe);
            } catch (Exception e) {
                askfor = true;
            }
        } while (askfor);
        
        do {
            
            String eingabe = JOptionPane.showInputDialog(null, "Geben Sie bitte die Länge der Streck ein.",
                    "Pferderennen",
                    JOptionPane.PLAIN_MESSAGE);
            askfor = false;
            try {
                if (eingabe == null) {
                    System.exit(0);
                }
                strecke = Integer.parseInt(eingabe);
                
            } catch (Exception e) {
                askfor = true;
            }
        } while (askfor);
        Pferderennen eingabe = new Pferderennen(strecke, anzahlpferde);
        return eingabe;
        
    }
    
    public boolean weiterspielen() {
        int eingabe = JOptionPane.showConfirmDialog(null,
                "Wollen Sie weiterspielen?",
                "Weiterspielen",
                JOptionPane.YES_NO_OPTION);
        if (eingabe == 1) {
            System.exit(0);
        }
        return true;
    }
    
    public int askGuthaben() {
        boolean askfor = true;
        int guthaben = 0;
        do {
            askfor = false;
            String eingabe = JOptionPane.showInputDialog(null, "Geben Sie ihr Guthaben ein.",
                    "Guthaben",
                    JOptionPane.PLAIN_MESSAGE);
            try {
                if (eingabe == null) {
                    System.exit(0);
                }
                guthaben = Integer.parseInt(eingabe);
                
            } catch (Exception e) {
                askfor = true;
            }
        } while (askfor);
        return guthaben;
    }
    
    public Wetten askWette(int guthaben) {
        List<Integer> wette = new ArrayList<>();
        boolean askfor = false;
                
            
        
            askfor = false;
            JTextField einsatz = new JTextField();
            JTextField index1 = new JTextField();
            JTextField index2 = new JTextField();
            JTextField index3 = new JTextField();
            Object[] message = {"Einsatz ("+guthaben+" verfügbar)", einsatz,
                "Pferdstartnummer", index1,
                "Pferdstartnummer", index2,
                "Pferdstartnummer", index3};
            JOptionPane pane = new JOptionPane(message,
                    JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.OK_CANCEL_OPTION);
            pane.createDialog(null, "Wette").setVisible(true);
        if(index3.getText()!= null){
          return new Wetten(Integer.parseInt(einsatz.getText()),new Pferd("Pferd "+ index1.getText(),0), new Pferd("Pferd "+index2.getText(), 0),new Pferd("Pferd "+index3.getText(), 0));     
        }else if(index2.getText()!=null){
            return new Wetten(Integer.parseInt(einsatz.getText()),new Pferd("Pferd "+index1.getText(),0), new Pferd("Pferd "+index2.getText(), 0));   
        }else if(index1.getText()!=null){
              return new Wetten(Integer.parseInt(einsatz.getText()), new Pferd("Pferd "+index1.getText(), 0));
        }
          return null;
  
    }
    public void ergebnisWette(int x){
        JOptionPane.showMessageDialog(null,
                                              "Ihr neues Guthaben ist "+ x,
                                              "Ergebnis",					      
					      JOptionPane.WARNING_MESSAGE);
    }
}
