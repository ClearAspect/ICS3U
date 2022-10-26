/*
Roan Mason
05/17/22

The table below contains the names and number of units of the top 10 pizza 
chains in 2020.  Write a program to place these data (from this data file) into 
a pair of parallel arrays (i.e. two arrays of the same length), compute the 
total number of units for these 10 chains, and display a table giving the name 
and percentage of total units for each of the companies.
*/
package mason1darrayexercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Mason1DArrayExercise5 {

    public static void printArray(String pizzaChain[], int units[]) {
        String msg = "\tNAME\t\t\t\t\tNUM UNITS\tMARKET SHARE\n";
        String percent;
        for (int i = 0; i < pizzaChain.length; i++) {
            percent = marketShare(units, units[i]);
            msg += (i+1)+".\t" + pizzaChain[i] + "\t\t"+units[i]+"\t\t"+percent+"\n";
        }
        System.out.println(msg);
    } 
    
    public static String marketShare(int units[], int unitsOwned) {
        DecimalFormat percent = new DecimalFormat("#,##0.00%");
        double total = 0;
        for (int i = 0; i < units.length; i++) {
            total += units[i];
        }
        double share = (unitsOwned/total);
        String sPercent = ""+percent.format(share);
        return sPercent;
    }
    
    public static void main(String[] args) {
        String pizzaChain[] = new String[10];
        int units[] = new int[10];
        try {
            File f = new File("src/mason1darrayexercise5/pizza.txt");
            Scanner s = new Scanner(f);
            for (int i = 0; i < 10; i++) {
                pizzaChain[i] = s.nextLine();
                units[i] = Integer.parseInt(s.nextLine());
            }
            printArray(pizzaChain, units);
        } catch (FileNotFoundException e) {
            System.out.println("Error: "+e);
        }
        
    }
    
}
