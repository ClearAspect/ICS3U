
package interactiveexercise3;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class InteractiveExercise3 {

    public static void main(String[] args) {
        
        double rate = Double.parseDouble(JOptionPane.showInputDialog("Enter your hourly rate of pay"));
        double hours = Double.parseDouble(JOptionPane.showInputDialog("Enter number of hours worked"));
        double totpay = rate*hours;
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        
        
        JOptionPane.showMessageDialog(null, ("You worked " + hours + " hours @ " + money.format(rate) + " and made " + money.format(totpay)));
        
    }
    
}
