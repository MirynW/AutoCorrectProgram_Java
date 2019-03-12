/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocorrectprogram_022019;

import java.util.*;

/**
 *
 * @author miryn
 */
public class Input {
    private String text;
    private ArrayList<Option> relatedOptions;
    private String replacement;
    
    public Input(String text) {
        this.text = text;
        this.relatedOptions = new ArrayList<>();
    }
    
    //Setters and Getters
    public String getReplacement() {
        return this.replacement;
    }
    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String newText) {
        this.text = newText;
    }
    public ArrayList<Option> getRelatedOptions() {
        return this.relatedOptions;
    }
    public void setRelatedOptions(ArrayList<Option> e) {
        this.relatedOptions = e;
    }
    
    //Methods
    //ToArrayTypes
    public Option[] toOptionArray() {
        //You may want to sort greatest to least and use only the 0 index to return the highest strengthValue option and replace the input with the text
        Option[] e = new Option[this.relatedOptions.size()];
        return this.relatedOptions.toArray(e);
    }
    public void getArrayListStrVals() {
        int i = 0;
        for(Option  x : relatedOptions) {
            relatedOptions.get(i);
            i++;
        }
    }
    
    public void replaceWithOption() {
        for(Option x : this.relatedOptions) {
            x = computeStrValue(this.text, x, false);
        }
        Sort e = new Sort(true);
        this.relatedOptions = e.sortArrayList(this.relatedOptions);
        
        if(this.relatedOptions.get(this.relatedOptions.size()-1).getStrVal() >= 0.50)
            this.replacement = this.relatedOptions.get(this.relatedOptions.size()-1).getText(); //Top 3 strength value options are within range usually
        else
            this.replacement = this.text;
    }
    
    //Private Methods:
    private Option computeStrValue(String input, Option check, boolean flag) {
        int minLen = checkSmaller(check.getText().length(), input.length());
        int maxLen = checkBigger(check.getText().length(), input.length());
        double strengthValue = 0;
        if(input.equalsIgnoreCase(check.getText())) {
            check.setStrVal(1);
            return check;
        }
        for (int i = 0; i < minLen; i++) {
            if(input.charAt(i) == check.getText().charAt(i) || input.charAt(i) == check.getText().charAt(i)+32 || input.charAt(i) == check.getText().charAt(i)-32) 
                strengthValue++;
            else if(input.contains(""+check.getText().charAt(i)))
                strengthValue += 0.5;
        }
        strengthValue = strengthValue/maxLen;
        
        Option reversedOp = new Option(reverseString(check.getText()));
        String reversedInput = reverseString(input);
        reversedOp = reversedStrValue(reversedInput,reversedOp);
        double comparitorValue = reversedOp.getStrVal();
        
        if(comparitorValue >= strengthValue)
            check.setStrVal(comparitorValue);
        else if(strengthValue >= comparitorValue)
            check.setStrVal(strengthValue);

        return check;
    }
    private Option reversedStrValue(String input, Option check) {
        int minLen = checkSmaller(check.getText().length(), input.length());
        int maxLen = checkBigger(check.getText().length(), input.length());
        double strengthValue = 0;
        if(input.equalsIgnoreCase(check.getText())) {
            check.setStrVal(1);
            return check;
        }
        for (int i = 0; i < minLen; i++) {
            if(input.charAt(i) == check.getText().charAt(i) || input.charAt(i) == check.getText().charAt(i)+32 || input.charAt(i) == check.getText().charAt(i)-32) 
                strengthValue++;
            else if(input.contains(""+check.getText().charAt(i)))
                strengthValue += 0.5;
        }
        strengthValue = strengthValue/maxLen;
        check.setStrVal(strengthValue);
        return check;
    }
    
    private String reverseString(String str) {
        String result = "";
        for (int i = str.length()-1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
    
    private int checkSmaller(int i, int j) {
        if(i>j)
            return j;
        else
            return i;
    }
    
    private int checkBigger(int i, int j) {
        if(i>j)
            return i;
        else
            return j;
    }
}
