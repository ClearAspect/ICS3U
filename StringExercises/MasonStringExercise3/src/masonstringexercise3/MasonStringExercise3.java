/*
Roan Mason
05/27/22

Write a program that reads lines of input from the user and outputs them with 
the 'r's removed.  (Note: your program should work for both lowercase r's and 
uppercase R's)
 */
package masonstringexercise3;

import java.util.Scanner;

public class MasonStringExercise3 {

    public static void main(String[] args) {

        String input = "";
        String output = "";
        Scanner s = new Scanner(System.in);

        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Please enter a line to remove the r's from (\"exit\" will exit)");
            input = s.nextLine();

            if (!input.equalsIgnoreCase("exit")) {
                output = input.replaceAll("[r,R]", "");
                System.out.println(output);
            } else {
                System.out.println("Exiting...");
            }
        }

    }

}
