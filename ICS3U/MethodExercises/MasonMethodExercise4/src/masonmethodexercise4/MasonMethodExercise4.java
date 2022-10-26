/*
Roan Mason
04/29/22

Write a program that allows the user to convert between the two main degree systems. 
Display a menu prompting the user to select either Fahrenheit to Celsius or Celsius to
Fahrenheit. Write a method to complete each of these conversions for you. Your main
method should just contain the menu code and the method calls. Error check the user’s menu 
input, and ensure that your menu repeats until the user chooses to exit.
 */
package masonmethodexercise4;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonMethodExercise4 {

    static double fahrenheit;
    static double celsius;
    static DecimalFormat temp = new DecimalFormat("#,###.#");

    public static void fToC() {
        fahrenheit = Double.parseDouble(JOptionPane.showInputDialog("Enter a Fahrenheit temperature"));
        celsius = (fahrenheit - 32) * (double) 5 / 9;
        JOptionPane.showMessageDialog(null, "The Celsius temperature is " + temp.format(celsius));
    }

    public static void cToF() {
        celsius = Double.parseDouble(JOptionPane.showInputDialog("Enter a Celsius temperature"));
        fahrenheit = (celsius * (double) 9 / 5) + 32;
        JOptionPane.showMessageDialog(null, "The Fahrenheit temperature is " + temp.format(fahrenheit));
    }

    public static void main(String[] args) {
        String option = "";
        
        while (!option.equals("3")) {
            option = "";
            if (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
                option = JOptionPane.showInputDialog("Select an option:\n1. Fahrenheit to Celsius conversion\n2. Celsius to Fahrenheit conversion\n3. Exit");
            }
            
            
            if (option.equals("1")) {
                fToC();
            } else if (option.equals("2")) {
                cToF();
            } else if (option.equals("3")) {
                System.exit(0);
            }
            
        }
         
    }

}
