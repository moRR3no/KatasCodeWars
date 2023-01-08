import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateEncoder {
    public static void main(String[] args) {
        String str = "Prespecialized";
        System.out.println(encode(str));

    }

    static String encode(String word) {
        List<Character> charList = word.toLowerCase().chars().mapToObj(c -> (char) c).toList();
        Set<Character> duplicatesChars = new HashSet<>();
        int count = 0;
        for (char c : charList) {

            for (int i = charList.indexOf(c); i < charList.size(); i++) {
                if (duplicatesChars.contains(c)) break;
                if (c == charList.get(i)) {
                    count++;
                }
            }
            if (count > 1) {
                duplicatesChars.add(c);
            }
            count = 0;
        }


        StringBuilder sb = new StringBuilder();
        for (char c : charList) {
            if (duplicatesChars.contains(c)) {
                sb.append(')');
                continue;
            }
            sb.append('(');
        }
        return sb.toString();
    }


    static String encodeBestPractice(String word) {
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }
}

