/*
Roan Mason
05/19/22

Create an array which will store 10000 integers. Populate it with random numbers
between 1 and 100. Calculate and display the mean, median and mode.
*/
package mason1darrayexercise8;

import java.util.Arrays;

public class Mason1DArrayExercise8 {
    
    public static int randNum() {
        int randNum = (int)(Math.random()*100)+1;
        return randNum;
    }
    
    private static int loadArray(int numbers[]) {
        int sum = 0;
        int randomNumber;
        for (int i = 0; i < numbers.length; i++) {
            randomNumber = randNum();
            numbers[i] = randomNumber;
            sum += randomNumber;
        }
        Arrays.sort(numbers);
        return sum;
    }
    
    private static void mean(int numbers[], int sum) {
        double mean = (double)sum/numbers.length;
        System.out.println("Mean: "+mean);
    }

    private static void median(int numbers[]) {
        int index = ((numbers.length)+1)/2;
        int median = numbers[index-1];
        System.out.println("Median: "+median);
    }
    
    private static void mode(int numbers[]) {
        int count2 = 0;
        int count1 = 0;
        int popular1 = 0;
        int popular2 = 0;

        for (int x = 0; x < numbers.length; x++) {
            popular1 = numbers[x];
            count1 = 0;

            for (int y = x + 1; y < numbers.length; y++) {
                if (popular1 == numbers[y]) {
                    count1++;
                }
            }

            if (count1 > count2) {
                popular2 = popular1;
                count2 = count1;
            } else if (count1 == count2) {
                popular2 = Math.min(popular2, popular1);
            }
        }

        System.out.println("Mode: "+popular2);
    }


    public static void printArray(int numbers[]) {
        String msg = "";
        for (int i = 0; i < numbers.length; i++) {
            msg += numbers[i] + ", ";
        }
        System.out.println(msg+"\n");
    }
    
    public static void main(String[] args) {
        int numbers[] = new int[25];
        
        int sum = loadArray(numbers);
        printArray(numbers);
        System.out.println("Sum: "+sum);
        
        mean(numbers, sum);
        median(numbers);
        mode(numbers);
        
        
        
    }
    
}
