/*
Roan Mason
03/23/22

Write a program that asks for a number from the user and tells them if it was even or odd.
*/
package ifexercise3;

import javax.swing.JOptionPane;

public class IfExercise3 {

    public static void main(String[] args) {
        
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number please"));
        int odd = num % 2;
        
        String evenOdd = "even";
        
        if (odd != 0) {
            evenOdd = "odd";
        }
        JOptionPane.showMessageDialog(null, (num+" is an "+evenOdd+" number"), "Results", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
