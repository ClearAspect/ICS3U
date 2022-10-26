/*
Roan Mason
02/16/2022

Given the list price of an item and the rate of discount, calculate and print 
the amount of discount and the net price.
*/
package masoninteractiveassignment1;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonInteractiveAssignment1 {

    public static void main(String[] args) {

        //Ask the user to input the price and discount of item + parse string into a double
        double price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the cost of your item(s):"));
        double discount = Double.parseDouble(JOptionPane.showInputDialog("Please enter the discount being applied\nEnter as a decimal (Ex. 0.30 for %30)"));
        //calculate the money taken off the price because of the discount and calculate the final cost of the item
        double cashOff = price*discount;
        double netPrice = price-cashOff;
        //Decimal and percent formating for numbers
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        DecimalFormat percent = new DecimalFormat("##.0%");
        
        //Final output telling the user the cost and discount they inputed aswell as the amount of $ discounted and the final cost of the total
        JOptionPane.showMessageDialog(null, ("List Price:   "+money.format(price)
                +"\nRate of discount:   "+percent.format(discount)
                +"\nAmount of Discount:   "+money.format(cashOff)
                +"\nNet price:   "+money.format(netPrice)));
        

    }
    
}
