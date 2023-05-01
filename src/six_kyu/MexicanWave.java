package six_kyu;

import java.util.ArrayList;
import java.util.List;

/**
 * In this simple Kata your task is to create a function that turns a string into a Mexican Wave. You will be passed
 * a string and you must return that string in an array where an uppercase letter is a person standing up.
 *
 *  1.  The input string will always be lower case but maybe empty.
 *  2.  If the character in the string is whitespace then pass over it as if it was an empty seat
 *
 *  wave("hello") => {"Hello", "hEllo", "heLlo", "helLo", "hellO"}
 */


//Level of difficulty: 6kyu
public class MexicanWave {
    public static void main(String[] args) {
        String str = "two words";
        wave(str);

    }

    public static String[] wave (String str) {
        char[] charArr = str.toCharArray();
        if (charArr.length==0) return new String[]{};
        List<String> stringList = new ArrayList<>();

        String tempString;
        int mexicanIndex = 0;
        for (char c : charArr){
            if (c == ' ') {
                mexicanIndex++;
                continue;
            }
            charArr[mexicanIndex] = Character.toUpperCase(charArr[mexicanIndex]);
            tempString = new String(charArr);
            stringList.add(tempString);
            charArr[mexicanIndex] = Character.toLowerCase(charArr[mexicanIndex]);
            mexicanIndex++;
        }
        String[] strArr = stringList.toArray(new String[stringList.size()]);

        return strArr;
    }

    public static String[] waveBestPractice(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') continue;
            list.add(str.substring(0,i) + Character.toUpperCase(ch) + str.substring(i+1));
        }
        return list.toArray(new String[0]);
    }
}
