/*
Roan Mason
03/21/2022

Write a program that calculates the user’s Environmental Impact Index. Ask the user to enter the 
number of electronic devices in their household and the average age of the devices. The EII can be 
found by first dividing the number of devices by the average age of each device, and then multiplying 
by 10. Tell the user if their environmental impact is minimal (<5), average (5 to less than 15), high 
(15 to less than 30), or excessive (30+). Also output a helpful message to the user.*
*/
package ifexercise4;

import javax.swing.JOptionPane;

public class IfExercise4 {

    public static void main(String[] args) {
        
        //ask user for their amount of devices and the average time owned
        double numOfDevices = Double.parseDouble(JOptionPane.showInputDialog("Enter the number of devices in your household.\nExamples of devices include: PC's, laptops, tablets, phones, gaming systems, etc"));
        double avgDeviceAge = Double.parseDouble(JOptionPane.showInputDialog("On average, how many years old is each device?"));
        //calculate EII by divding the number of devices by average age then multiplying by 10
        double impactRating = (numOfDevices/avgDeviceAge) * 10;
        
        //initiate variables
        String impact = "";
        String advice = "";
        
        if (impactRating<5){ //minimal less than 5
            //set the rating 
            impact = "minimal";
            //add advice
            advice = "continue to keep your older devices.";
        } else if (impactRating<15){ //average 5 to less than 15
            impact = "average";
            advice = "consider keeping your devices longer to reduce your environmental impact.";
        } else if (impactRating<30){ //high 15 to less than 30
            impact = "high";
            advice = "don't buy any new devices and repair any that break instead.";
        } else { //excessive more than 30
            impact = "excessive";
            advice = "consider holding onto your devices longer or repairing them instead of buying new ones.";
        }
        //give the user advice and their EII rating
        JOptionPane.showMessageDialog(null, "Your Environmental Impact Index is "+impact+".\n Here's some advice, "+advice);
        
    }
    
}
