/**
 * This time no story, no theory. The examples below show you how to write function accum:
 * <p>
 * Examples:
 * accum("abcd") -> "A-Bb-Ccc-Dddd"
 * accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
 * accum("cwAt") -> "C-Ww-Aaa-Tttt"
 * The parameter of accum is a string which includes only letters from a..z and A..Z.
 */
//Level of difficulty: 6kyu
public class Mumbling {
    public static void main(String[] args) {
        System.out.println(accum("ZpglnRxqenU"));;
    }

    public static String accum(String s) {
        Character tempChar ;
        String endString = "";
        for (int i = 1; i < s.length()+1; i++) {
            tempChar = s.charAt(i-1);
            endString = endString.concat(tempChar.toString().toUpperCase() +
                    (tempChar.toString().toLowerCase().repeat(i-1) + "-"));
        }
        return endString.replaceAll("-$","");
    }

    public static String accumBestPractice(String s){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i > 0) sb.append("-");
            sb.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++) {
                sb.append(Character.toLowerCase(c));
                i++;
            }
        }
        return sb.toString();
    }
}
