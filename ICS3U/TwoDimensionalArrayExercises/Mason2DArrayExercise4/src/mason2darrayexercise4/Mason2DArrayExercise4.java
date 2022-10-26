/*

 */
package mason2darrayexercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Mason2DArrayExercise4 {
    
    static DecimalFormat num = new DecimalFormat("#,##0.0");
    
    public static void main(String[] args) {
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] year = new int[5];
        double[][] tempData = new double[5][12];

        loadArray(tempData, year);
        printArray(tempData, month, year);
        average(tempData, year, month);

    }

    private static void loadArray(double[][] tempData, int[] year) {
        try {
            File f = new File("src/mason2darrayexercise4/temperature.txt");
            Scanner s = new Scanner(f);
            for (int x = 0; x < tempData.length; x++) {
                year[x] = Integer.parseInt(s.nextLine());
                for (int y = 0; y < tempData[x].length; y++) {
                    tempData[x][y] = Double.parseDouble(s.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

    }

    private static void printArray(double[][] tempData, String[] month, int[] year) {
        for (int x = 0; x < month.length; x++) {
            System.out.print("\t" + month[x]);
        }
        System.out.println("");
        for (int x = 0; x < tempData.length; x++) {
            System.out.print(year[x]);
            for (int y = 0; y < tempData[x].length; y++) {
                System.out.print("\t"+tempData[x][y]);
            }
            System.out.println("");
        }
    }

    private static void average(double[][] tempData, int[] year, String[] month) {
        double highest;
        String sHighest;
        double lowest;
        String sLowest;
        double average;
        for (int x = 0; x < tempData.length; x++) {
            highest = 0;
            sHighest = "";
            lowest = Double.MAX_VALUE;
            sLowest = "";
            average = 0;
            System.out.println("In " + year[x] + ":");
            for (int y = 0; y < tempData[x].length; y++) {
                average += tempData[x][y];
                if (tempData[x][y] > highest) {
                    highest = tempData[x][y];
                    sHighest = month[y];
                } else if (tempData[x][y] < lowest) {
                    lowest = tempData[x][y];
                    sLowest = month[y];
                }
            }
            average = average/tempData[x].length;
            System.out.println("The average temperature was: "+num.format(average));
            System.out.println("The month with the lowest temperature was "+sLowest);
            System.out.println("The month with the highest temperature was "+sHighest);
        }
        
    }
    
}
