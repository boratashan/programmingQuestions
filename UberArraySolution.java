import java.util.Arrays;
import java.util.Random;

/*
Given an array of integers, return a new array such that each element at index i 
of the new array is the product of all the numbers in the original array except 
the one at i.
*/
public class UberArraySolution {

    static int[] source = new int[5];
    static int[] newArray = new int[5];

    static {
        Random random = new Random();
        for (int i = 0; i < source.length; i++)
            source[i] = random.nextInt(10);
    }
    

    private static void printLine(String line) {
        System.out.println(line);
    }

    private static void doProcess() {
        int total = 1;
        int numberOfZeros = 0;
        Arrays.fill(newArray, 0);
        for (int i = 0; i < source.length; i++) {
            int val = source[i];
            total *= val == 0 ? 1 : val;
            numberOfZeros += val == 0 ? 1 : 0;
        }
        if (numberOfZeros <= 1) {
            for (int i = 0; i < source.length; i++) {
                int val = source[i];
                if (val != 0) {
                    if (numberOfZeros == 0) {
                        newArray[i] = total / val;
                    } else {
                        newArray[i] = 0;
                    }
                }
                else {
                    newArray[i] = numberOfZeros==1?total:0;
                }
            }
        }
    }

    public static void main(String[] args) {
        doProcess();
        printLine(Arrays.toString(source));
        printLine(Arrays.toString(newArray));
    }

}