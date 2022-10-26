/*
Roan Mason
05/30/22

Arrays Test:
https://docs.google.com/document/d/1hlu4sX7a0q1EiKC_vf9XJSJQRzDrPC-CVBnAVKxEvxY/edit
 */
package masonarraytest;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class MasonArrayTest {
    
    static DecimalFormat num = new DecimalFormat("#,###");

    public static int mainMenu() {
        int choice = 0;
        while (choice > 3 || choice < 1) {
            choice = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Choose an option:"
                    + "\n1. Make random numbers"
                    + "\n2. Analyze"
                    + "\n3. Exit"
            ));
        }
        return choice;
    }

    public static int[] randNums(int amount) {
        int[] randomArray = new int[amount];
        int randomNumber;
        for (int i = 0; i < randomArray.length; i++) {
            randomNumber = (int) (Math.random() * 200001) - 100000;
            randomArray[i] = randomNumber;
            System.out.println(randomNumber);
        }
        JOptionPane.showMessageDialog(null, "Done! Your number have been printed to the console.");
        return randomArray;
    }
    
    public static void analyzeArray(int[] randomArray, int amount) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int sum = 0;
        double average = 0;
        
        for (int i = 0; i < randomArray.length; i++) {
            sum += randomArray[i];
            
            if (randomArray[i] > largest) {
                largest = randomArray[i];
            }
            
            if (randomArray[i] < smallest) {
                smallest = randomArray[i];
            }
            
        }
        average = (double)sum / randomArray.length;
        JOptionPane.showMessageDialog(null, "in the "+num.format(amount)+"random numbers:"
                + "\n"+num.format(largest)+" is the largest"
                + "\n"+num.format(smallest)+" is the smallest"
                + "\n"+num.format(average)+" is the average");
        
    }
    
    public static void main(String[] args) {
        int[] randomArray = null;
        int choice = 0;
        int amount = 0;
        boolean numbersCreated = false;

        while (choice != 3) {
            choice = mainMenu();
            if (choice == 1) {
                numbersCreated = true;
                amount = Integer.parseInt(JOptionPane.showInputDialog("How many numbers do you want to make?"));
                randomArray = randNums(amount);
            } else if (choice == 2) {
                if (numbersCreated == true) {
                    analyzeArray(randomArray, amount);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: You haven't made any numbers yet!");
                }
            } else {
                System.exit(0);
            }
            
        }
        
        
    }
}
