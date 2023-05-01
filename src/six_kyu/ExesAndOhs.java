package six_kyu;

/**
 * Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be
 * case-insensitive. The string can contain any char.
 * <p>
 * Examples input/output:
 * <p>
 * XO("ooxx") => true
 * XO("xooxx") => false
 * XO("ooxXm") => true
 * XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
 * XO("zzoo") => false
 */


//Level of difficulty: 6kyu
public class ExesAndOhs {
    public static void main(String[] args) {

        //testing all three solutions (mine - getXO and two best practices: getXOBestPractice and getXOBestPractice2
        // provided by CodeWars)
        String str = "ooxx";
        System.out.println(str + ": " + getXO(str) + " - " + getXOBestPractice(str)
                + " - " + getXOBestPractice2(str));
        str = "xooxx";
        System.out.println(str + ": " + getXO(str) + " - " + getXOBestPractice(str)
                + " - " + getXOBestPractice2(str));
        str = "ooxXm";
        System.out.println(str + ": " + getXO(str) + " - " + getXOBestPractice(str)
                + " - " + getXOBestPractice2(str));
        str = "zpzpzpp";
        System.out.println(str + ": " + getXO(str) + " - " + getXOBestPractice(str)
                + " - " + getXOBestPractice2(str));
        str = "zzoo";
        System.out.println(str + ": " + getXO(str) + " - " + getXOBestPractice(str)
                + " - " + getXOBestPractice2(str));


    }

    public static boolean getXO(String str) {
        char someChar = 'x';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.toLowerCase().charAt(i) == someChar) {
                count++;
            }
        }
        someChar = 'o';
        int count1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.toLowerCase().charAt(i) == someChar) {
                count1++;
            }
        }
        return count == count1;
    }

    public static boolean getXOBestPractice (String str) {
        str = str.toLowerCase();
        return str.replaceAll("x","").length()==str.replaceAll("o","").length();
    }

    public static boolean getXOBestPractice2 (String str) {
        str=str.toLowerCase();
        int o = 0;
        int x = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'o') o++;
            if (str.charAt(i) == 'x') x++;
        }
        return o==x;
    }

}
