/*
Roan Mason
04/06/22

Create a data file containing the name, year of birth and citizenship of 15 people. Write a program that will :
a)	print a list of all the people in the file-include column headings:
b)	print the same list as above but print the person’s age instead of year of birth
*/
package masondataexercise1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MasonDataExercise1 {

    public static void main(String[] args) {
        
        //initialize variables
        String name, country;
        int birthYear, age;
        
        try {
            File f = new File("src/masondataexercise1/CitizenshipData.txt"); //locate data file
            Scanner s = new Scanner(f); //scanner scans data file
            System.out.println("Name\t\tYear of Birth\tAge\t\tCountry"); //start of table
            while (s.hasNextLine() == true) { //while the scanner can read the next line
                name = s.nextLine(); //name is first line
                birthYear = Integer.parseInt(s.nextLine()); //then birth year
                age = 2022 - birthYear; //calculate age difference of birth year and 2022
                country = s.nextLine(); //then country
                System.out.println(name+"\t\t"+birthYear+"\t"+age+"\t\t"+country); //print
            }
        } catch (FileNotFoundException e) { //if the file is not found
            System.out.println("Error: "+e); //send error message
        }
        
    }
    
}
