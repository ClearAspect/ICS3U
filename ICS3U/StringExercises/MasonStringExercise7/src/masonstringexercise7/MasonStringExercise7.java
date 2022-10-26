/*

 */
package masonstringexercise7;

import java.util.Scanner;

public class MasonStringExercise7 {

    public static void main(String[] args) {

        String input = "";
        Scanner s = new Scanner(System.in);
        String tester = "";
        boolean dupledrome;
        
        while (!input.equalsIgnoreCase("exit")) {
            dupledrome = true;
            System.out.println("Please enter a word (\"exit\" will exit)");
            input = s.nextLine();

            if (!input.equalsIgnoreCase("exit")) {
                for (int i = 0; i < input.length(); i++) {
                    tester = "";
                    tester += "" + input.charAt(i) + input.charAt(i);
                    if (input.indexOf(tester) == -1) {
                        dupledrome = false;
                    }
                }

                if (dupledrome == true) {
                    System.out.println(input + " is most definitely a dupledrome.");
                } else {
                    System.out.println(input + " is most definitely NOT a dupledrome.");

                }

            } else {
                System.out.println("Exiting...");
            }
        }

    }

}
