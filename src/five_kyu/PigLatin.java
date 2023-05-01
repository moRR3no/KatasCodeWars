package five_kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Move the first letter of each word to the end of it, then add "ay" to the end of the word.
 * Leave punctuation marks untouched.
 * <p>
 * Examples
 * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 * pigIt('Hello world !');     // elloHay orldway !
 */

//Level of difficulty: 5kyu
public class PigLatin {
    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool !"));
}

    public static String pigIt(String str) {
        StringBuilder endString = new StringBuilder();
        String[] stringArr = str.split(" ");
        String index;
        String restString;
        for (int i = 0; i < stringArr.length; i++) {
            if (stringArr[i].matches("^[A-Za-z]*$")) {
                index = stringArr[i].substring(0, 1);
                restString = stringArr[i].substring(1);
                endString.append(restString).append(index).append("ay ");
            } else endString.append(stringArr[i]).append(" ");
        }
        return endString.deleteCharAt(endString.lastIndexOf(" ")).toString();
    }

    public class PigLatinBestPractice {
        public static String pigIt(String str) {
            return Arrays.stream(str.split(" ")).map(PigLatinBestPractice::pigify).collect(Collectors.joining(" "));
        }

        private static String pigify(String word){
            return word.length() > 1 || Character.isLetter(word.charAt(0)) ? word.substring(1) + word.charAt(0) + "ay" : word;

        }
    }

}