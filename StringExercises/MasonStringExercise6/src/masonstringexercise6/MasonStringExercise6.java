/*
Roan Mason
05/27/22

Write a program that accepts a string from the user and outputs whether or not 
that string is a palindrome. A palindrome is a word that is the same backwards 
as forwards (e.g. racecar, tacocat).
*/
package masonstringexercise6;

import java.util.Scanner;

public class MasonStringExercise6 {

    public static void main(String[] args) {
        
        String input = "";
        String output = "";
        Scanner s = new Scanner(System.in);
        
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Please enter a word (\"exit\" will exit)");
            input = s.nextLine();

            if (!input.equalsIgnoreCase("exit")) {
                output = "";
                for (int i = 0; i < input.length(); i++) {
                    output += input.charAt(input.length()-1-i);
                }
                
                if (output.equalsIgnoreCase(input)) {
                    System.out.println(input+" is certainly a palindrome.");
                } else {
                    System.out.println(input+" is certainly NOT a palindrome.");

                }
                
            } else {
                System.out.println("Exiting...");
            }
        }
        
    }
    
}
