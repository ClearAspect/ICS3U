/*
Roan Mason
03/03/2022

The world population reached 7,571,689,185 in 2017 and is growing at some rate 
per year. Ask the user for the rate of growth and assuming that the population 
will continue to grow at the same rate, write a program that will determine in 
what year the world’s population will exceed 10 billion. Output a chart showing 
the population each year.
*/
package masonloopassn5;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonLoopAssn5 {

    public static void main(String[] args) {
        
        //ask the user for the rate of pop growth
        double rate = Double.parseDouble(JOptionPane.showInputDialog("What is the rate of growth of the world's population? (as a decimal ie 5% = 0.05)"));
        double population = 7571689185.0; //pop in 2017
        int year = 2017; //year as counter
        
        //number formating for percents and regular numbers
        DecimalFormat number = new DecimalFormat("#,###");
        DecimalFormat percent = new DecimalFormat("##0.0%");
        
        
        String growth = "\n" + year + "------>" + number.format(population); //text that gets added to the final message
        String finalMessage = "Year------>Population" + growth; //variable for final output
        
        
        while (population < 10000000000.0){ //Loop until pop reachs 10mil
            year++; //add to year each time
            population = population*(1+rate); //new population is the old one * the rate
            growth = "\n" + year + "------>" + number.format(population); //update text getting added to final message
            finalMessage += growth; //add new text to the final message
        }
        //final line of text
        finalMessage += "\nAt a growth rate of "+percent.format(rate)+" the world's population will reach 10 billion by the year "+year;
        JOptionPane.showMessageDialog(null, finalMessage); //finally output the text
    }
    
}
