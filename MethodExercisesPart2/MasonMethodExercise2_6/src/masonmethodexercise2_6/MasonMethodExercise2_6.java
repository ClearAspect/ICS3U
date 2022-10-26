/*
Roan Mason
05/05/22

Generate 2 random numbers from 1 to 10.  Based on the user's choice, ask the user the 
sum of the 2 numbers (or the difference or the product of the 2 numbers).  Indicate 
whether the user's answer was correct or incorrect.  Continue to ask the user for the 
correct answer until the user is correct.  Your program should not terminate until the
user selects 5 from the main menu.
 */
package masonmethodexercise2_6;

import javax.swing.JOptionPane;

public class MasonMethodExercise2_6 {

    /**
     * Creates a menu for the user to input decision
     * 
     * @param num1 - rand number one added to menu
     * @param num2 - rand number two added to menu
     * @return - an integer
     */
    public static int displayMenu(int num1, int num2) {
        int choice;
        choice = 0; //can be initialized as any number that isnt 1 - 5
        while (choice < 1 || choice > 5) { //while the users choice isnt 1 - 5 
            choice = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "MENU - 1st Number - " + num1 + " 2nd Number - " + num2
                    + "\n1. Addition"
                    + "\n2. Subtraction"
                    + "\n3. Multiplication"
                    + "\n4. New Numbers"
                    + "\n5. Terminate program"));
        }
        return choice; //return the users valid choice
    }

    /**
     * prompts the user to input
     *
     * @param msg - message being displayed to the user
     * @return - an integer
     */
    public static int input(String msg) {
        int num;
        //display prompt and parse response into an int
        num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return num; //return the users input
    }

    /**
     * displays a message to the user
     *
     * @param msg - message being displayed to the user
     */
    public static void output(String msg) {
        //simply create a message
        JOptionPane.showMessageDialog(null, msg);
    }

    /**
     * creates a random number
     *
     * @return - an integer
     */
    public static int randNum() {
        //create a random number
        int number = (int) (Math.random() * 10) + 1;
        return number; //return random number
    }

    /**
     *
     * @param problem - which type of problem it is (1 = +, 2 = -, 3 = *)
     * @param num1 - first number in eqn
     * @param num2 - second number in eqn
     * @param eqn - String of the eqn
     */
    public static void answerPrompt(int problem, int num1, int num2, String eqn) {
        int answer = 0;
        int userAns = Integer.MIN_VALUE; //make initialized variable imposssible for the answer to be equal to
        switch (problem) { //switch on problem (IDE suggested I use one)
            case 1 -> answer = num1 + num2; //answer is addition
            case 2 -> answer = num1 - num2; //answer is subtraction
            case 3 -> answer = num1 * num2; //answer is multiplication
        }
        while (userAns != answer) { //while the users response is incorrect
            userAns = input("What's the answer smartypants? " + eqn); //ask for answer
            if (userAns != answer) { //if wrong 
                output("Incorrect!"); //tell user theyre wrong
            } else { //if correct
                output("Correct!"); //tell user theyre correct
            }
        }
    }

    public static void main(String[] args) {
        //initialize variables
        int choice;
        int num1 = randNum(); //create initial random numbers
        int num2 = randNum(); 

        while (true) { //always let the program loop/run
            //display a menu for the user to decide on what they want to do with the random numbers
            choice = displayMenu(num1, num2); //display a menu for the user to decide on what they want to do with the random numbers
            //switch on the users choice
            switch (choice) { //switch on choice (IDE suggested I use one)
                case 5: //if choice == 5
                    System.exit(0); //exit program
                case 4: //if choice == 4
                    //create new random numbers
                    num1 = randNum();
                    num2 = randNum();
                    break;
                case 3: //if choice == 3
                    //create equation and prompt user for solution
                    answerPrompt(3, num1, num2, "(" + num1 + " * " + num2 + ")");
                    break;
                case 2: //if choice == 2
                    //create equation and prompt user for solution
                    answerPrompt(2, num1, num2, "(" + num1 + " - " + num2 + ")");
                    break;
                case 1: //if choice == 1
                    //create equation and prompt user for solution
                    answerPrompt(1, num1, num2, "(" + num1 + " + " + num2 + ")");
                    break;
            }
        }
    }
}
