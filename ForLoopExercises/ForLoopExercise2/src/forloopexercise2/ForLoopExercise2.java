/*
Roan Mason
02/24/2022

Print the following numbers (you can do all six of these in one project):
All values (inclusive) between 1 and 1000 
All values (exclusive) between 5 and 2000
All values (inclusive) between -400 and -15
All values (exclusive) between 200 and 100 backwards all on one line
All the even values (inclusive) between 2000 and 48000
All the numbers (inclusive) between 110 and -1 going down 3 each time
*/
package forloopexercise2;

public class ForLoopExercise2 {

    public static void main(String[] args) {
        //print all values between 1 and 1000
        for (int i = 1; i <= 1000; i++){
            System.out.println(i);
        }
        //print all values between 5 and 2000
        for (int i = 6; i <= 1999; i++){
            System.out.println(i);
        }
        //print all values between -400 and -15
        for (int i = -400; i <= -15; i++){
            System.out.println(i);
        }
        //print all values between 200 and 100
        for (int i = 199; i >= 101; i--){
            System.out.println(i);
        }
        //print all values between 2000 and 48000
        for (int i = 2000; i <= 48000; i+=2){
            System.out.println(i);
        }
        //print all values between 110 and -1 goig down by 3
        for (int i = 110; i >= -1; i-=3){
            System.out.println(i);
        }

    }
    
}
