/*
Roan Mason
03/03/2022

Ask the user to enter several words (an unknown amount). The user will type END 
to signal that no more words will be entered. Count the number of words that were 
entered (not including END).
*/
package masonloopassn1;

import javax.swing.JOptionPane;

public class MasonLoopAssn1 {

    public static void main(String[] args) {
        //Initiate variables and setup counter. -1 because we dont want 'END' to be counted
        String word = "";
        int counter = -1;
        
        //Ask the user for a word unless they enter 'END'. add to counter
        while (!word.equals("END")){
            counter++;
            word = JOptionPane.showInputDialog("Please enter a word. \'END\' to exit");
        }
        
        JOptionPane.showMessageDialog(null, "You entered "+counter+" word(s)");
    }
    
}
