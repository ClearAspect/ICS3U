/*
Roan Mason
05/13/22

Generate 6 random numbers between 1 and 100 and store them in an array. 
Print the 6 random numbers and their sum.
*/
package mason1darrayexercise2;

import javax.swing.JOptionPane;

public class Mason1DArrayExercise2 {
    
    public static void printArray(int numbers[]) {
        String msg = "";
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            msg += numbers[i] + " | ";
            sum += numbers[i];
        }
        msg += "\nThe sum of all the numbers in the array is : "+sum;
        System.out.println(msg);
    }
    
    public static int[] loadArray() {
        int numbers[] = new int[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = randNum();
        }
        return numbers;
    }
    
    public static int randNum() {
        int randNum = (int)(Math.random()*100)+1;
        return randNum;
    }
    
    public static void main(String[] args) {
        int numbers[] = loadArray();
        printArray(numbers);
        
    }
    
}
