/*
Roan Mason
02/24/2022

Write all the numbers from 1 to 10 and calculate the square and the 
cube of all these values. Include column headings.
*/
package forloopexercise4;

public class ForLoopExercise4 {

    public static void main(String[] args) {
        
        //Print the begining of the chart
        System.out.println("Number\tSquare\tCube");
        //Loop as long as i is less than or equal to 10
        for (int i = 1; i <= 10; i++){
            //print the current number the loop is on. Then show that number squared. Then show that number cubed
            System.out.println(i+"\t"+(i*i)+"\t"+(i*i*i));
        }
        
    }
    
}
