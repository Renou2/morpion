/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

/**
 *
 * @author vinotco
 */
public class Match {
    private Joueur J1;
    private Joueur J2;
    private int resultat;

    public Match(Joueur J1, Joueur J2) {
        this.J1 = J1;
        this.J2 = J2;
    }


    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public Joueur getJ1() {
        return J1;
    }

    public Joueur getJ2() {
        return J2;
    }

    public int getResultat() {
        return resultat;
    }

    public void setJ1(Joueur J1) {
        this.J1 = J1;
    }

    public void setJ2(Joueur J2) {
        this.J2 = J2;
    }

}
