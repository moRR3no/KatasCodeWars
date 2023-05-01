package _8kyu;

/**
 * Convert number to reversed array of digits
 * Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
 * <p>
 * Example(Input => Output):
 * 35231 => [1,3,2,5,3]
 * 0 => [0]
 */

//Level of difficulty: 8kyu
public class ConvertNum {
    public static void main(String[] args) {
        for (int a : digitize(35231)) {
            System.out.println(a);
        }


    }

    public static int[] digitize(long n) {
        String reversed = new StringBuilder(Long.toString(n)).reverse().toString();
        char[] asciiArr = reversed.toCharArray();
        int[] convertedArr = new int[asciiArr.length];
        int count = 0;
        for (int i : asciiArr) {
            convertedArr[count] = Character.getNumericValue(i);
            count++;
        }
        return convertedArr;
    }

    public static int[] digitizeBestPractice(long n) {
        return new StringBuilder().append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

}