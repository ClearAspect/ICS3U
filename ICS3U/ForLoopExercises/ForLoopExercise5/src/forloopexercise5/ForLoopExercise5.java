/*
Roan Mason
02/24/2022

Write all the numbers from 10 to 1 and calculate the square and the cube of 
all these values. Include column headings.
 */
package forloopexercise5;

public class ForLoopExercise5 {

    public static void main(String[] args) {

        //Print the begining of the chart
        System.out.println("Number\tSquare\tCube");
        //Loop as long as i is greater than or equal to 1
        for (int i = 10; i >= 1; i--) {
            //print the current number the loop is on. Then show that number squared. Then show that number cubed
            System.out.println(i + "\t" + (i * i) + "\t" + (i * i * i));
        }

    }

}