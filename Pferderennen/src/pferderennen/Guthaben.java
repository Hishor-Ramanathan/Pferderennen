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
public class Guthaben {

    private int guthaben;

    public Guthaben(int guthaben) {
        this.guthaben = guthaben;
    }

    public void addGuthaben(int guthaben) {
        this.guthaben += guthaben;
    }

    public int getGuthaben() {
        return guthaben;
    }

}
