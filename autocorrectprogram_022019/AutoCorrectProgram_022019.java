/*
=============================================================================================
Author:            Michael R. Nickerson
Version:          1.0
Date:              2/26/19
Description:    This is an autocorrect program written in java using object oriented programming techniques.
                     This will receive a user-typed text and automatically correct it by itterating each input through
                      a List of words. The sentence is then corrected and concatinated.
=============================================================================================
 */
package autocorrectprogram_022019;
//Imported Libraries:
import java.util.*;
// TODO Add input verification as well as clean up original autoCorrect code that works per word..
        /*
        Get Strength values per word Word Dictionary is contained by each input and verified by getting general strength value -> If word is not found we try the next word dictionary
        Word Dictionary::
            Contains full amount of words..
            original search is at index 0 of the character matching
            if strengthValue is under a certain amount, lets say x<0.15 ->Move to new search at index 1 of the character matching
            new Options and strength value sort :: Search for higher if it is less than 0.15 move onto next character.. Otherwise replace the word with the new word from the dictionary
            
        
            We can ignore these rules for now as they aim to improve performance.. Right now check through every single word and get strength values:: 
                Start off with a smaller dictionary for this increase to see how performance slows with more clutter/unneeded words.
        */
public class AutoCorrectProgram_022019 {

//Functions:
    
    //Converts String into a String arrayList of words, seperated by spaces:
    public static ArrayList<String> sentenceToWordArray(String text) {
        Scanner sc = new Scanner(text); 
        ArrayList<String> textArray = new ArrayList<>();
        while(sc.hasNext()) {
            textArray.add(sc.next());
        }
        return textArray;
    }
    //Converts a String arrayList of words into a ArrayList of Input objects which contain text of each word:
    public static ArrayList<Input> specifiedInputConversion(ArrayList<String> str) {
        ArrayList<Input> e = new ArrayList<>();
        Input i;
        for(String x : str) {
            i = new Input(x);
            e.add(i);
        }
        return e;
    }
    //Converts an arrayList of Strings into an arrayList of options
    public static ArrayList<Option> specifiedOptionConversion(ArrayList<String> str) {
        ArrayList<Option> e = new ArrayList<>();
        Option i;
        for(String x : str) {
            i = new Option(x);
            e.add(i);
        }
        return e;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        //Take input
        System.out.println("Please enter your sentence: ");
        String input = sc.nextLine();
        //Declare Arraylist for the String Array
        ArrayList<String> inputArr = new ArrayList<>();
        inputArr = sentenceToWordArray(input);  //Convert to String arrayList of words
        ArrayList<Input> inputList = specifiedInputConversion(inputArr);    //Convert to input ArrayList
        
        //String option = "The red fox jumps over the brown fence";
        String option = "red jumps jumped fox fence brown over the The green orange yellow gold work works is false a I hand eye confidence value them their there who nothing what when where why fast slow ugly young old somebody once told me pencil pen laptop programmer code java philosophy you will have love save broken words chair sentence grammar yet this was and be";
        ArrayList<String> optionArr = new ArrayList<>();
        optionArr = sentenceToWordArray(option);    //Convert to String arrayList of words
        ArrayList<Option> optionList = specifiedOptionConversion(optionArr);        //Convert to option ArrayList
        //Each input object will have its own dictionary to compare to -> this will take up alot of space in the long run
        String result = "";
        for(Input x : inputList) {
            x.setRelatedOptions(optionList);
            x.replaceWithOption();
            result = result + x.getReplacement() + " ";
        }
        System.out.println("Corrected Sentence: \n" + result);        
    }
    
}
/*
Current Issues:
-Cannot deal with missing first character.
-Characters that occur within the input however are at the wrong index are not accounted for in the total strength value
-Should read/write to file
-Must have a dictionary per word which leads to heavy memory usage since this might eventually be using hundreds of words
-Cannot read for punctuation. Must readFor and ignore and then concatonate onto new option before the sentence is created. This can be done through the input object.
-Consider actually correcting punctuation - How is it determined and where should it go. Next word is a starts with a capital and is in the list means that it is a new sentence.
*/