/*
Roan Mason
05/17/22

Write a program that asks the user how many numbers they will enter, makes an 
array that size, and then reads in values from the user to fill each slot in the 
array. Your program should then display the numbers, each on a newline.
*/
package mason1darrayexercise3;

import javax.swing.JOptionPane;

public class Mason1DArrayExercise3 {
    
    public static int intInput(String msg) {
        int input = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return input;        
    }
    
    public static void output(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static int[] loadArray(int elements) {
        int numbers[] = new int[elements];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = intInput("Enter an integer ("+(numbers.length - i)+" to go)");
        }
        return numbers;
    }
    
    public static void printArray(int numbers[]) {
        String msg = "";
        for (int i = 0; i < numbers.length; i++) {
            msg += numbers[i] + "\n";
        }
        output(msg);
    }
    
    public static void main(String[] args) {
        int elements = intInput("How many elements?");
        int numbers[] = loadArray(elements);
        printArray(numbers);
        
        
    }
    
}
