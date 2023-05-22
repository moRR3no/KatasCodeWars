package _6kyu;

import java.util.*;

/**
 * The main idea is to count all the occurring characters in a string. If you have a string like aba, then the result
 * should be {'a': 2, 'b': 1}.
 * <p>
 * What if the string is empty? Then the result should be empty object literal, {}.
 */
public class CountChars {

    public static void main(String[] args) {

        System.out.println(count(""));

    }

    public static Map<Character, Integer> count(String str) {
        if (str==null) return new HashMap<>();
        Set<Character> characterSet =
                new HashSet<>(Arrays.asList(str.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new)));


        Map<Character, Integer> result = new HashMap<>();

        for (Character c : characterSet) {
            long count = str.toLowerCase().chars().filter(letter -> letter == c).count();
            result.put(c,(int)count);
        }


        return result;
    }

    //best practice
    public static Map<Character, Integer> count1(String str) {
        Map<Character, Integer> hm = new TreeMap<>();
        for(char x: str.toCharArray()){
            hm.put(x, (int) str.chars().filter(t -> t == x).count());
        }
        return hm;
    }

}
