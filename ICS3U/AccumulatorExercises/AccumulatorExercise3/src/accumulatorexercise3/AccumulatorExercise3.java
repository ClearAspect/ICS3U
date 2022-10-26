/*
Roan Mason
02/25/2022

Write a program that will print
The grand total of all the even numbers between 10 and 60 (inclusive)  

All the numbers and the running total of values from 50 to 1 in steps of 5 (backwards)
*/
package accumulatorexercise3;


public class AccumulatorExercise3 {

    public static void main(String[] args) {
        
        int sumOne = 0;
        int sumTwo = 0;
        
        for (int i = 10; i <= 60; i += 2){
            sumOne += i;
        }
        System.out.println("The total of all of the even numbers from 10 to 60 is "+sumOne);
        
        System.out.println("\nNumber\tTotal");
        for (int i = 50; i > 1; i -= 5){
            sumTwo += i;
            System.out.println(i+"\t"+sumTwo);
        }
        
    }
    
}
