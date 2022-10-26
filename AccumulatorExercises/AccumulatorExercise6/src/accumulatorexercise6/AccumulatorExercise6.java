/*
Roan Mason
3/1/2022

Prompt the user for 15 numbers. Output the largest of these numbers. 
(Hint: Math.max(a,b);)
*/
package accumulatorexercise6;

import javax.swing.JOptionPane;

public class AccumulatorExercise6 {

    public static void main(String[] args) {
        
        //create variables. Lowest possible number of integer so it doesnt interfer with calculation
        int largestNum = -2147483648;
        int counter = 0;
        
        //ask for 15 different numbers in a loop. check if the new number is larger than the other largest number
        for (int i = 0; i <= 15; i++){
            counter++;
            int newNum = Integer.parseInt(JOptionPane.showInputDialog("Please input a number ("+counter+"/15)"));
            largestNum = Math.max(largestNum, newNum);
        }
        //Tell the user which number was the largest
        JOptionPane.showMessageDialog(null, "The largest number was "+largestNum);
        
    }
    
}
