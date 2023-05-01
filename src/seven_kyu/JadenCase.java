package seven_kyu;

/**
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
 * Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known
 * for almost always capitalizing every word. For simplicity, you'll have to capitalize each word, check out how
 * contractions are expected to be in the example below.
 * <p>
 * Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from
 * Jaden Smith, but they are not capitalized in the same way he originally typed them.
 * <p>
 * Example:
 * <p>
 * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 * Note that the Java version expects a return value of null for an empty string or null.
 */

//Level of difficulty: 7kyu
public class JadenCase {
    public static void main(String[] args) {
        System.out.println(toJadenCase("most Trees are Blue"));
    }

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.equals("")) return null;
        String[] phraseArr = phrase.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phraseArr.length; i++) {
            String temp = Character.toUpperCase(phraseArr[i].charAt(0)) + phraseArr[i].substring(1);
            sb.append(temp).append(" ");
        }
        int lastSpace = sb.lastIndexOf(" ");
        sb.replace(lastSpace,lastSpace+1,"");
        return sb.toString();
    }

    public String toJadenCaseBestPractice(String phrase) {
        if(phrase == null || phrase.equals("")) return null;

        char[] array = phrase.toCharArray();

        for(int x = 0; x < array.length; x++) {
            if(x == 0 || array[x-1] == ' ') {
                array[x] = Character.toUpperCase(array[x]);
            }
        }

        return new String(array);
    }
}

