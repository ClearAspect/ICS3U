
package wordproblem6;

import java.text.DecimalFormat;

public class WordProblem6 {

    public static void main(String[] args) {
        
        double originCost = 62.99;
        double finalCost = 71.81;
        double amountOfTax = finalCost-originCost;
        double taxRate = (finalCost/originCost)-1;
        
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        DecimalFormat percent = new DecimalFormat("##.0%");
        
        System.out.println("Original Cost\t\t" + money.format(originCost));
        System.out.println("Final Cost\t\t" + money.format(finalCost));
        System.out.println("Amount of Tax\t\t" + money.format(amountOfTax));
        System.out.println("Rate of Tax\t\t" + percent.format(taxRate));
        
        
    }
    
}
