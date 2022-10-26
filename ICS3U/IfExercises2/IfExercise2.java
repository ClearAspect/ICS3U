/*
Roan Mason
03/23/22

Write a program that asks the user for two numbers and outputs which number is larger
*/
package ifexercise2;

import javax.swing.JOptionPane;

public class IfExercise2 {

    public static void main(String[] args) {
        
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter a number please."));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter another number please."));
        
        String message = "";
        
        if (num1 == num2) {
            message = num1+" and "+num2+" are the same.";
        } else if (num1 > num2) {
            message = num1+" is larger than "+num2;
        } else {
            message = num2+" is larger than "+num1;
        }
        JOptionPane.showMessageDialog(null, message, "Results", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
