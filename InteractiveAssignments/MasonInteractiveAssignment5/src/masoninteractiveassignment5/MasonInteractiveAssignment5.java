/*
Roan Mason
02/18/2022

Create a DivAndMod application that prompts the user for two integers and 
then displays the result of integer and modulus division in any order. 
 */
package masoninteractiveassignment5;

import javax.swing.JOptionPane;

public class MasonInteractiveAssignment5 {

    public static void main(String[] args) {
        
        //Ask the user to input their first and second for Div and Mod calculations
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("What is your first integer?"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("What is your second integer?"));
        
        //Div and Mod starting with the first number
        int div1 = num1 / num2;
        int mod1 = num1 % num2;
        //Div and Mod starting with the second number
        int div2 = num2 / num1;
        int mod2 = num2 % num1;
        
        //Final output with the Div and Mod calculations using the numbers that the user inputed
        JOptionPane.showMessageDialog(null, ("Your numbers: " + num1 + " and " + num2
                +"\n"+num1+" / "+num2+" = "+div1
                +"\n"+num1+" % "+num2+" = "+mod1
                +"\n"+num2+" / "+num1+" = "+div2
                +"\n"+num2+" % "+num1+" = "+mod2
        ));
        
    }
    
}
