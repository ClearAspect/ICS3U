
package wordproblem4;

import java.text.DecimalFormat;

public class WordProblem4 {
     
    public static void main(String[] args) {
        
        double num1 = 70.0;
        double percent1 = 0.10;
        double ans1 = num1*percent1;
        
        double num2 = 25.0;
        double percent2 = 0.20;
        double ans2 = num2*percent2;
        
        double num3 = 60.0;
        double percent3 = 0.05;
        double ans3 = num3*percent3;
        
        DecimalFormat percent = new DecimalFormat("##.0%");

        System.out.println(percent.format(percent1) + " of " + num1 + " is " + ans1);
        System.out.println(percent.format(percent2) + " of " + num2 + " is " + ans2);
        System.out.println(percent.format(percent3) + " of " + num3 + " is " + ans3);
        
        
        
    }
    
}
