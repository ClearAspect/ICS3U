
package wordproblem3;

import java.text.DecimalFormat;

public class WordProblem3 {

    public static void main(String[] args) {
        
        int totalWidgets = 1022957;
        int numberInPack = 12;
        int totalBoxes = totalWidgets/numberInPack;
        int amountInBox = totalWidgets%numberInPack ;
        DecimalFormat thousand = new DecimalFormat("###,###,###");
        
        
        System.out.println("Total widgets\t\t" + thousand.format(totalWidgets));
        System.out.println("Number in pack\t\t" + thousand.format(numberInPack));
        System.out.println("Total Boxes\t\t" + thousand.format(totalBoxes));
        System.out.println("Amount in partial pack\t" + thousand.format(amountInBox));
        
        
    }
    
}
