package _6kyu;

import java.util.ArrayList;
import java.util.List;

/**
 * An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that
 * determines whether a string that contains only letters is an isogram. Assume the empty string is an isogram.
 * Ignore letter case.
 *
 * Example: (Input --> Output)
 *
 * "Dermatoglyphics" --> true "aba" --> false "moOse" --> false (ignore letter case)
 *
 * isIsogram "Dermatoglyphics" = true
 * isIsogram "moose" = false
 * isIsogram "aba" = false
 */

//Level of difficulty: 6kyu
public class Isogram {
    public static void main(String[] args) {

    }
    public static boolean isIsogram (String str) {
        List<Character> characters = new ArrayList<>();
        str = str.toLowerCase();

        for (int i = 0; i<str.length(); i++) {
            if (characters.contains(str.charAt(i))) return false;
            characters.add(str.charAt(i));
        }
        return true;
    }

    public static boolean isIsogramBestPractice (String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
