package _6kyu;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
 * that occur more than once in the input string. The input string can be assumed to contain only alphabets (both
 * uppercase and lowercase) and numeric digits.
 * <p>
 * Example
 * "abcde" -> 0 # no characters repeats more than once
 * "aabbcde" -> 2 # 'a' and 'b'
 * "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
 * "indivisibility" -> 1 # 'i' occurs six times
 * "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
 * "aA11" -> 2 # 'a' and '1'
 * "ABBA" -> 2 # 'A' and 'B' each occur twice
 */

//Level of difficulty: 6kyu
public class CountingDuplicates {
    public static void main(String[] args) {

        System.out.println(duplicateCount("abcde"));
        System.out.println(duplicateCount("aabbcde"));
        System.out.println(duplicateCount("aabBcde"));
        System.out.println(duplicateCount("indivisibility"));
        System.out.println(duplicateCount("Indivisibilities"));
        System.out.println(duplicateCount("aA11"));
        System.out.println(duplicateCount("ABBA"));

    }

    public static int duplicateCount(String text) {
        char[] chars = text.toLowerCase().toCharArray();
        List<Character> duplicateChars = new ArrayList<>();
        int count;
        for (char c : chars) {
            count = 0;
            for (char c2 : chars) {
                if (c == c2) count++;
            }
            if (count >= 2 && !duplicateChars.contains(c)) duplicateChars.add(c);
        }
        return duplicateChars.size();
    }

    public static int duplicateCountBestPractice(String text) {
        int ans = 0;
        text = text.toLowerCase();
        while (text.length() > 0) {
            String firstLetter = text.substring(0,1);
            text = text.substring(1);
            if (text.contains(firstLetter)) ans ++;
            text = text.replace(firstLetter, "");
        }
        return ans;
    }
}
