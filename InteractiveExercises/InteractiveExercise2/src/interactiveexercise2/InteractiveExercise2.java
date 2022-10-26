
package interactiveexercise2;

import javax.swing.JOptionPane;

public class InteractiveExercise2 {

    public static void main(String[] args) {
        
        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the first number please"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the second number please"));
        double num3 = Double.parseDouble(JOptionPane.showInputDialog("Enter the thrid number please"));
        double num4 = Double.parseDouble(JOptionPane.showInputDialog("Enter the fourth number please"));
        double num5 = Double.parseDouble(JOptionPane.showInputDialog("Enter the fifith number please"));
        
        double sum = num1 + num2 + num3 + num4 + num5;
        double average = (num1 + num2 + num3 + num4 + num5)/5;
        
        JOptionPane.showMessageDialog(null, ("The sum of " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5 + " is " + sum));
        JOptionPane.showMessageDialog(null, ("The average of " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5 + " is " + average));

    }
    
}
