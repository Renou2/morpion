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
public class Joueur {
    private String nom;
    private int Victoire;
    private int Defaite;
    private int Nul;

    public Joueur(String nom) {
        this.nom = nom;
        this.Victoire = 0;
        this.Defaite = 0;
        this.Nul = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getVictoire() {
        return Victoire;
    }

    public int getDefaite() {
        return Defaite;
    }

    public int getNul() {
        return Nul;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVictoire(int Victoire) {
        this.Victoire = Victoire;
    }

    public void setDefaite(int Defaite) {
        this.Defaite = Defaite;
    }

    public void setNul(int Nul) {
        this.Nul = Nul;
    }
    
    
            
}
