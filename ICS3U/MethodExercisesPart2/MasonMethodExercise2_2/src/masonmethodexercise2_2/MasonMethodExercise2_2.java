/*
Roan Mason
05/04/22

Write a method that returns the 6th root of any number. Write a program that allows the
user to utilize this method. 
*/
package masonmethodexercise2_2;

import javax.swing.JOptionPane;

public class MasonMethodExercise2_2 {

    /**
     * Prompts the user to enter an integer number
     *
     * @param msg - the message to prompt the user with
     * @return an integer number
     */
    public static int input(String msg) {
        int num;
        num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return num;
    }
    
    /**
     * calculate sixth root
     * 
     * @param x - number being rooted
     * @return a double
     */
    
    public static double sixRoot(int x) {
        double y;
        y = Math.pow(x, (double)1/6); //raise x to the 1/6th power. is the same as 6 root x
        return y;
    }
    
    
    public static void main(String[] args) {
        int num1 = input("Please enter a number");
        double num2 = sixRoot(num1);
        JOptionPane.showMessageDialog(null, "The sixth root of "+num1+" is "+num2);
    }
    
}
