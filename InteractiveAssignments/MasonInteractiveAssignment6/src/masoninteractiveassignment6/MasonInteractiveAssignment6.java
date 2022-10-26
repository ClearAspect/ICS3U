/*
Roan Mason
02/18/2022

There are two kinds of interest: simple and compound. With simple interest, the 
amount of the deposit remains the same, and the amount of interest is paid at the 
end of a time interval. For example, if $1000 is deposited for 7 years at an 
interest rate of 6% per year, $60 will be deposited at the end of each year, for
a total of $1420 after 7 years. The value of the amount after the term is calculated 
using the formula: TotalAmount = Principal * (1 + years * interestRate). 
Create a SimpleInterest application that prompts the user for the principal, number 
of years, and the interest rate (as a decimal), then calculates the amount of interest.

TotalAmount = Principal * (1 + years * interestRate)
*/

package masoninteractiveassignment6;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonInteractiveAssignment6 {

    public static void main(String[] args) {
        
        //Ask the user to input their initial investment, years invested, and interest rate
        double principal = Double.parseDouble(JOptionPane.showInputDialog("What is your principal (amount invested)?"));
        double years = Double.parseDouble(JOptionPane.showInputDialog("How many years will you be investing for?"));
        double interestRate = Double.parseDouble(JOptionPane.showInputDialog("What is the interest rate of your investment as a decimal (Ex. 6% would be 0.06)?"));
        
        //calculate the result of the investment and the $ accumulate because of the investment
        double totalInvest = principal * (1 + years * interestRate);
        double interestAmount = totalInvest-principal;
        
        DecimalFormat money = new DecimalFormat("$#,###.00");
        DecimalFormat percent = new DecimalFormat("###.0%");
        DecimalFormat number = new DecimalFormat("#,###");
        
        JOptionPane.showMessageDialog(null, ("Principal:   "+money.format(principal)
                +"\nYears Invested:   "+number.format(years)
                +"\nInterest rate:   "+percent.format(interestRate)
                +"\nInterest amount:   "+money.format(interestAmount)
                +"\nTotal value of investment:   "+money.format(totalInvest)
        ));
        
    }
    
}
