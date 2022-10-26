/*
Roan Mason
05/20/22

Declare a 2D array with 8 rows and 8 columns. Initialize each element to a 
random number between 1 and 8. Print the array in grid form, as well as the sum 
of the numbers in each column. Hint: use a one dimensional array to store the 
sum of each column!
*/
package mason2darrayexercise5;

public class Mason2DArrayExercise5 {

    public static void main(String[] args) {
        int grid[][] = new int[8][8];
        int sum[] = new int[grid[0].length];
        
        loadArray(grid, sum);
        printArray(grid, sum);

    }
    
    /**
     * Create random number between 1 - 8
     * 
     * @return - an integer
     */
    public static int randNum() {
        int randNum = (int) (Math.random() * 8) + 1;
        return randNum;
    }
    
    /**
     * load 2D array with random numbers
     * 
     * @param grid - 2D array that contains random values
     * @param sum - 1D array containing sum of each column in grid
     */
    private static void loadArray(int[][] grid, int[] sum) {
        int num; 
        for (int x = 0; x < grid.length; x++) { //for each 1st dimension x
            for (int y = 0; y < grid[x].length; y++) { //for each 2nd dimension y
                num = randNum(); //generate random number
                grid[x][y] = num; //put number into next empty grid space
                sum[y] += num; //add number to correct sum. sum[y] because y = column number of grid
            }
        }
        
        
        
    }
    
    /**
     * print out array and sum of each column
     * 
     * @param grid - 2D array that contains random values
     * @param sum - 1D array containing sum of each column in grid
     */
    private static void printArray(int[][] grid, int[] sum) {
        //print out grid in grid format
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                //create row
                System.out.print(grid[x][y]+"\t");
            }
            System.out.println(""); //new line after row is completed
        }
        
        for (int x = 0; x < grid.length; x++) {
            //add underscores between numbers and sum
            System.out.print("_\t");
        }
        System.out.println(""); //new line after row is completed
        
        for (int x = 0; x < grid.length; x++) {
            //add sums under the under the underscores
            System.out.print(sum[x]+"\t");
        }
        System.out.println(""); //new line after row is completed
    }
    
}
