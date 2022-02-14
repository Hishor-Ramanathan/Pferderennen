/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pferderennen;

/**
 *
 * @author Hisho
 */
public class Spielverlauf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GUI gui = new GUI();
        Guthaben guthaben = new Guthaben(gui.askGuthaben());

        do {
            Pferderennen pferderennen = gui.GUIPferderennen();
            System.out.println(pferderennen.getStand());
            Wetten wetten = gui.askWette(guthaben.getGuthaben());
            pferderennen.lassPferdeRennen();
            System.out.println(pferderennen.getRangliste());
            guthaben.addGuthaben(wetten.checkWette(pferderennen.getRanglisteArrayList()));
            gui.ergebnisWette(guthaben.getGuthaben());
        } while (gui.weiterspielen());
    }

}
