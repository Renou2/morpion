/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author vinotco
 */
public class VueInitialisation extends Observable{
    private final JFrame window ;
    private final JTextField champNom;
    private final JButton btnAjouter ;
    private final JScrollPane scroll;
    private final JButton btnSuppr ;
    private final JButton btnReset ;
    private final JButton btnLaunch ;

    @SuppressWarnings("Convert2Lambda")
    public VueInitialisation (ArrayList<String> nomJoueurs) {
        window = new JFrame("Morpion");

        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel topPanel = new JPanel (new GridLayout(3, 2));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        topPanel.add(new JLabel("Entrer nouveau joueur :"));
        topPanel.add(new JLabel(""));
        champNom = new JTextField();
        topPanel.add(champNom);
        btnAjouter = new JButton("Ajouter joueur");
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(getChampNom().getText());
                
                clearChanged();
                
            }
        });
        topPanel.add(btnAjouter);
        topPanel.add(new JLabel("Participants :"));


        
        JPanel middlePanel = new JPanel (new GridLayout(nomJoueurs.size(), 1));
        scroll = new JScrollPane(middlePanel);
        mainPanel.add(scroll, BorderLayout.CENTER);
       
        int i = 1;
        for(String nomJ : nomJoueurs){middlePanel.add(new JLabel("J"+i+" : "+nomJ)); i += 1;}

        JPanel botPanel = new JPanel (new GridLayout(1, 4));
        mainPanel.add(botPanel, BorderLayout.SOUTH);
        
        btnSuppr = new JButton("Retirer joueurs");
        btnSuppr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Action.SUPPR);
                clearChanged();
            }
        });
        botPanel.add(btnSuppr);

        btnReset = new JButton("Effacer tout");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Action.RESET);
                clearChanged();
            }
        });
        botPanel.add(btnReset);
        botPanel.add(new JLabel(""));
        
        btnLaunch = new JButton("Lancer Tournoi");
        btnLaunch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Action.LANCER);
                clearChanged();
            }
        });
        botPanel.add(btnLaunch);
        
    }
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
    
    /*public void updatePanel(ArrayList<String> nomJoueurs){
        this.scroll.removeAll();
        /*JPanel middlePanel = new JPanel (new GridLayout(nomJoueurs.size(), 1));

        int i = 1;
        for(String nomJ : nomJoueurs){this.mainPanel.add(new JLabel("J"+i+" : "+nomJ)); i += 1;}
        mainPanel.updateUI();
    }*/

    public JFrame getWindow() {
        return window;
    }

    public JTextField getChampNom() {
        return champNom;
    }

    public JButton getBtnAjouter() {
        return btnAjouter;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public JButton getBtnSuppr() {
        return btnSuppr;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JButton getBtnLaunch() {
        return btnLaunch;
    }
    
}