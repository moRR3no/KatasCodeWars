package _5kyu;

import java.math.BigInteger;

/**
 * Your job is to write a function which increments a string, to create a new string.
 * <p>
 * If the string already ends with a number, the number should be incremented by 1.
 * If the string does not end with a number. the number 1 should be appended to the new string.
 * Examples:
 * <p>
 * foo -> foo1
 * <p>
 * foobar23 -> foobar24
 * <p>
 * foo0042 -> foo0043
 * <p>
 * foo9 -> foo10
 * <p>
 * foo099 -> foo100
 * <p>
 * Attention: If the number has leading zeros the amount of digits should be considered.
 */


//Level of difficulty: 5kyu
public class StringIncrementer {
    public static void main(String[] args) {
        System.out.println(incrementString("ess01"));

    }

    public static String incrementString(String str) {
        if (str.equals("")) return "1";
        String intString = str.replaceAll("^.*\\D", "");
        String strString = str.replaceAll("\\d*$", "");

        if (intString.length() > 0) {
            BigInteger numberWithoutZeros = new BigInteger(intString);
            BigInteger numberWithoutZerosPlusOne = numberWithoutZeros.add(BigInteger.valueOf(1));

            int leadingZeros = intString.length() - String.valueOf(numberWithoutZeros).length();


            if (String.valueOf(numberWithoutZerosPlusOne).length() != String.valueOf(numberWithoutZeros).length()) {
                leadingZeros -= 1;
            }
            StringBuilder leadingZerosStr = new StringBuilder();
            leadingZerosStr.append("0".repeat(Math.max(0, leadingZeros)));
            return strString.concat(leadingZerosStr.toString()).concat(numberWithoutZerosPlusOne.toString());
        }

        return strString + "1";
    }

    public static String incrementStringBestPractice(String str) {
        String u = java.util.regex.Pattern.compile("(\\d+)$").matcher(str).replaceAll(x -> String.format("%0" + x.group().length() +"d", new BigInteger(x.group()).add(BigInteger.ONE)));
        return u.matches(".*(?<!\\d)")?u+1:u;
    }
}