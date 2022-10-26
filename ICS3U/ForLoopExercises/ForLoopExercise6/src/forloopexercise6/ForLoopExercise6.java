/*
Roan Mason
02/24/2022

Same as #4 but ask the user what the two starting/ending values should be. The 
user should be able to enter these two values in either order (e.g. inputs of 
10 and 20 would produce a chart of the same values as inputs of 20 and 10)
*/
package forloopexercise6;

import javax.swing.JOptionPane;

public class ForLoopExercise6 {

    public static void main(String[] args) {
        //ask the user to input 2 numbers. Parse into integers
        int firstNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter your first number:"));
        int secondNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter your second number:"));
        //create variables for later
        int higherNum;
        int lowerNum;
        
        //Use an If statement to check which number is higher. Higher number with then be listed last in the chart
        if (firstNum < secondNum) {
            higherNum = secondNum;
            lowerNum = firstNum;
        } else {
            lowerNum = secondNum;
            higherNum = firstNum;
        }
        
        
        //Print the begining of the chart
        System.out.println("Number\tSquare\tCube");
        
        //use for loop to list the numbers inputed by the user. Listed from lowest to highest
        for (int i = lowerNum; i <= higherNum; i++) {
            //print the current number the loop is on. Then show that number squared. Then show that number cubed
            System.out.println(i + "\t" + (i * i) + "\t" + (i * i * i));
        }
    
    }
    
}
