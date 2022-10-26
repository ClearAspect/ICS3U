/*
Roan Mason
04/05/22

Write a method called norm that accepts three double values: x,y, and z. The method 
should return a double, the value of the expression [x2 + y2 + z2]1/2. Write a program 
that allows the user to use this method.

*/
package masonmethodexercise2_3;

import javax.swing.JOptionPane;

public class MasonMethodExercise2_3 {

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
     * evaluate [x2 + y2 + z2]^1/2
     * 
     * @param x - x in the eqn
     * @param y - y in the eqn
     * @param z - z in the eqn
     * @return a double
     */
    public static double evaluate(double x, double y, double z) {
        double answer;
        answer = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2)); // [x2 + y2 + z2]^1/2
        return answer;
    }
    
    
    public static void main(String[] args) {        
        double num1 = input("Enter x value please");
        double num2 = input("Enter y value please");
        double num3 = input("Enter z value please");
        double num4 = evaluate(num1, num2, num3);
        JOptionPane.showMessageDialog(null, num1+", "+num2+", and "+num3+" evaluate to "+num4);
    }
    
}
