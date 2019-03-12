/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocorrectprogram_022019;

/**
 *
 * @author miryn
 */
public class Option {
    private String text;
    private double strVal;
    public Option(String text) {
        this.text = text;
    }
    
    //Setters and Getters
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public double getStrVal() {
        return this.strVal;
    }
    public void setStrVal(double newVal) {
        this.strVal = newVal;
    }
    
    //Public Methods
    
    //Private Methods
    
}
