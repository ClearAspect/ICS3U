/*
Roan Mason
05/231/22

Write an application that uses random numbers to help create sentences. Use four
arrays of Strings called article, noun, verb and preposition. Create a sentence 
by selecting a word at random from each array in the following order: article, 
noun, verb, preposition, article and noun. As each word is picked, concatenate 
it to the previous words in the sentence. The words should be separated by 
spaces. When the final sentence is output, it should start with a capital letter
and end with a period.
*/
package masonstringexercise8;

import java.util.Scanner;

public class MasonStringExercise8 {
    
    public static String create() {
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = {"to", "from", "over", "under", "on"};
        String output = "";
        
        
        output += article[randNum()] + " ";
        output += noun[randNum()] + " ";
        output += verb[randNum()] + " ";
        output += preposition[randNum()] + " ";
        output += article[randNum()] + " ";
        output += noun[randNum()] + ".";
        output = output.substring(0, 1).toUpperCase() + output.substring(1);
        return output;
    }

    
    public static void main(String[] args) {
        String input = "";
        String output = "";
        Scanner s = new Scanner(System.in);
        
        while (!input.equalsIgnoreCase("n")) {
            output = "";
            System.out.println("Would you like to make a new sentence? (Y/N)");
            input = s.nextLine();
            if (input.equalsIgnoreCase("y")) {
                output = create();
                System.out.println(output);
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("Exiting...");
            }
            
        }
    }
    
    public static int randNum() {
        int number = (int)(Math.random() * 5);
        return number;
    }
    
}
