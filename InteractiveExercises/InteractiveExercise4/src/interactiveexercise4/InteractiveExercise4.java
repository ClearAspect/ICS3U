
package interactiveexercise4;

import javax.swing.JOptionPane;

public class InteractiveExercise4 {

    public static void main(String[] args) {
        
        
        double cTemp = Double.parseDouble(JOptionPane.showInputDialog("Enter the temperature in Celcius"));
        double fTemp = (cTemp * 9/5)+32;
        
        JOptionPane.showMessageDialog(null, (cTemp + " degrees Celcius is " + fTemp + " degrees Farenheit"));
        
    }
    
}
