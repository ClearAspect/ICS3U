/*
Roan Mason
03/04/2022

You are offered two salary options for 10 days of work. Option 1: $100 per day. 
Option 2: $1 the first day, $2 the second day, $4 the third day, and so on, with 
the amount doubling each day. Write a program that will display a chart 
displaying the total pay so far each day so that you may choose the best method.
*/
package masonloopassn7;

import java.text.DecimalFormat;

public class MasonLoopAssn7 {

    public static void main(String[] args) {
        
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        
        double option1 = 100;
        double option2 = 1;
        int day = 1;
        
        String finalOutput = "Day\t\tOption 1\t\tOption 2";
        finalOutput += "\n"+day+"\t\t"+money.format(option1)+"\t\t\t"+money.format(option2); 
                
        while (option1 > option2){
            day++;
            option1 += 100;
            option2 = option2*2;
            finalOutput += "\n"+day+"\t\t"+money.format(option1)+"\t\t\t"+money.format(option2);
        }
        System.out.println(finalOutput);
        
    }
    
}
