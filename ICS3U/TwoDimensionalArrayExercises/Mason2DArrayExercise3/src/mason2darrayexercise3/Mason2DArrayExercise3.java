/*
Roan Mason
05/20/22

Declare a 10 by 10 2D array. Initialize each element to a random number between 
1 and 100. Print the array in grid form, as well as the largest number in each row
 */
package mason2darrayexercise3;

public class Mason2DArrayExercise3 {

    public static void main(String[] args) {
        int grid[][] = new int[10][10];

        loadArray(grid);
        printArray(grid);

    }

    public static int randNum() {
        int randNum = (int) (Math.random() * 100) + 1;
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
        int greatest;
        for (int x = 0; x < grid.length; x++) {
            greatest = 0;
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(grid[x][y] + " ");
                if (grid[x][y] > greatest) {
                    greatest = grid[x][y];
                }
            }
            System.out.print(":   Largest Value = " + greatest + "\n");
        }
    }

}
