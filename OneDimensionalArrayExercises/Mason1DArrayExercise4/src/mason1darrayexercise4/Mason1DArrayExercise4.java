/*
Roan Mason
05/17/22

Create a data file that contains the names of 10 people. Get a name from the 
user and count how many times that name appears in the file. Use an array to 
store the names of the people in the file. You should only read the file once, 
and the prompt to the user should loop until they enter “exit”. Be sure to 
include appropriate output if the name was not found.
*/
package mason1darrayexercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Mason1DArrayExercise4 {
    
    public static String stringInput(String msg) {
        String input = JOptionPane.showInputDialog(msg);
        return input;        
    }
    
    public static void output(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void main(String[] args) {
        String wanted = stringInput("What name are you looking for?");
        String found;
        int occurrence = 0;
        
        try {
            File f = new File("src/mason1darrayexercise4/names.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                found = s.nextLine();
                if (found.equalsIgnoreCase(wanted)) {
                    occurrence++;
                }
            }
            output("The name "+wanted+" occurs "+occurrence+" times in the file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: "+e);
        }
        
    }
    
}
