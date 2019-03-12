/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocorrectprogram_022019;

import java.util.ArrayList;

/**
 *
 * @author miryn
 */
public class Sort {
    double lower;
    double higher;
    double swap;
    double result[];
    boolean isActive;
    
    public Sort(boolean inAct) {
        this.isActive = inAct;
    }
    
    public void sortDouble(double inArray[]){
        for (int i = 0; i < inArray.length-1; i++) {
            for (int j = 0; j < inArray.length-i-1; j++) {
                this.lower = inArray[j];
                this.higher = inArray[j+1];
                if(this.lower > this.higher) {
                    inArray[j] = this.higher;
                    inArray[j+1] = this.lower;
                }
            }
        }
        this.higher = inArray[inArray.length-1];
        this.result = inArray;
    }
    public ArrayList<Option> sortArrayList(ArrayList<Option> e) {
        Option temp;
        for (int i = 0; i < e.size()-1; i++) {
            for (int j = 0; j < e.size()-i-1; j++) {
                if(e.get(j).getStrVal() > e.get(j+1).getStrVal()){
                    temp = e.get(j);
                    e.set(j, e.get(j+1));
                    if(temp != null) {
                        e.set(j+1, temp);
                    }                    
                }
            }
        }
        return e;
    }
    
}
