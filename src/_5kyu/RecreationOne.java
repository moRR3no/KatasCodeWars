package _5kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1, 246, 2, 123, 3, 82, 6, 41 are the divisors of number 246. Squaring these divisors we get: 1, 60516, 4, 15129, 9,
 * 6724, 36, 1681. The sum of these squares is 84100 which is 290 * 290.
 * <p>
 * Task
 * Find all integers between m and n (m and n integers with 1 <= m <= n) such that the sum of their squared divisors
 * is itself a square.
 * <p>
 * We will return an array of subarrays or of tuples (in C an array of Pair) or a string. The subarrays (or tuples or
 * Pairs) will have two elements: first the number the squared divisors of which is a square and then the sum of the
 * squared divisors.
 * <p>
 * Example:
 * list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
 * list_squared(42, 250) --> [[42, 2500], [246, 84100]]
 * The form of the examples may change according to the language, see "Sample Tests".
 * <p>
 * Note
 * In Fortran - as in any other language - the returned string is not permitted to contain any redundant trailing
 * whitespace: you can use dynamically allocated character strings.
 */

//Level of difficulty: 5kyu
public class RecreationOne {

    public static void main(String[] args) {

        System.out.println(listSquared(1,250));


    }

    public static String listSquared(long m, long n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (long i = m; i <= n; i++) {
            if (isSumIsSquare(squareDividers(dividers(i)))) {
                long dividerFirst = i;
                long squareSum = sum(squareDividers(dividers(i)));
                stringBuilder.append("[" + dividerFirst + ", " + squareSum + "], ");
            }
        }

        int length = stringBuilder.length();
        stringBuilder.replace(length-2,length,"");
//        System.out.println(stringBuilder.toString());
//        stringBuilder.deleteCharAt(33);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static List<Long> dividers(long number) {
        List<Long> numbers = new ArrayList<>();
        for (long i = 1; i <= number; i++) {
            if (number % i == 0) numbers.add(i);
        }
//        System.out.println("Dividers: ");
//        numbers.forEach(System.out::println);
        return numbers;
    }

    public static List<Long> squareDividers(List<Long> dividers) {
        List<Long> squaredList = new ArrayList<>();

        for (long i : dividers) {
            squaredList.add(i * i);
        }
//        System.out.println("\nSquared dividers: ");
//        squaredList.forEach(System.out::println);
        return squaredList;
    }

    public static boolean isSumIsSquare (List<Long> numbers) {

//        System.out.println("\nSum: ");
//        System.out.println(sum);
        double dbl = Math.sqrt(Double.valueOf(sum(numbers)));
        return (dbl - Math.floor(dbl)) == 0;
    }

    public static Long sum (List<Long> numbers) {
        Long sum = numbers.stream()
                .collect(Collectors.summingLong(Long::longValue));
        return sum;
    }

}
