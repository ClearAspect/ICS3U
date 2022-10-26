/*
Roan Mason
04/06/22

Write a program that will print a chart based on data read from a data file
*/
package masondataexercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MasonDataExercise2 {

    public static void main(String[] args) {
        
        //initialize variables
        String item, asterisks;
        int itemAmount;
        
        try {
            File f = new File("src/masondataexercise2/NumberOfItemsData.txt"); //load file
            Scanner s = new Scanner(f); //scanner scans file
            while (s.hasNextLine() == true) { //while there are still lines to go through
                item = s.nextLine(); //item name is first line
                itemAmount = Integer.parseInt(s.nextLine()); //next line is number
                asterisks = ""; //reset string so it can be used again
                for (int i = itemAmount; i > 0; i--) { //create a string with the asterisks based on number in file
                    asterisks += "*"; //string being created via loop
                }
                System.out.println(item+"\t"+asterisks);
            }
        } catch (FileNotFoundException e) { //if file is not found
            System.out.println("Error: "+e); //send error message
        }
        
    }
    
}
