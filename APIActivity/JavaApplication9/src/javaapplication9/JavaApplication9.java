/*
Roan Mason
05/09/22

Ask the user for the date (day, month, year). Inform them if the date that they entered 
is in the past, the present, or the future. Look at the API for the Calendar class to 
find an easy way to do this.
*/
package javaapplication9;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class JavaApplication9 {
    
    
    public static int getIntNum(String msg) {
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return num;
    }
    
    public static void output(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void main(String[] args) {
        int month = getIntNum("Enter the month");
        month--;
        int day = getIntNum("Enter the day");
        int year = getIntNum("Enter the year");
        
        Calendar userDate = Calendar.getInstance();
        userDate.set(year,month,day);
        Calendar now = Calendar.getInstance();
        
        int difference = now.compareTo(userDate);
        if (difference == 0) {
            output("Same");
        } else if (difference < 0) {
            output("Future");
        } else {
            output("Past");
        }

        
    }
    
}
