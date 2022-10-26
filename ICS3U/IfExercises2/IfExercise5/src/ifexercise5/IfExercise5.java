/*
Roan Mason
03/24/22

Write a program that chooses a random number between 1 and 100 and gives the user two guesses. 
It then tells them the number and which guess was closer. (Hint: Math.abs()) Also prompt the 
user at the end to see if they’d like to try again.
*/
package ifexercise5;

import javax.swing.JOptionPane;

public class IfExercise5 {

    public static void main(String[] args) {
        
        String play = "y";
        
        while (play.equalsIgnoreCase("y")) { //run the program
            int randNum = (int)(Math.random() *100) + 1;
            //System.out.println(randNum); //Use to test program
            //ask for guesses
            int guess1 = Integer.parseInt(JOptionPane.showInputDialog("Enter your first guess please."));
            int guess2 = Integer.parseInt(JOptionPane.showInputDialog("Enter your second guess please."));
            //find their aboslute values
            int guess1Acc = Math.abs(randNum-guess1);
            int guess2Acc = Math.abs(randNum-guess2);
            
            if (guess1Acc == guess2Acc) { //if they are the same
                JOptionPane.showMessageDialog(null, "Your guesses were equally close to "+randNum);
            } else if (guess1Acc < guess2Acc) { //if the first guess is closer
                JOptionPane.showMessageDialog(null, "Your first guess was closer to "+randNum);
            } else if (guess1Acc > guess2Acc) { //if the second guess is closer
                JOptionPane.showMessageDialog(null, "Your second guess was closer to "+randNum);
            }
            //ask the user if they want to go again
            play = JOptionPane.showInputDialog("Would you like to play again? (Y/N).");
            
        }
        
    }
    
}
