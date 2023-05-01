package _6kyu;

/**
 * Given a string of words, you need to find the highest scoring word.
 *
 * Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
 *
 * For example, the score of abad is 8 (1 + 2 + 1 + 4).
 *
 * You need to return the highest scoring word as a string.
 *
 * If two words score the same, return the word that appears earliest in the original string.
 *
 * All letters will be lowercase and all inputs will be valid.
 *
 */

//Level of difficulty: 6kyu
public class HighestScoringWord {

    public static String high(String s) {
        String[] words = s.split("\\s+");

        int indexOfHighestWord = 0;
        int wordSum = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int tempSum = 0;
            for (char c : word.toCharArray()) {
                tempSum += (Character.getNumericValue(c) - 9);
            }
            if (tempSum > wordSum) {
                wordSum = tempSum;
                indexOfHighestWord = i;
            }
        }
        return words[indexOfHighestWord];
    }
}
