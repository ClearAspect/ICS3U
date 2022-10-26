/*
Roan Mason
05/10/22

Write a program that will allow the user to perform some common math operations 
based on what they select from a menu. Your program should include the options 
below. The parameters, method names, and return types must match those specified.
*/
package masonmethodassignment;

import javax.swing.JOptionPane;

public class MasonMethodAssignment {

    
    /**
     * Menu 
     * 
     * @return - an integer
     */
    public static int displayMenu() {
        int choice;
        choice = 0; //can be initialized as any number that isnt 1 - 10
        while (choice < 1 || choice > 11) { //while the users choice isnt 1 - 10 
            choice = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "MENU - Choose some Maths!"
                    + "\n1. Terminate program"
                    + "\n2. Average"
                    + "\n3. CircleArea"
                    + "\n4. Distance"
                    + "\n5. SphereVolume"
                    + "\n6. TriArea"
                    + "\n7. Number of Divisors"
                    + "\n8. Sum of Divisors"
                    + "\n9. Greatest Common Divisor"
                    + "\n10. Lowest Common Multiple"
                    + "\n11. Power of 2"));
        }
        return choice; //return the users valid choice
    }

    /**
     * prompts the user to input
     *
     * @param msg - message being displayed to the user
     * @return - an integer
     */
    public static int inputInt(String msg) {
        int num;
        //display prompt and parse response into an int
        num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return num; //return the users input
    }
    
    /**
     * prompts the user to input
     *
     * @param msg - message being displayed to the user
     * @return - a double
     */
    public static double inputDouble(String msg) {
        double num;
        //display prompt and parse response into a double
        num = Double.parseDouble(JOptionPane.showInputDialog(msg));
        return num; //return the users input
    }

    /**
     * displays a message to the user
     *
     * @param msg - message being displayed to the user
     */
    public static void output(String msg) {
        //simply create a message
        JOptionPane.showMessageDialog(null, msg);
    }
    
    /**
     * Finds the average of 2 doubles
     * 
     * @param a - double 1
     * @param b - double 2
     * @return - a double
     */    
    public static double average(double a, double b) {
        double average = (a + b)/2; //simple average calc
        return average;
    }
    
    /**
     * Finds the area of a circle
     * 
     * @param r - radius of the circle
     * @return - a double
     */
    public static double circleArea(double r) {
        double area = Math.PI*Math.pow(r, 2); //formula for area of a circle
        return area;
    }
    
    /**
     * finds the distance between 2 points on a cartesian plane
     * 
     * @param x1 - x of point 1
     * @param y1 - y of point 1
     * @param x2 - x of point 2
     * @param y2 - y of point 2
     * @return - a double
     */
    public static double distance(double x1, double y1, double x2, double y2) {
        double xDifference = Math.abs(x1-x2); //find length between x's
        double yDifference = Math.abs(y1-y2); //find length between y's
        //calcualte distance between points with the pythagorean theorem
        double distance = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
        return distance;
    }
    
    /**
     * Finds the volume of a circle
     * 
     * @param r - radius of the circle
     * @return - a double
     */
    public static double sphereVolume(double r) {
        double volume = (double)4/3*(Math.PI*Math.pow(r, 3));
        return volume;
    }
    
    /**
     * Finds the area of a triangle using Heron's formula
     * 
     * @param a - 1st side length
     * @param b - 2nd side length
     * @param c - 3rd side length
     * @return  - a double
     */
    public static double area(double a, double b, double c) {
        double s = (a+b+c)/2; //calculate s (used in formula)
        double area;
        if (s-c < 0 || s-c < 0 || s-c < 0) { //if none of the sides are zero
            area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        } else { //return -1 if a side = zero
            area = -1;
        }
        return area;
    }
    
    /**
     * Finds the number of divisors not including the number itself
     * 
     * @param n - number entered
     * @return - an integer
     */
    public static int numDiv(int n) {
        int divisors = 0;
        
        if (n < 1) { // if the number is less than 1 return 0
            divisors = 0;
        } else {
            for (int i = 1; i < n; i++) { //divide by all possible numbers 
                if (n%i == 0) { //if they are whole numbers
                    divisors++; //add to counter
                }
            }
        }
        return divisors;
    }
    
    /**
     * Calculates the sum of all the divisors of a number not including the number itself
     * 
     * @param n - number entered
     * @return - an integer
     */
    public static int sumDiv(int n) {
        int sumDiv = 0;
        
        if (n < 1) { // if the number is less than 1 return 0 
            sumDiv = 0;
        } else {
            for (int i = 1; i < n; i++) { //divide by all possible numbers
                if (n%i == 0) { //if they are whole numbers
                    sumDiv += i; //add the number to the accumulator
                }
            }
        }
        return sumDiv;
    }
    
    /**
     * Finds the greatest common divisors between 2 numbers
     * 
     * @param a - number 1
     * @param b - number 2
     * @return 
     */
    public static int gcd(int a, int b) {
        int gcd;
        if (a == 0 || b == 0) { //if a number is zero
            return Math.abs(a+b); //return the number that isnt zero
        } else {
            gcd = Math.abs(gcd(b,a%b));
        }
        return gcd; //recycle numbers until one equals zero then that will be the greated common factor
        
    }
    
    /**
     * Finds the lowest common divisors between 2 numbers
     * 
     * @param a - number 1
     * @param b - number 2
     * @return - an integer
     */
    public static int lcm(int a, int b) {
        int gcd = gcd(a,b); //find greastest common factor between a & b
        int lcm = (Math.abs(a*b))/gcd; //use formula to find lcm
        return lcm;
    }
    
    /**
     * squares a number
     * 
     * @param a - number
     * @return - a double
     */
    public static double square(double a) {
        double b = Math.pow(a, 2);
        return b;
    }
    
    public static void main(String[] args) {
        //initialize variables
        int choice;
        double a;
        double b;
        double average;
        double area;
        double x1;
        double y1;
        double x2;
        double y2;
        double distance;
        double sphereVolume;
        double side1;
        double side2;
        double side3;
        int num1;
        int num2;
        int num3;
        
        while (true) { //always let the program loop/run
            choice = displayMenu(); //display a menu for the user to decide on what they want to do with the random numbers
            switch (choice) { //switch on choice (IDE suggested I use one)
                /*
                *FOR ALL CASES*
                - get input of required numbers via input method
                - invoke method desired bt the user and add input to method
                - output final value
                */
                case 1: 
                    System.exit(0); //exit program
                case 2:
                    a = inputDouble("Enter your first number");
                    b = inputDouble("Enter your second number");
                    average = average(a, b);
                    output("The average of "+a+" and "+b+" is "+average);
                    break;
                case 3:
                    area = circleArea(inputDouble("Enter the radius of the circle"));
                    output("The area of the circle is "+area);
                    break;
                case 4: 
                    x1 = inputDouble("Enter the x value of the first point");
                    y1 = inputDouble("Enter the y value of the first point");
                    x2 = inputDouble("Enter the x value of the second point");
                    y2 = inputDouble("Enter the y value of the second point");
                    distance = distance(x1, y1, x2, y2);
                    output("The distance between point ("+x1+","+y1+") and ("+x2+","+y2+") is "+distance);
                    break;
                case 5: 
                    sphereVolume = sphereVolume(inputDouble("Enter the radius of the sphere"));
                    output("The volume of the sphere is "+sphereVolume);
                    break;
                case 6: 
                    side1 = inputDouble("Enter side a of the triangle");
                    side2 = inputDouble("Enter side b of the triangle");
                    side3 = inputDouble("Enter side c of the triangle");
                    area = area(side1, side2, side3);
                    output("A triangle with the sides "+side1+", "+side2+" and "+side3+" have an area of "+area);
                    break;
                case 7: 
                    num1 = inputInt("Enter a number");
                    num2 = numDiv(num1);
                    output(num1+" has "+num2+" divisors");
                    break;
                case 8: 
                    num1 = inputInt("Enter a number");
                    num2 = sumDiv(num1);
                    output("The sum of "+num1+"'s divisors is "+num2);
                    break;
                case 9: 
                    num1 = inputInt("Enter your first number");
                    num2 = inputInt("Enter your second number");
                    num3 = gcd(num1, num2);
                    output("The greatest common divisor of "+num1+" and "+num2+" is "+num3);
                    break;
                case 10: 
                    num1 = inputInt("Enter your first number");
                    num2 = inputInt("Enter your second number");
                    num3 = lcm(num1, num2);
                    output("The lowest common divisor of "+num1+" and "+num2+" is "+num3);
                    break;
                case 11:
                    a = inputDouble("Enter a number");
                    b = square(a);
                    output(a+"^2 is "+b);
                    break;
            }
        }
    }
    
}
