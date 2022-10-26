/*
Roan Mason
04/29/22

Write a program that draws a house like the one below. Break the house up into three  
separate methods; addRoof(), addBase(), and addWalk().
*/
package masonmethodexercise1;


public class MasonMethodExercise1 {

    public static void addRoof() {
        System.out.println("   /\\");
        System.out.println("  /  \\");
        System.out.println(" /    \\");
        System.out.println("/______\\");
    }
    public static void addBase() {
        System.out.println("|      |");
        System.out.println("|  ___ |");
        System.out.println("|  | | |");
        System.out.println("|__| |_|");
    }
    public static void addWalk() {
        System.out.println("   ***");
        System.out.println("   *************");
    }
    
    
    public static void main(String[] args) {
        addRoof();
        addBase();
        addWalk();
    }
    
}
