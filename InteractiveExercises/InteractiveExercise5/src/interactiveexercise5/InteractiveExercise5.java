
package interactiveexercise5;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class InteractiveExercise5 {

    public static void main(String[] args) {
        
        String item = JOptionPane.showInputDialog("Welcome to Cutten's Computer. Enter the item name:");
        double itemCost = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the item:"));
        int numOfItems = Integer.parseInt(JOptionPane.showInputDialog("Enter the number og items purchased:"));
        double subtotal = itemCost*numOfItems;
        double total = subtotal*1.13;
        
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        
        JOptionPane.showMessageDialog(null, ("Your subtotal comes to " + money.format(subtotal) + " before HST."));
        JOptionPane.showMessageDialog(null, ("Your total comes to " + money.format(total) + " after HST (13%)."));
        
        double cashPaid = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount tendered:"));
        
        JOptionPane.showMessageDialog(null, ("Receipt" + "\n Item - " + item + "\n Cost - " + money.format(itemCost) + "\n Quantity - " + numOfItems + "\n Subtotal - " + money.format(subtotal) + "\n HST - " + money.format(total-subtotal) + "\n Total - " + money.format(total) + "\n ___________________" + "\n Amount Tendered - " + money.format(cashPaid) + "\n Change Due - " + money.format(cashPaid-total)));
        
    }
    
}
