/**
 * Given an array of integers, find the one that appears an odd number of times.
 *
 * There will always be only one integer that appears an odd number of times.
 *
 * Examples
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 */

//Level of difficulty: 6kyu
public class FindOdd {
    public static void main(String[] args) {
        int[] intSrr = {2,3,4,5,6,2,2,6,5,4,3};
        System.out.println(findIt(intSrr));
    }

    public static int findIt(int[] intArr) {
        int count;
        int intReturned =0;
        for (int i1 : intArr) {
            count = 0;
            for (int i2 : intArr) {
                if (i1==i2) count++;
            }
            if ((count) % 2 != 0) {
                intReturned = i1;
                break;
            }
        }
        return intReturned;
    }

    public static int findItBestPractice(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;
    }
}
