/*
Roan Mason
05/04/22

Write a method that accepts two sides of a right angled triangle and returns the 
hypotenuse. Write a program that allows the user to utilize this method.

*/
package masonmethodexercise2_1;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonMethodExercise2_1 {
    
    /**
     * Prompts the user to enter an integer number
     *
     * @param msg - the message to prompt the user with
     * @return a double number
     */
    public static double input(String msg) {
        double num;
        num = Double.parseDouble(JOptionPane.showInputDialog(msg));
        return num;
    }
    
    
    /**
     * Uses pythagorean theorem to find c value
     * 
     * @param a - a value in pythagorean theorem
     * @param b - b value in pythagorean theorem
     * @return a double
     */
    public static double getHypotenuse(double a, double b) {
        double c;
        c = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)); // root of a^2 + b^2 = c
        return c;
    }
    
    public static void main(String[] args) {
        DecimalFormat number = new DecimalFormat("#,###.0");
        
        double num1 = input("Enter side 1 please");
        double num2 = input("Enter side 1 please");
        double num3 = getHypotenuse(num1, num2);
        JOptionPane.showMessageDialog(null, "The hypoteneuse of a triangle with sides "+num1+" and "+num2+" is: "+number.format(num3));
        
    }
    
}
