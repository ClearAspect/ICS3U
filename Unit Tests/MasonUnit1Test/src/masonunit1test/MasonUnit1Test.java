/*
Roan Mason
02/23/2022

Mr. Cutten has started a new business manufacturing robots. He needs a computer program to help 
calculate the pay for his employees who sell the robots. Each person earns a base pay of $2,000 
plus a commission of 6% of the amount of their robot sales. The base pay plus the commission is 
known as gross pay. There is also an 18% deduction from an employee's gross pay for things like 
pension and benefits. An employee's net pay is their gross pay minus the amount of deductions. 
*/
package masonunit1test;

//import JOptionPane and number Formating 
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonUnit1Test {

    public static void main(String[] args) {
        
        //Prompt the user to input the dollar amount of sales and employee has made then parse the string into a double
        double sales = Double.parseDouble(JOptionPane.showInputDialog("Enter the dollar amount of sales please"));
        
        //declare the base pay of the employees
        final double basePay = 2000;
        //commission is 6% of sales
        double commission = sales*0.06;
        //grosspay is the sum of their base pay and commission from sales
        double grossPay = basePay+commission;
        //deduction of 0.18 on their gross pay for pension and benefits 
        double deduction = grossPay* 0.18;
        //net pay is grosspay-deductions
        double netPay = grossPay-deduction;
        
        //Create number formating for $. add $ symbol cents and "," between 3 digits
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        
        //Display a message box telling the user the employee's base pay, commission, grosspay, deductions on gross pay, and net pay
        JOptionPane.showMessageDialog(null, ("Employee Pay Information:"
                +"\nBase pay: "+money.format(basePay)
                +"\nCommission: "+money.format(commission)
                +"\nGross pay: "+money.format(grossPay)
                +"\nDeductions: "+money.format(deduction)
                +"\nNet pay: "+money.format(netPay)
                ));
    }
    
}
