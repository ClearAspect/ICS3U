/*
Roan Mason
05/02/22

Write a program that allows the user to convert between metric and imperial units of 
measurement. Write a separate method for each conversion. Your main
method should just contain the menu code and the method calls. Error check the user’s menu input, and ensure that your menu repeats until the user chooses to exit.

Conversion formulas:
inches * 2.54 = centimeters
feet * 30 = centimeters
yards * 0.91 = meters
miles * 1.6 = kilometers
*/
package masonmethodexercise6;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonMethodExercise6 {
    
    static double input = 0;
    static double output = 0;
    static DecimalFormat distance = new DecimalFormat("#,###.0");

    public static void inchesToCentimeters() { //Inches to centimeters
        //Ask user for the number to inches or whatever units are selected
        
        do {
            try {
                input = Double.parseDouble(JOptionPane.showInputDialog("Enter number of inches"));
            } catch (NumberFormatException e) {
                
            }
        } while (input == null);
        output = input * 2.54; //convert inches into centimeters
        //output the number of centimeters
        JOptionPane.showMessageDialog(null, "Number of centimeters: "+distance.format(output));
    }
    
    //Same commenting on the rest of the methods
    public static void centimetersToInches() { //Centimeters to inches
        input = Double.parseDouble(JOptionPane.showInputDialog("Enter number of centimeters"));
        output = input / 2.54;
        JOptionPane.showMessageDialog(null, "Number of inches: "+distance.format(output));
    }
    
    public static void feetToCentimeters() { //Feet to centimeters
        input = Double.parseDouble(JOptionPane.showInputDialog("Enter number of feet"));
        output = input * 30;
        JOptionPane.showMessageDialog(null, "Number of centimeters: "+distance.format(output));
    }
    
    public static void centimetersToFeet() { //Centimeters to feet
        input = Double.parseDouble(JOptionPane.showInputDialog("Enter number of centimeters"));
        output = input / 30;
        JOptionPane.showMessageDialog(null, "Number of feet: "+distance.format(output));
    }
    
    public static void yardsToMeters() { //Yards to meters
        input = Double.parseDouble(JOptionPane.showInputDialog("Enter number of yards"));
        output = input * 0.91;
        JOptionPane.showMessageDialog(null, "Number of meters: "+distance.format(output));
    }
    
    public static void metersToYards() { //Meters to yards
        input = Double.parseDouble(JOptionPane.showInputDialog("Enter number of meters"));
        output = input / 0.91;
        JOptionPane.showMessageDialog(null, "Number of yards: "+distance.format(output));
    }
    
    public static void milesToKilometers() { //Miles to kilometers
        input = Double.parseDouble(JOptionPane.showInputDialog("Enter number of miles"));
        output = input * 1.6;
        JOptionPane.showMessageDialog(null, "Number of kilometers: "+distance.format(output));
    }
    
    public static void kilometersToMiles() {//Kilometers to miles
        input = Double.parseDouble(JOptionPane.showInputDialog("Enter number of kilometers"));
        output = input / 1.6;
        JOptionPane.showMessageDialog(null, "Number of miles: "+distance.format(output));
    }
    
    
    public static void main(String[] args) {
        String selection = "";
        while (!selection.equals("9")) { //while the user hasnt selected Exit
            //while the user has an invalid selection
            while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") && !selection.equals("5") && !selection.equals("6") && !selection.equals("7") && !selection.equals("8") && !selection.equals("9")) {
                //loop the selection menu until a valid selection is made
                selection = JOptionPane.showInputDialog("Select an option:"
                    + "\n1. Inches to Centimeters"
                    + "\n2. Centimeters to Inches"
                    + "\n3. Feet to Centimeters"
                    + "\n4. Centimeters to Feet"
                    + "\n5. Yards to Meters"
                    + "\n6. Meters to Yards"
                    + "\n7. Miles to Kilometers"
                    + "\n8. Kilometers to Miles"
                    + "\n9. Exit");
            }
            
            if (selection.equals("1")) { //user selected 1
                inchesToCentimeters(); //execute corresponding method
            } else if (selection.equals("2")) {
                centimetersToInches();
            } else if (selection.equals("3")) {
                feetToCentimeters();
            } else if (selection.equals("4")) {
                centimetersToFeet();
            } else if (selection.equals("5")) {
                yardsToMeters();
            } else if (selection.equals("6")) {
                metersToYards();
            } else if (selection.equals("7")) {
                milesToKilometers();
            } else if (selection.equals("8")) {
                kilometersToMiles();
            } else {
                System.exit(0);
            }
            selection = "";
        }
    }
    
}
