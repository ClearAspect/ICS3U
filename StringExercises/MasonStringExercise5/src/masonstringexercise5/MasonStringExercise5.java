/*
Roan Mason
05/27/22

Write a program that lets you enter a word and that prints out that word in all 
lowercase letters. The program should repeat asking for more words, until you 
enter "exit". Can you also make this program work with entire sentences?
*/
package masonstringexercise5;

import java.util.Scanner;

public class MasonStringExercise5 {

    public static void main(String[] args) {
        
        String input = "";
        String output = "";
        Scanner s = new Scanner(System.in);

        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Please enter a word (\"exit\" will exit)");
            input = s.nextLine();

            if (!input.equalsIgnoreCase("exit")) {
                output = input.toLowerCase();
                System.out.println(output);
            } else {
                System.out.println("Exiting...");
            }
        }
        
    }
    
}
