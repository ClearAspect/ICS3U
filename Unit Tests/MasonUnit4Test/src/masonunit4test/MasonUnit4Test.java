/*
Roan Mason
04/21/22

Unit 4 Test https://docs.google.com/document/d/1_z8SGoLiUlzzQhbWNnVxOln2fvvkq3GHmPZOQOLYOBU/edit?usp=sharing
 */
package masonunit4test;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MasonUnit4Test {

    public static void main(String[] args) {

        String selectedTeam = "";

        while (!selectedTeam.equals("DONE")) {
            int highScore = -1, lowScore = 301, loopCount = 0;
            String highName = "", lowName = "";

            selectedTeam = JOptionPane.showInputDialog("Which bowling team would you like to examine? (Done to exit)");

            try {
                File f = new File("src/masonunit4test/bowling.txt");
                Scanner s = new Scanner(f);

                if (selectedTeam.equals("DONE")) {
                    JOptionPane.showMessageDialog(null, "Arrivederci!");
                } else {
                    while (s.hasNextLine()) {
                        String name = s.nextLine();
                        String team = s.nextLine();
                        int score = Integer.parseInt(s.nextLine());
                        if (team.equals(selectedTeam)) {
                            loopCount++;
                            if (score > highScore) {
                                highScore = score;
                                highName = name;
                            }
                            if (score < lowScore) {
                                lowScore = score;
                                lowName = name;
                            }
                        }
                    }
                    if (loopCount == 0) {
                        JOptionPane.showMessageDialog(null, "That team was not found. Sorry!");
                    } else {
                        JOptionPane.showMessageDialog(null, selectedTeam + " found!"
                                + "\n-" + highName + " has the highest score on the team"
                                + "\n-" + lowName + " has the lowest score on the team");
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e);
            }

        }

    }
}
