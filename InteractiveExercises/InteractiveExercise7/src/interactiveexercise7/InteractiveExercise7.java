/*
Roan Mason
02/14/2022

Write a program that prompts the user for the election results that each 
candidate received in each province (6 prompts total), and displays the results 
of the election.
*/

package interactiveexercise7;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class InteractiveExercise7 {

    public static void main(String[] args) {
        
        //Ask user for Cutten's(c) votes in Ontario, PEI and Quebec
        double cVotes1 = Double.parseDouble(JOptionPane.showInputDialog("How many votes did Cutten recive in Ontario?"));
        double cVotes2 = Double.parseDouble(JOptionPane.showInputDialog("How many votes did Cutten recive in Prince Edward Island?"));
        double cVotes3 = Double.parseDouble(JOptionPane.showInputDialog("How many votes did Cutten recive in Quebec?"));
        //Ask user for Treiguts'(t) votes in Ontario, PEI and Quebec
        double tVotes1 = Double.parseDouble(JOptionPane.showInputDialog("How many votes did Treiguts recive in Ontario?"));
        double tVotes2 = Double.parseDouble(JOptionPane.showInputDialog("How many votes did Treiguts recive in Ontario?"));
        double tVotes3 = Double.parseDouble(JOptionPane.showInputDialog("How many votes did Treiguts recive in Quebec?"));
        //Calculate total votes and total votes for each party
        double cTotal = cVotes1 + cVotes2 + cVotes3;
        double tTotal = tVotes1 + tVotes2 + tVotes3;
        double totalVotes = cTotal + tTotal;
        //Calculate percentage for total votes for each party
        double cVotesPercent = cTotal/totalVotes;
        double tVotesPercent = tTotal/totalVotes;
        //Create percentage format
        DecimalFormat percent = new DecimalFormat("##.#%");
        DecimalFormat number = new DecimalFormat("#,###.##");
        
        //Final ouput detailing total votes from each party and percentage of total
        JOptionPane.showMessageDialog(null, ("There were "+number.format(totalVotes)+" votes cast."
                +"\nCutten received "+number.format(cTotal)+" which is "+percent.format(cVotesPercent)
                +"\nTreiguts received "+number.format(tTotal)+" which is "+percent.format(tVotesPercent)
                
                ));
        
    }
    
}
