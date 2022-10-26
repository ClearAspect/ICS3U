
package wordproblem7;

import java.text.DecimalFormat;

public class WordProblem7 {

    public static void main(String[] args) {
        
        double costOfJeans = 24.99;
        double discount = 0.30;
        double amountOfDiscount = costOfJeans*discount;
        double totalCost = costOfJeans-amountOfDiscount;
        
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        DecimalFormat percent = new DecimalFormat("##.0%");
        
        System.out.println("Cost of jeans\t\t" + money.format(costOfJeans));
        System.out.println("Rate of discount\t" + percent.format(discount));
        System.out.println("Amount of discount\t" + money.format(amountOfDiscount));
        System.out.println("Total cost of jeans\t" + money.format(totalCost));
        
    }
    
}
