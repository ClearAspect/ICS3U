/*
Roan Mason
02/25/2022

Write a program that will ask the user what the capital of South Korea is. 
Count the number of times it takes to get a correct answer.
*/
package accumulatorexercise2;

import javax.swing.JOptionPane;

public class AccumulatorExercise2 {

    public static void main(String[] args) {
        
        //initiate variables for later
        String answer = "";
        int fails = 0;
        
        //as long as the user guesses wrong the loop continues
        while (!answer.equalsIgnoreCase("seoul")){
            answer = JOptionPane.showInputDialog("What's the capital of South Korea?");
            //add to fails counter
            fails++;
        }
        JOptionPane.showMessageDialog(null,"It took you "+fails+" tries to guess the capital of South Korea");
        
    }
    
}
