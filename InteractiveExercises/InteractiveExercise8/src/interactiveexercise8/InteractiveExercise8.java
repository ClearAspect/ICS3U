/*
Roan Mason
02/14/2022

Create a Sleep application that calculates the number of hours of your life that 
you have spent sleeping. Assume you sleep for 8 hours a night. To simplify the 
problem, assume that there are 30 days in each month and 365 days in each year.
*/

package interactiveexercise8;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class InteractiveExercise8 {

    public static void main(String[] args) {
        //Asks the user for the date they were born and the current date in the form of numbers
        //Also converts the string into a double
        int birthYear = Integer.parseInt(JOptionPane.showInputDialog("Enter the year you were born please:"));
        int birthMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter the month you were born please (as a number):"));
        int birthDay = Integer.parseInt(JOptionPane.showInputDialog("Enter the day you were born please:"));
        int currentYear = Integer.parseInt(JOptionPane.showInputDialog("Enter the current year please:"));
        int currentMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter the current month please (as a number):"));
        int currentDay = Integer.parseInt(JOptionPane.showInputDialog("Enter the current day please:"));
        
        //Declaring the time sleeping each night as always 8 hours
        final int hoursSlept = 8;
        
        //calculate the days in between the current and birth years and months
        int daysInYears = (currentYear-birthYear)*365;
        int daysInMonths = (currentMonth-birthMonth)*30;
        int differenceInDays = currentDay-birthDay;
        //Add up the values for total days alive
        int totalDays = daysInYears+(daysInMonths+differenceInDays);
        //Each day you sleep 8 hours(days * Hours Slept)
        int totalHours = totalDays * hoursSlept;
        
        DecimalFormat number = new DecimalFormat("#,###.##");
        
        JOptionPane.showMessageDialog(null, ("If you were born: "+birthYear+"-"+birthMonth+"-"+birthDay
                +"\nand today is: "+currentYear+"-"+currentMonth+"-"+currentDay
                +"\nThen you have been alive for "+number.format(totalDays)+" days,"
                +"\nand you have slept for "+number.format(totalHours)+" hours"
        
        
        ));
        
        
    }
    
}
