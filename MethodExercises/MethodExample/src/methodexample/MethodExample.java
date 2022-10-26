/*
Roan Mason
04/29/22
Method example Video
*/
package methodexample;

public class MethodExample {
    
    public static void newLine() {
        System.out.println("");
    }
    
    public static void threeLines() {
        newLine();
        newLine();
        newLine();
    }
    
    public static void main(String[] args) {
        System.out.println("First Line");
        threeLines();
        threeLines();
        threeLines();
        System.out.println("Second Line");
    }
    
}
