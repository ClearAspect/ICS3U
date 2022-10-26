/*
Roan Mason
02/25/2022

Write a program that will
Print the sum of all the values between 1.5 and 5.5 in increments of 0.5 (solution)
Print the sum of all the values between 1 and 0 backwards in decrements of 0.2
*/
package accumulatorexercise1;

public class AccumulatorExercise1 {

    public static void main(String[] args) {
        //create variables for the sums
        double sumOne = 0;
        double sumTwo = 0;
        
        //accumulate the sum until all the numbers have been gone through
        for (double i = 1.5; i <= 5.5; i += 0.5){
            sumOne += i;
        }
        //accumulate the sum until all the numbers have been gone through
        for (double i = 1; i >= 0; i -= 0.2){
            sumTwo += i;
        }
        
        sumTwo = Math.abs(sumTwo);
        System.out.println("The sum of 1.5 to 5.5 going by 0.5 is: "+sumOne);
        System.out.println("The sum of 1.0 to 0 going by -0.2 is :"+sumTwo);
        
    }
    
}
