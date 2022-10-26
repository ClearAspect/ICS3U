/*
Roan Mason
02/25/2022

Determine how many years it would take for a person to double their investment. 
Ask the user for a deposit amount and an interest rate. How long does it take 
for the investment to double? Assume the interest is compounded yearly. Be sure 
to format your output correctly. (Don’t use the formula - use a while loop!)
*/
package accumulatorexercise4;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class AccumulatorExercise4 {

    public static void main(String[] args) {
        //ask the user for their invesrment and the rate of the interest
        double deposit = Double.parseDouble(JOptionPane.showInputDialog("How much money would you like to deposit?"));
        double rate = Double.parseDouble(JOptionPane.showInputDialog("What is youe desired interest rate (as a decimal)?"));
        //double the deposit
        double depositDouble = 2*deposit;
        //accumulator and counter
        double total = deposit;
        int years = 0;
        
        //create a loop to check when the investment will reach double the deposit
        for (double i = total; i < depositDouble; i = total*(rate+1)){
            years++;
            System.out.println(i);
            total = total*(rate+1);
        }
        
        //include the year which the total is reached
        total = total*(rate+1);
        years++;
        
        //Money formating
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        
        
        System.out.print("After "+years+" years your deposit of "+money.format(deposit)+" will be worth "+money.format(total));
    }
    
}
