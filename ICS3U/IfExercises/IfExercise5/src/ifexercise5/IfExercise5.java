/*
Roan Mason
03/21/2022

Write a program that helps Farmer Bob sort his eggs. Bob will enter the weight in grams of 
each of the eggs that his chickens have laid. An entry of -1 signals that no more eggs are 
to be entered. For each egg entered, tell the user whether it is small (<2), medium (2 to 
less than 4), large(4 to less than 6), or extra large (6+). Also include error checking for 
when the user enters an impossible egg size. After all of the eggs have been entered, tell 
the user the total for each category.* 
*/
package ifexercise5;

import javax.swing.JOptionPane;

public class IfExercise5 {

    public static void main(String[] args) {
        
        //initiate variables
        int eggWeight = 0;
        int smalls = 0;
        int mediums = 0;
        int larges = 0;
        int xlarges = 0;
        //while loop controller
        boolean run = true;
        //variable string for messages
        String eggMessage = "";
        
        while (run == true){
            //ask user for weight of egg
            eggWeight = Integer.parseInt(JOptionPane.showInputDialog("How much does the egg weigh?(in grams, -1 to quit)"));
            
            if (eggWeight == -1){ //User wants to quit
                run = false; //stop loop
                eggMessage = "That egg was the last egg.";
            } else if (eggWeight < -1){ //Egg's weight is impossible
                eggMessage = "That egg was to small to be an egg.";
            } else if (eggWeight < 2) { //Egg's weight is less that 2
                smalls++; //add to small counter
                eggMessage = "That egg was small.";
            } else if (eggWeight < 4) { //Egg's weight is 2 to less than 4
                mediums++; //add to medium counter
                eggMessage = "That egg was medium.";
            } else if (eggWeight < 6) { //Egg's weight is 4 to less than 6
                larges++; //add to large counter
                eggMessage = "That egg was large.";
            } else { //Egg's weight is 6 or more
                xlarges++; //add to extra large counter
                eggMessage = "That egg was extra large.";
            }
            //display message decided by the if statements
            JOptionPane.showMessageDialog(null, eggMessage);
        }
        //Final message that tells the user the number of each type of egg
        JOptionPane.showMessageDialog(null, ("You entered:"
                +"\n"+smalls+" small eggs"
                +"\n"+mediums+" medium eggs"
                +"\n"+larges+" large eggs"
                +"\n"+xlarges+" extra large eggs"
                ));
        
    }
    
}
