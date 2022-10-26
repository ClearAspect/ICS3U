/*
Roan Mason
05/24/22


 */
package mason2dexercise6;

public class Mason2DExercise6 {

    public static void main(String[] args) {
        int grid[][] = new int[10][10];

        loadArray(grid);
        printArray(grid);

    }

    private static void loadArray(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (x == 0 || y == 0) {
                    grid[x][y] = 1;
                } else {
                    grid[x][y] = grid[x - 1][y] + grid[x][y - 1];

                }
            }
        }
    }

    private static void printArray(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(grid[x][y] + "\t");
            }
            System.out.println("");
        }
    }
}
