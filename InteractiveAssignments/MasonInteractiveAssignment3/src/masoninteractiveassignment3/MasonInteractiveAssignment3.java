/*
Roan Mason
02/16/2022

The American College of Sports Medicine recommends that you maintain your training
heart rate during an aerobic workout.  Your training heart rate is computed as
0.7 x (220 - a ) + 0.3 x r  
where a is your age and r is your resting heart rate (your pulse when you first 
awaken). Write a program to request a person’s age and resting heart rate and 
then calculate the training heart rate.   
*/

package masoninteractiveassignment3;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MasonInteractiveAssignment3 {

    public static void main(String[] args) {
        
        //ask the user to input their age and their resting heart rate
        int age = Integer.parseInt(JOptionPane.showInputDialog("Please enter your age:"));
        int restingHR = Integer.parseInt(JOptionPane.showInputDialog("Please enter your resting heart rate:"));
        
        //Use formula from question to calculate the users training heart rate
        double trainingHR = ((0.7)*(220-age)) + ((0.3)*restingHR);
        
        //Create format so that double variables display without decimals
        DecimalFormat number = new DecimalFormat("#,###"); 
        
        JOptionPane.showMessageDialog(null, ("Age:   " + age
                +"\nResting heart rate:   " + restingHR
                +"\nTraining heart rate:   " + number.format(trainingHR)
        
        ));
        
    }
    
}
