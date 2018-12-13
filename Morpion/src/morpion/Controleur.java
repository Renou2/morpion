/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

/**
 *
 * @author vinotco
 */
public class Controleur implements Observer {
    private ArrayList <Joueur> listeJoueurs = new ArrayList();
    private ArrayList <Joueur> classement = new ArrayList();
    private ArrayList <Match> listeMatchs = new ArrayList();
    private int indexMatch;
    private int tour = 0;
    private int l1 = 0;
    private int l2 = 0;
    private int l3 = 0;
    private int c1 = 0;
    private int c2 = 0;
    private int c3 = 0;
    private int d1 = 0;
    private int d2 = 0;

@Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            Joueur j = new Joueur(arg.toString());
            listeJoueurs.add(j);
            ArrayList<String> nomJoueurs = listeJoueursToString(listeJoueurs);
            ((VueInitialisation) o).close();
            VueInitialisation VI = new VueInitialisation(nomJoueurs);
            VI.afficher();
            VI.addObserver(this);
        }
        else if (arg instanceof Action) {
            if (((Action) arg) == Action.SUPPR) {
                ArrayList<String> nomJoueurs = listeJoueursToString(listeJoueurs);
                VueSuppr VS= new VueSuppr(nomJoueurs);
                VS.afficher();
                VS.addObserver(this);
            }
            else if (((Action) arg) == Action.RETIRER){
                
            }
            else if (((Action) arg) == Action.ANNULER){
                ((VueSuppr) o).close();
            }
            else if (((Action) arg) == Action.LANCER){
                this.creationListeMatchs(listeJoueurs);
                VueMorpion VM = new VueMorpion(listeMatchs.get(indexMatch).getJ1().getNom(), listeMatchs.get(indexMatch).getJ2().getNom());
                VM.afficher();
                VM.addObserver(this);
            }
        }
        else if(arg instanceof Integer) {
            gererTour(tour, ((Integer) arg));
            int resultat = verifVictoire(tour);
            ((VueMorpion) o).getListeBouttons().get(((Integer) arg)).setEnabled(false) ;
            ((VueMorpion) o).getListeBouttons().get(((Integer) arg)).setText("X");
            
            /*
            panel.removeAll()
            panel.validate
            panel.paint
            Panel.validate
            panel.repaint*/
            
        }
    }
    
    public ArrayList <Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public ArrayList <Joueur> getClassement() {
        return classement;
    }

    public int getIndexMatch() {
        return indexMatch;
    }

    public void setIndexMatch(int indexMatch) {
        this.indexMatch = indexMatch;
    }
    
    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public void setClassement(ArrayList<Joueur> classement) {
        this.classement = classement;
    }
    public void creationListeMatchs(ArrayList<Joueur> listeJoueurs){
        if (listeJoueurs.size() == 2){listeMatchs.add(new Match(listeJoueurs.get(0), listeJoueurs.get(1)));}
        else {
        
        for(int i = 0;  i < listeJoueurs.size(); i++){
            
            for(int j = i+1; j < listeJoueurs.size(); j++){
                listeMatchs.add(new Match(listeJoueurs.get(i),listeJoueurs.get(j)));
                
            }
                }
        this.setIndexMatch(1);
        }
        
    }
    public  ArrayList <String> listeJoueursToString(ArrayList<Joueur> listeJoueurs){
        ArrayList <String> nomJoueurs = new ArrayList();
        for (Joueur i : listeJoueurs){
            nomJoueurs.add(i.getNom());
        }
        return nomJoueurs;
    }
    
    public void gererTour(int tour, int numCase){
        int signe;
        if(tour%2 == 0){signe = -1;}
        else{signe = 1;}
        switch (numCase){
            case 0 : l1 += signe; c1 += signe;d1 += signe;
            case 1 : l1 += signe; c2 += signe;
            case 2 : l1 += signe; c3 += signe; d2 += signe;
            case 3 : l2 += signe; c1 += signe;
            case 4 : l2 += signe; c2 += signe; d1 += signe; d2 += signe;
            case 5 : l2 += signe; c3 += signe;
            case 6 : l3 += signe; c1 += signe; d2 += signe;
            case 7 : l3 += signe; c2 += signe;
            case 8 : l3 += signe; c3 += signe; d1 += signe;
        }
        tour += 1;
        
    }
    public int verifVictoire(int tour){
        int signe ;
        if (l1 == -3 || l2 == -3 || l3 == -3 || c1 == -3 || c2 == -3 || c3 == -3 || d1 == -3 || d2 == -3){signe = -1;}
        else if (l1 == 3 || l2 == 3 || l3 == 3 || c1 == 3 || c2 == 3 || c3 == 3 || d1 == 3 || d2 == 3){signe = 1;}
        else {signe = 0;}
        if(tour == 9){signe = 2;}
        return signe;
    }
    public void resetPartie(){
        tour = 0;
        l1 = 0;
        l2 = 0;
        l3 = 0;
        c1 = 0;
        c2 = 0;
        c3 = 0;
        d1 = 0;
        d2 = 0;
        
    }
}
