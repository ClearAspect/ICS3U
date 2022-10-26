
package interactiveexercise1;

import javax.swing.JOptionPane;

public class InteractiveExercise1 {

    public static void main(String[] args) {
        
        String firstName = JOptionPane.showInputDialog("Enter your first name");
        String lastName = JOptionPane.showInputDialog("Enter your last name");
        
        JOptionPane.showMessageDialog(null, ("Greetings, " + firstName + " " + lastName) );
        
    }
    
}
