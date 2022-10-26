/*
Roan Mason
05/13/22

Ask the user for 5 names of cities. Store these values in an array. 
Print these cities out in reverse order.
*/
package mason1darrayexercise1;

import javax.swing.JOptionPane;

public class Mason1DArrayExercise1 {
    
    public static String stringInput(String msg) {
        String response = JOptionPane.showInputDialog(msg);
        return response;
    }
    
    public static void output(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static String[] loadArray() {
        String cities[] = new String[5];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = stringInput("Enter a city #"+(i+1));
        }
        return cities;
    }
    
    public static void printArray(String cities[]) {
        String msg = "";
        for (int i = 4; i >= 0; i--) {
            msg += cities[i] + "\n";
        }
        output(msg);
    }
    
    public static void main(String[] args) {
        String cities[] = loadArray();
        printArray(cities); 
        
    }
    
}
