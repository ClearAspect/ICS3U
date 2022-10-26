/*
Roan Mason
04/05/22

Write a method that accepts a low and a high range and returns a random number within 
that range. Use that method to help you write a program that will generate 2 sets of 6 
random numbers based on the user's choice.  Lotto 649 generates 6 numbers between 1 and 49.  
Lottario generates 6 numbers between 1 and 39.  Display a menu as shown below.  See code 
for method displayMenu().
 */
package masonmethodexercise2_4;

import javax.swing.JOptionPane;

public class MasonMethodExercise2_4 {

    /**
     * Create selection menu
     *
     * @return an int
     */
    public static int displayMenu() {
        int choice;
        choice = 4; //can be initialized as any number that isnt 1 - 3
        while (choice < 1 || choice > 3) {
            choice = Integer.parseInt(JOptionPane.showInputDialog("MENU \n"
                    + "1.649-numbers between 1 and 49 \n"
                    + "2.Lottario-numbers between 1 and 39 \n"
                    + "3.Terminate program"));
        }
        return choice;
    }

    /**
     * generate random numbers between range
     * 
     * @param range - range of random numbers
     * @return - a string 
     */
    public static String lottery(int range) {
        String lotNumbers = "";
        for (int i = 0; i < 6; i++) {
            int randNum = (int)(Math.random()*range)+1;
            lotNumbers += randNum + " ";
        }
        return lotNumbers;
    }
    
    
    public static void main(String[] args) {
        int choice = displayMenu();
        int range = 0;
        if (choice == 1) {
            range = 49;
        } else if (choice == 2) {
            range = 39;
        } else {
            System.exit(0);
        }
        String lotNumbers = lottery(range);
        JOptionPane.showMessageDialog(null, "Your random numbers (1 - "+range+")"
                + "\n"+lotNumbers);
        
    }

}
