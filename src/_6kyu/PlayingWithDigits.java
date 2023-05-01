package _6kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Some numbers have funny properties. For example:
 * <p>
 * 89 --> 8¹ + 9² = 89 * 1
 * <p>
 * 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
 * <p>
 * 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 * <p>
 * Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p
 * <p>
 * we want to find a positive integer k, if it exists, such that the sum of the digits of n taken to the successive
 * powers of p is equal to k * n.
 * In other words:
 * <p>
 * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
 * <p>
 * If it is the case we will return k, if not return -1.
 * <p>
 * Note: n and p will always be given as strictly positive integers.
 * <p>
 * digPow(89, 1) should return 1 since 8¹ + 9² = 89 = 89 * 1
 * digPow(92, 1) should return -1 since there is no k such as 9¹ + 2² equals 92 * k
 * digPow(695, 2) should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
 * digPow(46288, 3) should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 */


//Level of difficulty: 6kyu
public class PlayingWithDigits {
    public static void main(String[] args) {
        System.out.println(digPow(46288, 3));

    }

    public static long digPow(int n, int p) {
        List<String> numStrList = new ArrayList<String>(Arrays.asList(String.valueOf(n).split("")));
        long sum = 0;
        for (String num : numStrList) {
            sum += Math.pow(Double.parseDouble(num), p);
            p++;
        }
        return sum % n == 0 ? sum / n : -1;
    }

    public static long digPowBestPractice(int n, int p) {
        String intString = String.valueOf(n);
        long sum = 0;
        for (int i = 0; i < intString.length(); ++i, ++p)
            sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
        return (sum % n == 0) ? sum / n : -1;
    }
}
