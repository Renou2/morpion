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
public class Case {
    private int numCase;
    private int value;

    public Case(int numCase, int value) {
        this.numCase = numCase;
        this.value = value;
    }

    public int getNumCase() {
        return numCase;
    }

    public int getValue() {
        return value;
    }

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
