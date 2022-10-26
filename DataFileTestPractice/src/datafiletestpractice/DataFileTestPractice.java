/*
Roan Mason
04/19/22

At the end of the NHL season, awards are given out to the players who have scored the 
most goals (Rocket Richard Trophy), who have the best plus/minus (Selke Trophy) and who 
have the least penalty minutes (Lady Byng Award). Create a data file with 5 records, 
containing the following 6 fields: name, goals, goals on for, goals on against, shots, 
and penalty minutes.

Create a report based on the data file
*/
package datafiletestpractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataFileTestPractice {

    public static void main(String[] args) {
        
        String rocket = "";
        int savedGoals = 0;
        String selke = "";
        int savedPlusMinus = Integer.MIN_VALUE;
        String ladyByng = "";
        int savedPenaltyMinutes = Integer.MAX_VALUE;
        
        
        try {
            File f = new File("src/datafiletestpractice/DataFileReview.txt");
            Scanner s = new Scanner(f);
            System.out.println("Name\t\tGoals\tPlus/Minus\tShooting %\tPenalty Minutes");
            while (s.hasNextLine()) {
                String name = s.nextLine();
                int goals = Integer.parseInt(s.nextLine());
                int goalsOnFor = Integer.parseInt(s.nextLine());
                int goalsOnAgainst = Integer.parseInt(s.nextLine());
                int shots = Integer.parseInt(s.nextLine());
                int penaltyMinutes = Integer.parseInt(s.nextLine());
                int plusMinus = goalsOnFor - goalsOnAgainst;
                int shooting = 100*goals/shots;
                System.out.println(name+"\t"+goals+"\t"+plusMinus+"\t\t"+shooting+"\t\t"+penaltyMinutes);
                if (goals > savedGoals) {
                    savedGoals = goals;
                    rocket = name;
                }
                if (plusMinus > savedPlusMinus) {
                    savedPlusMinus = plusMinus;
                    selke = name;
                }
                if (penaltyMinutes < savedPenaltyMinutes) {
                    savedPenaltyMinutes = penaltyMinutes;
                    ladyByng = name;
                }
            }
            
            System.out.println("\nMaurice \"Rocket\" Richard Winner: " + rocket
            +"\nSelke Winner: " + selke
            +"\nLady Byng Winner: " + ladyByng);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: "+e);
        }
        
        
    }
    
}
