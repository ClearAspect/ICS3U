/*
Roan Mason
03/04/2022

Prompt the user for an initial deposit and an interest rate to be compounded 
yearly. How many years will it take for them to become a millionaire? Output a 
chart showing the year, the initial value of the deposit, the dollar amount of 
interest earned that year, and the value of the deposit at the end of the year.
*/
package masonloopassn6;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonLoopAssn6 {

    public static void main(String[] args) {
        
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        DecimalFormat percent = new DecimalFormat("##0.0%");
        
        double investment = Double.parseDouble(JOptionPane.showInputDialog("What is the starting value of your investment?"));
        double rate = Double.parseDouble(JOptionPane.showInputDialog("What is the interest rate? (as a decimal ie 5% - 0.05)"));
        double interest = 0;
        int year = 0;
        
        String finalOutput = "Year\t\tStarting Value\t\tInterest Amt\t\tEnding Value";
        
        while (investment < 1000000){
            interest = investment*rate;
            investment = investment*(1+rate);
            year++;
            finalOutput += ("\n"+year+"\t\t"+money.format(investment-interest)+"\t\t"+money.format(interest)+"\t\t"+money.format(investment));
            
        }
        finalOutput += "\nAt "+percent.format(rate)+" interest, you will have $1,000,000.00 in "+(year+1)+" years";
        System.out.println(finalOutput);
    }
    
}
