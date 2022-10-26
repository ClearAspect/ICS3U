/*
Roan Mason
04/07/22

Figuring out how to create and delete data files
*/
package masoncreatingdatafiles;

import java.io.*;
import java.util.Scanner; 

public class MasonCreatingDataFiles {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        boolean run = true;
        String userInput = "";
        
        while (run == true) {
            System.out.println("----------\nMAIN MENU\n- Create File\n- Delete File\n- Open File\n\nuser/ ");
            userInput = s.next();
            
            try {                
                File f = new File("src/masoncreatingdatafiles/DataFileTest.txt");
                FileWriter writer = new FileWriter(f);

                if (userInput.equalsIgnoreCase("create")) {
                    if (f.createNewFile() == true) { //if f.createNewFile(); is possible/happening. f.createNewFile() happens when in if statement
                        System.out.println("File Created");
                    } else {
                        System.out.println("File Exists");

                    }
                } else if (userInput.equalsIgnoreCase("delete")) {
                    if (f.delete()) {
                        System.out.println("File Deleted");
                    } else {
                        System.out.println("File Does Not Exist");
                    }
                } else {
                    System.out.println("unknown command");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e);

            }
            
        }

    }

}
