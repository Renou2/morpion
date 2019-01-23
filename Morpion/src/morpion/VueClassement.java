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
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author lienardr
 */
public class VueClassement extends Observable{
    private JFrame window;
    private JScrollPane scroll;
    
    
    public VueClassement(ArrayList <String> nomsJoueurs, ArrayList<Integer> victoires, ArrayList<Integer> nuls, ArrayList<Integer> defaites){
    window = new JFrame("Morpion");

        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1200, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel middlePanel = new JPanel (new GridLayout(nomsJoueurs.size()+1, 5));
        scroll = new JScrollPane(middlePanel);
        mainPanel.add(scroll, BorderLayout.CENTER);
            middlePanel.add(new JLabel("Noms Joueurs : "));
            middlePanel.add(new JLabel("Victoires :"));
            middlePanel.add(new JLabel("Nuls :"));
            middlePanel.add(new JLabel("Défaites :"));
            middlePanel.add(new JLabel("Classement :"));
        
        for(Integer i = 0; i<nomsJoueurs.size(); i++ ){
            middlePanel.add(new JLabel(nomsJoueurs.get(i)));
            middlePanel.add(new JLabel(victoires.get(i).toString()));
            middlePanel.add(new JLabel(nuls.get(i).toString()));
            middlePanel.add(new JLabel(defaites.get(i).toString()));
            Integer pos = i+1;
            middlePanel.add(new JLabel(pos.toString()));
            
        }
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
}
