
package wordproblem5;

import java.text.DecimalFormat;

public class WordProblem5 {

    public static void main(String[] args) {
        
        double totalHours = 52.0;
        double regHours = 40.0;
        double otHours = totalHours-regHours;
        double regRate = 9.58;
        double otRate = regRate*1.5;
        double totalRegPay = regRate*regHours;
        double totalOtPay = otRate*otHours;
        double totalPay = totalRegPay+totalOtPay;
        DecimalFormat money = new DecimalFormat("$#,##0.00");
        
        System.out.println("Total hours\t\t" + totalHours);
        System.out.println("Regular hours\t\t" + regHours);
        System.out.println("OT hours\t\t" + otHours);
        System.out.println("Regular rate\t\t" + money.format(regRate));
        System.out.println("OT rate\t\t\t" + money.format(otRate));
        System.out.println("Total Regular Pay\t" + money.format(totalRegPay));
        System.out.println("Total OT Pay\t\t" + money.format(totalOtPay));
        System.out.println("Total Pay\t\t" + money.format(totalPay));
        
        
    }
    
}
