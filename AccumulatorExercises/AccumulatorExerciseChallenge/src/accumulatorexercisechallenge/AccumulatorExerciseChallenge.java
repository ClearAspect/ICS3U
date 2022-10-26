/*
Roan Mason
03/02/2022

Ask the user for 2 numbers. Determine the greatest common factor of these 2 
numbers (hint: you will need to use the % operator)
ex.
1st Num: 18
2nd Num:12
GCF: 6
 */
package accumulatorexercisechallenge;

import javax.swing.JOptionPane;

public class AccumulatorExerciseChallenge {

    public static void main(String[] args) {

        int userNum1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive integer:"));
        int userNum2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter a second positive integer:"));
        
        int numerator;
        int denominator;
        int remainder = 1;
        int gcf = 0;
        
        //make the higher number the numerator and the lower one the denominator
        if (userNum1 > userNum2){
            numerator = userNum1;
            denominator = userNum2;
        } else {
            numerator = userNum2;
            denominator = userNum1;
        }
        
        /*
        Divide the larger number by the smaller to give a quotient and remainder.
        If the remainder is 0 then the smaller number is the GCF.
        Otherwise repeat with the smaller number and the remainder.
         */
        while (remainder != 0) {
            gcf = remainder;
            remainder = numerator % denominator;
            denominator = numerator;
            numerator = remainder;
            
        }
        JOptionPane.showMessageDialog(null, "The greatest common factor of "+userNum1+" % "+userNum2+" is "+gcf);
        
    }

}
