package _6kyu;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence
 * "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once
 * (case is irrelevant).
 *
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers
 * and punctuation.
 */

// Level of difficulty: 6kyu
public class PangramChecker {
    public static void main(String[] args) {
    }

    public boolean check(String sentence){
        String[] arrayOne = "abcdefghijklmnopqrstuvwxyz".split("");
        Set<String> alphabet = new HashSet<>(List.of(arrayOne));

        String[] sentenceSplitted = sentence.toLowerCase().split("");
        for (String c : sentenceSplitted) {
            if (!alphabet.contains(c)) continue;
            alphabet.remove(c);
        }
        return alphabet.size()==0;
    }

    public boolean checkStream(String sentence) {
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count()==26;
    }
}
