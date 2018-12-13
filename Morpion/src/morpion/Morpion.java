/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.util.ArrayList;

/**
 *
 * @author vinotco
 */
public class Morpion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        Controleur controleur = new Controleur();
        
        VueInitialisation VI = new VueInitialisation(controleur.listeJoueursToString(controleur.getListeJoueurs()));
        VI.afficher(); 
        VI.addObserver(controleur);
        
    }
    
}
