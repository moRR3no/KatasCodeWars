package _8kyu;

import java.util.Arrays;

/**
 * Given an array of integers.
 * <p>
 * Return an array, where the first element is the count of positives numbers and the second element is sum of
 * negative numbers. 0 is neither positive nor negative.
 * <p>
 * If the input is an empty array or is null, return an empty array.
 * <p>
 * Example
 * For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you should return [10, -65].
 */

//Level of difficulty: 8kyu
public class CountPositivesNegatives {
    public static void main(String[] args) {
        int[] expectedResult = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
        System.out.println(Arrays.toString(countPositivesSumNegatives(expectedResult)));
        expectedResult = new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
        System.out.println(Arrays.toString(countPositivesSumNegatives(expectedResult)));
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length==0) return new int[]{};
        int positivesCount = 0;
        int sumNegatives = 0;
        for (int element : input) {
            if (element > 0) positivesCount++;
            if (element < 0) sumNegatives += element;
        }
        return new int[]{positivesCount,sumNegatives};
    }

    //My solution is also best practice
}
