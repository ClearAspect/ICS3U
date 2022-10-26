/*
Roan Mason
02/14/2022

Create a Spending application to help examine the spending patterns of a user. 
The application should prompt the user for the amount spent monthly on food, 
clothing, entertainment, and rent, and then display a message showing the 
percentage of expenditures in each category. 
*/

package interactiveexercise6;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class InteractiveExercise6 {
    
    public static void main(String[] args) {
        
        //Declare variables for expenses, ask user for a value and parse the string into a double
        double foodCost = Double.parseDouble(JOptionPane.showInputDialog("How much do you spend monthly on food?"));
        double clothingCost = Double.parseDouble(JOptionPane.showInputDialog("How much do you spend monthly on clothing?"));
        double entertainCost = Double.parseDouble(JOptionPane.showInputDialog("How much do you spend monthly on entertainment?"));
        double rentCost = Double.parseDouble(JOptionPane.showInputDialog("How much do you spend monthly on rent?"));
        //total expense
        double totalCost = foodCost + clothingCost + entertainCost + rentCost;
        
        //Declare variables for the percentage of total expense each value is equal to
        double foodPercent = foodCost / totalCost;
        double clothingPercent = clothingCost / totalCost;
        double entertainPercent = entertainCost / totalCost;
        double rentPercent = rentCost / totalCost;
        
        //setup money and percent formating
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        DecimalFormat percent = new DecimalFormat("##.#%");
        
        
        //Final output for the user that shows how much the user spends monthly(including calculated percentages)
        JOptionPane.showMessageDialog(null, ("You spend a total of "+money.format(totalCost)+" per month.\n\n Here's how it breaks down:\n"
                +"\nFood: "+money.format(foodCost)+" = "+percent.format(foodPercent)
                +"\nClothing: "+money.format(clothingCost)+" = "+percent.format(clothingPercent)
                +"\nEntertainment: "+money.format(entertainCost)+" = "+percent.format(entertainPercent)
                +"\nRent: "+money.format(rentCost)+" = "+percent.format(rentPercent)
                
                ));
        
        
        
    }
    
}
