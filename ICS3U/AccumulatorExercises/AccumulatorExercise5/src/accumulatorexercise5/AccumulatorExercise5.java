/*
Roan Mason
2/28/2022

Write a program that prints a conversion table for Celsius to Fahrenheit. 
Show the Fahrenheit values for -100 degrees Celsius to +100 degrees Celsius. 
To make your program even more useful, first prompt the user for the low and 
high Celsius values.
*/
package accumulatorexercise5;

import javax.swing.JOptionPane;

public class AccumulatorExercise5 {
    
    public static void main(String[] args) {
        
        //ask the user for 2 temperatures
        double tempOne = Double.parseDouble(JOptionPane.showInputDialog("What is your first temperature in celsius"));
        double tempTwo = Double.parseDouble(JOptionPane.showInputDialog("What is your second temperature in celsius"));
        
        //initiate variables
        double highTemp;
        double lowTemp;
        double celsius = 0;
        double fahrenheit = 0;
        
        //Check which temp is higher and assign it to a new variable
        if (tempOne > tempTwo){
            highTemp = tempOne;
            lowTemp = tempTwo;
        } else {
            highTemp = tempTwo;
            lowTemp = tempOne;
        }
        
        //start the chart
        System.out.println("Celsius\t\tFahrenheit");
        //loop that prints out the temp in celcius and fahrenheit. Goes up by 10
        //doesnt stop until all numbers between the inputed numbers have been displayed
        for (double i = lowTemp; i <= highTemp; i += 10){
            celsius = i;
            fahrenheit = 32 + (celsius*9/5) ;
            System.out.println(celsius+"\t\t"+fahrenheit);
        }
        
    }
    
}
