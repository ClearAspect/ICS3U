/*
Roan Mason
05/20/22

Declare a 2D array with 7 rows and 7 columns. Initialize each element to a 
random number between 1 and 7. Print the array in grid form, as well as the sum 
of the numbers in each row.
 */
package mason2darrayexercise2;

public class Mason2DArrayExercise2 {

    public static void main(String[] args) {
        int grid[][] = new int[7][7];

        loadArray(grid);
        printArray(grid);

    }

    public static int randNum() {
        int randNum = (int) (Math.random() * 7) + 1;
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
        int sum = 0;
        for (int x = 0; x < grid.length; x++) {
            sum = 0;
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(grid[x][y] + " ");
                sum += grid[x][y];
            }
            System.out.print("= "+sum+"\n");
        }
    }
}
