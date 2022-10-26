/*
Roan Mason
03/01/2022

Prompt the user for a positive integer, n. Output the nth Fibonacci number 
(1,1,2,3,5,8,13...), where each number is the sum of the previous two. The 10th 
Fibonacci number is 55, and the 20th Fibonacci number is 6765.
*/
package accumulatorexercise8;

import javax.swing.JOptionPane;

public class AccumulatorExercise8 {

    public static void main(String[] args) {
        
        //ask the user for the desired Fibonacci number
        int fibNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive integer:"));
        //initiate variables for later. Total, the previous number in the sequence, a way to save numbers.
        int total = 1;
        int previousNum = 0;
        int saveNum = 0;
        
        //as long as i is smaller than desired Fibonacci number
        for (int i = 1; i < fibNum; i++){
            //save the current number, add the previous number to the total,
            //make the previous number variable = the saved number
            saveNum = total;
            total += previousNum;
            previousNum = saveNum;
            
        }
        JOptionPane.showMessageDialog(null, "The "+fibNum+"th Fibonacci number is "+total); 
    }
    
}
