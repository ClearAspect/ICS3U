/*
Roan Mason
05/02/22

This data file contains the name and age of several people.  
Write a program that will read the file and print a card (shown below) for each 
record based on the age categories described below:

		Under 21 - category A
			- complete form
			- no medical certificate is required
		21 to 50 - category B
			- complete form
			- A medical certificate is required
		51 to 65 - category C
			- complete form
			- no medical certificate is required
		Over 65 - category D
			- no form required
			- A medical certificate is required
*/

package masonmethodexercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MasonMethodExercise5 {
    
    static String name = "";
    static int age = 0;
    static String category = "";
    
    public static void drawStars() {
        System.out.println("******************************");
    }
    
    public static void printNameAge() {
        System.out.println("Name: "+name+"\tAge: "+age);
    }
    
    public static void printAgeCategory() {
        if (age < 21){
            category = "A";
        } else if (age >= 21 && age <= 50) {
            category = "B";
        } else if (age >= 51 && age <= 65) {
            category = "C";
        } else {
            category = "D";
        }
        System.out.println("Age category for insurance purpose: "+category);
    }
    
    public static void printCompleteFormMessage() {
        if (category.equals("D")) {
            System.out.println("Do not complete enclosed form");
        } else {
            System.out.println("Complete enclosed form and return");
        }
    }
    
    public static void printMedCertificateMessage() {
        if (category.equals("A") || category.equals("C")) {
            System.out.println("No medical certificate required");
        } else {
            System.out.println("Medical certificate required");
        }
    }
    
    public static void completedCard() {
        drawStars();
        printNameAge();
        drawStars();
        printAgeCategory();
        drawStars();
        printCompleteFormMessage();
        drawStars();
        printMedCertificateMessage();
        drawStars();
    }
    
    public static void main(String[] args) {
        
        try {
            File f = new File("src/masonmethodexercise5/medicalData.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                name = s.nextLine();
                age = Integer.parseInt(s.nextLine());
                completedCard();
                System.out.println("\n");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: "+e);
        }
        
        
    }

}
