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
    private final JButton classement;
    private final JButton pSuivante;

    
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
        JLabel image = new JLabel("O");
        topPanel.add(image);
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel(""));
        JLabel image2 = new JLabel( "X");
        topPanel.add(image2);
        
       
        middlePanel = new JPanel (new GridLayout(3, 3));
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        
        JButton zero = new JButton();listeBouttons.add(zero);
        zero.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(zero));
                    clearChanged();
                }
            });
        
        
        JButton un = new JButton();listeBouttons.add(un);
        un.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(un));
                    clearChanged();
                }
            });

        JButton deux = new JButton();listeBouttons.add(deux);
        deux.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(deux));
                    clearChanged();
                }
            });

        JButton trois = new JButton();listeBouttons.add(trois);
        trois.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(trois));
                    clearChanged();
                }
            });

        JButton quatre = new JButton();listeBouttons.add(quatre);
        quatre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(quatre));
                    clearChanged();
                }
            });

        JButton cinq = new JButton();listeBouttons.add(cinq);
        cinq.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(cinq));
                    clearChanged();
                }
            });

        JButton six = new JButton();listeBouttons.add(six);
        six.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(six));
                    clearChanged();
                }
            });

        JButton sept = new JButton();listeBouttons.add(sept);
        sept.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(sept));
                    clearChanged();
                }
            });

        JButton huit = new JButton();listeBouttons.add(huit);
        huit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(listeBouttons.indexOf(huit));
                    clearChanged();
                }
            });

        for( int i = 0; i<=8; i++){
            middlePanel.add(listeBouttons.get(i));
        }
        
        
        JPanel bottomPanel = new JPanel (new GridLayout(1, 4));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        classement = new JButton("Classement");
        classement.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Action.CLASSEMENT);
                    clearChanged();
                }
        });
        bottomPanel.add(classement);
        bottomPanel.add(new JLabel(""));
        bottomPanel.add(new JLabel(""));
        
        pSuivante = new JButton("Partie Suivante");
        pSuivante.setEnabled(false);
        pSuivante.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Action.NEXT);
                    clearChanged();
                }
        });
        bottomPanel.add(pSuivante);
                
    }

    public JButton getpSuivante() {
        return pSuivante;
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
