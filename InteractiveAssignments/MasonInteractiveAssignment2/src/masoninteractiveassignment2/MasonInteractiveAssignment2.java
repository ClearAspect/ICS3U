/*
Roan Mason
02/16/2022

Given the list price and net prices of an item, find the amount of the discount
and the percent rate of discount.
*/
package masoninteractiveassignment2;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonInteractiveAssignment2 {

    public static void main(String[] args) {

        //Ask the user to input the original and final cost of the item(s)
        double price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the orginal cost of your item(s):"));
        double netPrice = Double.parseDouble(JOptionPane.showInputDialog("Please enter the final cost of your item(s):"));
        //Calculate the $ reduced by the discount. Use that to find the actual % of discount
        double cashOff = price-netPrice;
        double discount = cashOff/price;
        //Decimal and percent formating for numbers
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        DecimalFormat percent = new DecimalFormat("##.0%");
        
        //
        JOptionPane.showMessageDialog(null, ("List Price:   "+money.format(price)
                +"\nNet price:   "+money.format(netPrice)
                +"\nAmount of Discount:   "+money.format(cashOff)
                +"\nRate of discount:   "+percent.format(discount)
                ));
        

    }
    
}
