/*
Roan Mason
05/18/22

A retail store has 5 bins, numbered 1 to 5, each containing a different type of 
item. At the beginning of a particular day, each bin contains 45 items. The 
table shows the cost per item for each of the bins and the quantity sold during 
that day.

Write a program to:
a) Place the cost per item and the quantity sold from each bin into parallel arrays (from a  data file).
b) Display a table giving the inventory at the end of the day and the amount of revenue obtained from each bin
c) Compute the total revenue for the day
d) List the number of each bin that contains fewer than 20 items at the end of  the day.
*/
package mason1darrayexercise6;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Mason1DArrayExercise6 {

    static DecimalFormat money = new DecimalFormat("$#,##0.00");
    
    public static void readFile(int binNums[], double cost[], int numSold[]) {
        int i = 0;
        System.out.println("Loading Arrays...");
        try {
            File f = new File("src/mason1darrayexercise6/bins.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                binNums[i] = Integer.parseInt(s.nextLine());
                cost[i] = Double.parseDouble(s.nextLine());
                numSold[i] = Integer.parseInt(s.nextLine());
                i++;
            }
            System.out.println("Arrays loaded...");
        } catch (FileNotFoundException e) {
            System.out.println("Error: "+e);
        }   
    }
    
    public static int[] calculateRemaining(int numSold[]) {
        int remaining[] = new int[5];
        for (int i = 0; i < numSold.length; i++) {
            remaining[i] = 45 - numSold[i];
        }
        return remaining;
    }
    
    public static double[] calculateBinRevenue(double cost[], int numSold[]) {
        double revenue[] = new double[5];
        for (int i = 0; i < numSold.length; i++) {
            revenue[i] = cost[i] * numSold[i];
        }
        return revenue;
    }
    
    public static void printTable(int binNums[], int remaining[], double revenue[]) {
        System.out.println("Bin #\t\tRemaining\tDaily Revenue");
        for (int i = 0; i < binNums.length; i++) {
            System.out.println(binNums[i]+"\t\t"+remaining[i]+"\t\t"+money.format(revenue[i]));
        }
    }
    
    public static double calculateTotalRev(double revenue[]) {
        double sum = 0;
        for (int i = 0; i < revenue.length; i++) {
            sum += revenue[i];
        }
        return sum;
    }
    
    public static String findLowBins(int binNums[], int remaining[]) {
        String lowBins = "";
        for (int i = 0; i < binNums.length; i++) {
            if (remaining[i] < 20) {
                lowBins += "Bin "+binNums[i]+", ";
            }
        }
        return lowBins;
    }
    
    public static void main(String[] args) {
        //create an array for each field in the file
        int binNums[] = new int[5];
        double cost[] = new double[5];
        int numSold[] = new int[5];
        
        //a) Place the cost per item and the quantity sold from each bin into parallel arrays (from a  data file).
        readFile(binNums, cost, numSold);
        
        //b) Display a table giving the inventory at the end of the day and the amount of revenue obtained from each bin
        int remaining[] = calculateRemaining(numSold);
        double revenue[] = calculateBinRevenue(cost, numSold);
        printTable(binNums, remaining, revenue);
        
        //c) Compute the total revenue for the day
        double totalRevenue = calculateTotalRev(revenue);
        System.out.println("\nTOTAL REVENUE: " + money.format(totalRevenue));
        
        //d) List the number of each bin that contains fewer than 20 items at the end of the day.
        String lowBins = findLowBins(binNums, remaining);
        System.out.println("Bin #'s that need to be refilled: " + lowBins);
    }
    
}
