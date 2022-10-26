/*
Roan Mason
03/24/22

Write a program that asks the user for three numbers and outputs which number is the largest. 
Your program should inform the user if any two, or all three, numbers are the same. Also prompt 
the user at the end to see if they’d like to try again. (the picture below links to a video 
walkthrough of the program running).

Largest?
2 are the same?
3 are the same?
 */
package ifexercise4;

import javax.swing.JOptionPane;

public class IfExercise4 {

    public static void main(String[] args) {

        String play = "y";
        String message = "";

        while (play.equalsIgnoreCase("y")) {
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter a number please."));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter another number please."));
            int num3 = Integer.parseInt(JOptionPane.showInputDialog("Enter a final number please."));

            if (num1 > num2 && num1 > num3) { //1 is largest number
                message = num1 + " is larger than " + num2 + " and " + num3; //Output dialog saying that number 1 is largest
            } else if (num2 > num1 && num2 > num3) { //2 is largest number
                message = num2 + " is larger than " + num1 + " and " + num3;
            } else if (num3 > num2 && num3 > num1) { //3 is largest number
                message = num3 + " is larger than " + num2 + " and " + num1;
            } else if (num1 == num2 && num1 > num3) {
                message = num1 + " and " + num2 + " are the same, and larger than " + num3;
            } else if (num1 == num3 && num1 > num2) {
                message = num1 + " and " + num3 + " are the same, and larger than " + num2;
            } else if (num3 == num2 && num3 > num1) {
                message = num2 + " and " + num1 + " are the same, and larger than " + num1;
            } else { //all three must be the same
                message = num1 + " and " + num2 + " and " + num3 + " are the same ";
            }
            JOptionPane.showMessageDialog(null, message, "Results", JOptionPane.INFORMATION_MESSAGE);

            play = JOptionPane.showInputDialog("Would you like to play again? (Y/N).");

        }

    }

}
