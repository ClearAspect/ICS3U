/*
Roan Mason
03/03/2022

Write a program that duplicates the following output using only the following two print statements. Each statement can only be used once in your program.
System.out.print("*");
System.out.println("");
*/
package masonloopassn4;

public class MasonLoopAssn4 {

    public static void main(String[] args) {
        
        int counter  = 1; //line counter variable
        
        for (int i = 0; i < 10; i++){ //want the triangle to be 10 lines tall
            for (int l = 0; l < counter; l++) { //want the line length to be the same as the amount of lines created
                System.out.print("*"); //loop the print statement that's creating the shape
            }
            counter++; //add to line counter
            System.out.println(""); //create new line
            
        }
        
    }
    
}
