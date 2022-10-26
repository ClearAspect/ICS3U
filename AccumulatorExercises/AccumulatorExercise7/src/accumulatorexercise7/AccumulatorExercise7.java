/*
Roan Mason
03/01/2022

Prompt the user for a positive integer, n. Output the value of n!. 
(5! = 5 x 4 x 3 x 2 x 1 = 120).
*/
package accumulatorexercise7;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class AccumulatorExercise7 {

    public static void main(String[] args) {
        
        //ask the user for a number and initiate variables
        int userNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive integer:"));
        int product = 1;
        
        //i = the users inputed number. as long as it is larger than zero, loop
        //multiply the users number by 1 less than the users number
        for (int i = userNum; i > 0; i--){
            product = product * i;
        }
        DecimalFormat number = new DecimalFormat("#,###");
        //Display final product
        JOptionPane.showMessageDialog(null, "The total product is "+number.format(product));
        
    }
    
}
