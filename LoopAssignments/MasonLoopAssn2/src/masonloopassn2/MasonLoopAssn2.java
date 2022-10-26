/*
Roan Mason
03/03/2022

Pick a secret pin PIN number. Write a program that loops until the correct PIN 
is entered. Output the number of incorrect attempts.
 */
package masonloopassn2;

import javax.swing.JOptionPane;

public class MasonLoopAssn2 {

    public static void main(String[] args) {
        
        //Initiate variables. Correct PIN, PIN entered by user, counter for fails
        String pin = "9001";
        String userPin = "";
        int fails = 0;
        
        //Initial prompt for PIN
        userPin = JOptionPane.showInputDialog("Please enter the PIN");

        //aslong as the user is getting the PIN wrong. Tell them they are incorrect and add to fails
        while (!userPin.equals(pin)) {
            userPin = JOptionPane.showInputDialog("INCORRECT PIN\nPlease enter the PIN");
            fails++; //add to fails
        }
        
        //When they guess correctly tell them how many times they failed
        JOptionPane.showMessageDialog(null, "You entered "+fails+" incorrect attempt(s)");
    }

}
