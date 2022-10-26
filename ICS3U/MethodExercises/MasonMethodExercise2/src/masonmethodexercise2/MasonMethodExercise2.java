/*
Roan Mason
04/29/22

Write a method called drawBar() that prints a single line of a bar graph representing 
city population (i.e Guelph*********). Prompt the user for the name of a city and its 
population in the main method then invoke your drawBar() method twice in your main 
method. You’ll need to make the city name and population global variables in your program.
*/
package masonmethodexercise2;

import javax.swing.JOptionPane;

public class MasonMethodExercise2 {
    
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
        
        for (int i = 0; i < 2; i++) {
            city = JOptionPane.showInputDialog("Enter the city");
            population = Integer.parseInt(JOptionPane.showInputDialog("Enter the population of "+city));
            drawBar();
        }
        
    }
    
}
