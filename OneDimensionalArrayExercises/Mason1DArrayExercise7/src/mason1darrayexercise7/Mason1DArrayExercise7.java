/*
Roan Mason
05/18/22

Write a program to load this information into four arrays (flight number, 
origin, destination, departure time) from a data file. Your program should only 
read this file one time. Ask the user to request a flight number.  Have the 
computer find the flight number, and display the information corresponding to 
that flight. Account for the case where the user requests a nonexistent flight.
Your menu should loop until the user enters blank.
*/
package mason1darrayexercise7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Mason1DArrayExercise7 {
    
    /**
     * Reads file and loads array
     * 
     * @param flight - flight number array
     * @param origin - flight origin array
     * @param destination - destination array
     * @param departure - departure time
     */
    public static void readFile(String flight[], String origin[], String destination[], String departure[]) {
        int i = 0;
        try {
            //open file
            File f = new File("src/mason1darrayexercise7/flights.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) { //while therer are more lines in the file
                /*
                Lines: 
                1. flight number
                2. flight origin
                3. flight destination
                4. departure time
                */
                flight[i] = s.nextLine(); 
                origin[i] = s.nextLine();
                destination[i] = s.nextLine();
                departure[i] = s.nextLine();
                i++; //change array index to add more data
            }
        } catch (FileNotFoundException e) { //if file is not found
            //error msg
            System.out.println("Error: "+e);
        }   
    }
    
    /**
     * Input helper method
     * 
     * @param msg - msg displayed to the user
     * @return - a string
     */
    public static String strInput(String msg) { 
        String input = JOptionPane.showInputDialog(msg);
        return input;
    }
    
    /**
     * output helper method
     * 
     * @param msg - msg displayed to the user
     */
    public static void output(String msg) { 
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void checkNum(String request, String flight[], String origin[], String destination[], String departure[]) {
        int arrayIndex = -1; //Set array index as impossible integer
        String msg = ""; //message initialization
        for (int i = 0; i < flight.length; i++) { //While there are more flight numbers to test
            if (request.equals(flight[i])) { //if the requested flight number is in that index of the array
                arrayIndex = i; //array index equals the current index
                i = flight.length; //change value of i to end loop
            } else { //if they are not equal
                arrayIndex = -1; //index stays -1
            }
        }
        if (arrayIndex != -1) { //flight number exists
            /*
            output flight details. use arrayIndex as the index of the arrays
            this will output the correct details.
            */
            msg += "FOUND: Flight Number "+flight[arrayIndex]
                    + "\nOrigin: "+origin[arrayIndex]
                    + "\nDestination: "+destination[arrayIndex]
                    + "\nTime: "+departure[arrayIndex];
            output(msg);
        } else { //if array index = -1 then flight number does not exist
            output("Error: Flight not found");
        }
        
    }
    
    public static void main(String[] args) {
        //create parallel arrays
        String flight[] = new String[5]; //flight #
        String origin[] = new String[5]; //flight origin
        String destination[] = new String[5]; //destination place
        String departure[] = new String[5]; //leave time
        
        //read file and load arrays
        readFile(flight, origin, destination, departure); 
        String request = "0";
        while (!request.equals("")) { //while the user doesnt want to quit
            //ask user for desired flight nnumber
            request = strInput("Enter a flight number (blank to quit)");
            if (!request.equals("")) { //user does not want to quit. test number
            checkNum(request, flight, origin, destination, departure);
            }
        }
        
    }
    
}
