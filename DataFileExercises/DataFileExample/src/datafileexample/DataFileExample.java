/*
Roan Mason
04/06/22

Data file example done with the class. Reads name and ages from a file and outputs each persons
age in days
*/
package datafileexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataFileExample {

    public static void main(String[] args) {
        
        String name;
        int ageYears;
        System.out.println("Name\tAge\tAge(Days)");
        try {
            File f = new File("src/datafileexample/data.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine() == true) {
                name = s.nextLine();
                ageYears = Integer.parseInt(s.nextLine());
                int ageDays = ageYears*365;
                System.out.println(name + "\t" + ageYears + "\t" + ageDays);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);

        }
        
        
    }
    
}
