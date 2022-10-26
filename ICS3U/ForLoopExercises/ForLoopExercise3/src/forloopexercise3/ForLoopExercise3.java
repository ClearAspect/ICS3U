/*
Roan Mason
02/24/2022

Ask the user for a number and a character. Print the specified 
character the # of times requested by the user.
 */
package forloopexercise3;

import javax.swing.JOptionPane;

public class ForLoopExercise3 {

    public static void main(String[] args) {
        //Ask the user for the text they want repeated then ask for the amount of times they want it repeated. Parse string into int
        String text = JOptionPane.showInputDialog("What character would you like to see?");
        int times = Integer.parseInt(JOptionPane.showInputDialog("How many times would you like to see \""+text+"\"?"));
        
        //show them the text they requested
        System.out.println("Here are your "+times+" \""+text+"\"\'s");
        //print the text as much as the user requested. As long as i < their number
        for (int i = 0; i < times; i++){
            System.out.println(text);
        }
        
    }
    
}
