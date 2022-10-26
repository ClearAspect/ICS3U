/*
Roan Mason
03/22/2022

Write a game similar to NIM. Two players take away, alternatively, 1,2, or 3 coins from a 
given pile of pennies. The person making the last move wins (i.e. the person who takes the 
last penny). Write a program to simulate this game, starting with a random number of coins 
between 10 and  20.

*/
package ifexercisechallenge1;

import javax.swing.JOptionPane;

public class IfExerciseChallenge1 {

    public static void main(String[] args) {
        
        int coins = (int)(Math.random() *11) + 10;
        boolean run = true;
        int userCoins = 0;
        int CPUCoins = 0;
        String start = "";
        String winner = "";
        
        //ask the user if they want their turn first
        start = JOptionPane.showInputDialog("There are " +coins+ " total coins. Would you like to go first? y/n");
        
        while (run == true){ //run the game
            
            if (coins <= 0) { //check to see if someone has won
                run = false;
            } else { //otherwise run the game
                if (start.equals("y")) { //play the user
                    //ask how many coins they want to take away
                    userCoins = Integer.parseInt(JOptionPane.showInputDialog("There are " + coins + " coins remaining.\nYou may take 1, 2 or 3 from the pile."));
                    while ((userCoins > 3) || (userCoins < 1)) { //test if its a valid # of coins
                        JOptionPane.showMessageDialog(null, "Invalid Entry of coins.");
                        userCoins = Integer.parseInt(JOptionPane.showInputDialog("There are " + coins + " coins remaining.\nYou may take 1, 2 or 3 from the pile."));
                    }
                    coins -= userCoins; //remove coins from pile/total
                    JOptionPane.showMessageDialog(null, "You have taken away " + userCoins + " coins.\nThere are " + coins + " coins remaining.");
                    start = "n";
                    winner = "User";
                } else { //play the computer
                    if ((coins == 3) || (coins >= 7)) {
                        CPUCoins = 3;
                    } else if ((coins == 6) || (coins == 2)) {
                        CPUCoins = 2;
                    } else if ((coins == 5) || (coins == 1)) {
                        CPUCoins = 1;
                    }
                    coins -= CPUCoins;
                    JOptionPane.showMessageDialog(null, "The CPU has taken away " + CPUCoins + " coins.\nThere are " + coins + " coins remaining");
                    start = "y";
                    winner = "CPU";
                }
                
            }
            
        }
        JOptionPane.showMessageDialog(null, "There are 0 coins remaining. The "+winner+" has won the game!");
        
    }
    
}
