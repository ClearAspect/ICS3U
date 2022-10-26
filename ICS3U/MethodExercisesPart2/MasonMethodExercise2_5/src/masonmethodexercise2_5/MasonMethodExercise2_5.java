/*
Roan Mason
05/05/22

Write a program that asks the user for a positive integer. Write a boolean method that 
will return true if it contains a 1 digit. Display the results to the user and prompt 
again until -1 is entered.
*/
package masonmethodexercise2_5;

import javax.swing.JOptionPane;

public class MasonMethodExercise2_5 {

    /**
     * Prompts the user to enter an integer number
     *
     * @param msg - the message to prompt the user with
     * @return an integer number
     */
    public static int input(String msg) {
        int num;
        num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return num;
    }
    
    
    /**
     * output message
     * 
     * @param msg - the message displayed to the user
     */
    public static void output(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    /**
     * check to see if the number contains a "1"
     * 
     * @param userNum - number that the user entered in the input method
     * @return - a boolean
     */
    public static boolean gotOne(int userNum) {
        String sUserNum = "" + userNum;
        if (sUserNum.contains("1")) {
            return true;
        }
        return false;
            
    }
    
    
    public static void main(String[] args) {
        int userNum = 0;
        String msg = "Gimmie a number!";
        
        while (userNum != -1) {
            userNum = input(msg);
            msg = "Gimmie another number!";
            boolean gotOne = gotOne(userNum);
            
            if (userNum == -1) {
                output("Later skater!");
                System.exit(0);
            } else if (gotOne == true) {
                output("It's got one!");
            } else {
                output("It aint got one!");
            }
            
        }
        
        
    }
    
}
