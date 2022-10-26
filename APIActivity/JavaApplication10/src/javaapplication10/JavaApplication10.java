/*
Roan Mason
05/09/22

Find the API for the Scanner class. Use a Scanner type object to get names from the user. 
Store these names in a LinkedList (again, look at the API). The user will enter “done” to 
signal that no more names are to be entered. Print the names to the console in reverse order.
*/
package javaapplication10;

import java.util.Scanner;
import java.util.LinkedList;

public class JavaApplication10 {

    public static String input(String msg) {
        Scanner s = new Scanner(System.in);
        System.out.println(msg);
        String name = s.nextLine();
        return name;
    }
    
    
    
    public static void main(String[] args) {
        
        String thisName = "";
        
        LinkedList names = new LinkedList();
        
        
        while (!thisName.equalsIgnoreCase("done")) {
            thisName = input("Enter a name: ");
            if(!thisName.equalsIgnoreCase("done")) {
                names.add(thisName);
            }
        }
        
        for (int i = 0; i != names.size();) {
            System.out.println(names.getLast());
            names.removeLast();
        }
        
        
    }
    
}
