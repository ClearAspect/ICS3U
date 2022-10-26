/*
Roan Mason
05/27/22

Write a program that reads in lines of input from the user and replaces all the 
'r's with 'w's. (Note: your program should work for both lowercase r's and 
uppercase R's)
*/
package masonstringexercise4;

import java.util.Scanner;

public class MasonStringExercise4 {

    public static void main(String[] args) {
        
        String input = "";
        String output = "";
        Scanner s = new Scanner(System.in);

        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Please enter a line to swap the r's from (\"exit\" will exit)");
            input = s.nextLine();

            if (!input.equalsIgnoreCase("exit")) {
                output = input.replaceAll("r", "w");
                output = output.replaceAll("R", "W");
                System.out.println(output);
            } else {
                System.out.println("Exiting...");
            }
        }
        
    }
    
}
