/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author vinotco
 */
public class VueSuppr extends Observable{
    private final JFrame window ;
    private final JScrollPane scroll;
    private final JButton retirer;
    private final JButton annuler;
    
    public VueSuppr (ArrayList<String> nomJoueurs){
        window = new JFrame("Morpion");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        JPanel middlePanel = new JPanel (new GridLayout(nomJoueurs.size(), 1));
        scroll = new JScrollPane(middlePanel);
        mainPanel.add(scroll, BorderLayout.CENTER);
        
        for(String nomJ : nomJoueurs){
            JCheckBox nom = new JCheckBox(nomJ);
            middlePanel.add(nom);
        }
        JPanel botPanel = new JPanel(new GridLayout(1,4));
        mainPanel.add(botPanel, BorderLayout.SOUTH);
        retirer = new JButton("Retirer Joueurs");
        retirer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Action.RETIRER);
                clearChanged();
            }
        });
        botPanel.add(retirer);
        botPanel.add(new JLabel(""));
        botPanel.add(new JLabel(""));
        annuler = new JButton ("Annuler");
        botPanel.add(annuler);
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Action.ANNULER);
                clearChanged();
            }
        });
    }
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
}
