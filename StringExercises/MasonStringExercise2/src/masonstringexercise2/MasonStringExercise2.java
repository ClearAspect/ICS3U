/*
Roan Mason
05/27/22

Write a program that asks the user for a String pattern, then tells the user 
the first index of that pattern in Strings they enter (or if it is not in the 
String).
The program should stop and not display a message when the user types "exit".

 */
package masonstringexercise2;

import java.util.Scanner;

public class MasonStringExercise2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String word = "";
        System.out.println("Please enter a pattern to start");
        String pattern = s.nextLine();

        while (!word.equalsIgnoreCase("exit")) {
            System.out.println("Enter a word (\"exit\" will exit)");
            word = s.nextLine();
            if (!word.equalsIgnoreCase("exit")) {
                if (word.contains(pattern)) {
                    System.out.println(pattern + " begins at location " + word.indexOf(pattern) + " in " + word);
                } else {
                    System.out.println(pattern + " is not in " + word);
                }
            } else {
                System.out.println("Exiting...");
            }
            
            
        }
    }
}
