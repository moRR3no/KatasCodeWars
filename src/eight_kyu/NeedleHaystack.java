package eight_kyu;

/**
 * Can you find the needle in the haystack?
 *
 * Write a function findNeedle() that takes an array full of junk but containing one "needle"
 *
 * After your function finds the needle it should return a message (as a string) that says:
 *
 * "found the needle at position " plus the index it found the needle, so:
 *
 * Example(Input --> Output)
 *
 * ["hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"] --> "found the needle at position 5"
 * Note: In COBOL, it should return "found the needle at position 6"
 */

//Level of difficulty: 8kyu
public class NeedleHaystack {
    public static void main(String[] args) {
        System.out.println(findNeedle(new Object[]{"hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"}));
    }

    public static String findNeedle(Object[] haystack) {
        int count = 0;
        for (int i = 0; i<haystack.length; i++) {
            if ((haystack[i] != "needle") || haystack[i]==null) continue;
            count = i;
        }
        return "found the needle at position " + count;
    }

    public static String findNeedleBestPractice(Object[] haystack) {
        return String.format("found the needle at position %d", java.util.Arrays.asList(haystack).indexOf("needle"));
    }
}
