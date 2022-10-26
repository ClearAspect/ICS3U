/*
Roan Mason
05/27/22

Write a program that reads in words until the user types "exit", then prints 
the total number of characters that were in the words (not including "exit").
*/
package masonstringexercise1;

import java.util.Scanner;

public class MasonStringExercise1 {

    public static void main(String[] args) {
        
        String input = "";
        Scanner s = new Scanner(System.in);
        int charTotal = 0;
        
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Enter a word (\"exit\" will exit)");
            input = s.nextLine();
            if (!input.equalsIgnoreCase("exit")) {
                charTotal += input.length();
            } else {
                System.out.println("You entered "+charTotal+" characters in total");
            }
            
        }
        
    }
    
}
