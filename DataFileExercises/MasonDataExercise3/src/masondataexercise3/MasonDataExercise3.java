/*
Roan Mason
04/07/22

The table below gives the distribution of the Canadian population in thousands by 
age and fan base.  Write a program to produce the table shown below.  For each age 
group, the column labeled %Leafs gives the percentage of the people in that age group 
that are Leafs fans, similarly for the column labeled %Habs.
*/
package masondataexercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class MasonDataExercise3 {

    public static void main(String[] args) {
        
        //initialize variables 
        String ageGroup;
        double leafsFans, habsFans, totalFans, pLeafs, pHabs;
        //Formating for numbers
        DecimalFormat percent = new DecimalFormat("##.##%");
        DecimalFormat people = new DecimalFormat("#,###");
        
        try {
            File f = new File("src/masondataexercise3/HockeyFanData.txt"); //load file
            Scanner s = new Scanner(f); //Apply scanner to file
            System.out.println("Age Group\tLeafs Fans\tHabs Fans\t%Leafs\t\t%Habs"); //create begining of table
            while (s.hasNextLine() == true) { //while there are more lines in the data file
                ageGroup = s.nextLine(); //first line is age group
                leafsFans = Double.parseDouble(s.nextLine()); //second line is # of leafs fans
                habsFans = Double.parseDouble(s.nextLine()); //third line is # of habs fans
                totalFans = leafsFans + habsFans; //calculate total fans
                pLeafs = leafsFans/totalFans; //calculate percent of leafs fans
                pHabs = habsFans/totalFans; //calculate percent of habs fans
                //output line in the table
                System.out.println(ageGroup+"\t"+people.format(leafsFans)+"\t\t"+people.format(habsFans)+"\t\t"+percent.format(pLeafs)+"\t\t"+percent.format(pHabs));
            }

        } catch (FileNotFoundException e) { //if file is not found
            System.out.println("Error: "+e); //send error message
        }
        
    }
    
}
