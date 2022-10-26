/*
Roan Mason
05/16/22

Methods Test Program
https://docs.google.com/document/d/15LaIamCjETC5VvKY0I5jLqtbp_ndowsnHr7NByVE2jc/edit
*/
package masonmethodstest;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MasonMethodsTest {

    
    public static int displayMenu(){
        int choice = 0;
        while (choice > 6 || choice < 1) {
            choice = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Welcome to Cutten Motor Co. sales analyzer!"
                    + "\nChoose an option:"
                    + "\n1. Graph for cars."
                    + "\n2. Graph for trucks."
                    + "\n3. Graph for SUVs."
                    + "\n4. Comparison of all three."
                    + "\n5. Exit"));
        }
        return choice;
    }
    
    public static String dots(int numOfDots) {
        String msg = "";
        for (int i = 0; i < numOfDots; i++) {
            msg += "*";
        }
        return msg;
    }
    
    public static double percent(int wanted, int other1, int other2) {
        int total = wanted + other1 + other2;
        double percent = (double) wanted / total;
        return percent;
    }
    
    public static void cars(int year, int cars, int trucks, int suvs,DecimalFormat percentf) {

        double percent = percent(cars, trucks, suvs);
        String dots = dots(cars);
        System.out.println(year + " " + dots + percentf.format(percent));
    }
    public static void trucks(int year, int cars, int trucks, int suvs,DecimalFormat percentf) {

        double percent = percent(trucks, cars, suvs);
        String dots = dots(trucks);
        System.out.println(year + " " + dots + percentf.format(percent));
    }
    public static void suvs(int year, int cars, int trucks, int suvs,DecimalFormat percentf) {

        double percent = percent(suvs, trucks, cars);
        String dots = dots(suvs);
        System.out.println(year + " " + dots + percentf.format(percent));
    }
    
    public static void chart(int year, int cars, int trucks, int suvs,DecimalFormat percentf) {
        System.out.println(""
                + year + " C " + dots(cars) + percentf.format(percent(cars, trucks, suvs))
                + "\n" + year + " T " + dots(trucks) + percentf.format(percent(trucks, cars, suvs))
                + "\n" + year + " S " + dots(suvs) + percentf.format(percent(suvs, trucks, cars))
        );
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice = 0;
        int year = 0;
        int cars = 0;
        int trucks = 0;
        int suvs = 0;
        double percent = 0;
        String dots = "";
        DecimalFormat percentf = new DecimalFormat("###%");
        
        while (choice != 5) {
            choice = displayMenu();
            if (choice == 1) {
                System.out.println("\tNumber of Cars");
            } else if (choice == 2) {
                System.out.println("\tNumber of Trucks");
            } else if (choice == 3) {
                System.out.println("\tNumber of SUVs");
            } else if (choice == 4) {
                System.out.println("\tComparison Chart");
            }
            try {
                File f = new File("src/masonmethodstest/motors.txt");
                Scanner s = new Scanner(f);
                while (s.hasNextLine()) {

                    year = Integer.parseInt(s.nextLine());
                    cars = Integer.parseInt(s.nextLine());
                    trucks = Integer.parseInt(s.nextLine());
                    suvs = Integer.parseInt(s.nextLine());
                    if (choice == 1) {
                        cars(year, cars, trucks, suvs, percentf);
                    } else if (choice == 2) {
                        trucks(year, cars, trucks, suvs, percentf);
                    } else if (choice == 3) {
                        suvs(year, cars, trucks, suvs, percentf);
                    } else {
                        chart(year, cars, trucks, suvs, percentf);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e);
            }

        }

    }

}
