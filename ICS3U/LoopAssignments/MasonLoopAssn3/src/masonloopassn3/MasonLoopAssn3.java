/*
Roan Mason
03/03/2022

Write a program that duplicates the following output using only the following 
two print statements. Each statement can only be used once in your program.
System.out.print("*");
System.out.println("");
 */
package masonloopassn3;

public class MasonLoopAssn3 {

    public static void main(String[] args) {
        
        for (int i = 0; i < 3; i++) { //loop the following 3 times
            for (int l = 0; l < 15; l++) { //create a line of '*'s 15 characters long
                System.out.print("*");
            }
            System.out.println(""); //create a new line after the line of '*'s has been created

        }

    }

}
