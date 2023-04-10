import java.util.Arrays;
import java.util.HashMap;

/**
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 * <p>
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * It’s guaranteed that array contains at least 3 numbers.
 * <p>
 * The tests contain some very huge arrays, so think about performance.
 */


//Level of difficulty: 6kyu
public class FindUniqueNumber {

    public static double findUniq(double arr[]) {
        double notUniqueNum;
        int i = 0;

        if (arr[i] == arr[i + 1]) {
            notUniqueNum = arr[i];
        } else if (arr[i] == arr[i + 2]) {
            notUniqueNum = arr[i];
        } else {
            notUniqueNum = arr[i + 1];
        }

        HashMap<Double, Integer> hashmap = new HashMap<>();
        for (int j = 0; j < arr.length; j++) {
            hashmap.put(arr[j], j);
        }

        double returnNum = 0.0;
        for (double d : hashmap.keySet()) {
            if (d != notUniqueNum) returnNum = d;
        }
        return returnNum;
    }


    //Best practice
    public static double findUniqe(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }
}
