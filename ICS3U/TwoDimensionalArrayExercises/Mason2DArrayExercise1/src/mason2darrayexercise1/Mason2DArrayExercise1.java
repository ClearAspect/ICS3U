/*
Roan Mason
05/20/22

Declare a 2D array with 5 rows and 5 columns. Initialize each element to a 
random number between 1 and 5. Print the array in grid form.
*/
package mason2darrayexercise1;

public class Mason2DArrayExercise1 {

    
    public static void main(String[] args) {
        int grid[][] = new int[5][5];
        
        loadArray(grid);
        printArray(grid);
        
    }
    
    public static int randNum() {
        int randNum = (int)(Math.random()*5)+1;
        return randNum;
    }
    
    private static void loadArray(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = randNum();
            }
        }
    }
    
    private static void printArray(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(grid[x][y]+" ");
            }
            System.out.println("");
        }
    }
    
}
