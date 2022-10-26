/*
Roan Mason
03/25/22

Modify the following code segment to only use one if statement (one 'if' and one 'else if' clause). 
This will mean you need to use boolean logic! 
if(x > 10){  
   if(x < 20) {
	  System.out.println("a");
   }
}

if(x >= 20) {
   if(x < 30){
	  System.out.println("b");
   }
}

if(x < 0) {
    System.out.println("a");
}

a = >10,<20,<0
b = >=20,<30

*/
package ifexercise6;

import javax.swing.JOptionPane;

public class IfExercise6 {

    public static void main(String[] args) {
        
        int x = Integer.parseInt(JOptionPane.showInputDialog("Please enter an integer"));
        
        if ((x > 10 && x < 20) || (x < 0)) { //is the number between 10 and 20 or <0
            System.out.println("a");
        } else if (x >= 20 && x < 30) { //is the number between 20(inclusive) and 30
            System.out.println("b");
        }
        
        
    }
    
}
