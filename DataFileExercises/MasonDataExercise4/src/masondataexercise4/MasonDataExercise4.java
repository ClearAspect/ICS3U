/*
Roan Mason
04/07/22

At the end of each month, a credit card company constructs the table shown below to 
summarize the status of the accounts. Write a program to produce this table. The 
first 4 pieces of data for each account should be read from a data file. The program 
should compute the finance charges (1.5 percent of the unpaid past due amount) and the 
current amount due for an account.
*/
package masondataexercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class MasonDataExercise4 {
    
    public static void main(String[] args) {
        
        
        //initialize variables
        String account;
        Double pastDue, payments, purchases, charges, currentDue;
        //money format
        DecimalFormat money = new DecimalFormat("$#,##0.00");

        try {
            File f = new File("src/masondataexercise4/AccountStatusData.txt"); //load file
            Scanner s = new Scanner(f); //Apply Scanner to file
            //Create start of table
            System.out.println("Account #\tPast Due Amt\tPayments\tPurchases\tFinance Charges\tCurrent Amt Due");
            while (s.hasNextLine() == true) { //while there are more lines in the file
                account = s.nextLine(); //first line is account name
                pastDue = Double.parseDouble(s.nextLine()); //second line is past due amount
                payments = Double.parseDouble(s.nextLine()); //third line is payments
                purchases = Double.parseDouble(s.nextLine()); //fourth line is purchases
                charges = (pastDue - payments) * 0.015; //pastDue-payments = new due amount. * 0.015 because charges = 1.5%
                currentDue = (pastDue - payments) + purchases + charges; //new due amount + purchaes + charges = final amount due
                //add this data to the table
                System.out.println(account+"\t\t"+money.format(pastDue)+"\t\t"+money.format(payments)+"\t\t"+money.format(purchases)+"\t\t"+money.format(charges)+"\t\t"+money.format(currentDue));
            }
        } catch (FileNotFoundException e) { //if file is not found
            System.out.println("Error: "+e); //send error message
        }
        
        
    }
    
}
