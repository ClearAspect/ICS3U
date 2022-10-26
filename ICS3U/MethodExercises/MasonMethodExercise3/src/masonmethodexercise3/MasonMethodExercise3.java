/*
Roan Mason
04/29/22

Create a data file that contains a city name and a population. Use your drawBar() method from Q2! Make city name and population global variables in your program
 */
package masonmethodexercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MasonMethodExercise3 {

    static String city;
    static int population;

    public static void drawBar() {
        System.out.print(city);
        for (int i = 0; i < population; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        try {
            File f = new File("src/masonmethodexercise3/CityData.txt");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                city = s.nextLine();
                population = Integer.parseInt(s.nextLine());
                drawBar();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

    }

}
