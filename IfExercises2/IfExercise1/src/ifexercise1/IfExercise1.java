/*
Roan Mason
03/23/22

Write a program that asks the user for their age and either accepts or rejects 
them for buying a lottery ticket. (The legal age to gamble in Ontario is 18).
*/
package ifexercise1;

import javax.swing.JOptionPane;

public class IfExercise1 {

    public static void main(String[] args) {
        
        boolean run = true;
        String error = "";
        
        while (run == true){ //must be 18 to buy one. oldest person to ever live was 122
            int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));

            if ((age < 18) && (age > 0)){
                JOptionPane.showMessageDialog(null, "You are too young to buy a ticket");
            } else if (age < 18){
                JOptionPane.showMessageDialog(null, "Invalid Age - Too low", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (age > 123){
                JOptionPane.showMessageDialog(null, "Invalid Age - Too High", "Error", JOptionPane.ERROR_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "You may buy a ticket");
                run = false;
            }

        }
        
    }
    
}
