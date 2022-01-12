/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pferderennen;

import javax.swing.JOptionPane;

/**
 *
 * @author Hisho
 */
public class GUI {

    public void startePferderennen() {
        boolean askfor = false;
        int anzahlpferde = 0;
        int strecke = 0;
        do {

            String eingabe = JOptionPane.showInputDialog(null, "Geben Sie bitte die Anzahl der Pferde ein.",
                    "Pferderennen",
                    JOptionPane.PLAIN_MESSAGE);
            askfor = false;
            try {
                if(eingabe==null) {
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
                 if(eingabe==null) {
                    System.exit(0);
                }
                strecke = Integer.parseInt(eingabe);
               
            } catch (Exception e) {
                askfor = true;
            }
        } while (askfor);
        Pferderennen eingabe = new Pferderennen(strecke, anzahlpferde);
        eingabe.lassPferdeRennen();
        System.out.println(eingabe.getRangliste());
    }
}
