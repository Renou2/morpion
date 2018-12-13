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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vinotco
 */
public class VueMorpion extends Observable{
    private final JFrame window ;
    private final JPanel middlePanel;
    private final ArrayList <JButton> listeBouttons = new ArrayList<>();

    
    public VueMorpion (String j1, String j2){
        window = new JFrame("Morpion");

        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1200, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel topPanel = new JPanel (new GridLayout(2, 5));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.add(new JLabel("Joueur 1 :"));
        topPanel.add(new JLabel(j1));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel("Joueur 2 :"));
        topPanel.add(new JLabel(j2));
        topPanel.add(new JLabel(""));
        JLabel image = new JLabel( new ImageIcon( "/users/info/etu-s2/vinotco/croix.jpg"));
        topPanel.add(image);
        topPanel.add(new JLabel(""));
        JLabel image2 = new JLabel( new ImageIcon( "/users/info/etu-s2/vinotco/rond.jpg"));
        topPanel.add(image2);
        
       
        middlePanel = new JPanel (new GridLayout(3, 3));
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        
        JButton un = new JButton("ezrzerzerze"); listeBouttons.add(un);
        JButton deux = new JButton("ezrzerzerze");listeBouttons.add(deux);
        JButton trois = new JButton("ezrzerzerze");listeBouttons.add(trois);
        JButton quatre = new JButton("ezrzerzerze");listeBouttons.add(quatre);
        JButton cinq = new JButton("ezrzerzerze");listeBouttons.add(cinq);
        JButton six = new JButton("ezrzerzerze");listeBouttons.add(six);
        JButton sept = new JButton("ezrzerzerze");listeBouttons.add(sept);
        JButton huit = new JButton("ezrzerzerze");listeBouttons.add(huit);
        JButton neuf = new JButton("ezrzerzerze");listeBouttons.add(neuf);
        
        for( int i = 0; i<=8; i++){
            listeBouttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(getListeBouttons().indexOf(this));
                    clearChanged();
                }
            });
            middlePanel.add(listeBouttons.get(i));
        }
        
    }

    public JPanel getMiddlePanel() {
        return middlePanel;
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }        

    public JFrame getWindow() {
        return window;
    }

    public ArrayList <JButton> getListeBouttons() {
        return listeBouttons;
    }
}
