package six_kyu;

/**
 * You live in the city of Cartesia where all roads are laid out in a perfect grid. You arrived ten minutes too early
 * to an appointment, so you decided to take the opportunity to go for a short walk. The city provides its citizens
 * with a Walk Generating App on their phones -- everytime you press the button it sends you an array of one-letter
 * strings representing directions to walk (eg. ['n', 's', 'w', 'e']). You always walk only a single block for each
 * letter (direction) and you know it takes you one minute to traverse one city block, so create a function that will
 * return true if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!)
 * and will, of course, return you to your starting point. Return false otherwise.
 * <p>
 * Note: you will always receive a valid array containing a random assortment of direction letters ('n', 's', 'e',
 * or 'w' only). It will never give you an empty array (that's not a walk, that's standing still!).
 */

//Level of difficulty: 6kyu
public class TenMinutesWalk {
    public static void main(String[] args) {
        System.out.println(isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        System.out.println(isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}));
        System.out.println(isValid(new char[]{'w'}));
        System.out.println(isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));

    }

    public static boolean isValid(char[] walk) {
        int e = 0;
        int w = 0;
        int s = 0;
        int n = 0;

        if (walk.length == 10) {
            for (char c : walk) {
                if (c == 'e') e++;
                if (c == 's') s++;
                if (c == 'w') w++;
                if (c == 'n') n++;
            }
            return (e == w) && (n == s);
        }
        return false;
    }

    public static boolean isValidBestPractice(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        int x = 0, y = 0;
        for (int i = 0; i < 10; i++) {
            switch (walk[i]) {
                case 'n':
                    y++;
                    break;
                case 'e':
                    x++;
                    break;
                case 's':
                    y--;
                    break;
                case 'w':
                    x--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}